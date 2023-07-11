
/*/TC -->o(n)
   SC--->o(n)
   Notes &&Approch -->calculating ValueToFind -->using target-nums[i] 
   and checking if the array contains that  value or not by stroing their frequencies in the map

   1] special case if the target is  4 and values are (2,2) then we have to find the value other than 2 at nums[i]
   for that condition should be 
            ---map.containsKey(valueToFind) && (valueToFind != nums[i] || map.get(valueToFind) > 1)
            value can be ==2 or !=2   
            case 1:
                !=2 then the (valueToFind != nums[i] ||  will handle
            case 2:
                ==2 then the || map.get(valueToFind) > 1) will handle 

                for finding the index of that value get the value and iterate over the map by excluding current nums[i] index
   */

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            int valueToFind = target - nums[i];
            if (map.containsKey(valueToFind) && (valueToFind != nums[i] || map.get(valueToFind) > 1)) {
                int[] result = new int[2];
                result[0] = i;
                result[1] = findIndex(nums, valueToFind, i);
                return result;
            }
        }

        return new int[0]; // No valid solution found
    }

    private int findIndex(int[] nums, int target, int excludeIndex) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target && i != excludeIndex) {
                return i;
            }
        }
        return -1;
    }
}


/*Approch 2 */


class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }

        return new int[]{}; // No solution found
    }
}