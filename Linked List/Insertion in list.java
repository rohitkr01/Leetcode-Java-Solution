import java.util.*;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class LL_Creation {
    
// inserting node at the head
    static Node insertAtHead(Node head , int data){
        Node newNode = new Node(data);
        newNode.next = head;
        // head = newNode;
        // return head;
        return newNode;
    }

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

//  insert at the kth index in the list
    public static Node insertAtKth(Node head,int data,int k){
        Node newNode = new Node(data);
        // edge case
        if(head==null || k==1){
            newNode.next=head;
            return newNode; 
        }

        Node currNode = head;
        Node prevNode = null;
        for(int i=1;i<k;i++){
            prevNode=currNode;
            currNode=currNode.next;
        }
        prevNode.next=newNode;
        newNode.next=currNode;
        return head;
    }

// Finding Length of List
    static int lengthofList(Node head){
       int len=0;
       Node currNode = head;
       while(currNode != null){
        len++;
        currNode=currNode.next;
       }
       return len;
    }

// Print Kth Node 
    static void printKthNode(Node head,int k ){

        // check if k is grater than length of list
        int length = lengthofList(head);
        if(k>length){
            System.out.println(-1);
            return;
        }

        Node currNode=head;
        int i=1;
        while(i<k){
            currNode=currNode.next;
            i++;
        }
        System.out.println();
        System.out.println(k+"th node is : "+currNode.data);
    }

// Printing the Linked List
    static void printList(Node head){
        Node currNode = head;
        while(currNode!= null){
            System.out.print(currNode.data + "->");
            currNode=currNode.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
        Node head = null;     // head = null,  means the Linked List is empty.

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i =0;i<n;i++){
            int data = sc.nextInt();
            // head = insertAtHead(head, data);    
            head = insertAtTail(head, data);
        }
        int k=sc.nextInt();
        head=insertAtKth(head, 7, k);
        printList(head);
        printKthNode(head,4);
        // Node head = new Node(5);
        // head.next = new Node(19);
        sc.close();
    }
}
