package service;


import constants.GameConstant;
import constants.GameMessages;
import domain.Opponent;
import domain.Player;
import domain.Referee;
import camp.nextstep.edu.missionutils.Console;


public class BaseBallGame {

    Opponent opponent;
    Referee referee;
    Player player;


    // 싱글톤
    private BaseBallGame() {
        opponent = Opponent.getOpponent();
    }
    private static final BaseBallGame baseBallGame = new BaseBallGame();

    public static BaseBallGame getBaseBallGame() {
        return baseBallGame;
    }


    public void play(){
        opponent.setOpponentBalls();
        boolean gameOver = false;
        while (!gameOver) {
            referee = new Referee();
            player = new Player();
            player.setPlayerBalls();
            referee.judge(player.getPlayerBalls(),opponent.getOpponentBalls());
            gameOver = isGameOver();
        }

    }

    private boolean isGameOver() {
        if (referee.strike == 3){
            System.out.println(GameConstant.BALL_COUNT + GameMessages.gameOverMSG);
            return true;
        }
        return false;
    }

    public boolean terminate(){
        while (true){
            try {
                System.out.println(GameMessages.nextGameMSG);
                String input = Console.readLine();
                int msg = checkValidInput(input);
                return isTerminated(msg);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " => 올바른 값을 입력해주세요");
            }
        }
    }

    private boolean isTerminated(int msg) {
        return msg != 1;
    }

    private static int checkValidInput(String input) {
        try {
            int msg = Integer.parseInt(input);
            if (msg != 1 && msg != 2) {
                throw new IllegalArgumentException("1 또는 2를 입력하세요");
            }
            return msg;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 입력해주세요");
        }
    }
}
