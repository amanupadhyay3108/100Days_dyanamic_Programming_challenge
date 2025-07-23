import java.util.*;

public class shoppingOffers {
    public static void main(String[] args) {
        List<Integer> price = Arrays.asList(2, 5);
        List<List<Integer>> special = Arrays.asList(
            Arrays.asList(3, 0, 5), // Buy 3 of item 0 and get 5 off
            Arrays.asList(1, 2, 10) // Buy 1 of item 0 and 2 of item 1 for 10
        );
        List<Integer> needs = Arrays.asList(3, 2); // Need 3 of item 0 and 2 of item 1

        System.out.println(shoppingOffers(price, special, needs)); // Output the minimum cost
    }

     public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<List<Integer>, Integer> memo = new HashMap<>();
        return dfs(price, special, needs, memo);
    }

    public static int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> memo) {
        if (memo.containsKey(needs)) return memo.get(needs);

        int n = price.size();
        int minCost = 0;
        for (int i = 0; i < n; i++) {
            minCost += price.get(i) * needs.get(i);
        }
        for (List<Integer> offer : special) {
            List<Integer> newNeeds = new ArrayList<>();
            boolean valid = true;

            for (int i = 0; i < n; i++) {
                if (offer.get(i) > needs.get(i)) {
                    valid = false; // Can't apply this offer
                    break;
                }
                newNeeds.add(needs.get(i) - offer.get(i));
            }

            if (valid) {
                int offerCost = offer.get(n) + dfs(price, special, newNeeds, memo);
                minCost = Math.min(minCost, offerCost);
            }
        }

        memo.put(needs, minCost);
        return minCost;
    }

}
