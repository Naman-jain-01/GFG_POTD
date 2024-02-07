class Solution {
    public Node subLinkedList(Node head1, Node head2) {
        
        Node node1 = head1;
        Node node2 = head2;
        
        StringBuilder num1 = new StringBuilder();
        while (node1 != null) {
            num1.append(node1.data);
            node1 = node1.next;
        }
        
        StringBuilder num2 = new StringBuilder();
        while (node2 != null) {
            num2.append(node2.data);
            node2 = node2.next;
        }
        
        //System.out.println(num1 + " " + num2);
        
        String NUM1 = removeLeadingZeros(num1.toString());
        String NUM2 = removeLeadingZeros(num2.toString());

        String sub = subtractLargeNumbers(NUM1, NUM2);
        
        LinkedList ans = new LinkedList();
        
        for (char digit : sub.toCharArray()) {
            ans.insert(digit - '0');
        }
        return ans.head;
    }

    String removeLeadingZeros(String str) {
        int nonZeroIdx = 0;
        while (nonZeroIdx < str.length() - 1 && str.charAt(nonZeroIdx) == '0') {
            nonZeroIdx++;
        }
        return str.substring(nonZeroIdx);
    }

    String subtractLargeNumbers(String num1, String num2) {
        int len = Math.max(num1.length(), num2.length());
        int carry = 0;

        // Pad the shorter number with zeros
        num1 = String.format("%1$" + len + "s", num1).replace(' ', '0');
        num2 = String.format("%1$" + len + "s", num2).replace(' ', '0');
        
        //System.out.println(num1 + " " + num2);
        
        // Subtract digits
        if (num1.compareTo(num2)<0) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        StringBuilder difference = new StringBuilder();

        for (int i = len - 1; i >= 0; i--) {
            int digit1 = num1.charAt(i) - '0';
            int digit2 = num2.charAt(i) - '0';

            int result = digit1 - digit2 - carry;
            if (result < 0) {
                result += 10;
                carry = 1;
            } else {
                carry = 0;
            }

            difference.insert(0, result);
        }

        // Remove leading zeros
        
        String ans = removeLeadingZeros(difference.toString());
        return ans;
    }

}
