package TwoNumbers;


public class TwoNumbersSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode temp = null;

        int carry = 0;
        while(l1 != null || l2 != null) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            int sum = num1 + num2 + carry;
            if(sum >= 10) {
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }
            if(result == null) {
                result = new ListNode(sum);
                temp = result;
            } else {
                temp.next = new ListNode(sum);
                temp = temp.next;
            }
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry != 0)
            temp.next = new ListNode(carry);

        return result;
    }

    public static void Test() {
        // int[] l1Nums = {2,4,3};
        // int[] l2Nums = {5,6,4};
        int[] l1Nums = {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
        int[] l2Nums = {5,6,4};

        ListNode l1 = null;
        ListNode l2 = null;

        ListNode curr = null;
        ListNode next = null;

        for(int i = 0; i < l1Nums.length; i++) {
            curr = new ListNode(l1Nums[i]);
            if(l1 == null) {
                l1 = curr;
            } else {
                next.next = curr;
            }
            next = curr;
        }
        for(int i = 0; i < l2Nums.length; i++) {
            curr = new ListNode(l2Nums[i]);
            if(l2 == null) {
                l2 = curr;
            } else {
                next.next = curr;
            }
            next = curr;
        }

        TwoNumbersSolution solution = new TwoNumbersSolution();

        ListNode result = solution.addTwoNumbers(l1, l2);
        String resultStr = "";
        while (result != null)
        {
            resultStr += "" + result.val + ",";
            result = result.next;
        }
        System.out.println("result = " + resultStr);
    }
}
