package com.company;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CharityUpdateCommand {
  @NotNull
  private final Long id;

  @NotBlank
  private final String name;

  public CharityUpdateCommand(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

}
