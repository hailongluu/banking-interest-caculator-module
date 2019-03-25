/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import bank.SavingAccount;
import java.sql.SQLException;

/**
 *
 * @author hailo
 */
public class TestCommon {
    public static void main(String[] args) throws SQLException {
        BankAccountGenID bagid = new BankAccountGenID();
        SavingAccount sv = new SavingAccount();
        System.out.println(sv.autoGenNumber(10));
        System.out.println(bagid.toString());
    }
}
