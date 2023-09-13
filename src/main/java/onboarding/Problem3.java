package onboarding;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem3 {
    private static final Set<Character> checkContain369 = new HashSet<>(List.of('3','6','9'));
    public static int solution(int number) {
        int answer = 0;
        for(int i=1; i<=number; i++){
            String changeNumber = String.valueOf(i);
            answer += getAnsewerContain369(changeNumber);
        }
        return answer;
    }
    private static int getAnsewerContain369(String changeNumber){
        int count = 0;
        for(int i=0; i<changeNumber.length(); i++){
            if(checkContain369.contains(changeNumber.charAt(i))){
                count +=1;
            }
        }
        return count;
    }
}
