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
import mx.utng.ultima.model.entity.Personal;
import mx.utng.ultima.model.service.IPersonalService;



@Controller
@SessionAttributes("personal")
public class PersonalController {
    //Inyectamos una dependencia del servicio
    @Autowired
    private IPersonalService personalService;

    //Manda llamar este metodo en una peticion GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"/personal/list","/personal","/personal/"})
    public String list(Model model){
        model.addAttribute("title", "Gastos en cuidado personal");
    model.addAttribute("personales", personalService.list());
    return "plist";
    }

    //Peticion que contenga al final de la url /form
    @GetMapping("/personal/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de gastos personales");
        model.addAttribute("personal", new Personal());
        return "pform";
    }

    @GetMapping("/personal/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Personal personal = null;
        if (id>0) {
            personal = personalService.getById(id);
        }else{
            return "redirect:plist";
        }

        model.addAttribute("title", "Editar gastos en cuidado personal");
        model.addAttribute("personal", personal);
        return "pform";
    }

    @PostMapping ("/personal/form")
    public String save(@Valid Personal personal, BindingResult br, Model model){

        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de gastos en cuidado personal");
            return "pform";
        }

        personalService.save(personal);
        return "redirect:/personal/list";
    }

    @GetMapping("/personal/delete/{id}")
    public String delete (@PathVariable Long id, Model model){
        if (id>0) {
            personalService.delete(id);
        }
        return "redirect:/personal/list";
    }
}



