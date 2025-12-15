class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for(int i : stones){
            maxHeap.add(-i);
        }
        while(maxHeap.size()>1){
            int y = -maxHeap.remove();
            int x = -maxHeap.remove();
            if(x != y){
               maxHeap.add(-(y-x));
            }
        }
        return maxHeap.isEmpty() ? 0 : -maxHeap.remove();
    }
}