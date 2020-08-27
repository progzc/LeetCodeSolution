package com.zcprog;

import java.util.*;

/**
 * 17.电话号码的字母组合
 */
public class CharCombinationOfPhonenumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        List<String> strings = new CharCombinationOfPhonenumber().letterCombinations(next);
        System.out.println(strings.toString());

    }

    public List<String> letterCombinations(String digits) {

        List<String> results = new ArrayList<>();
        if(digits.length() == 0){
            return results;
        }
        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
        search(results, phoneMap, digits, 0, new StringBuilder());
        return  results;
    }

    public void search(List<String> results, Map<Character, String> phoneMap,
                       String digits, int index, StringBuilder result){
        if (index == digits.length()){
            results.add(result.toString());
        }else{
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++){
                result.append(letters.charAt(i));
                search(results, phoneMap, digits, index+1, result);
                result.deleteCharAt(index);
            }
        }
    }
}
