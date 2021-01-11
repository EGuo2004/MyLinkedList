import java.util.*;
public class MyLinkedList{
 private int size;
 private Node start,end;

 public MyLinkedList() {
   size = 0;
   start = null;
   end = start;
 }

 public int size() {
   return size;
 }

 public boolean add(String value) {
   Node a = new Node(value);
   if(size == 0) {
     start = a;
     end = a;
     a.setNext(end);
     a.setPrev(null);
   } else {
     end.setNext(a);
     a.setPrev(end);
     end = a;
   }
   size++;
   return true;
 }

 public void add(int index, String value) {
   Node a = new Node(value);
   if( index > size) {
     throw new IndexOutOfBoundsException("Index greater than size of MyLinkedList");
   }
   if (index == 0) {
     a.setNext(start);
     start.setPrev(a);
     start = a;
   } else {
     if(index == size) {
       a.setPrev(end.getPrev());
       a.setNext(end);
       end.setPrev(a);
     } else {
       a.setPrev(getNode(index-1));
       a.setNext(getNode(index));
       a.getPrev().setNext(a);
       a.getNext().setPrev(a);
     }
   }
   size++;
 }

 private Node getNode(int index) {
   Node current = start;
   for(int i = 0; i < index;i++) {
     current = current.getNext();
   }
   return current;
 }

 public String get(int index) {
   return getNode(index).getVal();
 }

 public String set(int index, String value) {
   String returnString = get(index);
   getNode(index).setVal(value);
   return returnString;
 }

 public String toString() {
   String returnString = "";
   for (int i = 0; i < size - 1; i++) {
     returnString += get(i) + ", ";
   }
   returnString += end.getVal();
   return returnString;
 }

 public String remove(int index) {
   String returnString = get(index);
   if (index > size) {
     throw new IndexOutOfBoundsException("Index greater than size of MyLinkedList");
   }
   if (index == 0) {
     Node a  = getNode(1);
     a.setPrev(null);
     start = a;
   } else {
     if (index == size - 1) {
       Node a = getNode(size - 2);
       end = a;
       a.setNext(null);
     } else {
       if(size == 1) {
         start = null;
         end = start;
       } else {
         Node prev = getNode(index - 1);
         Node next = getNode(index + 1);
         prev.setNext(next);
         next.setPrev(prev);
       }
     }
   }
   size--;
   return returnString;
 }

 public void extend(MyLinkedList other) {
   Node TEnd = this.getNode(this.size() - 1);
   Node OStart = other.getNode(0);
   TEnd.setNext(OStart);
   OStart.setPrev(TEnd);
   this.size += other.size();
   other = new MyLinkedList();
 }
}
