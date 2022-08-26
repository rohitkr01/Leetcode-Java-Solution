//   -------------2. Add Two Numbers--------------------
//   Problem Statement :
/* You are given two non-empty linked lists representing two non-negative integers. 
   The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
   
Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
  
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]    
*/

// Code

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
         ListNode temp = new ListNode(0); // Created a list where we return sum of two list
        ListNode curr = temp; // Cureent pointer intially at temp;
        int carry = 0; // Intially carry is 0
        
        while(l1 != null || l2 != null || carry == 1){ // Run the loop till l1 or l2 not reach null or carry still has some value present
            int sum = 0; // Intialize sum;
            if(l1 != null){ // Check for l1
                sum += l1.val; // add value to sum
                l1 = l1.next; // then update l1 to next node
            }
            if(l2 != null){ // Check for l2
                sum += l2.val; // add value to sum
                l2 = l2.next; // then update l2 to next node
            }
            
            sum += carry; // don't forgot to add carry to sum
            carry = sum / 10; // get the carry
            ListNode node = new ListNode(sum % 10); // remaining of carry will be store as new node and add to current
            curr.next = node; // current point to new node
            curr = curr.next; // update current
        }
        return temp.next; // return temp.next becuase, intial temp node is 0, as we created so, we have to ignore that  
    }
}


// ----------------------------- 445. Add Two Numbers II  ------------------------------------------
/*
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. 
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1 :
Input: l1 = [7,2,4,3], l2 = [5,6,4]
Output: [7,8,0,7]

Example 2:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [8,0,7]

Example 3:
Input: l1 = [0], l2 = [0]
Output: [0]
*/

// Code
import java.util.*;

class Node{
  int data;
  Node next;

  Node(int data){
    this.data = data;
    this.next=null;
  }
}

public class AddTwoNumbers
{
// inserting to the tail
   static Node insertAtTail(Node head,int data){
      Node newNode = new Node(data);
     if(head==null){
       return newNode;
     }
     Node currNode = head;
     while(currNode.next !=null){
       currNode = currNode.next;
     }
     currNode.next=newNode;
     return head;
   } 

//    Reverse the list
static Node reverseList(Node head){
    if(head ==null || head.next ==null){
        return head;
    }
    Node prevNode = null;
    Node currNode = head;
    while(currNode!=null){
        Node nextNode = currNode.next;
        currNode.next = prevNode;
        prevNode = currNode;
        currNode = nextNode;
    }
    return prevNode;
}
  
// Adding Two number
    public static Node addTwoNumbers(Node l1, Node l2) {
        Node p=reverseList(l1);    //reverse the list1
        Node q=reverseList(l2);    //reverse the list 2
        Node ans = new Node(0);
        Node curr = ans;
        int carry=0;
        while(p !=null || q!=null){
            int x=(p!=null) ? p.data : 0;
            int y=(q!=null) ? q.data : 0;
            int sum = carry + x + y;
            carry = sum/10;
            curr.next = new Node(sum%10);
            curr=curr.next;
            
            if(p!=null) p = p.next;
            if(q!=null) q = q.next;
        }
        if(carry>0){
            curr.next = new Node(carry);
        }
        return reverseList(ans.next);       // return the reverse of sum of list1 and list2
    }

  //  Printing the list
  static void printList(Node head){
    Node currNode = head;
    while(currNode != null){
      System.out.print(currNode.data + " ");
      currNode = currNode.next;
    }
  }
	public static void main (String[] args) throws java.lang.Exception
	{
      Node list1 = null;
      Node list2 = null;
		//your code here
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      int M = sc . nextInt();
      for(int i =0 ; i<N;i++){
        int data = sc.nextInt();
        list1= insertAtTail(list1,data);
      }
       for(int i =0 ; i<M;i++){
        int data = sc.nextInt();
        list2= insertAtTail(list2,data);
      }

      Node ans = null;
      ans =  addTwoNumbers(list1,list2) ;
      printList(ans);

      sc.close();
	}
}

