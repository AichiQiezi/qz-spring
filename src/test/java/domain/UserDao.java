package domain;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

    public void initDataMethod(){
        System.out.println("执行：init-method");
        hashMap.put("10001", "小傅哥");
        hashMap.put("10002", "八杯水");
        hashMap.put("10003", "阿毛");
    }

    public void destroyDataMethod(){
        System.out.println("执行：destroy-method");
        hashMap.clear();
    }


    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "qz");
        hashMap.put("10002", "cat");
        hashMap.put("10003", "dog");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

}
