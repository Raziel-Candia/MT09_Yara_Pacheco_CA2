package mx.edu.utez.MT09_Yara_Pacheco_CA2.controller;

import jakarta.validation.Valid;
import mx.edu.utez.MT09_Yara_Pacheco_CA2.controller.dto.InscribirParticipanteDTO;
import mx.edu.utez.MT09_Yara_Pacheco_CA2.model.Inscripcion;
import mx.edu.utez.MT09_Yara_Pacheco_CA2.service.MyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscripciones")
@CrossOrigin("*")
public class InscripcionController {

    private final MyService servicio;

    public InscripcionController(MyService servicio) {
        this.servicio = servicio;
    }

    @PostMapping
    public ResponseEntity<Inscripcion> inscribir(@Valid @RequestBody InscribirParticipanteDTO payload) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.inscribirParticipante(payload));
    }

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<Inscripcion> cancelar(@PathVariable Long id) {
        return ResponseEntity.ok(servicio.cancelarInscripcion(id));
    }

    @GetMapping("/correo/{correo}")
    public ResponseEntity<List<Inscripcion>> consultarPorCorreo(@PathVariable String correo) {
        return ResponseEntity.ok(servicio.consultarInscripcionesPorCorreo(correo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inscripcion> consultarDetalle(@PathVariable Long id) {
        return ResponseEntity.ok(servicio.consultarDetalleInscripcion(id));
    }
}



