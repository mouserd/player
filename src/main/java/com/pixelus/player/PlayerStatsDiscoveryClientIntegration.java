package com.pixelus.player;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

@Component
public class PlayerStatsDiscoveryClientIntegration {

    @Autowired
    private DiscoveryClient discoveryClient;

    public Link buildPlayerStatsLink(Player player) {
        System.out.println("Looking up player-stats service...");
        InstanceInfo instanceInfo = discoveryClient.getNextServerFromEureka("player-stats", false);

        return new Link(instanceInfo.getHomePageUrl() + "playerstats/" + player.getId());
    }
}