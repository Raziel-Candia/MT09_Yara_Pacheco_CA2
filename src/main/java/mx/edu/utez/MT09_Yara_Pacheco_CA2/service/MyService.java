package mx.edu.utez.MT09_Yara_Pacheco_CA2.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import mx.edu.utez.MT09_Yara_Pacheco_CA2.controller.dto.RequestCambiarEstadoCurso;
import mx.edu.utez.MT09_Yara_Pacheco_CA2.controller.dto.RequestCrearCursoDTO;
import mx.edu.utez.MT09_Yara_Pacheco_CA2.controller.dto.InscribirParticipanteDTO;
import mx.edu.utez.MT09_Yara_Pacheco_CA2.exception.CustomException;
import mx.edu.utez.MT09_Yara_Pacheco_CA2.model.Curso;
import mx.edu.utez.MT09_Yara_Pacheco_CA2.model.Inscripcion;
import mx.edu.utez.MT09_Yara_Pacheco_CA2.repository.CursoRepository;
import mx.edu.utez.MT09_Yara_Pacheco_CA2.repository.InscripcionRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class MyService {
    private final CursoRepository cursoRepository;
    private final InscripcionRepository inscripcionRepository;

    public MyService(CursoRepository cursoRepository, InscripcionRepository inscripcionRepository) {
        this.cursoRepository = cursoRepository;
        this.inscripcionRepository = inscripcionRepository;
    }


    @Transactional
    public Inscripcion inscribirParticipante(InscribirParticipanteDTO payload) {
        Curso curso = cursoRepository.findById(payload.getIdCurso())
                .orElseThrow(() -> new CustomException("El curso no existe"));

        if (!"DISPONIBLE".equals(curso.getEstado())) {
            throw new CustomException("El curso no se encuentra en estado DISPONIBLE");
        }

        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setNombreParticipante(payload.getNombreParticipante());
        inscripcion.setEdadParticipante(payload.getEdadParticipante());
        inscripcion.setCorreo(payload.getCorreo());
        inscripcion.setFechaInscripcion(LocalDate.now());
        inscripcion.setEstado("ACTIVA");
        inscripcion.setCalificacion(null);
        inscripcion.setCurso(curso);

        return inscripcionRepository.save(inscripcion);
    }


    @Transactional
    public Inscripcion cancelarInscripcion(Long idInscripcion) {
        Inscripcion inscripcion = inscripcionRepository.findById(idInscripcion)
                .orElseThrow(() -> new CustomException("La inscripción no existe "));

        if (!"ACTIVA".equals(inscripcion.getEstado())) {
            throw new CustomException("Unicamente se pueden cancelar inscripciones en estado ACTIVA ");
        }

        Curso curso = inscripcion.getCurso();
        if ("EN_CURSO".equals(curso.getEstado()) || "FINALIZADO".equals(curso.getEstado())) {
            throw new CustomException("No se puede cancelar la inscripción porque el curso ya comenzó");
        }

        inscripcion.setEstado("CANCELADA");
        return inscripcionRepository.save(inscripcion);
    }


    public Curso registrarCurso(RequestCrearCursoDTO payload) {
        Curso curso = new Curso();
        curso.setNombre(payload.getNombre());
        curso.setDescripcion(payload.getDescripcion());
        curso.setCupoMaximo(payload.getCupoMaximo());
        curso.setFechaInicio(payload.getFechaInicio());
        curso.setFechaFin(payload.getFechaFin());
        curso.setEstado("DISPONIBLE");

        return cursoRepository.save(curso);
    }


    public List<Curso> listarCursosDisponibles() {
        return cursoRepository.findByEstado("DISPONIBLE");
    }


    public List<Curso> listarTodosLosCursos() {
        return cursoRepository.findAll();
    }


    public List<Inscripcion> consultarInscripcionesPorCorreo(String correo) {
        return inscripcionRepository.findByCorreo(correo);
    }


    public List<Inscripcion> consultarParticipantesDeCurso(Long idCurso) {
        if (!cursoRepository.existsById(idCurso)) {
            throw new CustomException("El curso no existe");
        }
        return inscripcionRepository.findByCursoId(idCurso);
    }

    public Inscripcion consultarDetalleInscripcion(Long idInscripcion) {
        return inscripcionRepository.findById(idInscripcion)
                .orElseThrow(() -> new CustomException("La inscripción no existe"));
    }

    /*registrar calificacion de un participante - 20
Recibir el ID de la inscripción y una calificación.
Validar que la inscripción exista.
Validar que el curso asociado esté en estado FINALIZADO.
Permitir calificaciones entre 0 y 10.
Permitir registrar calificación únicamente si la inscripción está ACTIVA.
Cambiar el estado de la inscripción a COMPLETADA.
Guardar la calificación y el nuevo estado.
     */

    public Inscripcion registrarCalificacionParticipante(Long idInscripcion){


        Inscripcion inscripcion = inscripcionRepository.findById(idInscripcion)
                .orElseThrow(() -> new CustomException("La inscripción no existe "));


        inscripcion.getCalificacion();


        if (!"ACTIVA".equals(inscripcion.getEstado())) {
            throw new CustomException("Unicamente se pueden cancelar inscripciones en estado ACTIVA ");
        }

        Curso curso = inscripcion.getCurso();
        if ("FINALIZADO".equals(curso.getEstado())) {
            throw new CustomException("El curso debe estar FINALIZADO");
        }

        inscripcion.setEstado("COMPLETADA");
        return inscripcionRepository.save(inscripcion);

    }














}
