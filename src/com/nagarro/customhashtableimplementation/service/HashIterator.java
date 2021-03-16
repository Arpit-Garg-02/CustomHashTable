/*
* Class name: HashIterator
*
* Version info: jdk 1.8
*
* Copyright notice:
* 
* Author info: Arpit Garg
*
* Creation date: 16/Mar/2021
*
* Last updated By: Arpit Garg
*
* Last updated Date: 16/Mar/2021
*
* Description: Iterator class for Hash Table
*/
package com.nagarro.customhashtableimplementation.service;

import java.util.ArrayList;
import java.util.Iterator;

import com.nagarro.customhashtableimplementation.model.HashNode;

public class HashIterator implements Iterator<Object> {
    private int capacity;
    private int nextElement = 0;
    private HashNode<Object, Object>[] hashEntry;

    public HashIterator(int capacity, HashNode[] hashEntry) {
        this.capacity = capacity;
        this.hashEntry = hashEntry;
    }

    /**
     * check hash table has next element or not
     */
    @Override
    public boolean hasNext() {
        if (nextElement > (capacity - 1)) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        String output = "";
        if (hashEntry[nextElement] != null) {
            HashNode node = hashEntry[nextElement];
            output += node.getKey() + "=";
            ArrayList<Integer> value = node.getValue();
            for (Integer nodeValue : value) {
                output += " " + nodeValue + ",";
            }
            output = output.substring(0, output.length() - 1);
        }
        nextElement++;
        return output;
    }
}
