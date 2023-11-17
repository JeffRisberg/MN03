package com.company.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.micronaut.serde.annotation.Serdeable;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.*;

@Serdeable
@Entity
@Table(name = "donors")
@Data
public class Donor {

  @Id
  @Column(name = "id", nullable = false, unique = true)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long id;

  @NotNull
  @Column(name = "first_name", nullable = false)
  private String firstName;

  @NotNull
  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "address", nullable = true)
  private String address;

  @OneToMany(mappedBy = "donor", fetch = FetchType.EAGER)
  @JsonIgnore
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private Set<Donation> donations = new HashSet<Donation>();
}
