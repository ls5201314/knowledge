package knowledge.sort.insertsort;

import java.util.Arrays;
import java.util.List;

/**
 * 二分法插入排序
 * 思路：二分法插入排序的思想和直接插入一样，只是找合适的插入位置的方式不同，这里是按二分法找到合适的位置，可以减少比较的次数
 * 复杂度：nLog n
 */
public class BinaryInsertSort {

    public static void main(String[] args) {
        Integer[] arrays = {6, 2, 5, 0, 22, 6, 8, 56};
        List<Integer> nums = Arrays.asList(arrays);
        sort(nums);
        nums.forEach(num -> System.out.println(num));
    }

    private static void sort(List<Integer> nums) {

        for (int i = 0; i < nums.size(); i++) {
            int left = 0;
            int right = i - 1;
            int mid = 0;
            int temp = nums.get(i);

            while(left <= right) {
                mid = (left + right) / 2;
                if (nums.get(mid) > temp) {
                    right = mid - i;
                } else {
                    left = mid + 1;
                }
            }

            //left~i-1的数据依次往后移动一位
            for (int j = i - 1; j >= left; j--) {
                nums.set(j+1, nums.get(j));
            }
            //left即为数字i的位置
            nums.set(left, temp);
        }
    }
}
