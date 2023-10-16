package assignment1;

public class Budget {
	private double amount;

	public Budget(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Budget [ amount= " + amount + "$ ]";
	}

}
