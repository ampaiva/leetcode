package com.ampaiva.p451.s2;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;

class Solution {

    public String frequencySort(String s) {
        return s.chars()
                .boxed()
                .collect(groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed().thenComparing(Map.Entry::getKey))
                .map(e -> Character.valueOf((char) e.getKey().intValue()).toString().repeat(e.getValue().intValue()))
                .collect(joining());
    }
}