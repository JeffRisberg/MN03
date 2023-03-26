package com.company;

import com.company.domain.Donor;
import io.micronaut.data.exceptions.DataAccessException;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@ExecuteOn(TaskExecutors.IO)
@Controller("/donors")
public class DonorController {

  protected final DonorRepository donorRepository;

  public DonorController(DonorRepository donorRepository) {
    this.donorRepository = donorRepository;
  }

  @Get("/{id}")
  public Optional<Donor> show(Long id) {
    return donorRepository
      .findById(id);
  }

  @Put
  public HttpResponse update(@Body @Valid DonorUpdateCommand command) {
    donorRepository.update(command.getId(), command.getFirstName(), command.getLastName(), command.getAddress());
    return HttpResponse
      .noContent()
      .header(HttpHeaders.LOCATION, location(command.getId()).getPath());
  }

  @Get("/list")
  public List<Donor> list(@Valid Pageable pageable) {
    return donorRepository.findAll(pageable).getContent();
  }

  @Post
  public HttpResponse<Donor> save(
    @Body("name") @NotBlank String name,
    @Body("ein") @NotBlank String ein,
    @Body("description") @NotBlank String description) {
    Donor donor = donorRepository.save(name, ein, description);

    return HttpResponse
      .created(donor)
      .headers(headers -> headers.location(location(donor.getId())));
  }

  @Post("/ex")
  public HttpResponse<Donor> saveExceptions(
    @Body("firstName") @NotBlank String firstName,
    @Body("lastName") @NotBlank String lastName,
    @Body("address") @NotBlank String address) {

    try {
      Donor donor = donorRepository.saveWithException(firstName, lastName, address);
      return HttpResponse
        .created(donor)
        .headers(headers -> headers.location(location(donor.getId())));
    } catch (DataAccessException e) {
      return HttpResponse.noContent();
    }
  }

  @Delete("/{id}")
  @Status(HttpStatus.NO_CONTENT)
  public void delete(Long id) {
    donorRepository.deleteById(id);
  }

  protected URI location(Long id) {
    return URI.create("/donors/" + id);
  }

  protected URI location(Donor donor) {
    return location(donor.getId());
  }
}
