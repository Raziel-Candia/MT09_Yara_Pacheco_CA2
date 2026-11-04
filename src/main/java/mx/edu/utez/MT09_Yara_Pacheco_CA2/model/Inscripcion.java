package mx.edu.utez.MT09_Yara_Pacheco_CA2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreParticipante;
    private int edadParticipante;
    private String correo;
    private LocalDate fechaInscripcion;
    private String estado;
    private Double calificacion;


    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;


}
