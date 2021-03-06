package uk.co.krystianjagoda.springapp.app.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uk.co.krystianjagoda.springapp.app.model.Player;
import uk.co.krystianjagoda.springapp.app.service.PlayerService;


@Controller
@RequestMapping("players")
@SessionAttributes("playerSession")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @ModelAttribute
    public Player defaultPlayer() {
        return new Player("...", "...");
    }

    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String displayPlayers(Model model) {
        model.addAttribute("players", playerService.getPlayers());

        return "players";
    }

    @RequestMapping(value = "form", method = RequestMethod.POST)
    public String addPlayers(Player player, Model model) {
        playerService.addPlayers(player);
        model.addAttribute("players", playerService.getPlayers());

        return "players";

    }

    @RequestMapping(value = "/removePlayers", method = RequestMethod.POST)
    public String removePlayers(Player player, Model model) {
        playerService.removePlayers(player);
        model.addAttribute("players", playerService.getPlayers());

        return "players";
    }


}
