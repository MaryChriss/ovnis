package br.com.fiap.epictaskx.task;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/task")
public class SightingController {

    private final SightingService sightingService;

    public SightingController(SightingService sightingService) {
        this.sightingService = sightingService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("sighting", sightingService.getAllTasks());
        return "index";
    }

    @GetMapping("/form")
    public String form() {
        return "form";
    }

    @PostMapping("/form")
    public String create(Sighting sighting, RedirectAttributes redirect) { //TODO DTO
        sightingService.save(sighting);
        redirect.addFlashAttribute("message", "Tarefa cadastrada com sucesso !");
        return "redirect:/task";
    }

}
