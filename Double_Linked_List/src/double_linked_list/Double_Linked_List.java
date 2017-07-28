/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package double_linked_list;

/**
 *
 * @author deivakumaran
 */
public class Double_Linked_List {

    public class Node {

        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            next = null;
            prev = null;
        }

    }

    Node head = null;
    Node tail = null;

    public void insertBeginning(int data) {

        Node new_node = new Node(data);

        if (head == null) {
            head = new_node;
            tail = new_node;
            return;
        } else {
            new_node.next = head;
            head.prev = new_node;
            head = new_node;
        }

    }

    public void insertEnd(int data) {

        Node new_node = new Node(data);

        if (tail == null) {
            head = new_node;
            tail = new_node;
            return;
        } else {
            tail.next = new_node;
            new_node.prev = tail;
            tail = new_node;

        }

    }

    public void insertAfterPosition(int position, int data) {

        Node new_node = new Node(data);
        Node temp = head;
        int count = 1;

        while (count != position) {
            if (temp.next == null) {
                System.out.println("Invalid Position");
                return;
            }
            temp = temp.next;
            count++;
        }

        new_node.next = temp.next;
        temp.next = new_node;
        temp.next.prev = new_node;
        new_node.prev = temp;

    }

    public void insertAfterElement(int element, int data) {
        boolean status = checkElement(element);
        if (status == false) {
            System.out.println("The element is not presnt in list");
            return;
        } else {
            Node new_node = new Node(data);

            Node temp = head;
            while (temp.data != element) {
                temp = temp.next;
            }
            new_node.next = temp.next;
            temp.next = new_node;
            temp.next.prev = new_node;
            new_node.prev = temp;

        }
    }

    public void insertBeforeElement(int element, int data) {

        boolean status = checkElement(element);
        if (status == false) {
            System.out.println("The element is not presnt in list");
            return;
        } else {
            Node new_node = new Node(data);
            Node temp = head;
            while (temp.next.data != element) {

                temp = temp.next;

            }
            new_node.next = temp.next;
            temp.next = new_node;
            temp.next.prev = new_node;
            new_node.prev = temp;
        }
    }

    public boolean checkElement(int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) {
                return true;
            }
            temp = temp.next;

        }
        return false;
    }

    public void deleteBeginning() {

        if (head == null) {
            System.out.println("The list is empty to be deleted");
            return;
        } else {

            head = head.next;
            head.prev = null;
        }
    }

    public void deleteEnd() {
        if (head == null) {
            System.out.println("The list is empty to be deleted");
            return;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public void deletePosition(int position) {

        if (head == null) {
            System.out.println("No element to be deleted from list");
            return;
        } else if (position == 1) {

            head = head.next;
            head.prev = null;
        } else {
            Node temp = head;
            int count = 0;
            while (count != position - 1) {
                if (temp.next == null) {

                    System.out.println("Invalid Position");
                    return;
                }
                count++;
                temp = temp.next;

            }

            if (temp.next.next == null) {
                temp.next = null;
            } else {
                temp.next.next.prev = temp;
                temp.next = temp.next.next;

            }
        }
    }

    public void deleteElement(int element) {

        boolean status = checkElement(element);
        if (status == false) {
            System.out.println("The element is not found ");
            return;
        } else if (head.data == element) {

            head = head.next;
            head.prev = null;
        } else {
            Node temp = head;
            while (temp.next.data != element) {
                temp = temp.next;
            }
            if (temp.next.next == null) {
                temp.next = null;

            } else {
                temp.next.next.prev = temp;
                temp.next = temp.next.next;
            }
        }

    }

    public int countElements() {
        int count = 0;
        Node temp = head;
        while (temp != null) {

            count++;
            temp = temp.next;
        }

        return count;
    }

    public void printDoubleLinkedList() {

        Node temp = head;

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }

    }

    public void printDoubleLinkedListBack() {

        Node temp = tail;

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.prev;
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Double_Linked_List dl = new Double_Linked_List();

        dl.insertEnd(30);
        dl.insertEnd(40);
        dl.insertEnd(50);
        dl.insertBeginning(20);
        dl.insertBeginning(10);
        System.out.println("---------------");
        dl.printDoubleLinkedList();
      
        dl.insertAfterPosition(1, 25);
        dl.insertAfterElement(30, 35);
        System.out.println("---------------");
        dl.printDoubleLinkedList();
        
        dl.deleteElement(40);
        System.out.println("---------------");
        dl.printDoubleLinkedList();
        
        dl.deleteBeginning();
        dl.deleteEnd();
        System.out.println("---------------");
        dl.printDoubleLinkedList();
        
        dl.deletePosition(1);
        System.out.println("---------------");
        dl.printDoubleLinkedList();
        System.out.println("The count:" + dl.countElements());

    }

}
