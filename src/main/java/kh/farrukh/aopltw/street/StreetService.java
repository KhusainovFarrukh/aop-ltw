package kh.farrukh.aopltw.street;

import java.util.List;
import kh.farrukh.aopltw.street.model.StreetRequestDTO;
import kh.farrukh.aopltw.street.model.StreetResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StreetService {

  Page<StreetResponseDTO> getStreets(Pageable pageable);

  List<StreetResponseDTO> getStreets();

  StreetResponseDTO getStreetById(Long id);

  StreetResponseDTO createStreet(StreetRequestDTO streetRequestDTO);

  StreetResponseDTO updateStreet(Long id, StreetRequestDTO streetRequestDTO);

  void deleteStreet(Long id);

}
