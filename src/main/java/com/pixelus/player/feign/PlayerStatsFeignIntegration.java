package com.pixelus.player.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PlayerStatsFeignIntegration implements CommandLineRunner {

    @Autowired
    private PlayerStatsFeignClient playerStatsClient;

    @Override
    public void run(String... args) {
        System.out.println(playerStatsClient.getPlayerStats("CD_P3001292"));
    }
}
