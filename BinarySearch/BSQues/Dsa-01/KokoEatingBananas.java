// Question Name: KokoEatingBananas (LeetCode 875)

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for(int banana : piles){
            high = Math.max(high , banana);
        }

        while (low < high) {
            int mid = low + (high - low)/2;

            if(canEatAll(piles, h, mid)){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        
        return low; // minimum speed
    }

    private boolean canEatAll(int[] piles, int h, int speed) {
        int hours = 0;
        for(int banana : piles){
            hours += (banana + speed - 1) / speed;

        }
        return hours <= h;
    }

    // Main method inside same class
    public static void main(String[] args) {
        KokoEatingBananas sol = new KokoEatingBananas();
        int[] piles = {30, 11, 23, 4, 20};
        int h = 6;
        System.out.println(sol.minEatingSpeed(piles, h)); // Output: 23
    }
}
