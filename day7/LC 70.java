class Solution {
    public int climbStairs(int n) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(0);
        arr.add(1);
        arr.add(2);
        for(int i=3;i<=n;i++){
            int k = arr.get(i-1)+arr.get(i-2);
            arr.add(k);
        }
        return arr.get(n);
    }
}