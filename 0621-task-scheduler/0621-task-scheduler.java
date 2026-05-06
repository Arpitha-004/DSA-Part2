class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for(char c : tasks){
            arr[c-'A']++;
        }
        Arrays.sort(arr);
        int max_val = arr[25] - 1; //at the end we don't need idle
        int idle = max_val * n;
        for(int i=24;i>=0;i--){
            idle -= Math.min(arr[i],max_val);
        }
        return idle > 0 ? idle + tasks.length : tasks.length;
    }
}