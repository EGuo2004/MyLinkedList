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
}
