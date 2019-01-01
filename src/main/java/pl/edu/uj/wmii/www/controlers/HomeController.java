package pl.edu.uj.wmii.www.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.uj.wmii.www.entity.Player;
import pl.edu.uj.wmii.www.services.PlayerService;

import java.util.List;

@Controller
public class HomeController {
    private PlayerService playerService = new PlayerService();

    @RequestMapping("/")
    public String displayHome () {
        return "home";
    }

    @RequestMapping("/player")
    public ModelAndView addPlayer(@RequestParam("playerName") String playerName) {

        if (playerService.isValid(playerName)) {
            playerService.addPlayer(playerName);
        }
        List<Player> players = playerService.getPlayers();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.addObject("players", players);

        return modelAndView;
    }

    @RequestMapping("/play")
    public ModelAndView startGame(@RequestParam("chosenPlayers") Player[] chosenPlayers) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("game");
        modelAndView.addObject("chosenPlayers");
        return modelAndView;
    }
}
