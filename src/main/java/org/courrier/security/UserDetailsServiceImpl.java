package org.courrier.security;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.courrier.entities.Utilisateur;
import org.courrier.repositories.UtilisateurRepository;
import org.courrier.security.UserNotActivatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by SimonPascal on 04/17/2016.
 */
@Service
@Slf4j
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {
    private static final Utilisateur SUPER_ADMIN=Utilisateur.superAdmin();
    @Inject
    private UtilisateurRepository utilisateurRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        log.debug("Authenticating {}", login);
        final String lowercaseLogin = login.toLowerCase();
        if(SUPER_ADMIN.getLogin().equals(login)){
            User user=new User(lowercaseLogin,SUPER_ADMIN.getPassword(), Lists.newArrayList());
            return user;
        }else{
            Optional<Utilisateur> userFromDataBase=utilisateurRepository.findOneByLoginOrEmail(lowercaseLogin);

            return userFromDataBase.map(user -> {
                if (!user.isActivated()) {
                    throw new UserNotActivatedException("User " + lowercaseLogin + " was not activated");
                }
                List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
                        .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                        .collect(Collectors.toList());
                return new org.springframework.security.core.userdetails.User(lowercaseLogin,
                        user.getPassword(),
                        grantedAuthorities);
            }).orElseThrow(() -> new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the " +
                    "database"));
        }


    }
}
