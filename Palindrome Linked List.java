class Solution {
   public boolean isPalindrome(ListNode head) {
        ListNode temp = head; // Init head to compare other nodes
        Stack stack = new Stack();
        while (temp != null) {
            stack.push(temp.val); // pushing value to temp to compare with head
            temp = temp.next;
        }
        
        while (head != null) {
            if (head.val != (int)stack.pop()) { // if num in stack doent match with head
                return false;
            }
            head = head.next; // Change head
        }
        return true;
    }
}