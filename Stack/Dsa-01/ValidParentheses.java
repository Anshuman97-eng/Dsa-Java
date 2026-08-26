import java.util.Stack;

public class ValidParentheses {

    // Function to check valid parentheses
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        // 👉 your logic goes here
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }else{
                if(stack.isEmpty()) return false;
                char c = stack.pop();
                if((ch == ')' && c != '(') || (ch == '}' && c != '{') || (ch == ']' && c != '[')){
                    return false;
                }
            }
        }
        // Use stack.push(), stack.pop(), stack.peek(), stack.isEmpty()

        return stack.isEmpty(); // change this after coding
    }

    // Driver code
    public static void main(String[] args) {
        String s1 = "({[]})";
        String s2 = "([)]";

        System.out.println(isValid(s1)); // expected true
        System.out.println(isValid(s2)); // expected false
    }
}
