package kh.farrukh.aopltw.street;

import kh.farrukh.aopltw.street.model.StreetRequestDTO;
import kh.farrukh.aopltw.street.model.StreetResponseDTO;
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
  public Page<StreetResponseDTO> getStreets(Pageable pageable, Long tenant) {
    return repo
        .findAll(pageable)
        .map(mapper::toResponseDTO);
  }

  @Override
  public StreetResponseDTO getStreetById(Long id, Long tenant) {
    return mapper.toResponseDTO(findStreet(id));
  }

  @Override
  public StreetResponseDTO createStreet(StreetRequestDTO streetRequestDTO, Long tenant) {
    var entity = mapper.toEntity(streetRequestDTO);
    entity.setTenant(tenant);
    return mapper.toResponseDTO(repo.save(entity));
  }

  @Override
  public StreetResponseDTO updateStreet(Long id, StreetRequestDTO streetRequestDTO, Long tenant) {
    var street = findStreet(id);
    mapper.updateEntity(streetRequestDTO, street);
    return mapper.toResponseDTO(repo.save(street));
  }

  @Override
  public void deleteStreet(Long id, Long tenant) {
    repo.deleteById(id);
  }

  private StreetEntity findStreet(Long id) {
    return repo
        .findById(id)
        .orElseThrow();
  }
}
