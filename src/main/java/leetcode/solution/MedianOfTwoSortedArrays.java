package leetcode.solution;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhihao.mao
 */
public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        int rightIndex = ((nums1Length + nums2Length) / 2);
        int leftIndex = rightIndex;
        if ((nums1Length + nums2Length) % 2 == 0) {
            leftIndex--;
        }
        int nums1Index = 0;
        int nums2Index = 0;
        double leftValue = 0;
        double rightValue = 0;
        for (int i = 0; i <= rightIndex; i++) {
            int nums1Value;
            int nums2Value;
            int currentValue;
            if (nums1Index >= nums1Length) {
                if (nums2Index >= nums2Length) {
                    break;
                }
                currentValue = nums2[nums2Index];
                nums2Index++;
                if (i == leftIndex) {
                    leftValue = currentValue;
                }
                if (i == rightIndex) {
                    rightValue = currentValue;
                }
                continue;
            }
            if (nums2Index >= nums2Length) {
                currentValue = nums1[nums1Index];
                nums1Index++;
                if (i == leftIndex) {
                    leftValue = currentValue;
                }
                if (i == rightIndex) {
                    rightValue = currentValue;
                }
                continue;
            }
            nums1Value = nums1[nums1Index];
            nums2Value = nums2[nums2Index];
            if (nums2Value >= nums1Value) {
                nums1Index++;
                currentValue = nums1Value;
                if (i == leftIndex) {
                    leftValue = currentValue;
                }
                if (i == rightIndex) {
                    rightValue = currentValue;
                }
            } else {
                nums2Index++;
                currentValue = nums2Value;
                if (i == leftIndex) {
                    leftValue = currentValue;
                }
                if (i == rightIndex) {
                    rightValue = currentValue;
                }
            }
        }

        return (leftValue + rightValue) / 2.0;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

}
