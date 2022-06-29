package com.bot.bot.repo;

import com.bot.bot.model.AskDiscord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AskDiscordRepository extends JpaRepository<AskDiscord, Long> {
}
