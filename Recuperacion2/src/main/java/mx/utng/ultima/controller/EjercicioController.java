package mx.utng.ultima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import jakarta.validation.Valid;
import mx.utng.ultima.model.entity.Ejercicio;
import mx.utng.ultima.model.service.IEjercicioService;



@Controller
@SessionAttributes("ejercicio")
public class EjercicioController {
    //Inyectamos una dependencia del servicio
    @Autowired
    private IEjercicioService ejercicioService;

    //Manda llamar este metodo en una peticion GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"/ejercicio/list","/ejercicio","/ejercicio/"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Consumo de ejercicio");
    model.addAttribute("ejercicios", ejercicioService.list());
    return "elist";
    }

    //Peticion que contenga al final de la url /form
    @GetMapping("/ejercicio/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de Consumo de ejercicio");
        model.addAttribute("ejercicio", new Ejercicio());
        return "eform";
    }

    @GetMapping("/ejercicio/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Ejercicio ejercicio = null;
        if (id>0) {
            ejercicio = ejercicioService.getById(id);
        }else{
            return "redirect:elist";
        }

        model.addAttribute("title", "Editar consumo de ejercicio");
        model.addAttribute("ejercicio", ejercicio);
        return "eform";
    }

    @PostMapping ("/ejercicio/form")
    public String save(@Valid Ejercicio ejercicio, BindingResult br, Model model){

        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de comsumo de ejercicio");
            return "eform";
        }

        ejercicioService.save(ejercicio);
        return "redirect:/ejercicio/list";
    }

    @GetMapping("/ejercicio/delete/{id}")
    public String delete (@PathVariable Long id, Model model){
        if (id>0) {
            ejercicioService.delete(id);
        }
        return "redirect:/ejercicio/list";
    }

}



