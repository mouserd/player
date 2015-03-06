package com.pixelus.player;

import com.pixelus.player.model.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "players", path = "players")
public interface PlayerRepository extends CrudRepository<Player, String> {
}
