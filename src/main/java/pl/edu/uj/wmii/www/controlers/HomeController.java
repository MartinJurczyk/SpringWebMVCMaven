package pl.edu.uj.wmii.www.controlers;

import core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.uj.wmii.www.services.PlayerService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class HomeController {
    private static PokerState pokerState;

    @Autowired
    private PlayerService playerService;

    @RequestMapping("/")
    public String displayHome() {
        return "home";
    }

    @RequestMapping("/player")
    public ModelAndView addPlayer(@RequestParam("playerName") String playerName) {
        playerService.addPlayer(playerName, 1000);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.addObject("players", playerService.getPlayers());
        return modelAndView;
    }

    @RequestMapping("/play")
    public ModelAndView startGame(@RequestParam(value = "chosenPlayers") Integer[] chosenIdPlayers) {
        playerService.setChosenPlayers(chosenIdPlayers);
        initGameManager();
        return getModelAndView();
    }

    @RequestMapping("/putMoney")
    public ModelAndView putMoney(@RequestParam(value = "money", defaultValue = "0") String money) {
        pokerState.makeMove(Integer.parseInt(money));
        return getModelAndView();
    }

    @RequestMapping("/pass")
    public ModelAndView pass() {
        pokerState.resign();
        return getModelAndView();
    }

    @RequestMapping("/cleanUp")
    public ModelAndView cleanUp() {
        pokerState.cleanUp();
        return getModelAndView();
    }

    private ModelAndView getModelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("game");
        modelAndView.addObject("state", pokerState);
        return modelAndView;
    }

    private void initGameManager() {
        pokerState = PokerState.builder()
                .players(playerService.getChosenPlayers())
                .build();
    }

    @RequestMapping("/img/{name}")
    @ResponseBody
    public HttpEntity<byte[]> getPhoto(@PathVariable String name) throws IOException {

        Path path = Paths.get("D:\\Studia\\WWW\\SpringWebMVCMaven\\src\\main\\webapp\\resources\\img\\" + name + ".png");
        byte[] image = Files.readAllBytes(path);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        headers.setContentLength(image.length);
        return new HttpEntity<>(image, headers);
    }
}
