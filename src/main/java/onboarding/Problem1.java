package onboarding;

import java.util.List;

class Problem1 {
    private static final int exceptionNum = -1;
    private static final int compareNum = 0;
    private static final int winPobiNum = 1;
    private static final int winCrongNum = 2;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int ans = 0;

        if(isNotSize(pobi) || isNotSidePage(pobi) || isNotRange(pobi)){
            return exceptionNum;
        }

        if(isNotSize(crong) || isNotSidePage(crong) || isNotRange(crong)){
            return exceptionNum;
        }

        return ans;
    }

    private static boolean isNotSize(List<Integer> checkList){
        return checkList.size() !=2;
    }

    private static boolean isNotSidePage(List<Integer> checkList){
        return checkList.get(1) - checkList.get(0) != 1;
    }

    private static boolean isNotRange(List<Integer> checkList){
        if((checkList.get(0)>0 && checkList.get(0)<=400)
        && (checkList.get(1)>0 && checkList.get(1)<=400)){
            return false;
        }
        return true;
    }
}