package code;

import java.util.BitSet;

public class SimpleBloomFilter {

    private static final int DEFAULT_SIZE = 2 << 24;
    private static final int[] seeds = new int[]{7, 11, 13, 31, 37, 61};
    private BitSet bitSet = new BitSet(DEFAULT_SIZE);
    private SimpleHash[] funcs = new SimpleHash[seeds.length];

    public SimpleBloomFilter() {
        for(int i = 0; i < seeds.length; i++) {
            funcs[i] = new SimpleHash(DEFAULT_SIZE, seeds[i]);
        }
    }

    public void add(String value) {
        if(value == null)
            return;

        for(SimpleHash f : funcs) {
            bitSet.set(f.hash(value), true);
        }
    }

    public boolean contains(String value) {
        if(value == null)
            return false;

        boolean res = false;
        for(SimpleHash f : funcs) {
            res = bitSet.get(f.hash(value)) && res;
            if(!res)
                return false;
        }
        return true;

    }


    static class SimpleHash {
        private int cap;
        private int seed;

        public SimpleHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }

        public int hash(String value) {
            int result = 0;
            for(int i = 0; i < value.length(); i++) {
                result = result * seed + value.charAt(i);
            }
            return (cap - 1) & result;
        }
    }
}
