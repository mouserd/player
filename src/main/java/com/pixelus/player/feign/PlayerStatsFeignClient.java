package com.pixelus.player.feign;

import com.pixelus.player.model.PlayerStats;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("player-stats")
interface PlayerStatsFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/playerstats/{id}")
    PlayerStats getPlayerStats(@PathVariable("id") String id);
}