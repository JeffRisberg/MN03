package com.company;

import com.company.domain.Donation;
import io.micronaut.data.exceptions.DataAccessException;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.PageableRepository;

import javax.transaction.Transactional;

@JdbcRepository(dialect = Dialect.MYSQL)
public interface DonationRepository extends PageableRepository<Donation, Long> {

  Donation save();

  @Transactional
  default Donation saveWithException() {
    save();
    throw new DataAccessException("test exception");
  }

  long update();
}
