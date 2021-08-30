package MedianSortedArrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0.0;

        List<Integer> merged = new ArrayList<Integer>();
        int index = 0;
        while(index < nums1.length || index < nums2.length) {
            if(index < nums1.length)
                merged.add(nums1[index]);
            if(index < nums2.length)
                merged.add(nums2[index]);
            index++;
        }
        Collections.sort(merged);
        if(merged.size() == 0)
            return result;
        else if(merged.size() == 1)
            return merged.get(0);
        else if(merged.size() == 2)
            return (merged.get(0) + merged.get(1)) / 2.0;
        else if(merged.size() % 2 == 0) {
            int index1 = merged.size() / 2;
            return (merged.get(index1 - 1) + merged.get(index1)) / 2.0;
        } else {
            int index1 = merged.size() / 2;
            return merged.get(index1);
        }
    }

    public static void Test() {
        int[][][] tests = {
            {{1,3}, {2}},
            {{1,2}, {3,4}},
            {{0,0}, {0,0}},
            {{}, {1}},
            {{2}, {}}
        };

        MedianSortedArrays test = new MedianSortedArrays();
        for (int i = 0; i < tests.length; i++) {
            int[] arr1 = tests[i][0];
            int[] arr2 = tests[i][1];
            double result = test.findMedianSortedArrays(arr1, arr2);
            String output = "";
            output += "test " + i + " , arr1 = [";
            for(int j = 0; j < arr1.length; j++) {
                output += "" + arr1[j] + (j < arr1.length - 1 ? "," : "");
            }
            output += "], arr2 = [";
            for(int j = 0; j < arr2.length; j++) {
                output += "" + arr2[j] + (j < arr2.length - 1 ? "," : "");
            }
            output += "], result = " + result;
            System.out.println(output);
        }
    }
}
