package ReverseInteger;

public class ReverseInteger {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int ost = x % 10;
            if(ost != 0 || result != 0) {
                try {
                    result = Math.addExact(Math.multiplyExact(result, 10), ost);
                } catch (Exception e) {
                    return 0;
                }                
            }
            x /= 10;
        }        
        return result;
    }

    public static void Test() {
        int[] tests = {1534236469, 123, -123, 120, 0, 901000};        

        ReverseInteger test = new ReverseInteger();
        for (int i = 0; i < tests.length; i++) {
            int result = test.reverse(tests[i]);
            System.out.println("test " + i + ": number=" + tests[i] + ", ReverseInteger : " + result);    
        }
    }
}
