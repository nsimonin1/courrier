package org.courrier.service;

import org.courrier.entities.Utilisateur;

import javax.validation.constraints.NotNull;

/**
 * Created by SimonPascal on 04/17/2016.
 */
public interface UtilisateurService {
    void creerUtilisateur(@NotNull Utilisateur utilisateur);
}
