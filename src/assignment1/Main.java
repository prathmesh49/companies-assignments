package assignment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Store store = new Store();

		printProduct(store);
		Budget budget = new Budget(600);
		try {
			setBudget(budget);
		} catch (CustomeException e) {
			e.printStackTrace();
			return;
		}
		Operataions operataions = new Operataions();
		operataions.setBudget(budget);
		operataions.setStore(store);

		operataions.possibleCombinitionInBudget();

		List<List<Integer>> list = operataions.getAnswer();
		System.out.println("Possible Combination in Budget :");
		for (List<Integer> combination : list) {
			int tshirts = combination.get(0);
			int jeans = combination.get(1);
			int jackets = combination.get(2);
			if (tshirts > 0 && jeans > 0 && jackets > 0) {
				int remainingBudget = (int) budget.getAmount()
						- (tshirts * store.getT_shirt() + jeans * store.getJeans() + jackets * store.getJackets());
				if (remainingBudget < tshirts * store.getT_shirt()) {
					System.out.println("T-shirts: " + tshirts + ", Jeans: " + jeans + ", Jackets: " + jackets);
				}
			}
		}

	}

	private static void setBudget(Budget budget) throws CustomeException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.println("Enter the Ammount : ( fill NA for default amount 600$ ) ");
				String input = br.readLine();
				if (input.equals("NA"))
					return;
				else {
					double ammount = Double.parseDouble(input);
					budget.setAmount(ammount);
					break;
				}
			} catch (NumberFormatException | IOException e) {
//				throw new CustomeException("Invalid Input! Please try again..");
				System.out.println("Invalid Input! Please try again..");
			}
		}

		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void printProduct(Store store) {
		System.out.println("T-shirts: " + store.getT_shirt() + "$ , Jeans: " + store.getJeans() + "$ , Jackets: "
				+ store.getJackets() + "$");
	}

}
