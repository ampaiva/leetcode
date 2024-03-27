package com.ampaiva.p451.s1;

import java.util.*;

class Solution implements Comparator<Map.Entry<Character, Integer>> {

    private static final Solution solution = new Solution();

    private static void testCase(String input, String expected) {
        String result = solution.frequencySort(input);
        System.out.println(input + " => " + result);
        if (!result.equals(expected))
            throw new RuntimeException(result + " <> " + expected);
    }

    public static void main(String[] args) {
        testCase("rtee", "eert");
        testCase("Aabcce", "ccAabe");
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            int count = map.getOrDefault(ch, 0);
            map.put(ch, count + 1);
        }
        List<Map.Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());

        entries.sort(this);

        StringBuilder result = new StringBuilder();
        for (var entry : entries) {
            Character ch = entry.getKey();
            int count = entry.getValue();
            result.append(String.valueOf(ch).repeat(Math.max(0, count)));
        }

        return result.toString();
    }

    @Override
    public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
        int result = o1.getValue().compareTo(o2.getValue()) * -1;
        if (result == 0) {
            result = o1.getKey().compareTo(o2.getKey());
        }
        return result;
    }
}