/*
* Class name: CustomHashTable
*
* Version info: jdk 1.8
*
* Copyright notice:
* 
* Author info: Arpit Garg
*
* Creation date: 15/Mar/2021
*
* Last updated By: Arpit Garg
*
* Last updated Date: 16/Mar/2021
*
* Description: Hash Table class for creating and do operations
*/
package com.nagarro.customhashtableimplementation.service;

import java.util.ArrayList;
import java.util.Iterator;

import com.nagarro.customhashtableimplementation.model.HashNode;

public class CustomHashTable<K, V> implements Iterable<Object> {
    private HashNode<K, V> hashEntry[];
    private int size;
    private int capacity;

    /**
     * To initialize value of size, capacity and HashNode[]
     */
    public CustomHashTable() {
        this.size = 0;
        this.capacity = 16;
        this.hashEntry = new HashNode[16];
        for (int i = 0; i < this.capacity; i++) {
            hashEntry[i] = null;
        }
    }

    /**
     * Insert key and Value pair to hash table
     * 
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        int hash = getHashValue((key));
        if (hasKey(key)) {
            hashEntry[hash].setValue(value);
        } else {
            hashEntry[hash] = new HashNode<K, V>(key, value);
            size++;
        }
    }

    /**
     * return value corresponding to the key
     * 
     * @param key
     * @return
     */
    public ArrayList<Object> get(K key) {
        int hash = getHashValue(key);
        if (hashEntry[hash] == null) {
            return null;
        } else {
            return hashEntry[hash].getValue();
        }
    }

    /**
     * Remove the key value pair corresponding to the key
     * 
     * @param key
     * @return
     */
    public void remove(K key) {
        if (key != null) {
            int hash = getHashValue(key);
            while (hashEntry[hash] != null) {
                if (hashEntry[hash].getKey().equals(key)) {
                    hashEntry[hash] = null;
                    size--;
                }
                hash = (hash + 1) % this.capacity;
            }
        }
    }

    /**
     * Search for the key
     * 
     * @param key
     * @return
     */
    public boolean hasKey(K key) {
        int hash = getHashValue(key);
        if (hashEntry[hash] == null) {
            return false;
        } else if (hashEntry[hash].getKey().equals(key)) {
            return true;
        }
        return false;
    }

    /**
     * Search for the value
     * 
     * @param value
     * @return
     */
    public boolean hasValue(V value) {
        for (int i = 0; i < this.capacity; i++) {
            HashNode<K, V> node = hashEntry[i];
            if (node != null) {
                ArrayList<Object> nodeListValue = node.getValue();
                for (Object nodeValue : nodeListValue) {
                    if (nodeValue.equals(value)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Give size of hash table
     * 
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * Check hash table is empty or not
     * 
     * @return
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Traverse the hash table
     */
    public void traverse() {
        for (int i = 0; i < capacity; i++) {
            if (hashEntry[i] != null) {
                System.out.println("");
                HashNode node = hashEntry[i];
                System.out.print(node.getKey() + "= ");
                ArrayList<Integer> value = node.getValue();
                for (Integer nodeValue : value) {
                    System.out.print(nodeValue + " ");
                }
            }
        }
        System.out.println("");
    }

    /**
     * Iterator for hash table
     */
    public void customIterator(CustomHashTable<K, V> hashTable) {
        Iterator<Object> itr = hashTable.iterator();
        System.out.println(itr.hasNext());
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    /**
     * calculate the hash value for key
     * 
     * @param key
     * @return
     */
    private int getHashValue(K key) {
        int hash = (key.hashCode() % this.capacity);
        // to avoid collisions if already used by key
        while (hashEntry[hash] != null && !(hashEntry[hash].getKey() == key)) {
            hash = (hash + 1) % this.capacity;
        }
        return hash;
    }

    @Override
    public Iterator<Object> iterator() {
        return new HashIterator(capacity, this.hashEntry);
    }
}
