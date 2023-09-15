package onboarding;

import java.util.*;

public class Problem7 {

    private static Set<String> userFriendList;
    private static Map<String, Integer> recommendFriendList;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>(Collections.emptyList());

        userFriendList =  getUserFriendList(user, friends);
        recommendFriendList = getRecommendFriendList(user, friends);


        for(String friend: visitors){
            if(userFriendList.contains(friend)) continue;
            recommendFriendList.put(friend, recommendFriendList.getOrDefault(friend, 0)+1);
        }

        List<String[]> recommendFriends = new ArrayList<>();
        for(String key: recommendFriendList.keySet()){
            String core =  Integer.toString(recommendFriendList.get(key));
            recommendFriends.add(new String[]{key, core});
        }

        Collections.sort(recommendFriends, (o1,o2)->{
            int coreA = Integer.parseInt(o1[1]);
            int coreB = Integer.parseInt(o2[1]);
            if(coreA==coreB){
                return o1[0].compareTo(o2[0]);
            }
            return coreB-coreA;
        });

        for(int i=0; i<5&&i<recommendFriends.size(); i++){
            answer.add(recommendFriends.get(i)[0]);
        }
        return answer;
    }

    private static String getFriend(String userA, String userB){
        return userFriendList.contains(userA) ? userB : userA;
    }

    private static Set<String> getUserFriendList(String user, List<List<String>> friends){
        Set<String> userFriend = new HashSet<>();
        for(List<String> friend: friends){
            if(checkUserFriend(friend.get(0), friend.get(1), user)){
                userFriend.add(getUserFriend(friend.get(0), friend.get(1), user));
            }
        }
        return userFriend;
    }

    private static boolean checkUserFriend(String userA, String userB, String user){
        return user.equals(userA) || user.equals(userB);
    }
    private static String getUserFriend(String userA, String userB, String user){
        return user.equals(userA) ? userB : userA;
    }

    private static Map<String, Integer> getRecommendFriendList(String user, List<List<String>> friends){
        Map<String, Integer> recommendFriendScore = new HashMap<>();
        for(List<String> friend: friends){
            if(checkFriend(friend.get(0), friend.get(1), user)){
                String friendFriend = getFriend(friend.get(0),friend.get(1));
                recommendFriendScore.put(friendFriend, recommendFriendScore.getOrDefault(friendFriend,0)+10);
            }
        }
        return recommendFriendScore;
    }

    private static boolean checkFriend(String userA, String userB, String user){
        if(user.equals(userA) || user.equals(userB)) return false;
        if(userFriendList.contains(userA)|| userFriendList.contains(userB)) return true;
        return false;
    }
}
