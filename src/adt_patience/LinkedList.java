/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt_patience;

import entity.Patient;
import java.util.Iterator;

public class LinkedList<T> implements ListInterface<T> {
      private Node firstNode;
    private int numberOfEntries;
    
    
    private class Node {

    private T data;
    private Node next;

    private Node(T data) {
      this.data = data;
      this.next = null;
    }

    
    private Node(T data, Node next) {
      this.data = data;
      this.next = next;
    }
    
    }
    
    
    @Override
    public boolean isEmpty() {
        boolean result;
        result = numberOfEntries == 0;
        return result;

    }

    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
    Node currentNode = firstNode;

    while (!found && (currentNode != null)) {
      if (anEntry.equals(currentNode.data)) {
        found = true;
      } else {
        currentNode = currentNode.next;
      }
    }
    return found;
        
        
    }
    
  
//Add to front
    @Override
    public boolean addFront(T newEntry) {
       Node newNode = new Node(newEntry);
       
       if(isEmpty()){
           firstNode = newNode;
       }else{
           newNode.next = firstNode;
           firstNode= newNode;
       }
       numberOfEntries++; //add newNode == increase of entries
        return true;
       
    }
 
    //Add to back
    @Override
    public boolean add(T newEntry) {
       Node newNode = new Node(newEntry);
       
       if(isEmpty()){
           
           firstNode = newNode;
       }else{
           Node currentNode = firstNode;
           
           while ( currentNode.next !=null){  //havent reach the last node
               if(currentNode.data.equals(newEntry)){  //have same node
                   return false;
               }
               currentNode = currentNode.next;  //to reach last node
       }
        currentNode.next = newNode; //lastNode.next become newNode
       }
       
       numberOfEntries++; //add newNode == increase of entries
       return true;
    }

    // Add to specifix position
    @Override
    public boolean add(int newPosition, T newEntry) {
        boolean isSuccessful = true;
        if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {   
            Node newNode = new Node(newEntry);

            if (isEmpty() || (newPosition == 1)) {  //check if no any node, add to beginning
                newNode.next = firstNode;  //new node link to the first node = first node become second node
                firstNode = newNode;  // and then first node become new node
            } else {
                Node nodeBefore = firstNode; //have first node

                while (nodeBefore.next != null) { //have second & others
                    if (nodeBefore.data.equals(newEntry)) {  //have same data with new node
                        return false;
                    }
                    nodeBefore = nodeBefore.next; 
                }

                nodeBefore = firstNode;

                for (int i = 1; i < newPosition - 1; i++) { 
                    nodeBefore = nodeBefore.next;
                }
                newNode.next = nodeBefore.next;
                nodeBefore.next = newNode;
            }
            numberOfEntries++;
        } 
        else {
            isSuccessful = false;
        }

        return isSuccessful;
        

    }

    @Override
    public boolean replace(int givenPosition, T newEntry) {
       boolean isSuccessful = true;
       
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
      Node currentNode = firstNode;
      for (int i = 0; i < givenPosition - 1; ++i) {
        currentNode = currentNode.next;		// advance currentNode to next node
      }
      currentNode.data = newEntry; //when arrived given position currentNode replace by new Entry
        }
        else{
            isSuccessful =false;
        }
        
        return isSuccessful;
    

    }

    
    @Override
    public T remove(int givenPosition) {
       T result = null;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {  
            if (givenPosition == 1) { 
                result = firstNode.data;  // first node will be null
                firstNode = firstNode.next;  //the second node will be first node
            } else {
                Node nodeBefore = firstNode;  
                for (int i = 1; i < givenPosition - 1; i++) {
                    nodeBefore = nodeBefore.next;   //loop until the firstNode beside to node of given position
                }
                result = nodeBefore.next.data; //node of given position become null
                nodeBefore.next = nodeBefore.next.next; //the node after move infront
            }

            numberOfEntries--; // remove node = decrease entries
        }

        return result;
    }

    @Override
    public T getEntry(int givenPosition) {
       T result = null;

    if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
      Node currentNode = firstNode;
      for (int i = 0; i < givenPosition - 1; ++i) {
        currentNode = currentNode.next;		// advance currentNode to next node
      }
      result = currentNode.data;	// currentNode is pointing to the node at givenPosition
    }

    return result; // return null if there is no entry at given position
    }

    @Override
    public int getNumberOfEntries() {
       return numberOfEntries;
    }

    @Override
    public void clear() {
         firstNode = null;
         numberOfEntries = 0;
        
    }
    
    @Override
    public Iterator<T> getIterator(){
        return new LinkedListIterator();
    }
    
    private class LinkedListIterator implements Iterator<T>{
        
        private Node currentNode = firstNode;

        @Override
        public boolean hasNext() { //check if entry exists
            return currentNode != null;
        }

        @Override
        public T next() {
            
            if (hasNext()){
                T currentData = currentNode.data;
                    currentNode = currentNode.next;
                    return currentData;
                    
            } else {
            return null; //if no next item the return nothing
            }
        }
    
    }
}
