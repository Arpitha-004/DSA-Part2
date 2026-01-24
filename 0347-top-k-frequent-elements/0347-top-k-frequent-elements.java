class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> fre = new HashMap<>();
        for(int i:nums)
            fre.put(i, fre.getOrDefault(i,0)+1);
        
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for(Map.Entry<Integer,Integer> e : fre.entrySet()){
            pq.add(e);
            if(pq.size()>k)
                pq.poll();
        }
        int[] res = new int[k];
        int i=0;
        while(!pq.isEmpty())
            res[i++] = pq.poll().getKey();
        return res;
    }
}