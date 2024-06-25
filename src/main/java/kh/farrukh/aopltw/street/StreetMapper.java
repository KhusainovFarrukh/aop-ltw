package kh.farrukh.aopltw.street;

import kh.farrukh.aopltw.street.model.StreetRequestDTO;
import kh.farrukh.aopltw.street.model.StreetResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = ComponentModel.SPRING)
public interface StreetMapper {

  StreetResponseDTO toResponseDTO(StreetEntity streetEntity);

  StreetEntity toEntity(StreetRequestDTO streetRequestDTO);

  void updateEntity(StreetRequestDTO streetRequestDTO, @MappingTarget StreetEntity streetEntity);

  StreetResponseDTO toResponseDTO(StreetRequestDTO streetRequestDTO);

}
