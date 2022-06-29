package com.bot.bot.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Accounts implements Serializable {
    @Id
    private String id;

    private String keyBot;

    private String discordName;

    private String status;



    public Accounts() {
    }

    public Accounts(String id, String keyBot, String discordName, String status) {
        this.id = id;
        this.keyBot = keyBot;
        this.discordName = discordName;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKeyBot() {
        return keyBot;
    }

    public void setKeyBot(String keyBot) {
        this.keyBot = keyBot;
    }

    public String getDiscordName() {
        return discordName;
    }

    public void setDiscordName(String discordName) {
        this.discordName = discordName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}