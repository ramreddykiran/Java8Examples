package logical;

import java.util.*;


class Queue {
    Node head;
    class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    public void push(int new_data) {
        //new data contains the value to be pushed into the queue
        Node temp = new Node(new_data);
        temp.next = null;
        if(head == null) {
            head = temp;
        } else {
            Node temp1 = head;
            while (temp1.next != null) {
                temp1 = temp1.next;
            }
            temp1.next = temp;
        }
    }

    public int pop() {
        // returns the popped element
        //returns -1 if the queue is empty
        if(head == null) {
            return -1;
        }
        int value = head.data;
        head = head.next;
        return value;
    }
}

class Stack {
    Queue q1, q2;
    Stack() {
        q1 = new Queue();
        q2 = new Queue();
    }
   /* public void push(int new_data) {
       // write code for function below
       //new data contains the value to be pushed into the queue
       //Use the push and pop funcitons of the Queue class

        q2.push(new_data);

        int existingValue = q1.pop();
        while (existingValue != -1) {
            q2.push(existingValue);
            existingValue = q1.pop();
        }

        Queue temp = q1;
        q1 = q2;
        q2 = temp;

    }
    */
   public void push(int new_data) {
       // write code for function below
       //new data contains the value to be pushed into the queue
       //Use the push and pop funcitons of the Queue class
       while(q1.head != null) {
           q2.push(q1.pop());
       }
       q1.push(new_data);
       while(q2.head!=null) {
           q1.push(q2.pop());
       }
   }

   public int pop() {
       /*
        write code for the function below
        return the popped element
        use the push and pop functions of the Queue class
         */

        return q1.pop();
    }
}

public class StackSolution {
    public static void main(String[] args) throws Exception {
        Stack s = new Stack();
        Scanner in = new Scanner(System.in);
        int q, type, value, popped, numPops = 0;
        q = in.nextInt();
        int[] output = new int[q];
        //Read input from stdin and apply query
        for(int i=0; i<q; i++) {
            type = in.nextInt();
            if (type == 1) {
                value = in.nextInt();
                s.push(value);
            } else {
                popped = s.pop();
                output[numPops++] = popped;
            }
        }
        //print output
        for(int i=0; i<numPops; i++) {
            if(i != numPops-1) {
                System.out.println(output[i] + " ");
            } else {
                System.out.println(output[i]);
            }
        }
    }
}

/*
 Input:1 total 5 elements (1 2 means type1 element 2)
 5
 1 2
 1 3
 2
 2
 1 8
    Output:3 2

 input:2 total 6 elements (1 7 means type1 element 7)
 6
 2
 1 7
 2
 1 3
 1 4
 2
    Output:-1 7 4
 */