import java.util.Scanner;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
        this.next=null;
    }
}

public class LL_Delation 
{
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

// Deletion at Head
    static Node deleteAtHead(Node head){
        if(head==null || head.next==null){
            return null;
        }
        head=head.next;
        return head;
    } 

// Deletion at Tail
    static Node deleteAtTail(Node head){
        // edge case
        if(head==null ||  head.next==null){
            return null;
        }
        Node currNode=head;
        Node prevNode=null;

        while(currNode.next != null){
            prevNode=currNode;
            currNode=currNode.next;
        }
        prevNode.next=null;
        return head;
    }

// Deletion At Kth Node
    static Node deleteAtKth(Node head , int k){
        Node currNode = head;
        Node prevNode = null;
        // edge case
        if(k==1 ){
            head=head.next;
            return head;
        }
        for(int i=0;i<k;i++){
            prevNode=currNode;
            currNode=currNode.next;
        }
        prevNode.next = currNode.next;
        return head;
    }

// Delete Middle Node (Approach - 2 using two pointer)
    static Node deleteMiddle(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node slow=head;
        Node fast = head;
        Node prevOfSlow = null;
        
        while(fast !=null && fast.next !=null){
            prevOfSlow=slow;
            slow=slow.next;
            fast = fast.next.next;
        }
        // after loop , slow is the middleNode 
        prevOfSlow.next=slow.next;
        return head;
    }
   

//  Print List
    static void printList(Node head){
        Node currNode = head;
        while(currNode!=null){
            System.out.print(currNode.data+"->");
            currNode=currNode.next;
        }
        System.out.println("null");
    }
// finding size of List
    static int sizeOfList(Node head){
        Node currNode=head;
        int len=0;
        while(currNode!=null){
            len++;
            currNode=currNode.next;
        }
        return len;
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
        printList(head);
        // head = deleteAtHead(head);
        // head = deleteAtTail(head);

        int k = sc.nextInt();
        head = deleteAtKth(head,k);
        printList(head);
      
        //  for deleting middle element , k = sizeOfList/2 .
        System.out.println("Size of list = "+sizeOfList(head));
        // int mid = sizeOfList(head)/2;
        // head = deleteAtKth(head,mid);

        head = deleteMiddle(head);
        printList(head);

        sc.close();
    }
}
