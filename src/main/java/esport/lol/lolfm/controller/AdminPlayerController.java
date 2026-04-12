package esport.lol.lolfm.controller;

import esport.lol.lolfm.service.PlayerMasterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/players")
@RequiredArgsConstructor
public class AdminPlayerController {

    private final PlayerMasterService playerMaterService;

    @GetMapping("/new")
    public String registrationForm(Model model) {
        return "admin/player-form";
    }

    @PostMapping
    public String register(@ModelAttribute) {
        playerMaterService.register();
        return "redirect:/admin/player";
    }
}
