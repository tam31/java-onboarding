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
                String userFriend = getUserFriend(userA, userB, user);
                userFriendList.add(userFriend);
            }
        }

        for(List<String> friend: friends){
            String userA = friend.get(0);
            String userB = friend.get(1);
            if(checkFriend(userA,userB,user)){
                String friendFriend = getFriend(userA,userB);
                recommendFriendList.put(friendFriend, recommendFriendList.getOrDefault(friendFriend,0)+10);
            }
        }

        for(String friend: visitors){
            recommendFriendList.put(friend, recommendFriendList.getOrDefault(friend, 0)+1);
        }

        return answer;
    }

    private static String getFriend(String userA, String userB){
        return userFriendList.contains(userA) ? userB : userA;
    }

    private static boolean checkFriend(String userA, String userB, String user){
        if(user.equals(userA) || user.equals(userB)) return false;
        if(userFriendList.contains(userA)|| userFriendList.contains(userB)) return true;
        return false;
    }

    private static boolean checkUserFriend(String userA, String userB, String user){
        return user.equals(userA) || user.equals(userB);
    }
    private static String getUserFriend(String userA, String userB, String user){
        return user.equals(userA) ? userB : userA;
    }
}
