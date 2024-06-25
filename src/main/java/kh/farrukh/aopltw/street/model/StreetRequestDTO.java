package kh.farrukh.aopltw.street.model;

import jakarta.validation.constraints.NotBlank;

public record StreetRequestDTO(
    @NotBlank
    String name,
    String description
) {

}
