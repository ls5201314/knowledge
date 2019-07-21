package knowledge.sort.selectsort;

import java.util.Arrays;
import java.util.List;

/**
 * 直接选择排序
 * 思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止
 * n2
 */
public class DirectSelectSort {

    public static void main(String[] args) {
        Integer[] arrays = {6, 2, 5, 0, 22, 6, 8, 56};
        List<Integer> nums = Arrays.asList(arrays);
        sort(nums);
        nums.forEach(num -> System.out.println(num));
    }


    private static void sort(List<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            Integer min = nums.get(i);
            Integer minIndex = i;
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(j) < min) {
                    min = nums.get(j);
                    minIndex = j;
                }
            }
            nums.set(minIndex, nums.get(i));
            nums.set(i, min);

        }
    }
}
