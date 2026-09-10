import java.util.*;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        // your code here
        List<String> result = new ArrayList<>();    
        backtrack(result, new StringBuilder(""), 0, 0, n);
        return result;
    }

    public boolean isValid(StringBuilder s){

        int count = 0;
        for(char ch : s.toString().toCharArray()){
            if(ch == '('){
                count++;
                if(count < 0){
                    return false;
                }
            }else{
                count--;
            }
        }

        return true;
    }

    private void backtrack(List<String> result, StringBuilder curr, int open, int close, int n) {
        // your recursion code here

        if(curr.length() == n*2){
            if(isValid(curr)){
                result.add(curr.toString());
            }

            return;
        }


        if(open < n){
            curr.append("(");
            backtrack(result, curr, open + 1, close, n);
            curr.deleteCharAt(curr.length() - 1);
        }

        if(close < open){
            curr.append(")");
            backtrack(result, curr, open, close + 1, n);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        List<String> ans = gp.generateParenthesis(3);
        System.out.println(ans);
    }
}
