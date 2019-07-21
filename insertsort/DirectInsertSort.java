package knowledge.sort.insertsort;

import java.util.Arrays;
import java.util.List;

/**
 * 直接插入排序
 * 思路：从前到后依次排序（从后往前找），查询该元素排序的位置，其他数据往后移动一位
 * 复杂度：n2
 */
public class DirectInsertSort {

    public static void main(String[] args) {
        Integer[] arrays = {6, 2, 5, 0, 22, 6, 8, 56};
        List<Integer> nums = Arrays.asList(arrays);
        sort(nums);
        nums.forEach(num -> System.out.println(num));
    }



    private static void sort(List<Integer> nums) {
        for (int i = 1; i < nums.size(); i++) {
            Integer temp = nums.get(i);
            int j;
            //查找数字i的位置
            for (j = i - 1; j >= 0; j--) {
                if (nums.get(j) > temp) {
                    //其他比数字i大的数据依次往后挪一位，为i腾出空间
                    nums.set(j+1, nums.get(j));
                } else {
                    break;
                }

            }
            //找到数字i位置，插入
            nums.set(j+1, temp);
        }
    }
}
