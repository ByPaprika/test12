package com.bot.bot.controllers;


import com.bot.bot.model.Accounts;
import com.bot.bot.model.AskDiscord;
import com.bot.bot.service.MainServise;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "https://github.com/")
@RequestMapping("/bot")
public class MainController {
    private final MainServise mainServise;

    public MainController(MainServise mainServise) {
        this.mainServise = mainServise;
    }

    @PostMapping("/ask")
    public void createNewAsk(@RequestBody AskDiscord ask) {
        mainServise.createNewAsk(ask);
    }

    @GetMapping("/login")
    public Accounts loginApp(@AuthenticationPrincipal Accounts accounts) {
        return accounts;
    }

}
