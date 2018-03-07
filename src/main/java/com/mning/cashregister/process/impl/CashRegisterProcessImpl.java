package com.mning.cashregister.process.impl;

import com.mning.cashregister.process.ICashRegisterProcess;

import java.util.*;
/**
 * Created by IntelliJ IDEA.
 * User: Michael Ning
 * Date: 10/25/17
 * Time: 10:26 PM
 * Implementation of ICashRegisterProcess
 */
public class CashRegisterProcessImpl implements ICashRegisterProcess {

    private Stack<Integer> stack = new Stack<Integer>();
    private int sumInStack = 0;
    private List<Integer> sortedData;
    private String output = "No Solution";

    public CashRegisterProcessImpl(int[] data, int change) {
        sortArray(data, change);
    }

    // find the first solution for the changes,then record it in stack and exit
    public boolean changes(int start, int change) {
        if (sumInStack == change) {
            buildOutput(stack, change);
            return false;
        }
        for (int currentIndex = start; currentIndex < sortedData.size(); currentIndex++) {
            if (sumInStack + sortedData.get(currentIndex) <= change) {
                stack.push(sortedData.get(currentIndex));
                sumInStack += sortedData.get(currentIndex);
                if (!changes(currentIndex + 1, change)) {
                    return false;
                }
                sumInStack -= (Integer) stack.pop();
            }
        }
        return false;
    }

    // build the solution as output
    private void buildOutput(Stack<Integer> stack, int change) {
        StringBuilder sb = new StringBuilder();
        for (Integer i : stack) {
            sb.append(i).append(",");
        }
        output = sb.deleteCharAt(sb.length() - 1).toString();
    }

    // sort input array in ascending order and ignore any number greater than change
    private void sortArray(int[] data, int change) {
        sortedData = new ArrayList<Integer>();
        Arrays.sort(data);
        for (int i : data) {
            if (i <= change && i > 0) {
                sortedData.add(i);
            } else {
                break;
            }
        }
    }

    public String getOutput() {
        return output;
    }
}