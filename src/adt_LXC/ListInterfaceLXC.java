/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt_LXC;

/**
 *
 * @author KIEN
 */
public interface ListInterfaceLXC<T> {

    public void add(T newEntry);

    public boolean add(int newPosition, T newEntry);

    public T remove(int givenPosition);

    public void clear();

    public boolean replace(int givenPosition, T newEntry);

    public T getEntry(int givenPosition);

    public boolean contains(T anEntry);

    public int getNumberOfEntries();

    public boolean isEmpty();

    public boolean isFull();
}
