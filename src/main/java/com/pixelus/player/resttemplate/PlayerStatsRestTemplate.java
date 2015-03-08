package com.pixelus.player.resttemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.pixelus.player.model.PlayerStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PlayerStatsRestTemplate {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "defaultPlayerStatsById")
    public PlayerStats getPlayerStatsById(final String id) {

        return restTemplate.getForObject("http://player-stats/playerstats/{id}", PlayerStats.class, id);
    }

    public PlayerStats defaultPlayerStatsById(final String id) {
        return null;
    }
}
