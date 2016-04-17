package org.courrier.repositories;

import org.courrier.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * Created by SimonPascal on 04/16/2016.
 */
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long>{
    @Query("SELECT urs FROM Utilisateur urs WHERE urs.login = :loginOrEmail OR urs.email = :loginOrEmail")
    Optional<Utilisateur> findOneByLoginOrEmail(@Param("loginOrEmail") String loginOrEmail);
}
