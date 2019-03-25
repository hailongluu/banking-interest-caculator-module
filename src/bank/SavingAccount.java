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
public class SavingAccount {
    int id;
    String number;
    double cash;
    float interestRate;
    int term;
    String kind;
    Customer customer;
    Date date;

    public SavingAccount(int id, String number, double cash, float interestRate, int term, String kind, Customer customer, Date date) {
        
        this.id = id;
        this.number = autoGenNumber(id);
        this.cash = cash;
        this.interestRate = interestRate;
        this.term = term;
        this.kind = kind;
        this.customer = customer;
        this.date = date;
    }

    public SavingAccount() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public float getInterestRate() {
        return interestRate;
    }

    public int getTerm() {
        return term;
    }

    public String getKind() {
        return kind;
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

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public String autoGenNumber(int id){
        String numberFomartted = String.format("HN%06d", id);
        return numberFomartted;
    }
}
