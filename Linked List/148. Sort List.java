// ----------------------- 148. Sort List------------------------------
/*
Given the head of a linked list, return the list after sorting it in ascending order.

Example:
Input: head = [4,2,1,3]
Output: [1,2,3,4]

Exaple 2:
Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]

Example 3:
Input: head = []
Output: []

*/

-------------------------Approach -1 :   Selection Sort -----------------
  public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode currNode = head;
        while(currNode != null){
            ListNode itrNode = currNode;
            ListNode minNode = itrNode;
            while(itrNode!=null){
                if(itrNode.val<minNode.val)
                   minNode = itrNode;
                itrNode=itrNode.next;
            }
            int temp=currNode.val;
            currNode.val = minNode.val;
            minNode.val = temp;
            
            currNode=currNode.next;
        }
        return head;
    }

Time complexity : O(n2)
Space Complexity: O(n)

-------------------------Approach - 2 : Merge Sort  ---------------------
  1. Find the Middle Node of list
  2. Merge Two Sorted List
  
  Time Complextity : O(nlogn)
  Space Complexity : O(1)
  
  
  class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next == null)  
            return head;
        
        ListNode mid = getMiddleNode(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        
        return mergeList(left,right);  
        
    }
    
//     finding middle Node of thr list;
    
    private ListNode getMiddleNode(ListNode head){
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }
    
//     merging two list in the sorted manner
    public ListNode mergeList(ListNode left , ListNode right){
        if(left==null && right == null)  return null;
        if(left == null)  return right;
        if(right == null) return left;
        
        ListNode ans = new ListNode(-1);
        ListNode itr = ans;
        
        while(left !=null && right !=null){
            if(left.val<=right.val){
                itr.next=left;
                itr=itr.next;
                left=left.next;
            }
            else{
                itr.next=right;
                itr=itr.next;
                right=right.next;
            }
        }
        if(left !=null) itr.next=left;
        if(right != null) itr.next = right;
        
        return ans.next;
    }
}

  
