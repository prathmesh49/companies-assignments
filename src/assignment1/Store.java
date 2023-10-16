package assignment1;

public class Store {
	private int t_shirt;
	private int jeans;
	private int jackets;

	public Store() {
		this.t_shirt = 50;
		this.jeans = 80;
		this.jackets = 100;
	}

	public int getItemPrice(int idx) {
		if (idx == 0) {
			return getT_shirt();
		} else if (idx == 1) {
			return getJeans();
		} else {
			return getJackets();
		}
	}

	public int getT_shirt() {
		return t_shirt;
	}

	public void setT_shirt(int t_shirt) {
		this.t_shirt = t_shirt;
	}

	public int getJeans() {
		return jeans;
	}

	public void setJeans(int jeans) {
		this.jeans = jeans;
	}

	public int getJackets() {
		return jackets;
	}

	public void setJackets(int jackets) {
		this.jackets = jackets;
	}

	@Override
	public String toString() {
		return "Store [ t_shirt= " + t_shirt + "$ , jeans= " + jeans + "$ , jackets= " + jackets + "$ ]";
	}

}
