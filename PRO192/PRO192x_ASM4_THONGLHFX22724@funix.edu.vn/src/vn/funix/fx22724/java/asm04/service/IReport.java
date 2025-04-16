package vn.funix.fx22724.java.asm04.service;

import vn.funix.fx22724.java.asm04.model.Account;

public interface IReport {
    void log(double amount, String type, Account receiveAccount);
}
