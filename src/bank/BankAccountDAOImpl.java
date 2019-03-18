/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import customer.Customer;

/**
 *
 * @author hailo
 */
public class BankAccountDAOImpl {
    public boolean addAccount(BankAccount account){
        return true;
    }
    public boolean addSavingAccount(SavingAccount account){
        return true;
    }
    public BankAccount getBankAccount(Customer customer ){
        return null;
    }
    public SavingAccount getSavingAccount(Customer customer){
        return null;
    }
}
