package pe.edu.cibertec.waprimeraevaluacion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.waprimeraevaluacion.model.PreguntaUnoModel;

@Controller
public class PreguntaUnoController {
    @GetMapping("/preguntauno")
    public String inicioPreguntaUno(Model model) {
        model.addAttribute("preguntaunoModel", new PreguntaUnoModel());
        model.addAttribute("mostrarMensaje",false);
        return "preguntauno";
    }

    @PostMapping("/preguntauno")
    public String calcularPreguntaUno(@ModelAttribute("preguntaunoModel") PreguntaUnoModel preguntaunoModel,
                              Model model) {
        double tasamax;
        double tasa = preguntaunoModel.getTasa();
        String indicador = preguntaunoModel.getIndicador();

        if (indicador.equals("T")) {
            tasamax = 0.5;
        } else {
            tasamax = 0.3;
        }

        String diagnostico = "";
        if ( tasa > tasamax) {
            diagnostico = "Positivo";
        } else {
            diagnostico = "Negativo";
        }

        model.addAttribute("mostrarMensaje", true);
        model.addAttribute("resultado", "Su diagnóstico es: "+ diagnostico);

        return "preguntauno";

    }
}
