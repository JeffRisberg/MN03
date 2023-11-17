package com.company.domain;

import io.micronaut.serde.annotation.Serdeable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Serdeable
@Entity
@Table(name = "charities")
@Data
public class Charity {

  @Id
  @Column(name = "id", nullable = false, unique = true)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long id;

  @NotNull
  @Column(name = "name", nullable = false)
  private String name;

  @NotNull
  @Column(name = "ein", nullable = false)
  private String ein;

  @Column(name = "description", nullable = false)
  private String description;
}
