package com.pixelus.player.discoveryservice;

import com.pixelus.player.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

@Component
public class PlayerResourceDiscoveryClientProcessor implements ResourceProcessor<Resource<Player>> {

    @Autowired
    private PlayerStatsDiscoveryClientIntegration playerStatsDiscoveryClientIntegration;

    @Override
    public Resource<Player> process(final Resource<Player> playerResource) {

        final Player player = playerResource.getContent();
        final Link playerStatsLink = playerStatsDiscoveryClientIntegration.getPlayerStatsLinkById(player.getId());
        if (playerStatsLink != null) {
            playerResource.add(playerStatsLink.withRel("stats"));
        }

        return playerResource;
    }
}
