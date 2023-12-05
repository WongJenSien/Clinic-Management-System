/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package adt_patience;

import java.util.Iterator;

/**
 *
 * @author wongh
 */
public interface ListInterface<T> {
    public boolean isEmpty();
    public boolean contains(T anEntry);
    public boolean addFront(T newEntry);
    public boolean add(T newEntry);
    public boolean add(int newPosition, T newEntry);
    public boolean replace(int givenPosition, T newEntry);
    public T remove(int givenPosition);
    public T getEntry(int givenPosition);
    public int getNumberOfEntries();
    public void clear();
    public Iterator<T> getIterator();

}
