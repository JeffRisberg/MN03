package com.company.mn03.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "donations")
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class DonationEntity extends AbstractDatedEntity {

  @Column(name = "amount", nullable = false)
  private Double amount;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "donor_id", insertable = false, updatable = false)
  @JsonIgnore
  private DonorEntity donor;

  @Column(name = "donor_id")
  private Long donorId;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "charity_id", insertable = false, updatable = false)
  @JsonIgnore
  private CharityEntity charity;

  @Column(name = "charity_id")
  private Long charityId;

  public String toString() {
    StringBuilder sb = new StringBuilder();

    sb.append("DonationEntity[date=" + getDateCreated());
    sb.append(", amount=" + amount);
    sb.append("]");

    return sb.toString();
  }
}
