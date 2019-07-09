package p1;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<Integer, Integer>(); 
        for(int i= 0; i<nums.length; i++){
            if(map.containsKey(target-nums[i]))
                return new int[]{i, map.get(target-nums[i])};
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
    public static void main(String[] args) {
        TwoSum ts = new TwoSum();

        int []indices = ts.twoSum(new int[]{2, 7, 11, 15}, 9);
        for(int idx : indices)
            System.out.print(idx + " ");

    }
}

// keyword { "fontStyle": "bold" }
// storage { "foreground": "#1857AB" }
// storage.type { "foreground": "#1857AB" }
// variable.other { "foreground": "#E7F6DA" }
// entity.name.function { "fontStyle": "", "foreground": "#E7F6DA" }