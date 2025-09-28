class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int steps=0, rem=capacity;
        for(int i=0;i<plants.length;i++){
            if(rem >= plants[i]){
                steps++;
                rem -= plants[i];
            }else{
                int extra = i*2;
                steps += extra + 1;
                rem = capacity - plants[i];
            }
        }
        return steps;
    }
}