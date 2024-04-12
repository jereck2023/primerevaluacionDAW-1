package pe.edu.cibertec.waprimeraevaluacion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.waprimeraevaluacion.model.PreguntaCuatroModel;

@Controller
public class PreguntaCuatroController {

    @GetMapping("/preguntacuatro")
    public String inicioPreguntaCuatro(Model model){
        model.addAttribute("preguntaCuatroModel", new PreguntaCuatroModel());
        model.addAttribute("mostrarMensaje", false);
        return "preguntacuatro";
    }
    @PostMapping("/preguntacuatro")
    public String calcularPreguntaCuatro(@ModelAttribute("preguntaCuatroModel") PreguntaCuatroModel preguntaCuatroModel,
                                       Model model){

        int primero = preguntaCuatroModel.getInicial();
        int segundo = preguntaCuatroModel.getFin();

        int i;
        int suma = 0;

        for(i = primero; i <= segundo; i ++) {
            suma += (i - i % 10) / 10 + i % 10;
        }



        model.addAttribute("mostrarMensaje", true);
        model.addAttribute("resultado", "La suma de los dígitos es: "
                +suma);
        return "preguntacuatro";
    }
}
