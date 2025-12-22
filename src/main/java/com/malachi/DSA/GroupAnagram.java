package com.malachi.DSA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {
    public static void main(String[] args) {
        List<String> words = List.of("eat","tea","tan", "ate","nat","bat");
        List<List<String>> result = groupAnagram(words);
        System.out.println("result: " + result);
    }
    public static List<List<String>> groupAnagram(List<String> list){
        Map<String, List<String>> anagramGroup = new HashMap<>();

        for(String str : list){
            String sortedString = sortLetters(str.toCharArray());
            anagramGroup.computeIfAbsent(sortedString, k -> new ArrayList<>()).add(str);
        }

        List<List<String>> result = new ArrayList<>(anagramGroup.values());
        return result;

    }

    public static String sortLetters(char[] charArray){
        List<Integer> charCode = new ArrayList<>();
        for (char c : charArray) {
            charCode.add((int) c);
        }

        charCode = charCode.stream().sorted( (a, b) -> a - b).toList();
        List<Character> character = new ArrayList<>();

        for (int ascii : charCode) {
            character.add((char) ascii);
        }

        StringBuilder stringBuilder = new StringBuilder(character.size());
        for(char ascii : character){
            stringBuilder.append(ascii);
        }
        return stringBuilder.toString();
    }
}
