package org.courrier.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.hibernate.annotations.Cache;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by SimonPascal on 04/16/2016.
 */
@Entity
@Table(name = "t_user")
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@EqualsAndHashCode(of = "id")
@EntityListeners(AuditingEntityListener.class)
public class Utilisateur extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Pattern(regexp = "^[a-z0-9]*$|(anonymousUser)")
    @Size(min = 1, max = 50)
    @Column(length = 50, unique = true, nullable = false)
    @Getter
    @Setter
    private String login;

    @JsonIgnore
    @NotNull
    @Size(min = 60, max = 60)
    @Column(name = "password_hash",length = 60)
    @Getter@Setter
    private String password;

    @Size(max = 50)
    @Column(name = "first_name", length = 50)
    @Getter@Setter
    private String firstName;

    @Size(max = 50)
    @Column(name = "last_name", length = 50)
    @Getter@Setter
    private String lastName;

    @Email
    @Size(max = 100)
    @Column(length = 100, unique = true)
    @Getter@Setter
    private String email;

    @Column(nullable = false)
    @Getter@Setter
    private boolean activated = false;

    @Size(min = 2, max = 5)
    @Column(name = "lang_key", length = 5)
    @Getter@Setter
    private String langKey;

    @Size(max = 20)
    @Column(name = "activation_key", length = 20)
    @JsonIgnore
    @Getter@Setter
    private String activationKey;

    @Size(max = 20)
    @Column(name = "reset_key", length = 20)
    @Getter@Setter
    private String resetKey;

    @Column(name = "reset_date", nullable = true)
    @Getter@Setter
    private ZonedDateTime resetDate = null;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "t_utilisateur_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "name")})
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @Getter@Setter
    private Set<Authority> authorities = new HashSet<>();

    public static Utilisateur superAdmin() {
        final Utilisateur utilisateur=new Utilisateur();
        utilisateur.setLogin("admin");
        utilisateur.setPassword("$2a$08$oY6TCBgpW0Ofz1Eh/IO9QuvQ1lUlWCd8Rji6qyBALinXBvTC/8uSS");

        return utilisateur;
    }
}
