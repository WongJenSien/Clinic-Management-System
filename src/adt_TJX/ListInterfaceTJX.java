/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt_TJX;

/**
 *
 * @author Tai Jun Xian
 */
public interface ListInterfaceTJX<T> {
    
    public boolean add(T newMedicine);
    public T remove(int givenPosition);
    public boolean replace(int givenPosition, T newMedicine);
    public T getEntry(int givenPosition);
    public int getNumberOfEntries();
    public boolean isEmpty();
    
}
