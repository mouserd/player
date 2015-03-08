package com.pixelus.player.discoveryservice;

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

    @HystrixCommand(fallbackMethod = "defaultPlayerStatsLinkById")
    public Link getPlayerStatsLinkById(final String id) {

        final InstanceInfo instanceInfo = discoveryClient.getNextServerFromEureka("player-stats", false);
        return new Link(instanceInfo.getHomePageUrl() + "playerstats/" + id);
    }

    public Link defaultPlayerStatsLinkById(final String id) {
        return new Link("Unavailable");
    }
}