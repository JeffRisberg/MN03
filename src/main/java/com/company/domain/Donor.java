package com.company.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "donors")
@Data
public class Donor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long id;

  @NotNull
  private String firstName;

  @NotNull
  private String lastName;

  private String address;
}
