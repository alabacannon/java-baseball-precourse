package domain;

import camp.nextstep.edu.missionutils.Console;
import constants.GameConstant;
import constants.GameMessages;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Player {
    List<Integer> balls;


    public List<Integer> getPlayerBalls() {
        return balls;
    }

    public void setPlayerBalls() {
//        while(true){
            try {
                System.out.print(GameMessages.inputMSG);
                getInput();
                validUniqueness(balls);
                validBallCount(balls);
                validFormat(balls);
//                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                throw e;
            }
//        }


    }
    public void getInput() {
        balls = Console.readLine().chars()
                .map(c -> c - '0')
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private void validUniqueness(List<Integer> balls) {
        Set<Integer> uniqueness = new HashSet<>(balls);
        if (uniqueness.size() != balls.size()){
            throw new IllegalArgumentException("중복된 숫자를 기입하였습니다");
        }
    }

    private void validFormat(List<Integer> balls) {
        for (int ball : balls) {
            if (ball < 1 || ball > 9) {
                throw new IllegalArgumentException("숫자만 입력해야 합니다");
            }
        }
    }

    private static void validBallCount(List<Integer> balls) {
        if (balls.size() != GameConstant.BALL_COUNT){
            throw new IllegalArgumentException(GameConstant.BALL_COUNT + "개의 숫자를 입력해주세요");
        }
    }


}
