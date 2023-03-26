package com.company;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class DonorUpdateCommand {
  @NotNull
  private final Long id;

  @NotBlank
  private final String firstName;
  private final String lastName;
  private final String address;
}
