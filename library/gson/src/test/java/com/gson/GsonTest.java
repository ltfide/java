package com.gson;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
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
}
