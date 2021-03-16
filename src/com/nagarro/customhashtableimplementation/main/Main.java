/*
* Class name: Main
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
* Last updated Date: 15/Mar/2021
*
* Description: Main class of Hash Table
*/
package com.nagarro.customhashtableimplementation.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.nagarro.customhashtableimplementation.exception.InvalidStateException;
import com.nagarro.customhashtableimplementation.service.CustomHashTable;
import com.nagarro.customhashtableimplementation.utils.InputValidationUtil;

public class Main {
    private static final String WRONG_CHOICE = "Wrong Choice!";
    private static final String ENTER_VALUE_TO_BE_SEARCH = "Enter value to be search";
    private static final String _4_CONATINS_VALUE = "4- Conatins Value";
    private static final String _3_CONTAINS_KEY = "3- Contains Key";
    private static final String ENTER_KEY_VALUE = "Enter Key Value";
    private static final String _8_TRAVERSE = "8- Traverse";
    private static final String ENTER_ELEMENT_TO_BE_ADDED = "Enter Element to be added";
    private static final String WELCOME = "Welcome!....";
    private static final String _7_ITERATOR = "7- Iterator";
    private static final String _6_SIZE = "6- Size";
    private static final String _5_GET_VALUE_BY_KEY = "5- Get Value By Key";
    private static final String _2_REMOVE = "2- Remove";
    private static final String _1_INSERT = "1- Insert";
    private static final String SELECT_OPERATION_TO_BE_PERFORM = "Select Operation to be perform...";
    private static final String PRESS_Y_FOR_CONTINUE = "Press 'y' for continue...";
    private static final String ENTER_YOUR_CHOICE = "Enter Your Choice...";
    private static Scanner scan = new Scanner(System.in);

    /**
     * @param args
     */
    public static void main(String[] args) {
        char ch;
        CustomHashTable<Integer, Integer> hashTable = new CustomHashTable<Integer, Integer>();
        System.out.println(WELCOME);
        do {
            System.out.println(SELECT_OPERATION_TO_BE_PERFORM);
            System.out.println(_1_INSERT);
            System.out.println(_2_REMOVE);
            System.out.println(_3_CONTAINS_KEY);
            System.out.println(_4_CONATINS_VALUE);
            System.out.println(_5_GET_VALUE_BY_KEY);
            System.out.println(_6_SIZE);
            System.out.println(_7_ITERATOR);
            System.out.println(_8_TRAVERSE);
            System.out.println(ENTER_YOUR_CHOICE);
            String choiceForOperation = scan.next();
            int choice = new InputValidationUtil().inputValidation(choiceForOperation);
            choiceAction(choice, hashTable);
            System.out.println(PRESS_Y_FOR_CONTINUE);
            ch = scan.next().charAt(0);
        } while (ch == 'y');
        scan.close();
    }

    /**
     * provide different operations for user
     * 
     * @param choice
     * @param hashTable
     */
    private static void choiceAction(int choice, CustomHashTable<Integer, Integer> hashTable) {
        switch (choice) {
        case 1:
            System.out.println(ENTER_KEY_VALUE);
            String KeyValueToAdd = scan.next();
            int key = new InputValidationUtil().inputValidation(KeyValueToAdd);
            System.out.println(ENTER_ELEMENT_TO_BE_ADDED);
            String ValueForKey = scan.next();
            int value = new InputValidationUtil().inputValidation(ValueForKey);
            hashTable.put(key, value);
            break;

        case 2:
            System.out.println(ENTER_KEY_VALUE);
            String keyForRemove = scan.next();
            key = new InputValidationUtil().inputValidation(keyForRemove);
            hashTable.remove(key);
            break;

        case 3:
            System.out.println(ENTER_KEY_VALUE);
            String keyForSearch = scan.next();
            key = new InputValidationUtil().inputValidation(keyForSearch);
            System.out.println(hashTable.hasKey(key));
            break;

        case 4:
            System.out.println(ENTER_VALUE_TO_BE_SEARCH);
            String valueForSearch = scan.next();
            value = new InputValidationUtil().inputValidation(valueForSearch);
            System.out.println(hashTable.hasValue(value));
            break;

        case 5:
            System.out.println(ENTER_KEY_VALUE);
            String keyForGetValue = scan.next();
            key = new InputValidationUtil().inputValidation(keyForGetValue);
            ArrayList<Object> nodeValue = hashTable.get(key);
            for (Object nodeVal : nodeValue)
                System.out.println(nodeVal + " ");
            break;

        case 7:
            hashTable.customIterator(hashTable);
            break;

        case 6:
            System.out.println(hashTable.size());
            break;

        case 8:
            hashTable.traverse();
            break;

        default:
            new InvalidStateException(WRONG_CHOICE);
        }
    }

}
