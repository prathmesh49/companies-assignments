package assignment1;

import java.util.ArrayList;
import java.util.List;

public class Operataions {
	private Store store;
	private Budget budget;
	private List<List<Integer>> answer = new ArrayList<>();

	public Operataions(Store store, Budget budget) {
		this.setStore(store);
		this.setBudget(budget);
	}

	public Operataions() {
	}

	public void possibleCombinitionInBudget() {
		generateCombinations((int) budget.getAmount(), 0, new ArrayList<>(), answer);
	}

	private void generateCombinations(int remainingBudget, int start, List<Integer> currentCombination,
			List<List<Integer>> validCombinations) {
		if (currentCombination.size() == 3) {
			int totalCost = currentCombination.get(0) * store.getT_shirt()
					+ currentCombination.get(1) * store.getJeans() + currentCombination.get(2) * store.getJackets();
			if (totalCost <= remainingBudget) {
				validCombinations.add(new ArrayList<>(currentCombination));
			}
			return;
		}

		for (int i = start; i <= remainingBudget / store.getItemPrice(currentCombination.size()); i++) {
			currentCombination.add(i);
			generateCombinations(remainingBudget, i, currentCombination, validCombinations);
			currentCombination.remove(currentCombination.size() - 1);
		}
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Budget getBudget() {
		return budget;
	}

	public void setBudget(Budget budget) {
		this.budget = budget;
	}

	public List<List<Integer>> getAnswer() {
		return answer;
	}

	public void setAnswer(List<List<Integer>> answer) {
		this.answer = answer;
	}

}
