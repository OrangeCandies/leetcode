package anything.leetcode.mid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Problem34 {

    class RandomizedSet {

        private HashMap<Integer,Integer> set = new HashMap<>();
        private ArrayList<Integer> list = new ArrayList<>();
        private int size = 0;
        private Random random = new Random();
        /** Initialize your data structure here. */
        public RandomizedSet() {

        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(set.containsKey(val)) {
                return false;
            }else{
                set.put(val,size);
                if(size == list.size())
                    list.add(val);
                else
                    list.set(size,val);
                size++;
            }
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(set.containsKey(val)){
                Integer index = set.get(val);
                Integer last = list.get(size - 1);
                list.set(index,last);
                set.put(last,index);
                set.remove(val);
                size--;
                return true;
            }else{
                return false;
            }
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int index = random.nextInt(size);
            return list.get(index);
        }
    }


    public static void main(String[] args) {
        RandomizedSet randomizedSet = new Problem34().new RandomizedSet();
        randomizedSet.insert(0);
        randomizedSet.insert(1);
        randomizedSet.remove(0);
        randomizedSet.insert(2);
        randomizedSet.remove(1);
        int random = randomizedSet.getRandom();
        System.out.println(random);
    }
}
