package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.ArrayList;

public class setting {
    public static int userAnswer;
    private static int answerLength = 3;
    private static int digit = 0;
    private static int startNum = 1;
    private static int endNum = 9;
    
    
    private static void makeDigit(){
        digit = 1;
        for(int i = 0; i < answerLength; i++){
        digit = digit *10;
        }
    }

    public List<Integer> getUserAnswer() {
        userAnswer = Integer.parseInt(Console.readLine());
        validateLength(userAnswer);
        List<Integer> afterProcessAnswer = processAnswer(userAnswer);
        validateNumbers(afterProcessAnswer);
        return afterProcessAnswer;
    }
    private List<Integer> processAnswer(int userAnswer){
        List<Integer> processAns = new ArrayList<>();
        digit =1;
        makeDigit();
        for(int i = 0 ; i < answerLength; i++){
            processAns.add(userAnswer/ digit);
            digit = digit/10;
        }
        return processAns;
    }

    private void validateLength(int userAnswer){
        if(99 < userAnswer && userAnswer < 1000) return;
        throw new IllegalArgumentException("잘못된 입력값을 입력하였습니다.");
    }

    private  void validateNumbers(List<Integer> AfterProcessAnswer){
        for(int i = 0; i < answerLength; i++){
            if(AfterProcessAnswer.get(i) == 0){
                throw new IllegalArgumentException("잘못된 입력값을 입력하였습니다.");
            }
        }
    }

    private int makeAns() {
        return camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(startNum,endNum);
    }

}
