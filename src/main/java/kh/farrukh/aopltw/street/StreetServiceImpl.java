package kh.farrukh.aopltw.street;

import java.util.List;
import kh.farrukh.aopltw.street.model.StreetRequestDTO;
import kh.farrukh.aopltw.street.model.StreetResponseDTO;
import kh.farrukh.aopltw.tenant.CurrentTenant;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StreetServiceImpl implements StreetService {

  private final StreetRepo repo;
  private final StreetMapper mapper;

  @Override
  public Page<StreetResponseDTO> getStreets(Pageable pageable) {
    return repo
        .findAll(pageable)
        .map(mapper::toResponseDTO);
  }

  @Override
  public List<StreetResponseDTO> getStreets() {
    return repo
        .findAll()
        .stream()
        .map(mapper::toResponseDTO)
        .toList();
  }

  @Override
  public StreetResponseDTO getStreetById(Long id) {
    return mapper.toResponseDTO(findStreet(id));
  }

  @Override
  public StreetResponseDTO createStreet(StreetRequestDTO streetRequestDTO) {
    var entity = mapper.toEntity(streetRequestDTO);
    entity.setTenant(CurrentTenant.get());
    return mapper.toResponseDTO(repo.save(entity));
  }

  @Override
  public StreetResponseDTO updateStreet(Long id, StreetRequestDTO streetRequestDTO) {
    var street = findStreet(id);
    mapper.updateEntity(streetRequestDTO, street);
    return mapper.toResponseDTO(repo.save(street));
  }

  @Override
  public void deleteStreet(Long id) {
    repo.deleteById(id);
  }

  private StreetEntity findStreet(Long id) {
    return repo
        .findById(id)
        .orElseThrow();
  }
}
