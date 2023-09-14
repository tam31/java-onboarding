package onboarding;

import java.util.*;

public class Problem7 {

    private static Set<String> userFriendList = new HashSet<>();
    private static Map<String, Integer> recommendFriendList = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>(Collections.emptyList());

        for(List<String> friend: friends){
            String userA = friend.get(0);
            String userB = friend.get(1);
            if(checkUserFriend(userA, userB, user)){

            }
        }

        return answer;
    }

    private static boolean checkUserFriend(String userA, String userB, String user){
        return user.equals(userA) || user.equals(userB);
    }
}
