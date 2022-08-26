import java.util.*;
class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
} 

public class Reverse_LinkedList {

// inserting node at the tail 
    static Node insertAtTail(Node head , int data){
        Node newNode = new Node(data);
        newNode.next=null;

        // edge case
        if(head==null){
            return newNode;
        }
        // move to the last node
        Node currNode = head;
        while(currNode.next !=null){
            // move forward , move to next node
            currNode=currNode.next;
        }
        // when this loop will stop , currnode is tail node
        // point currNode.next to newNode
        currNode.next=newNode;
        return head;
    }

// Reverse Linked list( using ArrayList) 
   static Node ReverseListUsingArrayList(Node head){
    Node currNode = head;
    ArrayList<Integer> arr = new ArrayList<Integer>();
    while(currNode != null){
        arr.add(currNode.data);
        currNode = currNode.next;
    }
    while(currNode != null){
        currNode.data = arr.remove(arr.size()-1);
        currNode =currNode.next;
    }
    return head;
   }

//  Reverse Linked List (  without  Recursion )
    public static Node ReverseList(Node head){
        Node prevNode = null;
        Node currNode = head;
        Node nextNode = null;
        while(currNode !=null){
            nextNode=currNode.next;
            currNode.next=prevNode;
            prevNode=currNode;
            currNode=nextNode;
        }
        head = prevNode;
        return head;
    }

//  Reverse Linked List ( Using  Recursion )
    static Node ReverseListRecursive(Node head){
        if(head==null || head.next==null) return head;
        Node rest = ReverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

// Printing Reverse Linked List (  using  Recursion - 2 )
public static void printInReverse(Node head){
    // base case
      if(head== null){
          return;
      }
      printInReverse(head.next);
      System.out.print(head.data + " ");
  }

//  Printing th list
    public static void printList(Node head){
        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data + "->");
            currNode = currNode.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
        Node head = null;

        Scanner sc = new Scanner(System.in);
        for(int i =0;i<6;i++){
            int data = sc.nextInt();
            head = insertAtTail(head, data);
        }

        // printInReverse(head);

         head = ReverseListRecursive(head);

        // head = ReverseList(head);

        printList(head);
    sc.close();
    }
}
