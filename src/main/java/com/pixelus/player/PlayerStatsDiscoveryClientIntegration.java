package com.pixelus.player;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

@Component
public class PlayerStatsDiscoveryClientIntegration {

    @Autowired
    private DiscoveryClient discoveryClient;

    @HystrixCommand(fallbackMethod = "defaultPlayerStatsLink")
    public Link buildPlayerStatsLink(Player player) {
        System.out.println("Looking up player-stats service...");
        InstanceInfo instanceInfo = discoveryClient.getNextServerFromEureka("player-stats", false);

        return new Link(instanceInfo.getHomePageUrl() + "playerstats/" + player.getId());
    }

    public Link defaultPlayerStatsLink(Player player) {
        return new Link("Unavailable");
    }
}