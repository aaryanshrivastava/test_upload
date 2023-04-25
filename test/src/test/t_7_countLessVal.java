package test;

public class t_7_countLessVal {

	public static int countLessVal(int[] sortedArray, int lessThan) { // O(n)
		int count = 0;
		if (sortedArray == null) {
			return 0;
		}
		for (int i = 0; i < sortedArray.length; i++) {
			if (sortedArray[i] < lessThan) {
				count++;
			} else {
				break;
			}
		}
		return count;
	}

	public static int countLessVal2(int[] sortedArray, int lessThan) { // O(Log(n))
		int start = 0;
		int end = sortedArray.length - 1;
		int mid = 0;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (sortedArray[mid] < lessThan) {
				if (mid < sortedArray.length - 1 && sortedArray[mid + 1] < lessThan) {
					start = mid + 1;
					continue;
				} else {
					return mid + 1;
				}
			}

			if (sortedArray[mid] >= lessThan) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int val = countLessVal(arr, 7);
		int val2 = countLessVal2(arr, 5);
		System.out.println(val);
		System.out.println(val2);
	}
}
