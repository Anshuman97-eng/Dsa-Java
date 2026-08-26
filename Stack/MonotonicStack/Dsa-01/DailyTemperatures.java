import java.util.*;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temps) {
        int n = temps.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>(); // 👉 store indexes

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temps[i] > temps[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex; // days difference
            }
            stack.push(i); // push current index
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] temps = { 73, 74, 75, 71, 69, 72, 76, 73 };
        int[] result = dailyTemperatures(temps);
        System.out.println(Arrays.toString(result));
    }
}
