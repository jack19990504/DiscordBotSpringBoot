package com.example.demo.discord.handler;

import org.javacord.api.DiscordApi;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TextHandler {


    private final DiscordApi api;

    public TextHandler(DiscordApi api){
        this.api = api;
    }

    @PostConstruct
    public void addListener(){
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!hey")) {
                event.getChannel().sendMessage("ho!");
            }
        });
    }
}
