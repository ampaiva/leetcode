import java.util.*;

class Solution implements Comparator<Map.Entry<Character, Integer>> {

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            int count = map.getOrDefault(ch, 0) ;
            map.put(ch, count+1);
        }
        List<Map.Entry<Character, Integer>> entries = new ArrayList<>();
        for (var entry : map.entrySet()) {
            entries.add(entry);
        }

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