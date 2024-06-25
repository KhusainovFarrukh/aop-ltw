package kh.farrukh.aopltw.street;

import kh.farrukh.aopltw.street.model.StreetRequestDTO;
import kh.farrukh.aopltw.street.model.StreetResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StreetController implements StreetApi {

  private final StreetService service;

  @Override
  public ResponseEntity<Page<StreetResponseDTO>> getStreets(Pageable pageable, Long tenant) {
    return ResponseEntity.ok(service.getStreets(pageable, tenant));
  }

  @Override
  public ResponseEntity<StreetResponseDTO> getStreetById(Long id, Long tenant) {
    return ResponseEntity.ok(service.getStreetById(id, tenant));
  }

  @Override
  public ResponseEntity<StreetResponseDTO> createStreet(
      StreetRequestDTO streetRequestDTO,
      Long tenant
  ) {
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(service.createStreet(streetRequestDTO, tenant));
  }

  @Override
  public ResponseEntity<StreetResponseDTO> updateStreet(
      Long id,
      StreetRequestDTO streetRequestDTO,
      Long tenant
  ) {
    return ResponseEntity.ok(service.updateStreet(id, streetRequestDTO, tenant));
  }

  @Override
  public ResponseEntity<Void> deleteStreet(Long id, Long tenant) {
    service.deleteStreet(id, tenant);
    return ResponseEntity.noContent().build();
  }
}
