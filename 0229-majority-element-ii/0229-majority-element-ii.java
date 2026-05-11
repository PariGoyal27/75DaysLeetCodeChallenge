// Using Boyer-Moore Voting Algorithm
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int c1 = 0, c2 = 0;
        int e1 = 0, e2 = 0;
        for(int i = 0; i < n; i++){
            if(c1 == 0 && nums[i] != e2){
                c1 = 1;
                e1 = nums[i];
            }else if(c2 == 0 && nums[i] != e1){
                c2 = 1;
                e2 = nums[i];
            }else if(e1 == nums[i]){
                c1++;
            }else if(e2 == nums[i]){
                c2++;
            }else{
                c1--;
                c2--;
            }
        }
        // check is either e1 and e2 are valid
        int cnt1 = 0, cnt2 = 0;
        for(int num : nums){
            if(num == e1) cnt1++;
            else if(num == e2) cnt2++;
        }
        List<Integer> list = new ArrayList<>();
        if(cnt1 > n/3) list.add(e1);
        if(cnt2 > n/3) list.add(e2);
        return list;
    }
}

// using hashmap
// class Solution {
//     public List<Integer> majorityElement(int[] nums) {
//         HashMap<Integer, Integer> map = new HashMap<>();
//         List<Integer> list = new ArrayList<>();
//         int n = nums.length;
//         int mm = n/3 + 1;
//         for(int i = 0; i < n; i++){
//             map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//             if(map.get(nums[i]) == mm){
//                 list.add(nums[i]);
//             }
//              if(list.size() == 2) break;
//         }
//         return list;
//     }
// }