package com.company;

import io.micronaut.serde.annotation.Serdeable;
import java.util.Date;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Serdeable
public class DonationUpdateCommand {
  @NotNull
  private final Long id;

  @NotNull
  private final Long donor_id;

  @NotNull
  private final Long charity_id;

  @NotNull
  private Double amount;

  @NotNull
  private Date dateCreated;

  @NotNull
  private Date lastUpdated;
}
