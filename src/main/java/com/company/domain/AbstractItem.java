package com.company.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
public class AbstractItem implements Serializable {
  @Id
  @Column(name = "id", unique = true)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  protected void init(long id) {
    this.setId(id);
  }

  protected void init(String id, EntityType type) {
    this.setId(CryptoUtils.generateEntityId(id, type));
  }

  @Column(name = "date_created", nullable = false)
  private LocalDateTime dateCreated;

  @Column(name = "last_updated", nullable = true)
  private LocalDateTime lastUpdated;
}
