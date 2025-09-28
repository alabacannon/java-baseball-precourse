package domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import constants.GameConstant;

public class Opponent {

    static List<Integer> opponentBalls;

    // 싱글톤
    private Opponent(){}
    private static final Opponent opponent = new Opponent();
    public static Opponent getOpponent() {
        return opponent;
    }

    public List<Integer> getOpponentBalls() {
        return opponentBalls;
    }

    public void setOpponentBalls() {
        opponentBalls =  new ArrayList<>();
        while (opponentBalls.size() < 3) {
            int n = Randoms.pickNumberInRange(1, GameConstant.MAX_NUM);
            if (opponentBalls.contains(n)) {
                continue;
            }
            opponentBalls.add(n);
        }
//        System.out.println(opponentBalls);


    }
}
