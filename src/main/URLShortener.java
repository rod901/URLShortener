package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class URLShortener {
    static Map<String, Map<String, Integer>>mapWCounter = new HashMap<>();
    static String local = "http://localhost/";

    public static String getShort(String uri) {
        String temp = uri.substring(uri.indexOf(".com"))
                .replace(".com", "");

        String[] array = temp.split("/");
        String result = array[0];

        if (!mapWCounter.containsKey(uri)) {
            Map<String, Integer> map = new HashMap<>();
            result = local + result + "-" + new Random().ints(100).boxed().findFirst().get();
            map.put(result, 1);
            mapWCounter.put(uri, map);

        } else {
            Map<String, Integer> valueMap = mapWCounter.get(uri);

            for (String value : valueMap.keySet()) {
                Map<String, Integer> counterMap = new HashMap<>();
                result = value;
                int count = valueMap.get(value) + 1;
                counterMap.put(result, count);
                mapWCounter.put(uri, counterMap);
            }
        }
        return result;
    }

    public static int getHitCounter(String uri) {
        Map<String, Integer> defaultMap = new HashMap<>();
        defaultMap.put(local, 1);
        return mapWCounter
                    .getOrDefault(uri,defaultMap)
                    .entrySet()
                    .stream()
                    .mapToInt(value -> value.getValue())
                    .findFirst()
                    .getAsInt();
    }
}
