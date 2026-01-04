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
        for(int i = 0; i < answerLength-1; i++){
        digit = digit *10;
        }
    }

    public static List<Integer> getUserAnswer() {
        userAnswer = Integer.parseInt(Console.readLine());
        validateLength(userAnswer);
        List<Integer> afterProcessAnswer = processAnswer(userAnswer);
        validateNumbers(afterProcessAnswer);
        validateUnique(afterProcessAnswer);
        return afterProcessAnswer;
    }
    private static List<Integer> processAnswer(int userAnswer){
        List<Integer> processAns = new ArrayList<>();
        digit =1;
        makeDigit();
        for(int i = 0 ; i < answerLength; i++){
            processAns.add(userAnswer/ digit);
            userAnswer = userAnswer%digit;
            digit = digit/10;
        }
        return processAns;
    }

    private static void validateLength(int userAnswer){
        if(111 < userAnswer && userAnswer < 1000) return;
        throw new IllegalArgumentException("잘못된 입력값을 입력하였습니다.");
    }

    private static void validateNumbers(List<Integer> AfterProcessAnswer){
        for(int i = 0; i < answerLength; i++){
            if(AfterProcessAnswer.get(i) == 0){
                throw new IllegalArgumentException("잘못된 입력값을 입력하였습니다.");
            }
        }
    }

    public static List<Integer> makeAns() {
        List<Integer> ans = new ArrayList<>();
        int tmp = 0;
        tmp = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(startNum,endNum);
        ans.add(tmp);
        int tmp2 = 0;
        while(true){
        tmp2 = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(startNum,endNum);
            if(tmp != tmp2){
                ans.add(tmp2);
                break;
            }
        }
        int tmp3 = 0;
        one :while (true){
            tmp3 = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(startNum,endNum);
            boolean check = false;
            for(int i = 0 ; i < 2; i++){
                if(ans.get(i) != tmp3);
                else check = true;
            }
        if(!check){
            ans.add(tmp3);
            break one;
        }
        }

        return ans;
    }

    private static void validateUnique(List<Integer> AfterProcessAnswer){
        boolean[] check = new boolean[10];
        for(int i = 0; i< answerLength; i++){
            if(!check[AfterProcessAnswer.get(i)])
                check[AfterProcessAnswer.get(i)] = true;
            else throw new IllegalArgumentException("잘못된 입력값을 입력하였습니다.");
        }
    }

}
