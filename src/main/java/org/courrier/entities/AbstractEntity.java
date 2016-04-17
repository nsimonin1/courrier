package org.courrier.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.hibernate.envers.Audited;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.ZonedDateTime;
import org.hibernate.annotations.Type;

/**
 * Created by SimonPascal on 04/16/2016.
 */
@MappedSuperclass
@Audited
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity {


    @CreatedBy
    @NotNull
    @Column(name = "created_by", nullable = false, length = 50, updatable = false)
    @Getter@Setter
    @JsonIgnore
    private String createdBy;

    @CreatedDate
    @NotNull
    @Column(name = "created_date", nullable = false)
    @JsonIgnore
    @Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentZonedDateTime")
    @Getter@Setter
    private ZonedDateTime createdDate = ZonedDateTime.now();

    @LastModifiedBy
    @Column(name = "last_modified_by", length = 50)
    @JsonIgnore
    @Getter@Setter
    private String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    @JsonIgnore
    @Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentZonedDateTime")
    @Getter@Setter
    private ZonedDateTime lastModifiedDate = ZonedDateTime.now();



}
