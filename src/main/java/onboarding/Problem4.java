package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        answer = getGreenFrog(word);
        return answer;
    }

    private static String getGreenFrog(String word){
        String greenFrog = "";
        for(int i=0; i<word.length(); i++){
            greenFrog += Character.isAlphabetic(word.charAt(i)) ?
                    checkAlpahetChar(word.charAt(i)) : word.charAt(i);
        }
        return greenFrog;
    }
    private static char checkAlpahetChar(char word){
        if(checkLowerAlpahet(word)){
            return changeLowerAlpahet(word);
        }
        return changeUpperAlpahet(word);
    }

    private static char changeLowerAlpahet(char word){
        return (char)('a' + ('z'-word));
    }

    private static char changeUpperAlpahet(char word){
       
    }

    private static boolean checkLowerAlpahet(char word){
        return Character.isLowerCase(word);
    }

    private static boolean checkUpperAlpahet(char word){
        return Character.isUpperCase(word);
    }
}
