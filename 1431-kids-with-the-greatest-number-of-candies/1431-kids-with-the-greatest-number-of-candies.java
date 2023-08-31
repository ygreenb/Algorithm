class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> result = new ArrayList<>(candies.length);

        int max = 0;
        for(int candy: candies){
            max = Math.max(max, candy);
        }

        max -= extraCandies;
        for(int candy: candies){
            result.add(candy>=max);
        }

        return result;
    }
}