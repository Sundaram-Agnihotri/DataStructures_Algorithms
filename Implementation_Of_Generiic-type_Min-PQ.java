//the best way to implement priority queue is to use balanced bst , in which use lgn time in all cases. But there is an issue with this is : we have to maintain balace factor of each node and there is difficult to store the values in tree as there is useage of pointers for left child and right child.
// So we use heap datastructure to reresent priority queue as it holds :
// 1 : complete binary tree
// 2 : heap property

//to store the heap we internally used ArrayList , where in each index there will be two elemnts stored 1- > data and 2 -> priority of that element...
import java.util.*;

public class Implementation_of_PQ<T>{
    private ArrayList<Element<T>> heap;

    public Implementation_of_PQ(){
        //initialize the array list
        heap = new ArrayList<>();
    }

    public void insert(T value,int priority){
      
      Element<T> e = new Element<>(value,priority);
      heap.add(e);

      int childrenIndex = heap.size()-1;
      int parentIndex = (childrenIndex -1)/2;

      while (childrenIndex > 0) {
        if(heap.get(childrenIndex).priority < heap.get(parentIndex).priority){
          Element<T> temp = heap.get(childrenIndex);
          heap.set(childrenIndex, heap.get(parentIndex));
          heap.set(parentIndex, temp);
          childrenIndex = parentIndex;
          parentIndex = (childrenIndex -1)/2;
        }
        else{
          return;
        }
        
      }
    }

    public T getMin(){
      if(isEmpty()){
        return null;
      }
      else{
        return heap.get(0).value;
      }
    }

    public T removeMin(){
     if(isEmpty()){
      return null;
     }

     Element<T> removed = heap.get(0);
     T ans = removed.value;

     heap.set(0,heap.get(heap.size()-1));
     heap.remove(heap.size()-1);

     int parentIndex = 0;
     int leftChildIndex = 2*parentIndex + 1;
     int rightChildIndex = 2*parentIndex + 2;

     while (leftChildIndex<heap.size()) {
      int minIndex = parentIndex;
      if(heap.get(leftChildIndex).priority < heap.get(minIndex).priority){
        minIndex = leftChildIndex;
      }
      if (rightChildIndex<heap.size() && (heap.get(rightChildIndex).priority < heap.get(minIndex).priority)) {
        minIndex = rightChildIndex;
      }

      Element<T> temp = heap.get(minIndex);
      heap.set(minIndex,heap.get(parentIndex));
      heap.set(parentIndex, temp);
      parentIndex = minIndex;
      leftChildIndex = 2*parentIndex + 1;
      rightChildIndex = 2*parentIndex + 2;
      
     }

     return ans;
    }

    public int size(){
       return heap.size();
    }

    public boolean isEmpty(){
       if(size() == 0)
       return true;
       
       return false;
    }
}
