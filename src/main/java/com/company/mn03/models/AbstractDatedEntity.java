package com.company.mn03.models;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import com.company.mn03.models.AbstractEntity;

/**
 * @author Jeff Risberg
 * @since 10/22/17
 */
@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractDatedEntity extends AbstractEntity {

  @Column(name = "date_created")
  protected Date dateCreated;

  @Column(name = "last_updated")
  protected Date lastUpdated;

  @PrePersist
  protected void onCreate() {
    dateCreated = new Date();
  }

  @PreUpdate
  protected void onUpdate() {
    lastUpdated = new Date();
  }

}
