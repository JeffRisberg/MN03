package com.company;

import com.company.domain.Charity;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.exceptions.DataAccessException;
import io.micronaut.data.repository.PageableRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Repository()
public interface CharityRepository extends PageableRepository<Charity, Long> {

  Charity save(@NonNull @NotBlank String name, @NonNull @NotBlank String ein, String description);

  @Transactional
  default Charity saveWithException(
      @NonNull @NotBlank String name, @NonNull @NotBlank String ein, String description) {
    save(name, ein, description);
    throw new DataAccessException("test exception");
  }

  long update(@NonNull @NotNull @Id Long id, @NonNull @NotBlank String name);
}
