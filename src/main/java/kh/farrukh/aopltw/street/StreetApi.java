package kh.farrukh.aopltw.street;

import jakarta.validation.Valid;
import java.util.List;
import kh.farrukh.aopltw.street.model.StreetRequestDTO;
import kh.farrukh.aopltw.street.model.StreetResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/streets")
public interface StreetApi {

  @GetMapping
  ResponseEntity<Page<StreetResponseDTO>> getStreets(
      Pageable pageable
  );

  @GetMapping("/list")
  ResponseEntity<List<StreetResponseDTO>> getStreets();

  @GetMapping("/{id}")
  ResponseEntity<StreetResponseDTO> getStreetById(
      @PathVariable Long id
  );

  @PostMapping
  ResponseEntity<StreetResponseDTO> createStreet(
      @Valid @RequestBody StreetRequestDTO streetRequestDTO
  );

  @PutMapping("/{id}")
  ResponseEntity<StreetResponseDTO> updateStreet(
      @PathVariable Long id,
      @Valid @RequestBody StreetRequestDTO streetRequestDTO
  );

  @DeleteMapping("/{id}")
  ResponseEntity<Void> deleteStreet(
      @PathVariable Long id
  );

}
