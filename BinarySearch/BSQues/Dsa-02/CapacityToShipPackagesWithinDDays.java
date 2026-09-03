// Question Name: CapacityToShipPackagesWithinDDays (LeetCode 1011)

public class CapacityToShipPackagesWithinDDays {
    public boolean weightRequire(int[] weights, int capacity, int days) {
       int usedDays = 1;
       int MaxCapacity = 0;

       for(int weight : weights){
            if(MaxCapacity + weight > capacity){
                usedDays++;
                MaxCapacity = 0;
            }
            MaxCapacity += weight;
       }

        return usedDays <= days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;
        
        for(int weight : weights){
            low = Math.max(low, weight);
            high = high + weight;
        }

        while(low < high){
            int mid = low + (high - low)/2;
            if(weightRequire(weights,mid,days)){
                high = mid;
            }else{
                low = mid + 1;
            }
        }

        return low; // minimum capacity
    }

    // Main method inside same class
    public static void main(String[] args) {
        CapacityToShipPackagesWithinDDays sol = new CapacityToShipPackagesWithinDDays();
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(sol.shipWithinDays(weights, days)); // Output: 15
    }
}
