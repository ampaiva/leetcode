package com.ampaiva.p451.s2;

public class TestSolution {

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


}
