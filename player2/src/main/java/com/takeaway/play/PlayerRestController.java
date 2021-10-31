package com.takeaway.play;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

/**
 * @author misajovanovic
 * @created on 31.10.21. at 20:38
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/game")
@Api(value = "Payroll Integrations")
public class PlayerRestController {

    private final PlayerService playerService;
    private final PlayerClient playerClient;

    @ApiOperation(value = "Start a game", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully started a geame"),
    })
    @ResponseStatus(OK)
    @PostMapping(path = "/start")
    public String startGame(@RequestBody Integer num) {
        return playerService.startGame(num);
    }

    @ApiOperation(value = "Play a game", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved winner of the game"),
    })
    @ResponseStatus(OK)
    @PostMapping(path = "/play")
    public String playGame(@RequestBody Integer num) {
        if (num != 1) {
            playerClient.playGame(playerService.playGame(num));
        }
        return "Player 1 WON the Game!!!";
    }
}
