package domain;

import constants.GameConstant;
import constants.GameMessages;

import java.util.List;

public class Referee {

    public int strike;
    public int ball;

    public Referee() {}

    public void judge(List<Integer> playerBalls, List<Integer> opponentBalls) {
        strike = 0;
        ball = 0;
        for (int i = 0; i < playerBalls.size(); i++) {
            int playerBall = playerBalls.get(i);
            determineStrikeOrBall(playerBall, opponentBalls, i);
        }
        refereeCall();
    }

    private void determineStrikeOrBall(int playerBall, List<Integer> opponentBalls, int i) {
        if (playerBall == opponentBalls.get(i)) {
            strike++;
            return;
        }
        for (int j = 0; j < GameConstant.BALL_COUNT; j++) {
            if (playerBall == opponentBalls.get(j)) {
                ball++;
                return;
            }
        }
    }

    public void refereeCall() {
        if (strike ==0 && ball == 0) {
            System.out.println(GameMessages.nothingMSG);
            return;
        }
        if (ball > 0) {
            System.out.print(ball + GameMessages.ballMSG + " ");
        }
        if (strike > 0) {
            System.out.print(strike + GameMessages.strikeMSG);
        }
        System.out.println();
    }
}
