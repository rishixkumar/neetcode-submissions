/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        } //baseCase if the head is null there is nothing to reorder

        //create arr of nodes to hold all nodes
        List<ListNode> validNodes = new ArrayList<>();
        ListNode curr = head;
        //loops through linkedList 
        //add all nodes to arr
        while (curr != null) {
            validNodes.add(curr);
            curr = curr.next;
        }

        //twoPtr format
        int i = 0;
        int j = validNodes.size() - 1;
        //implement bSearch ops
        //loop until i < j -- twoPtr
        while (i < j) {
            validNodes.get(i).next = validNodes.get(j);
            i++;
            if (i >= j) {
                break;
            }
            validNodes.get(j).next = validNodes.get(i);
            j--;            
        }
        validNodes.get(i).next = null;
    }
}
