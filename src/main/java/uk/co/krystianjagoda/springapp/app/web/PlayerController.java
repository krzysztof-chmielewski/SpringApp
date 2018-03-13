package uk.co.krystianjagoda.springapp.app.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class PlayerController {
    private final List<String> players = new ArrayList<>();

    public PlayerController() {
        players.add("Adam Lalanna");
    }

    @GetMapping("display")
    public String display(Model model){
        model.addAttribute("players", players);

        return "players";
    }

    @PostMapping("add")
    public String addPlayer(@RequestParam String firstName, @RequestParam String lastName, Model model){
        players.add(firstName + " " + lastName);
        model.addAttribute("players",players);

        return "players";

    }

    @PostMapping("remove")
    public String removePlayer(@RequestParam String firstName, @RequestParam String lastName, Model model){
        players.remove(firstName + " " + lastName);
        model.addAttribute("players", players);

        return "players";
    }


}
