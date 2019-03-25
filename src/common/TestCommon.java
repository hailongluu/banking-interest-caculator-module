/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import bank.InterestCaculator;
import bank.SavingAccount;
import bank.SavingAccountDAO;
import customer.Customer;
import customer.CustomerDAO;
import java.sql.SQLException;
import java.util.Date;

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
        CustomerDAO cusDAO = new CustomerDAO();
//        cusDAO.getCustomerByIdCard("001097001906");
//        Customer customer = new Customer(1,null,"abc","abc","11111","11111");
//        SavingAccount sa = new SavingAccount(bag.getNewSavingAccountId(),10000,8.7,2,"Deposite", customer,new Date());
//        savingAccountDAO.addSavingAccount(sa);
//        SavingAccount hn000001 = savingAccountDAO.getSavingAccountByAccountNumber("HN000001");
//        List<SavingAccount> savingAccountByIdCard = savingAccountDAO.getSavingAccountByIdCard("1234567890");
//        System.out.println(hn000001);
//        System.out.println(savingAccountByIdCard);
    }
    static void testCaculator(){
        DateTimeFomater dtf = new DateTimeFomater();
        SavingAccountDAO savingAccountDAO = new SavingAccountDAO();
        InterestCaculator interestCaculator = new InterestCaculator();
        BankAccountGenID bag = new BankAccountGenID();
        Customer customer = new Customer(1,"abc","abc","11111","11111");
        SavingAccount sa = new SavingAccount(bag.getNewSavingAccountId(),100000000,5.5,2,"Deposite", customer,dtf.convertStringToDate("2018-03-01"));
        double interest = interestCaculator.caculateInterest(sa,dtf.convertStringToDate("2018-05-07") );
        double interest2 = interestCaculator.caculateInterest(sa,dtf.convertStringToDate("2018-10-10") );
        System.out.println(interest+"   "+interest2);
    }
}
