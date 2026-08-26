public class MinimumAddParentheses {

    // Function to calculate minimum add
    public static int minAddToMakeValid(String s) {
        // 👉 your logic goes here
        int open = 0; // count of unmatched '('
        int add = 0;  // count of insertions needed

        // loop through string
        for (char ch : s.toCharArray()) {
            // 👉 fill in logic
            if(ch == '('){
                open++;
            }else{
                if(open >0){
                    open--;
                }else{
                    add++;
                }
            }
        }

        return open + add; // final answer
    }

    // Driver code
    public static void main(String[] args) {
        String s1 = "())";
        String s2 = "(((";

        System.out.println(minAddToMakeValid(s1)); // expected 1
        System.out.println(minAddToMakeValid(s2)); // expected 3
    }
}
