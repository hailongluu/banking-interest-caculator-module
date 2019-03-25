/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import bank.SavingAccount;
import bank.SavingAccountDAO;
import connection.DBconnection;
import customer.Customer;

import java.sql.Connection;
import java.util.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * @author hailo
 */
public class TestCommon {
    public static void main(String[] args) throws SQLException {
        testSavingDAO();
    }

    static void testSavingDAO() {
        DateTimeFomater dtf = new DateTimeFomater();
        SavingAccountDAO savingAccountDAO = new SavingAccountDAO();
        BankAccountGenID bag = new BankAccountGenID();
        Customer customer = new Customer(1,null,"abc","abc","11111","11111");
        SavingAccount sa = new SavingAccount(bag.getNewSavingAccountId(),10000,8.7,2,"Deposite", customer,new Date());
        savingAccountDAO.addSavingAccount(sa);
        SavingAccount hn000001 = savingAccountDAO.getSavingAccountByAccountNumber("HN000001");
        List<SavingAccount> savingAccountByIdCard = savingAccountDAO.getSavingAccountByIdCard("1234567890");
        System.out.println(hn000001);
//        System.out.println(savingAccountByIdCard);
    }
}
