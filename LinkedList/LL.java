package LinkedList;

import javafx.scene.chart.ValueAxis;

import java.util.LinkedList;

public class LL {

    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }

    public void insertFirst(int new_val) {
        Node node = new Node(new_val);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    public void dispaly() {
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.value + "->");
            tmp = tmp.next;
        }
        System.out.println("END");
    }

    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node newTail = new Node(val);
        tail.next = newTail;
        tail = newTail;
        size += 1;
    }

    public void insert(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }
        Node tmp = head;
        for (int i = 1; i < index; i++) {
            tmp = tmp.next;
        }
        Node node = new Node(val, tmp.next);
        tmp.next = node;
        size++;
    }

    public int deleteFirst() {
        int val = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return val;
    }

    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }

        Node secondLast = get(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }

    public int delete(int index) {
        if (index == 0) {
            deleteFirst();
        }
        if (index == size) {
            deleteLast();
        }
        Node prev = get(index - 1);
        prev.next = get(index).next;
        size--;
        return get(index).value;
    }

    public Node find(int value) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    private Node get(int index) {
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }
    public void bubblSort(){
        bubbleSort(size-1,0);
    }

    private void bubbleSort(int row, int col) {
        if (row == 0) {
            return;
        }
        Node f = get(col);
        Node s = get(col + 1);

        if (col < row) {
            if (f.value > s.value) {
                if (f == head) {
                    head = s;
                    f.next = s.next;
                    s.next = f;
                } else if (s == tail) {
                    Node preN = get(col - 1);
                    tail = f;
                    f.next = null;
                    s.next = f;
                    preN.next = s;
                } else {
                    Node preN = get(col - 1);
                    f.next = s.next;
                    s.next = f;
                    preN.next = s;
                }
            }bubbleSort(row,col+1);

        }bubbleSort(row-1,col);

    }
    //recursive approach
    public void reverse(Node node){
        if(node==tail){
            head=tail;
            return;
        }
        reverse(node.next);
        tail.next=node;
        tail=node;
        tail.next=null;
    }
    //iterative approach
    public void reverse(){
        Node pre=null;
        Node curr=head;
        Node next=curr.next;
        while(curr!=null){
            curr.next=pre;
            pre=curr;
            curr=next;
            if (next != null) {
                next=next.next;
            }
        }
        head=pre;
    }


    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}

