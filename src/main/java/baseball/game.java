package baseball;

import camp.nextstep.edu.missionutils.Console;
import org.w3c.dom.ls.LSOutput;

import java.util.List;

public class game {
    private static List<Integer> guess;
    private static List<Integer> answer;

    public static void beforeRun(){
        answer = setting.makeAns();
    }

    public static int run() {


        System.out.print("숫자를 입력해 주세요 : ");
        guess = setting.getUserAnswer();

        int strike = 0;
        //3스트라이크
        int restart = 0;
        for (int i = 0; i < 3; i++) {
            if (guess.get(i) == answer.get(i)) strike++;

        }
        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("세 개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하시려면 1, 종료하시려면 2를 입력하세요.");

            restart = Integer.parseInt(Console.readLine());
            return restart;
        }

        //볼
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (guess.get(i) != answer.get(i)) {
                for (int j = 0; j < 3; j++) {
                    if (i != j) {
                        if (guess.get(i) == answer.get(j)) ball++;
                    }
                }

            }
        }

        if(ball != 0 && strike !=0) {
            System.out.println(ball + "볼" + " " + strike + "스트라이크");
        }else {
            System.out.println("낫싱");
        }
            ball = 0;
            strike = 0;

            return 0;

    }

}
