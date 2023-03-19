package com.company.domain;


import io.micronaut.context.annotation.Primary;
import io.micronaut.data.annotation.MappedEntity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "charities")
@Data
public class Charity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long id;

  @NotNull
  private String name;

  @NotNull
  private String ein;

  private String description;
}
