package knowledge.sort.insertsort;

import java.util.Arrays;
import java.util.List;

/**
 * 希尔排序
 * 思路：先取一个小于n的整数d1作为第一个增量，把文件的全部记录分成d1个组。所有距离为d1的倍数的记录放在同一个组中。先在各组内进行直接插入排序；然后，取第二个增量d2
 * 复杂度：nLog2n
 */
public class ShellSort {

    public static void main(String[] args) {
        Integer[] arrays = {6, 2, 5, 0, 22, 6, 8, 56};
        List<Integer> nums = Arrays.asList(arrays);
        sort(nums);
        nums.forEach(num -> System.out.println(num));
    }


    private static void sort(List<Integer> nums) {
        int d = nums.size();
        while (true) {
            d = d / 2;
            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < nums.size(); i = i + d) {
                    int temp = nums.get(i);
                    int j;
                    for (j = i - d; j >= 0 && nums.get(j) > temp; j = j - d) {
                        nums.set(j + d, nums.get(j));
                    }
                    nums.set(j + d, temp);
                }
            }
            if (d == 1) {
                break;
            }
        }
    }
}
