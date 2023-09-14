package onboarding;

import java.util.*;

public class Problem6 {

    private static HashMap<String, String> checkDuplication = new HashMap<>();
    private static Set<String> duplicationEmail = new HashSet<>();
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;

        for(List<String> list: forms){
            String email = list.get(0);
            String name = list.get(1);
            getAnswerCheckDulications(name, email);
        }
        answer = new ArrayList<>(duplicationEmail);
        Collections.sort(answer);
        return answer;
    }

    private static void getAnswerCheckDulications(String name, String email){
        for(int i=0; i<=name.length()-2; i++){
            String checkName = name.substring(i,i+2);
            if(checkDuplication.containsKey(checkName)){
                duplicationEmail.add(email);
                duplicationEmail.add(checkDuplication.get(checkName));
            }else{
                checkDuplication.put(checkName, email);
            }
        }
    }
}
