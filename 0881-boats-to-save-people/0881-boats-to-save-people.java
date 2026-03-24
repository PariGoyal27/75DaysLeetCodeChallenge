class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        Arrays.sort(people);
        int boats = 0;
        int i = 0, j = n-1;
        while(i <= j){
            int sum = people[i] + people[j];
            if(sum <= limit){
                i++; j--;
            }else{
                j--;
            }
            boats++;
        } 
        return boats;
    }
}