package mx.edu.utez.MT09_Yara_Pacheco_CA2.controller;

import jakarta.validation.Valid;
import mx.edu.utez.MT09_Yara_Pacheco_CA2.controller.dto.RequestCrearCursoDTO;
import mx.edu.utez.MT09_Yara_Pacheco_CA2.model.Curso;
import mx.edu.utez.MT09_Yara_Pacheco_CA2.model.Inscripcion;
import mx.edu.utez.MT09_Yara_Pacheco_CA2.service.MyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Cursos")
@CrossOrigin("*")
    public class CursoController {
        private final MyService servicio;

        public CursoController(MyService servicio) {
            this.servicio = servicio;
        }

        @PostMapping
        public ResponseEntity<Curso> registrarCurso(@Valid @RequestBody RequestCrearCursoDTO payload) {
            return ResponseEntity.status(HttpStatus.CREATED).body(servicio.registrarCurso(payload));
        }

        @GetMapping("/disponibles")
        public ResponseEntity<List<Curso>> listarDisponibles() {
            return ResponseEntity.ok(servicio.listarCursosDisponibles());
        }

        @GetMapping
        public ResponseEntity<List<Curso>> listarTodos() {
            return ResponseEntity.ok(servicio.listarTodosLosCursos());
        }

        @GetMapping("/{id}/participantes")
        public ResponseEntity<List<Inscripcion>> consultarParticipantes(@PathVariable Long id) {
            return ResponseEntity.ok(servicio.consultarParticipantesDeCurso(id));
        }
    }


