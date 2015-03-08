package com.pixelus.player.resttemplate;

import com.pixelus.player.model.Player;
import com.pixelus.player.model.PlayerStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

@Component
public class PlayerResourceRestTemplateProcessor implements ResourceProcessor<Resource<Player>> {

    @Autowired
    private PlayerStatsRestTemplate playerStatsRestTemplate;

    @Override
    public Resource<Player> process(final Resource<Player> playerResource) {

        final Player player = playerResource.getContent();
        final PlayerStats playerStats = playerStatsRestTemplate.getPlayerStatsById(player.getId());
        if (playerStats != null) {
            player.setStats(playerStats);
        }

        return playerResource;
    }
}
