package mx.edu.utez.MT09_Yara_Pacheco_CA2.controller.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestCambiarEstadoCurso {
    @NotBlank(message = "El nuevo estado es obligatorio")
    private String nuevoEstado;
}
