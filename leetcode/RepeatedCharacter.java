package leetcode;

import java.util.HashSet;
import java.util.Set;

public class RepeatedCharacter {

    // https://leetcode.com/problems/first-letter-to-appear-twice/

    public char repeatedCharacter(String s) {

        Set<Character> set = new HashSet<>();

        for (char letter : s.toCharArray()) {
            if(set.contains(letter)){
                return letter;
            }else{
                set.add(letter);
            }
        }

        return s.charAt(0);
    }
}
