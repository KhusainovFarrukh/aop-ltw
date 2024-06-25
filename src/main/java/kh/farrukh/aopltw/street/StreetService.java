package kh.farrukh.aopltw.street;

import kh.farrukh.aopltw.street.model.StreetRequestDTO;
import kh.farrukh.aopltw.street.model.StreetResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StreetService {

  Page<StreetResponseDTO> getStreets(Pageable pageable, Long tenant);

  StreetResponseDTO getStreetById(Long id, Long tenant);

  StreetResponseDTO createStreet(StreetRequestDTO streetRequestDTO, Long tenant);

  StreetResponseDTO updateStreet(Long id, StreetRequestDTO streetRequestDTO, Long tenant);

  void deleteStreet(Long id, Long tenant);

}
