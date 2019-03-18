/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import customer.Customer;
import java.sql.Date;

/**
 *
 * @author hailo
 */
public class BankAccount {
    private int id;
    private String number;
    private double cash;
    private Customer customer;
    private Date date;
    public BankAccount() {
    }

    public BankAccount(int id, String number, double cash, Customer customer, Date date) {
        this.id = id;
        this.number = number;
        this.cash = cash;
        this.customer = customer;
        this.date = date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
    
    

    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public double getCash() {
        return cash;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
}
