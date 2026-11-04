package mx.edu.utez.MT09_Yara_Pacheco_CA2.controller.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestCrearCursoDTO {
    @NotBlank(message = "El nombre del curso no puede estar vacío")
    private String nombre;

    private String descripcion;

    @NotNull(message = "El cupo máximo es obligatorio")
    @Min(value = 1, message = "El cupo máximo debe ser mayor a cero")
    private Integer cupoMaximo;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;

}
