package org.courrier.service.impl;

import org.courrier.entities.Utilisateur;
import org.courrier.repositories.UtilisateurRepository;
import org.courrier.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;

/**
 * Created by SimonPascal on 04/17/2016.
 */
@Service
@Transactional
public class UtilisateurServiceImpl implements UtilisateurService{

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public void creerUtilisateur(@NotNull Utilisateur utilisateur){
        final String password=passwordEncoder.encode(utilisateur.getLogin());
        utilisateur.setPassword(password);
        utilisateurRepository.save(utilisateur);
    }
}
