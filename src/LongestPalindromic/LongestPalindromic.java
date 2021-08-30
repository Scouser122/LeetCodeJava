package LongestPalindromic;
import java.lang.StringBuilder;

public class LongestPalindromic {
    public Boolean isPalindrome(String s) {
        Boolean result = true;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if(chars[i] != chars[chars.length - 1 - i]){
                result = false;
                break;
            }
        }
        return result;
    }

    public String longestPalindrome(String s) {
        String result = "";
        int maxPalindromeLen = 0;

        if(s.length() == 0)
            return result;
        
        int startIndex = 0;
        int endIndex = s.length() - 1;

        if(startIndex == endIndex)
            return s;

        while (endIndex > 0) {
            String testStr = s.substring(startIndex, endIndex + 1);
            if(testStr.length() <= maxPalindromeLen) {
                endIndex--;
                startIndex = 0;
                continue;
            }
            if(isPalindrome(testStr)) {
                if(testStr.length() > maxPalindromeLen) {
                    maxPalindromeLen = testStr.length();
                    result = testStr;
                }
            }
            startIndex++;
            if(startIndex == endIndex) {
                endIndex--;
                startIndex = 0;
            }
        }

        if(maxPalindromeLen == 0)
            result = s.substring(0, 1);

        return result;
    }

    public static void Test() {
        // String[] tests = {"a", "ac", "babad", "cbbd" };
        String[] tests = {"babad", "cbbd", "a", "ac", "fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffgggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"};

        LongestPalindromic test = new LongestPalindromic();
        for (int i = 0; i < tests.length; i++) {
            String result = test.longestPalindrome(tests[i]);
            System.out.println("test " + i + ": str=\"" + tests[i] + "\", longestPalindrome : " + result);    
        }
    }
}
