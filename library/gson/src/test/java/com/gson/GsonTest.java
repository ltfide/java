package com.gson;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Type;
import java.util.*;

public class GsonTest {

    @Test
    void toJson() {
        Gson gson = new Gson();
        String json = gson.toJson("1");
        System.out.println(json); // "1"

        Map<String, Object> map = new HashMap<>();
        map.put("name", "Lutfi");
        map.put("age", 100);
        map.put("isActive", true);
        JsonElement jsonTree = gson.toJsonTree(map);
        System.out.println(jsonTree); // {"name":"Lutfi","isActive":true,"age":100}

        Map<String, Object> tree = new LinkedHashMap<>();
        tree.put("1", map);
        tree.put("2", map);
        tree.put("3", map);
        System.out.println(gson.toJson(tree));
        // {"1":{"name":"Lutfi","isActive":true,"age":100},"2":{"name":"Lutfi","isActive":true,"age":100},"3":{"name":"Lutfi","isActive":true,"age":100}}

        Person person = new Person();
        person.setUsername("sL");
        person.setPassword("123");
        person.setSts(true);
        String personJson = gson.toJson(person);
        System.out.println(personJson); // {"username":"sL","password":"123","sts":true}

        int[] ints = {1,2,3,4,5};
        System.out.println(gson.toJson(ints)); // [1,2,3,4,5]
        String[] strs = {"Aa", "Bb", "Cc"};
        System.out.println(gson.toJson(strs)); // ["Aa","Bb","Cc"]

        List<Integer> intList = List.of(1,2,3);
        System.out.println(gson.toJson(intList)); // [1,2,3]
    }

    @Test
    void fromJson() {
        Gson gson = new Gson();

        String personJson = "{\"1\":{\"name\":\"Lutfi\",\"isActive\":true,\"age\":100},\"2\":{\"name\":\"Lutfi\",\"isActive\":true,\"age\":100},\"3\":{\"name\":\"Lutfi\",\"isActive\":true,\"age\":100}}";
        Person person1 = gson.fromJson(personJson, Person.class);
        System.out.println(person1.getUsername());
        System.out.println(person1.getPassword());
        System.out.println(person1.isSts());

        Type type = new TypeToken<Map<String, Object>>() {}.getType();
        Map<String, Object> personMap = gson.fromJson(personJson, type);
        System.out.println(personMap);

        int[] ints = gson.fromJson("[1,2,3,4]", int[].class);
        System.out.println(Arrays.toString(ints)); // [1, 2, 3, 4]
    }

    @Test
    void jsonObject() {
        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();

        Person person1 = new Person();
        person1.setUsername("sL");
        person1.setPassword("123");
        person1.setSts(true);

        JsonElement jsonElement = gson.toJsonTree(person1);
        jsonObject.add("person1", jsonElement);
        jsonObject.add("person2", jsonElement);
        jsonObject.add("person3", jsonElement);

        System.out.println(gson.toJson(jsonObject));
        // {"person1":{"username":"sL","password":"123","sts":true},"person2":{"username":"sL","password":"123","sts":true},"person3":{"username":"sL","password":"123","sts":true}}

        /* Nested Object */
        JsonObject address = new JsonObject();
        address.addProperty("city", "Jakarta");
        address.addProperty("country", "Indonesia");

        JsonArray hobbies = new JsonArray();
        hobbies.add("Reading");
        hobbies.add("Gaming");

        JsonObject user = new JsonObject();
        user.addProperty("name", "Lf");
        user.add("address", address);
        user.add("hobbies", hobbies);

        System.out.println(gson.toJson(user));
        // {"name":"Lf","address":{"city":"Jakarta","country":"Indonesia"},"hobbies":["Reading","Gaming"]}

        String strJson = "{\"name\":\"Lf\",\"address\":{\"city\":\"Jakarta\",\"country\":\"Indonesia\"},\"hobbies\":[\"Reading\",\"Gaming\"]}";

        JsonObject parser = new JsonObject();
        if (JsonParser.parseString(strJson).isJsonObject()) {
            parser = JsonParser.parseString(strJson).getAsJsonObject();
        }

        System.out.println(parser); // {"name":"Lf","address":{"city":"Jakarta","country":"Indonesia"},"hobbies":["Reading","Gaming"]}
        System.out.println(parser.getAsJsonArray("hobbies")); // ["Reading","Gaming"]
        System.out.println(parser.get("name").getAsString()); // Lf
        System.out.println(parser.get("address").getAsJsonObject().get("city").getAsString()); // Jakarta
        System.out.println(parser.has("name")); // true
        System.out.println(parser.has("notfound")); // false
    }

    @Test
    void createJson() {
        Map<String, Object> m1 = new HashMap<>();
        m1.put("a", "A");
        m1.put("b", "B");

        Map<String, Object> m2 = new HashMap<>();
        m2.put("c", "C");
        m2.put("d", "D");

        String m3 = "{\"e\":\"E\",\"f\":\"F\"}";

        Gson gson = new Gson();
        JsonObject jsonObj = new JsonObject();
        jsonObj.add("m1", gson.toJsonTree(m1));
        jsonObj.add("m2", gson.toJsonTree(m2));
        jsonObj.add("m3", gson.toJsonTree(JsonParser.parseString(m3)));
        System.out.println(jsonObj);
    }
}
