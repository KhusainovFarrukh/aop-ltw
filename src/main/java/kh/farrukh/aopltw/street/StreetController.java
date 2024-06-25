package kh.farrukh.aopltw.street;

import java.util.List;
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
  public ResponseEntity<Page<StreetResponseDTO>> getStreets(Pageable pageable) {
    return ResponseEntity.ok(service.getStreets(pageable));
  }

  @Override
  public ResponseEntity<List<StreetResponseDTO>> getStreets() {
    return ResponseEntity.ok(service.getStreets());
  }

  @Override
  public ResponseEntity<StreetResponseDTO> getStreetById(Long id) {
    return ResponseEntity.ok(service.getStreetById(id));
  }

  @Override
  public ResponseEntity<StreetResponseDTO> createStreet(
      StreetRequestDTO streetRequestDTO
  ) {
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(service.createStreet(streetRequestDTO));
  }

  @Override
  public ResponseEntity<StreetResponseDTO> updateStreet(
      Long id,
      StreetRequestDTO streetRequestDTO
  ) {
    return ResponseEntity.ok(service.updateStreet(id, streetRequestDTO));
  }

  @Override
  public ResponseEntity<Void> deleteStreet(Long id) {
    service.deleteStreet(id);
    return ResponseEntity.noContent().build();
  }
}
