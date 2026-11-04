package mx.edu.utez.MT09_Yara_Pacheco_CA2.repository;

import mx.edu.utez.MT09_Yara_Pacheco_CA2.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findByEstado(String disponible);

}
