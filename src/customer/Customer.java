package customer;

import customer.Account;
import customer.Person;

public class Customer extends Person {
	private int id;

    public Customer(int id, Account account, String fullName, String address, String idCard) {
        super(account, fullName, address, idCard);
        this.id = id;
    }
       

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", fullName=" + fullName +
                ", address=" + address +
                '}';
    }
}