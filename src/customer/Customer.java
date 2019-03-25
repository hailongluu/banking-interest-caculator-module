package customer;

import bank.Account;

public class Customer {

    private int id;
    private Account account;
    public String fullName;
    public String address;
    public String phoneNumber;
    String idCard;

    public Customer(int id, Account account, String fullName, String address, String phoneNumber, String idCard) {
        this.id = id;
        this.account = account;
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.idCard = idCard;
    }

    public Customer() {
    }

    
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Account getAccount() {
        return account;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }
@Override
    public String toString() {
        return "Customer{" + "id=" + id + ", account=" + account + ", fullName=" + fullName + ", address=" + address + ", phoneNumber=" + phoneNumber + ", idCard=" + idCard + '}';
    }
    
}
