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
import mx.utng.ultima.model.entity.Deporte;
import mx.utng.ultima.model.service.IDeporteService;



@Controller
@SessionAttributes("deporte")
public class DeporteController {
    //Inyectamos una dependencia del servicio
    @Autowired
    private IDeporteService deporteService;

    //Manda llamar este metodo en una peticion GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"/deporte/list","/deporte","/deporte/"})
    public String list(Model model){
        model.addAttribute("title", "Listado Deportes");
    model.addAttribute("deportes", deporteService.list());
    return "delist";
    }

    //Peticion que contenga al final de la url /form
    @GetMapping("/deporte/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de deseos de deportes");
        model.addAttribute("deporte", new Deporte());
        return "deform";
    }

    @GetMapping("/deporte/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Deporte deporte = null;
        if (id>0) {
            deporte = deporteService.getById(id);
        }else{
            return "redirect:delist";
        }

        model.addAttribute("title", "Editar lista de deportes");
        model.addAttribute("deporte", deporte);
        return "deform";
    }

    @PostMapping ("/deporte/form")
    public String save(@Valid Deporte deporte, BindingResult br, Model model){

        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de lista de deportes");
            return "deform";
        }

        deporteService.save(deporte);
        return "redirect:/deporte/list";
    }

    @GetMapping("/deporte/delete/{id}")
    public String delete (@PathVariable Long id, Model model){
        if (id>0) {
            deporteService.delete(id);
        }
        return "redirect:/deporte/list";
    }

}



