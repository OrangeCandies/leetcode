package anything.leetcode.easy;

import java.util.Random;

public class Problem37 {

    class Solution {
        private int[] nums;
        private int[] getRandom;
        private int sz;

        public Solution(int[] nums) {
            this.nums = nums;
            sz = nums.length;
            getRandom = new int[sz];
            for(int i =0; i < sz; i++){
                getRandom[i] = nums[i];
            }
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            for(int i = 0; i < sz;i ++){
                getRandom[i] = nums[i];
            }
            return getRandom;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            getRandoms();
            return getRandom;
        }

        private void getRandoms() {

            Random random = new Random();
            for (int i = sz - 1; i >= 0; i--) {
                int x = random.nextInt(i+1) ;
                if (x != i) {
                    getRandom[i] ^= getRandom[x];
                    getRandom[x] ^= getRandom[i];
                    getRandom[i] ^= getRandom[x];
                }
            }
        }
    }


}
