package com.bot.bot.repo;

import com.bot.bot.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountsBotRepository extends JpaRepository<Accounts, String> {
}
