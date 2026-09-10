import java.util.*;

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        // your code here
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0) return result;

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(result, new StringBuilder(""),map, digits, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder curr,Map<Character,String> map, String digits, int index) {
        // your recursion code here
        if(index == digits.length()){
            result.add(curr.toString());
            return ;
        }

        String ans = map.get(digits.charAt(index));

        for(int i=0; i<ans.length() ; i++){
            curr.append(ans.charAt(i));
            backtrack(result, curr, map, digits, index+1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations lc = new LetterCombinations();
        List<String> ans = lc.letterCombinations("23");
        System.out.println(ans);
    }
}
