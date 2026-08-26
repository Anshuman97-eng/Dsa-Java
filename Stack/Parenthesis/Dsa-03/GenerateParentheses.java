import java.util.*;

public class GenerateParentheses {

    // Function to generate all valid parentheses
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    // Backtracking helper
    private static void backtrack(List<String> result, String current, int open, int close, int n) {
        // Base case: when we used all pairs
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        // Add '(' if we still can
        if (open < n) {
            backtrack(result, current + "(", open + 1, close, n);
        }

        // Add ')' if valid (only if close < open)
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, n);
        }
    }

    // Driver code
    public static void main(String[] args) {
        int n = 3;
        List<String> ans = generateParenthesis(n);
        System.out.println(ans); 
        // Expected: ["((()))","(()())","(())()","()(())","()()()"]
    }
}
