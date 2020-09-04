package com.demo.org.algorithm.reconstruct.itinerary;

import com.demo.org.algorithm.common.util.Json;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

    private List<String> results = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        results.clear();
        Map<String, List<String>> fromToMap = new HashMap<>();
        for (List<String> ticket : tickets) {
            List<String> dest = fromToMap.get(ticket.get(0));
            if (dest != null) {
                dest.add(ticket.get(1));
            } else {
                dest = new ArrayList<>();
                dest.add(ticket.get(1));
                fromToMap.put(ticket.get(0), dest);
            }
        }
        fromToMap.values().forEach(dest -> dest.sort(Comparator.naturalOrder()));
        String dest = "JFK";
        dfs(fromToMap, dest);
        return results;
    }

    void dfs(Map<String, List<String>> fromToMap, String dest) {
        List<String> destList = fromToMap.get(dest);
        while (destList != null && destList.size() > 0) {
            String next = destList.get(0);
            destList.remove(0);
            dfs(fromToMap, next);
        }
        results.add(0,dest);
    }

    @Test
    public void test() {
        Type type = new TypeToken<List<List<String>>>() {
        }.getType();
        List<List<String>> input = Json.gson.fromJson("[[\"JFK\",\"SFO\"],[\"JFK\",\"ATL\"],[\"SFO\",\"ATL\"],[\"ATL\",\"JFK\"],[\"ATL\",\"SFO\"]]", type);
        System.out.println(findItinerary(input));

        List<List<String>> input2 = Json.gson.fromJson("[[\"JFK\",\"KUL\"],[\"JFK\",\"NRT\"],[\"NRT\",\"JFK\"]]", type);
        System.out.println(findItinerary(input2));
    }
}
