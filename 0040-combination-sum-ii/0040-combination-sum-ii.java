class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int[] freq = new int[51];
        for (int x : candidates) {
            freq[x]++;
        }
        List<List<List<Integer>>> combs = new ArrayList<>(target+1);
        for (int t=0; t<=target; t++) {
            combs.add(new ArrayList<>());
        }
        combs.get(0).add(List.of()); 
        for (int i=1; i<=50; i++) {
            for (int t=target-i; t>=0; t--) {
                for (List<Integer> l : combs.get(t)) {
                    List<Integer> temp = new ArrayList<>(l);
                    for (int j=1; j <= freq[i] && t+i*j <= target; j++) {
                        temp.add(i);
                        combs.get(t+i*j).add(new ArrayList<>(temp));
                    }
                }
            }
        }
        return combs.get(target);
    }
}