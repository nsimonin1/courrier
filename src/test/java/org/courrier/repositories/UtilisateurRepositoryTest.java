package org.courrier.repositories;

import com.google.common.collect.Lists;
import org.courrier.CourrierApplication;
import org.courrier.config.PersistenceContext;
import org.courrier.config.SecurityConfiguration;
import org.courrier.entities.Utilisateur;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by SimonPascal on 04/16/2016.
 */
@lombok.extern.slf4j.Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {CourrierApplication.class})
public class UtilisateurRepositoryTest {

    @Autowired
    private UtilisateurRepository utilisateurRepository;


    @Test
    public void loadAllUsers(){
        List<Utilisateur> utilisateurs=utilisateurRepository.findAll();
        assertTrue(utilisateurs.isEmpty());
    }

   /* @Test
    public void saveTest(){
        Utilisateur utilisateur=new Utilisateur();
        utilisateur.setEmail("dodo@courrier");
        utilisateur.setFirstName("Jean");
        utilisateur.setLangKey("fr");
        utilisateur.setLogin("dodo");
        utilisateur.setPassword("dodo");
        repository.save(utilisateur);
    }*/
}