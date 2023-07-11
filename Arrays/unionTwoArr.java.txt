class Solution{
    public static int doUnion(int a[], int n, int b[], int m) 
    {
        if(a.length==0||b.length==0){
            return 0;
        }
        
        Set<Integer> set = new HashSet<>();
        List<Integer> union = new ArrayList<>();

        for (int num : a)
            set.add(num);

        for (int num : b)
            set.add(num);

        union.addAll(set);
        return union.size();
}
}