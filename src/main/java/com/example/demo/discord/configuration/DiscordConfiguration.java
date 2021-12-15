package com.example.demo.discord.configuration;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DiscordConfiguration {

    @Value("${token}")
    private String token;

    @Bean
    public DiscordApi discordApiBean(){
        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!ping")) {
                event.getChannel().sendMessage("Pong!");
            }
        });
        return api;

    }


}
