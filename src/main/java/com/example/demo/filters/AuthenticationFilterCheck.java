package com.example.demo.filters;
import java.util.HashMap;
import java.util.Set;

public class AuthenticationFilterCheck {

        public static HashMap<String, Boolean> checkMap = new HashMap<>();

        public static void checkMapInit(){
            checkMap.put("demo/saveServlet", false);
            checkMap.put("demo/viewServlet", true);
            checkMap.put("demo/deleteServlet", false);
            checkMap.put("demo/putServlet", false);
            checkMap.put("demo/viewByIDServlet", true);
            checkMap.put("demo/LogoutServlet", true);
            checkMap.put("demo/LoginServlet", true);
        }



        public static boolean checkMapUri(String uri){
            Set<String> set = checkMap.keySet();
            for (String key: set
            ) {
                if (uri.endsWith(key) && checkMap.get(key)){
                    return true;
                }
            }
            return false;

        }
    public static boolean checkLogin(String uri){
        return uri.endsWith("demo/loginServlet");
    }
}

