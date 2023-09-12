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

        int pobiLargeValue = getLargeValue(pobi);
        int crongLargeValue = getLargeValue(crong);


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

    private static int getSum(int number){
        int sum = 0;
        while(number !=0){
            sum += number%10;
            number /= 10;
        }
        return sum;
    }

    private static int getMultiplication(int number){
        int sum = 1;
        while(number != 0){
            sum *= number%10;
            number /=10;
        }
        return sum;
    }

    private static int getLargeValue(List<Integer> checkList){
        int leftSumValue = getSum(checkList.get(0));
        int leftMultiplicationValue = getMultiplication(checkList.get(0));
        int rightSumValue = getSum(checkList.get(1));
        int rightMultiplicationValue = getMultiplication(checkList.get(1));

        int leftLargeValue = Math.max(leftSumValue, leftMultiplicationValue);
        int rigthLargeValue = Math.max(rightSumValue, rightMultiplicationValue);

        return Math.max(leftLargeValue, rigthLargeValue);
    }
}