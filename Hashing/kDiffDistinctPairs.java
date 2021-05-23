class kDiffDistinctPairs
{
    public int TotalPairs(int[] nums, int k)
    {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        
        for(int i:nums)
        {
            hm.put(i, hm.getOrDefault(i, 0)+1);
        }  
        int pairs = 0;
    
        for(Map.Entry<Integer, Integer> curr: hm.entrySet())
        {
            if(hm.containsKey(curr.getKey()+k))
            pairs = pairs + (k==0 && curr.getValue()==1?0:1);
        }
        
        return pairs;
        
    }
}