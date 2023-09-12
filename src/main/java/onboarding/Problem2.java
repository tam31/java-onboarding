package onboarding;

import java.util.Stack;

public class Problem2 {
    private static boolean status = true;
    public static String solution(String cryptogram) {
        String answer = "";

        while(status){
            status = false;
            answer = getAnswerWithoutDuplicate(cryptogram);
            status = compareTwoLength(cryptogram, answer);
            cryptogram = answer;
        }
        return answer;
    }
    private static boolean compareTwoLength(String cryptogram, String answer){
        return !(cryptogram.length() == answer.length());
    }
    private static String getAnswerWithoutDuplicate(String cryptogram){
        if(cryptogram.length()==0) return "";

        String removeDuplicate = "";
        char checkDuplicateValue = cryptogram.charAt(0);
        boolean checkDuplicateStatus = false;
        for(int i=1; i<cryptogram.length(); i++){
            if(checkDuplicateValue==cryptogram.charAt(i)){
                checkDuplicateStatus = true;
            }else if(checkDuplicateStatus && checkDuplicateValue != cryptogram.charAt(i)){
                checkDuplicateValue = cryptogram.charAt(i);
                checkDuplicateStatus = false;
            }else{
                removeDuplicate += checkDuplicateValue;
                checkDuplicateValue = cryptogram.charAt(i);
            }
        }
        if(!checkDuplicateStatus){
            removeDuplicate += checkDuplicateValue;
        }
        return removeDuplicate;
    }
}
