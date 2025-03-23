package com.gson;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class GsonTest {

    @Test
    void toJson() {
        Gson gson = new Gson();
        String json = gson.toJson("1");
        System.out.println(json);

        Map<String, Object> map = new HashMap<>();
        map.put("name", "Lutfi");
        map.put("age", 100);
        map.put("isActive", true);
        JsonElement jsonTree = gson.toJsonTree(map);
        System.out.println(jsonTree);

        Map<String, Object> tree = new LinkedHashMap<>();
        tree.put("1", map);
        tree.put("2", map);
        tree.put("3", map);
        System.out.println(gson.toJson(tree));

        Person person = new Person();
        person.setUsername("sL");
        person.setPassword("123");
        person.setSts(true);
        String personJson = gson.toJson(person);
        System.out.println(personJson);
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
    }
}
