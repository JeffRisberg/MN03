package com.company;

import com.company.domain.Donor;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.exceptions.DataAccessException;
import io.micronaut.data.repository.PageableRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Repository()
public interface DonorRepository extends PageableRepository<Donor, Long> {

  Donor save(
      @NonNull @NotBlank String firstName, @NonNull @NotBlank String lastName, String address);

  @Transactional
  default Donor saveWithException(
      @NonNull @NotBlank String firstName, @NonNull @NotBlank String lastName, String address) {
    save(firstName, lastName, address);
    throw new DataAccessException("test exception");
  }

  long update(
      @NonNull @NotNull @Id Long id,
      @NonNull @NotBlank String firstName,
      @NotNull @NotBlank String lastName,
      String address);
}
