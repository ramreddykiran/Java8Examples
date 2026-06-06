package logical;

import java.util.*;
import java.util.stream.Collectors;

public class LongestNonRepeatedSubStringFromString {
    public static void main(String[] args) {
        LongestNonRepeatedSubStringFromString l = new LongestNonRepeatedSubStringFromString();
        String input1 = "pwwkew";//"abcabcdabcdefabcdeabcde";//"thisisasamplestringexampletocalculatelongestnonrepeatedcharacterssubstring";
        l.longestSubStringLength(input1);
        l.approach1(input1);
        l.approach2(input1);
        l.approach3(input1);
    }

    private void approach1(String input) {
        char[] chArr = input.toCharArray();
        List<Character> chars = new ArrayList<>();
        List<String> nonRepeatedWords = new ArrayList<>();
        for(char ch : chArr) {
            if(!chars.contains(ch)) {
                chars.add(ch);
            } else {
                String subStr = chars.stream()
                        .map(c -> String.valueOf((char) c))
                        .collect(Collectors.joining());
                nonRepeatedWords.add(subStr);
                chars.clear();
                chars.add(ch);
            }
        }
        String longestString = nonRepeatedWords.stream()
                .max(Comparator.comparing(String::length))
                .orElse("No substring repeated");
        System.out.println("approach 1 " + longestString);
    }


    /**
     * The problem is Sliding window + HashSet/Map
     * Approach : maintain a window with unique characters only
     * Step1: expand right pointer
     * Step2: if duplicate appears, move left pointer until duplicate removed
     * track max window length
     */
    private void approach2(String input) {
        Set<Character> subStringsSet = new HashSet();
        int left = 0, start = 0, maxLength = 0;

        for(int right = 0; right < input.length(); right++) {
            while(subStringsSet.contains(input.charAt(right))) {
                subStringsSet.remove(input.charAt(left));
                left++;
            }

            subStringsSet.add(input.charAt(right));

            if(right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                start = left;
            }
        }

        String output = input.substring(start, start + maxLength);
        System.out.println("Approach-1: max length substring = " + output);
    }

    private void approach3(String input) {
        Map<Character, Integer> map = new HashMap<>();
        /* map stores character + last seen index
        input pwwkew
        p -> 0
        w -> 2 (updates when seen again)
        k -> 3
        e -> 4
        this helps jump left pointer directly when duplicate char appears
         */
        int left = 0, start = 0, maxLength = 0;
        /*
        left - starting of sliding window
        right - end of sliding window (loop variable)
        start - start index of longest substring
        maxLength - length of longest substring
         */

        for(int right = 0; right < input.length(); right++) { // expand window by moving right pointer 1 char at a time
            char ch = input.charAt(right); //current character

            if(map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }
            /*
            if duplicate char found, move the left pointer after its previous index.
            we use Math.max() becoz, the old index might be outside of current window.
            Example why we use Math.max(left, map.get(ch) + 1) input : "abba"
            Step-by-step:

            right	char	map	                            left
        0	        a	    a→0	                             0
        1	        b	    b→1	                             0
        2	        b	    duplicate!	                     move left to 2
        3	        a	    duplicate found at index 0

            Without Math.max, left would go backwards ❌
            We never move left backward.

            So:
            left = max(currentLeft, lastSeenIndex + 1) i.e, max(left, map.get(ch) + 1)
            This keeps window valid
             */

            map.put(ch, right); // update last seen index. Always update to latest position

            if(right - left + 1 > maxLength) { // check if current window is longest. window length = (right - left + 1)
                maxLength = right - left + 1;
                start = left;
            }
        }

        String output = input.substring(start, start + maxLength);
        System.out.println("Approach-2 non-repeated max length substring = " + output);
    }


    private void longestSubStringLength(String input) {
        Set<Character> set = new HashSet<>();
        int left = 0, maxLength = 0;
        for(int right = 0; right < input.length(); right++) {
            while(set.contains(input.charAt(right))) {
                set.remove(input.charAt(left));
                left++;
            }
            set.add(input.charAt(right));
            maxLength = Math.max(maxLength, left - right + 1);
        }
        System.out.println("length of longest non-repeated substring = " + maxLength);
    }


}
