package code.dsa;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/count-elements-with-maximum-frequency/description/?envType=daily-question&envId=2024-03-08
public class MaxFrequencyElements {

    public static void main(String[] args) {
        System.out.println(maxFrequencyElements(new int[]{1,2,2,3,1,4}));
        System.out.println(maxFrequencyElements(new int[]{1,2,3,4,5}));
    }

    private static int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int n : nums) {
            if(freqMap.containsKey(n))
                freqMap.put(n, freqMap.get(n) + 1);
            else
                freqMap.put(n, 1);
        }
        int maxFreq = 0;
        int totalFreq = 0;
        for(int ele : freqMap.keySet()) {
            int freq = freqMap.get(ele);
            if(freq == maxFreq)
                totalFreq += freq;
            if(freq > maxFreq) {
                maxFreq = freq;
                totalFreq = freq;
            }
        }

        return totalFreq;
    }
}
