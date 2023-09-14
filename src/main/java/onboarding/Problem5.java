package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    private static final int[] listMoney = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(Collections.emptyList());

        for(int i=0; i<listMoney.length; i++){
            int getMoney = getAnswerMoney(money, listMoney[i]);
            answer.add(getMoney);
        }
        return answer;
    }

    private static int getAnswerMoney(int money, int listMoney){
        return money/listMoney;
    }

}
