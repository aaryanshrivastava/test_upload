package test;

import java.util.HashMap;
import java.util.Map;

public class t_9add1_tupleSum {
	public static int[] tupleSum(int[] nums, int targetSum) {
		Map<Integer, Integer> numToIndex = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			numToIndex.put(nums[i], i);
		}

		for (int i = 0; i < nums.length; i++) {
			int complement = targetSum - nums[i];
			if (numToIndex.containsKey(complement) && numToIndex.get(complement) != i) {
				return new int[] { i, numToIndex.get(complement) };
			}
		}

		return null;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 1, 5, 7, 5, 9 };
		int targetSum = 10;

		int[] indices = tupleSum(nums, targetSum);
		if (indices == null) {
			System.out.println("No two numbers in the list add up to the targetSum sum.");
		} else {
			System.out.println("The two numbers whose sum is equal to the targetSum sum are at indices " + indices[0]
					+ " and " + indices[1]);
		}
	}
}
