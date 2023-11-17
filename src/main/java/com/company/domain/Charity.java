package com.company.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.micronaut.serde.annotation.Serdeable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.*;

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

  @OneToMany(mappedBy = "charity", fetch = FetchType.EAGER)
  @JsonIgnore
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private Set<Donation> donations = new HashSet<Donation>();
}
