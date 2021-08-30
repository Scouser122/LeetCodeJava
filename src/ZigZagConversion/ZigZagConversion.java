package ZigZagConversion;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        String result = "";
        int lastRowInPrevColumn = 0;
        int currentRow = 0;

        String[] rows = new String[numRows];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new String();
        }
        
        int currentIndex = 0;
        while (currentIndex < s.length()) {
            if(lastRowInPrevColumn > 0) {
                rows[lastRowInPrevColumn] += s.charAt(currentIndex);
                lastRowInPrevColumn--;
                currentIndex++;
                continue;
            }
            rows[currentRow] += s.charAt(currentIndex);
            currentRow++;
            if(currentRow > numRows - 1) {
                lastRowInPrevColumn = currentRow - 2;
                currentRow = 0;
            }
            currentIndex++;
        }

        for (int i = 0; i < rows.length; i++) {
            result += rows[i];
        }

        return result;
    }

    public static void Test() {
        String[] tests = {"PAYPALISHIRING", "PAYPALISHIRING", "A" };
        int[] testsSize = {3, 4, 1};
        

        ZigZagConversion test = new ZigZagConversion();
        for (int i = 0; i < tests.length; i++) {
            String result = test.convert(tests[i], testsSize[i]);
            System.out.println("test " + i + ": str=\"" + tests[i] + "\", ZigZagConversion : " + result);    
        }
    }
}
