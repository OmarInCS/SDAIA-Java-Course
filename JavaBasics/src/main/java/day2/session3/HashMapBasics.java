package day2.session3;

import java.util.HashMap;

public class HashMapBasics {

    public static void main(String[] args) {

        var counteries = new HashMap<String, String>();
        counteries.put("SA", "Saudi Arabia");
        counteries.put("EG", "Egypt");
        counteries.put("AE", "Arab Emirates");

        System.out.println(counteries);
        System.out.println(counteries.keySet());
        System.out.println(counteries.values());
        System.out.println(counteries.size());

        System.out.println(counteries.get("SA"));
        counteries.put("EG", "Republic of Egypt");
        System.out.println(counteries);

        for (var item : counteries.entrySet()) {
            System.out.println(item.getKey());
            System.out.println(item.getValue());
        }
    }

}
