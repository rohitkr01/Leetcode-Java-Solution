// ---------------- 141. Linked List Cycle   ------------------
 
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next ==null){
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow!=fast){
            if(fast == null || fast.next == null){
                return false;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return true;
    }
}


// --------------- 142. Linked List Cycle II ----------------

public class Solution {
    public ListNode detectCycle(ListNode head) {
      
//     Best Approach - 1
        
        if(head == null || head.next==null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode entry = head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            
            if(slow ==fast){
                while(entry!=slow){
                  slow=slow.next;
                  entry=entry.next;
                 }
             return entry;
            }    
        }
        return null;
        
// Approach -2  ( Using HashSet )
        
//         if(head ==null || head.next ==null){
//             return null;
//         }
//         ListNode currNode = head;
//         Set<ListNode> set = new LinkedHashSet<>();
//         while(currNode.next != null){
//                 if(set.contains(currNode)){
//                     return currNode;
//                 }
//                 else{
//                     set.add(currNode);
//                     currNode=currNode.next;
//                 }
//         }
       
//         return null;
    }
}
