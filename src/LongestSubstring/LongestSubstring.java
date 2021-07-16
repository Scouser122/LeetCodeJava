package LongestSubstring;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        String currStr = "";
        int maxSeq = 0;

        for(char ch : chars){
            if(currStr.indexOf(ch) == -1) {
                currStr += ch;
            } else {
                if(currStr.length() > maxSeq) {
                    maxSeq = currStr.length();
                }
                currStr = currStr.substring(currStr.indexOf(ch) + 1) + ch;
            }
        }
        if(currStr.length() > 0 && currStr.length() > maxSeq) {
            maxSeq = currStr.length();
        }

        return maxSeq;
    }

    public static void Test() {
        String[] tests = {"abcabcbb", "bbbbb", "pwwkew", "", " ", "dvdf", "jbpnbwwd"};
        // String[] tests = {"jbpnbwwd"};

        LongestSubstring test = new LongestSubstring();
        for (int i = 0; i < tests.length; i++) {
            int result = test.lengthOfLongestSubstring(tests[i]);
            System.out.println("test " + i + ": str=\"" + tests[i] + "\", lengthOfLongestSubstring : " + result);    
        }
            
    }
}
