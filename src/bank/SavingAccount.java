/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import customer.Customer;
import java.util.Date;
import java.util.Objects;

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
// Khoi tao khi tao stk moi
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.number);
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.cash) ^ (Double.doubleToLongBits(this.cash) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.interestRate) ^ (Double.doubleToLongBits(this.interestRate) >>> 32));
        hash = 53 * hash + this.term;
        hash = 53 * hash + Objects.hashCode(this.kind);
        hash = 53 * hash + Objects.hashCode(this.customer);
        hash = 53 * hash + Objects.hashCode(this.date);
        hash = 53 * hash + this.isWithdrawned;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SavingAccount other = (SavingAccount) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.cash) != Double.doubleToLongBits(other.cash)) {
            return false;
        }
        if (Double.doubleToLongBits(this.interestRate) != Double.doubleToLongBits(other.interestRate)) {
            return false;
        }
        if (this.term != other.term) {
            return false;
        }
        if (this.isWithdrawned != other.isWithdrawned) {
            return false;
        }
        if (!Objects.equals(this.number, other.number)) {
            return false;
        }
        if (!Objects.equals(this.kind, other.kind)) {
            return false;
        }
        if (!Objects.equals(this.customer, other.customer)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }
    
}
