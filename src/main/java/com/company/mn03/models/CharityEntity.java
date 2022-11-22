package com.company.mn03.models;

import javax.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name = "charities")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Slf4j
public class CharityEntity extends AbstractDatedEntity {

  @Column(name = "name", nullable = false)
  protected String name;

  @Column(name = "ein", nullable = false)
  private String ein;

  @Column(name = "description", nullable = true)
  protected String description;

  @Column(name = "website", nullable = true)
  protected String website;
}
