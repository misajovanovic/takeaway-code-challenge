package com.takeaway.play;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author misajovanovic
 * @created on 31.10.21. at 20:37
 */

@RequiredArgsConstructor
@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerClient playerClient;

    @Override
    public String startGame(Integer number){
        return playerClient.playGame(number);
    }

    @Override
    public Integer playGame(Integer number) {
        Integer result;
        if (number == 0) {
            throw new ArithmeticException("Play number cannot be zero");
        }else if (number == 1){
            return number;
        } else {
            result = divideNumberBy3(number);
        }
        playerClient.playGame(result);
        return result;
    }

    private Integer divideNumberBy3(Integer number) {
        if (checkIsNumberDivisibleBy3(number)) {
            return number / 3;
        } else {
            number = makeNumberDivisibleBy3(number);
        }
        return number;
    }

    private Integer makeNumberDivisibleBy3(Integer number) {
        if (++number % 3 == 0) {
            return number / 3;
        } else {
            return --number / 3;
        }
    }

    private boolean checkIsNumberDivisibleBy3(Integer number) {
        return number % 3 == 0;
    }
}
