package com.mning.cashregister.process;
/**
 * Created by IntelliJ IDEA.
 * User: Michael Ning
 * Date: 10/25/17
 * Time: 10:23 PM
 * Interface for CashRegisterProcess
 */
public interface ICashRegisterProcess {
    public boolean changes(int start, int change);
    public String getOutput();
}
