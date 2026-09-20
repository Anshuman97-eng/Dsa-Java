import java.util.*;

class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        // 👉 You will implement:
        Map<String ,Integer> map = new HashMap<>();

        for(String name : words){
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        List<String> wordList = new ArrayList<>(map.keySet());

        Collections.sort(wordList, (a, b) -> {
                int sum = map.get(b) - map.get(a);

                if(sum == 0){
                    return a.compareTo(b);
                }
                return sum;
            } 
        );

        return wordList.subList(0, k);
    }

    public static void main(String[] args) {
        TopKFrequentWords sol = new TopKFrequentWords();

        String[] words = {"i","love","leetcode","i","love","coding"};
        int k = 2;

        List<String> result = sol.topKFrequent(words, k);
        System.out.println("Top " + k + " frequent words: " + result);
    }
}
