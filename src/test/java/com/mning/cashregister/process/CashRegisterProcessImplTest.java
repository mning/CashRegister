package com.mning.cashregister.process;

import com.mning.cashregister.process.impl.CashRegisterProcessImpl;
import org.junit.Assert;
import org.junit.Test;
/**
 * Created by IntelliJ IDEA.
 * User: Michael Ning
 * Date: 10/24/17
 * Time: 12:53 PM
 * Unit Test Cases for CashRegisterProcessImpl
 */
public class CashRegisterProcessImplTest {
    private ICashRegisterProcess cashRegisterProcess;

    @Test
    public void changesHappyTest1() throws Exception {
        int[] data = {1, 2, 5, 5};
        cashRegisterProcess = new CashRegisterProcessImpl(data, 8);
        cashRegisterProcess.changes(0, 8);
        String returnedString = cashRegisterProcess.getOutput();
        String expectedString = "1,2,5";
        Assert.assertEquals(expectedString, returnedString);
    }

    @Test
    public void changesHappyTest2() throws Exception {
        int[] data = {1, 1, 1, 1, 2, 2, 5};
        cashRegisterProcess = new CashRegisterProcessImpl(data, 8);
        cashRegisterProcess.changes(0, 8);
        String returnedString = cashRegisterProcess.getOutput();
        String expectedString = "1,1,1,1,2,2";
        Assert.assertEquals(expectedString, returnedString);
    }

    @Test
    public void changesSadTest() throws Exception {
        int[] data = {1, 2, 10};
        cashRegisterProcess = new CashRegisterProcessImpl(data, 8);
        cashRegisterProcess.changes(0, 8);
        String returnedString = cashRegisterProcess.getOutput();
        String expectedString = "No Solution";
        Assert.assertEquals(expectedString, returnedString);
    }

    @Test
    public void shouldBeHappyButIsSadTest() throws Exception {
        int[] data = new int[100001];
        for (int i = 0; i < 100000; ++i) {
            data[i] = 20;
        }
        data[100000] = 5;
        cashRegisterProcess = new CashRegisterProcessImpl(data, 5);
        cashRegisterProcess.changes(0, 5);
        String returnedString = cashRegisterProcess.getOutput();
        String expectedString = "5";
        Assert.assertEquals(expectedString, returnedString);
    }
}