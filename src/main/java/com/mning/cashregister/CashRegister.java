package com.mning.cashregister;

import com.mning.cashregister.process.impl.CashRegisterProcessImpl;
import com.mning.cashregister.process.ICashRegisterProcess;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Michael Ning
 * Date: 10/24/17
 * Time: 12:54 PM
 * CashRegister is to handle I/O (CLI) and output changes in console
 */

class CashRegister {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        int length, change;
        String array;
        System.out.println("Enter the length of an array:");
        length = (scanner.nextInt());
        int[] arr = new int[length];
        System.out.println("Enter array in one line(comma as separator):");
        array = (scanner.next());
        convertToArray(length, array, arr);
        System.out.println("Enter Change:");
        change = (scanner.nextInt());

        executeChanges(length, change, arr);

    }

    private static void executeChanges(int length, int change, int[] arr) {
        ICashRegisterProcess cashRegisterImpl = new CashRegisterProcessImpl(arr, change);
        cashRegisterImpl.changes(0, change);
        System.out.println(cashRegisterImpl.getOutput());
    }

    //convert input string with comma to array, if there is non-numeric character, application exits
    private static void convertToArray(int length, String array, int[] arr) {
        String[] sarr = array.split(",");
        try {
            for (int i = 0; i < length; i++) {
                arr[i] = Integer.valueOf(sarr[i]);
            }
        } catch (Exception e) {
            System.out.println("Please only type Integer!");
            System.exit(0);
        }
    }
}