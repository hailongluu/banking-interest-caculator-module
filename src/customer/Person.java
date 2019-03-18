package customer;

public class Person {
	private Account account;
	public String fullName;
        public String address;
        String idCard;

    public Person(Account account, String fullName, String address, String idCard) {
        this.account = account;
        this.fullName = fullName;
        this.address = address;
        this.idCard = idCard;
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
		return "Person{" +
				"account=" + account +
				", fullName=" + fullName +
				", address=" + address +
				'}';
	}
}