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
}
