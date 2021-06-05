class combinationalSum
{
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Set<Integer> hs = new HashSet<Integer>(A);
        hs.addAll(A);
        A = new ArrayList<Integer>(hs);
        Collections.sort(A);
        find(0, A, B, ans, new ArrayList<>());
        return ans;
    }
    
    static void find(int idx, ArrayList<Integer> nos, int target, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> des)
    {
        if(idx == nos.size())
        {
            if(target == 0)
            {
                ans.add(new ArrayList<>(des));
            }
            return;
        }
        
        if(nos.get(idx)<=target)
        {
            des.add(nos.get(idx));
            find(idx, nos, target - nos.get(idx), ans, des);
            des.remove(des.size()-1);
        }
        
        find(idx+1, nos, target, ans, des);
    }
}