package mx.edu.utez.MT09_Yara_Pacheco_CA2.repository;

import mx.edu.utez.MT09_Yara_Pacheco_CA2.model.Curso;
import mx.edu.utez.MT09_Yara_Pacheco_CA2.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
    List<Inscripcion> findByCorreo(String correo);
    List<Inscripcion> findByCursoId(Long idCurso);
    List<Inscripcion> findByEstado(String estado);

}
