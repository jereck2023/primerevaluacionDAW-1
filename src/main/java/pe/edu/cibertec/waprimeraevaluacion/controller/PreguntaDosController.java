package pe.edu.cibertec.waprimeraevaluacion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.waprimeraevaluacion.model.PreguntaDosModel;

@Controller
public class PreguntaDosController {
    @GetMapping("/preguntados")
    public String inicioPreguntaDos(Model model){
        model.addAttribute("preguntaDosModel", new PreguntaDosModel());
        model.addAttribute("mostrarMensaje", false);
        return "preguntados";
    }
    @PostMapping("/preguntados")
    public String calcularPreguntaDos(@ModelAttribute("preguntaDosModel") PreguntaDosModel preguntaDosModel,
                                      Model model){

        int primero = preguntaDosModel.getPrimero();
        int segundo = preguntaDosModel.getSegundo();
        int valor;

        if(primero == segundo){
            valor = primero * segundo;
        } else if (primero > segundo){
            valor = primero - segundo;
        }else {
            valor = primero + segundo;
        }

        model.addAttribute("mostrarMensaje", true);
        model.addAttribute("resultado", "Su valor es: "
                +valor);
        return "preguntados";
    }
}
