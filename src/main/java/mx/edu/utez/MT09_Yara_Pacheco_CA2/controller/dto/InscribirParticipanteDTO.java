package mx.edu.utez.MT09_Yara_Pacheco_CA2.controller.dto;

import jakarta.validation.constraints.Email;
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
public class InscribirParticipanteDTO {

    @NotNull(message = "El ID del curso es obligatorio")
    private Long idCurso;

    @NotBlank(message = "El nombre del participante no puede estar vacío")
    private String nombreParticipante;

    @NotNull(message = "La edad es obligatoria")
    @Min(value = 1, message = "La edad debe ser positiva")
    private Integer edadParticipante;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo debe tener un formato válido")
    private String correo;
}
