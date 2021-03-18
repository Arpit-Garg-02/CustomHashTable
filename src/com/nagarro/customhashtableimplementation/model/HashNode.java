/*
* Class name: HashNode
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
* Description: Model class of Hash Table, Store Value in the Node
*/
package com.nagarro.customhashtableimplementation.model;

import java.util.ArrayList;

public class HashNode<K, V> {
    private K key;
    private ArrayList<Object> ObjectValue;

    /**
     * @param key
     * @param value
     */
    public HashNode(K key, V value) {
        this.key = key;
        ObjectValue = new ArrayList<>();
        ObjectValue.add(value);
    }

    /**
     * @return key
     */
    public K getKey() {
        return key;
    }

    /**
     * @param key
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     * @return value
     */
    public ArrayList<Object> getValue() {
        return ObjectValue;
    }

    /**
     * @param value
     */
    public void setValue(V value) {
        this.ObjectValue.add(value);
    }
}
