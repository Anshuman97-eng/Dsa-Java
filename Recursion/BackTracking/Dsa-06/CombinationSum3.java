import java.util.*;

class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        solve(k, n, 1, result, new ArrayList<Integer>()); // start from 1
        return result;
    }

    public void solve(int k, int n, int idx, List<List<Integer>> result, List<Integer> curr) {
        if (n == 0 && curr.size() == k) {
            result.add(new ArrayList<>(curr));
            return;
        }

        if (curr.size() > k || n < 0) return;

        for (int i = idx; i <= 9; i++) {
            curr.add(i);
            solve(k, n - i, i + 1, result, curr); // use i+1
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum3 obj = new CombinationSum3();

        int k = 3;
        int n = 9;

        List<List<Integer>> result = obj.combinationSum3(k, n);
        System.out.println("Combinations = " + result);
    }
}
