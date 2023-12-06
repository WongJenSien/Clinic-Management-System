/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt_LXC;

import java.io.Serializable;

/**
 *
 * @author XIAO CHERK
 */
public class ArrayListLXC<T> implements ListInterfaceLXC<T>, Serializable {

    private T[] array;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 2;

    public ArrayListLXC() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayListLXC(int initialCapacity) {
        numberOfEntries = 0;
        array = (T[]) new Object[initialCapacity];
    }

    public void add(T newEntry) {
        if(isFull()){
            doubleArray();
        }
        array[numberOfEntries] = newEntry;
        numberOfEntries++;
    }

    public boolean add(int newPosition, T newEntry) {
        boolean isSuccessful = true;

        if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
            makeCampaign(newPosition);
            array[newPosition - 1] = newEntry;
            numberOfEntries++;
        } else {
            isSuccessful = false;
        }
        return isSuccessful;
    }

    public T remove(int givenPosition) {
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            result = array[givenPosition - 1];

            if (givenPosition < numberOfEntries) {
                removeGap(givenPosition);
            }
            numberOfEntries--;
        }
        return result;
    }

    public void clear() {
        numberOfEntries = 0;

    }

    public boolean replace(int givenPosition, T newEntry) {
        boolean isSuccessful = true;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            array[givenPosition - 1] = newEntry;
        } else {
            isSuccessful = false;
        }

        //array [givenPosition] = newEntry;
        return isSuccessful;
    }

    public T getEntry(int givenPosition) {
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            result = array[givenPosition - 1];
        }
        return result;
    }

    public boolean contains(T anEntry) {
        boolean found = false;
        for (int index = 0; !found && (index < numberOfEntries); index++) {
            if (anEntry.equals(array[index])) {
                found = true;
            }
        }
        return found;
    }

    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    public boolean isFull() {
        return numberOfEntries == array.length;
    }

    private void doubleArray() {
        T[] oldList = array;
        int oldSize = oldList.length;

        array = (T[]) new Object[2 * oldSize];

        for (int index = 0; index < oldSize; index++) {
            array[index] = oldList[index];
        }
    }
    
    public String toString() {
        String outputStr = "";
        for (int index = 0; index < numberOfEntries; ++index) {
            outputStr += array[index] + "\n";
        }
        return outputStr;
    }

    private void makeCampaign(int newPosition) {
        int newIndex = newPosition - 1;
        int lastIndex = numberOfEntries - 1;

        for (int index = lastIndex; index >= newIndex; index--) {
            array[index + 1] = array[index];
        }
    }

    private void removeGap(int givenPosition) {
        int removeIndex = givenPosition - 1;
        int lastIndex = numberOfEntries - 1;

        for (int index = removeIndex; index < lastIndex; index++) {
            array[index] = array[index + 1];
        }
    }
}
