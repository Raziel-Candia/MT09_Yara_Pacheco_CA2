package mx.edu.utez.MT09_Yara_Pacheco_CA2.controller;

import mx.edu.utez.MT09_Yara_Pacheco_CA2.service.MyService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controlador")
@CrossOrigin("*")
public class MyController {
    private final MyService servicio;
    public MyController(MyService servicio) {
        this.servicio = servicio;
    }

}
