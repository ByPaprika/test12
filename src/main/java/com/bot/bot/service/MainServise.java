package com.bot.bot.service;

import com.bot.bot.model.AskDiscord;
import com.bot.bot.repo.AccountsBotRepository;
import com.bot.bot.repo.AskDiscordRepository;
import org.springframework.stereotype.Service;

@Service
public class MainServise {
    private final AccountsBotRepository accountsBotRepository;
    private final AskDiscordRepository askDiscordRepository;

    public MainServise(AccountsBotRepository accountsBotRepository, AskDiscordRepository askDiscordRepository){
        this.accountsBotRepository = accountsBotRepository;
        this.askDiscordRepository = askDiscordRepository;
    }

    public void createNewAsk(AskDiscord askDiscord) {
        askDiscordRepository.save(askDiscord);
    }
}
