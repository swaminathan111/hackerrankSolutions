package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Find First and Last Position of Element in Sorted Array
 * 
 * @author 91944
 *
 */
class SortedArray {
	public static int[] searchRange(int[] nums, int target) {

		int low = 0;
		int high = nums.length - 1;
		List<Integer> res = new ArrayList<Integer>();
		List<Integer> notfound = new ArrayList<Integer>();
		if (nums.length > 0) {
			while (low <= high) {
				int mid = (low + high) / 2;

				if (nums[mid] == target) {

					while (low < mid && high > mid) {

						if (nums[low] == target) {
							res.add(low);
						} else if (nums[high] == target) {
							res.add(high);
						}
						low = low + 1;
						high = high - 1;
					}
					res.add(mid);
					if (res.size() == 0) {
						notfound.add(-1);
						notfound.add(-1);
					}
					if(low==high && low==mid && nums.length==1) {
						res.add(mid);
					}
					return res.stream().mapToInt(i -> i).toArray();
				} else if (nums[mid] > target) {
//					notfound.add(-1);
					high = mid - 1;
				} else {
					low = mid + 1;
//					notfound.add(-1);
				}
			}
			if (res.size() == 0) {
				notfound.add(-1);
				notfound.add(-1);
				return notfound.stream().mapToInt(i -> i).toArray();
			}

		} else {
			notfound.add(-1);
			notfound.add(-1);
		}
		return notfound.stream().mapToInt(i -> i).toArray();

	}

	public static void main(String[] args) {

//		int[] nums = new int[] {0};

//		int[] nums = new int[] {2,3,7,7,8,8};
//		int target = 8;
		
		int[] nums = new int[] {1};
		int target = 1;
		
		int[] finalResult = searchRange(nums, target);
		System.out.println("Final Result->" + Arrays.toString(finalResult));
	}
}
