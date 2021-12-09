package com.example.demo.session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginStructure {
        public static Map<String, String> map = new HashMap<>();
        public static List<String[]> list = new ArrayList<>();

        public static void InitMap() {
            map.put("Dima", "2003");
            map.put("Damir", "2002");
            map.put("Vlad", "2001");
        }

        public static void InitList() {
            list.add(new String[]{"Dima", "2003"});
            list.add(new String[]{"Damir", "2002"});
            list.add(new String[]{"Vlad", "2001"});
        }

        public static boolean checkInList(String login, String password){
            for (String[] x:list) {
                if (x[0].equals(login) && x[1].equals(password)){
                    return true;
                }
            }
            return false;
        }
        public static boolean checkInMap(String login, String password) {
            if (map.containsKey(login) && map.get(login).equals(password)) {

                return true;
            }
            return false;
        }
    }


