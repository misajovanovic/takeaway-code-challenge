package com.takeaway.play;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author misajovanovic
 * @created on 31.10.21. at 20:55
 */
@FeignClient(name = "player-1", url = "http://localhost:8081/api/game")
public interface PlayerClient {

    @PostMapping(path = "/start")
    String startGame(@RequestBody Integer number);

    @PostMapping(path = "/play")
    String playGame(@RequestBody Integer number);

}
