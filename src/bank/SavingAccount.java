/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import customer.Customer;
import java.util.Date;

/**
 *
 * @author hailo
 */
public class SavingAccount {
    int id;
    String number;
    double cash;
    double interestRate;
    int term;
    String kind;
    Customer customer;
    Date date;
    int isWithdrawned;

    public SavingAccount(int id, double cash, double interestRate, int term, String kind, Customer customer, Date date) {
        
        this.id = id;
        this.number = autoGenNumber(id);
        this.cash = cash;
        this.interestRate = interestRate;
        this.term = term;
        this.kind = kind;
        this.customer = customer;
        this.date = date;
        this.isWithdrawned = 0;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setIsWithdrawned(int isWithdrawned) {
        this.isWithdrawned = isWithdrawned;
    }

    public int getIsWithdrawned() {
        return isWithdrawned;
    }
//    khoi tao khi tao tk tiet kiem iswithdrawned = 0
    public SavingAccount(int id, String number, double cash, double interestRate, int term, String kind, Customer customer, Date date) {

        this.id = id;
        this.number = number;
        this.cash = cash;
        this.interestRate = interestRate;
        this.term = term;
        this.kind = kind;
        this.customer = customer;
        this.date = date;
        this.isWithdrawned = 0;
    }
//    khoi tao khi lay ra tu csdl de check account da rut hay chua
    public SavingAccount(int id, String number, double cash, double interestRate, int term, String kind, Customer customer, Date date,int isWithdrawned) {

        this.id = id;
        this.number = number;
        this.cash = cash;
        this.interestRate = interestRate;
        this.term = term;
        this.kind = kind;
        this.customer = customer;
        this.date = date;
        this.isWithdrawned = isWithdrawned;
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

    public double getInterestRate() {
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
