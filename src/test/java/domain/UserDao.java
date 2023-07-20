package domain;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

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
