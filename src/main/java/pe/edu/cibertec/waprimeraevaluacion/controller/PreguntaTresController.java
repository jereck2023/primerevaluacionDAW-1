package pe.edu.cibertec.waprimeraevaluacion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.waprimeraevaluacion.model.PreguntaTresModel;

@Controller
public class PreguntaTresController {

    @GetMapping("/preguntatres")
    public String inicioPreguntaTres(Model model){
        model.addAttribute("preguntaTresModel", new PreguntaTresModel());
        model.addAttribute("mostrarMensaje", false);
        return "preguntatres";
    }
    @PostMapping("/preguntatres")
    public String calcularPreguntaTres(@ModelAttribute("preguntaTresModel") PreguntaTresModel preguntaTresModel,
                                       Model model){

        int numero = preguntaTresModel.getMesnum();
        String nombre = switch (numero) {
            case 1 -> "Enero";
            case 2 -> "Febrero";
            case 3 -> "Marzo";
            case 4 -> "Abril";
            case 5 -> "Mayo";
            case 6 -> "Junio";
            case 7 -> "Julio";
            case 8 -> "Agosto";
            case 9 -> "Septiembre";
            case 10 -> "Octubre";
            case 11 -> "Noviembre";
            default -> "Diciembre";
        };

        model.addAttribute("mostrarMensaje", true);
        model.addAttribute("resultado", "Nombre del mes: "
                +nombre);
        return "preguntatres";
    }
}
