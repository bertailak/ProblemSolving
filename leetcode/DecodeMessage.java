package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

public class DecodeMessage {

    // https://leetcode.com/contest/weekly-contest-300/problems/decode-the-message/

    public String decodeMessage(String key, String message) {
        HashMap<Character, Character> map = new HashMap<>();

        int index = 0;
        int alphaIndex = 0;
        while (alphaIndex < 26 && index < key.length()) {
            if ((key.charAt(index) >= 'a' && key.charAt(index) <= 'z') && !map.containsKey(key.charAt(index))) {
                map.put(key.charAt(index), (char) (alphaIndex + 'a'));
                alphaIndex++;
            }
            index++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) >= 'a' && message.charAt(i) <= 'z') {
                sb.append(map.get(message.charAt(i)));
            } else {
                sb.append(message.charAt(i));
            }
        }

        return sb.toString();
    }

    @Test
    public void test1() {
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";
        String expected = "this is a secret";
        String actual = decodeMessage(key, message);
        assertEquals(expected, actual);
    }
}
