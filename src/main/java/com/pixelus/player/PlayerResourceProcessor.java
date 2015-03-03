package com.pixelus.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

@Component
public class PlayerResourceProcessor implements ResourceProcessor<Resource<Player>> {

    @Autowired
    private PlayerStatsDiscoveryClientIntegration playerStatsDiscoveryClientIntegration;

    @Override
    public Resource<Player> process(final Resource<Player> playerResource) {

        Link playerStatsLink = playerStatsDiscoveryClientIntegration.buildPlayerStatsLink(playerResource.getContent());
        if (playerStatsLink != null) {
            playerResource.add(playerStatsLink);
        }

        return playerResource;
    }
}
