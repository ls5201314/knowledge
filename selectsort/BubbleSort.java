package knowledge.sort.selectsort;

import java.util.Arrays;
import java.util.List;

/**
 * 冒泡排序
 * 思想：在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒。即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换
 * n2
 */
public class BubbleSort {

    public static void main(String[] args) {
        Integer[] arrays = {6, 2, 5, 0, 22, 6, 8, 56};
        List<Integer> nums = Arrays.asList(arrays);
        sort(nums);
        nums.forEach(num -> System.out.println(num));
    }


    private static void sort(List<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size() - i - 1; j++) {
                if (nums.get(j) > nums.get(j + 1)) {
                    Integer temp = nums.get(j);
                    nums.set(j, nums.get(j + 1));
                    nums.set(j + 1, temp);
                }
            }
        }
    }
}
