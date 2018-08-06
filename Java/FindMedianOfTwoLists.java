import java.util.Scanner;

/**
 * ClassName FindMedianOfTwoLists
 * Author  Lin
 * Date 2018/8/3 22:22
 **/

public class FindMedianOfTwoLists {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return findMedianSortedArraysRec(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1);
    }

    public double findMedianSortedArraysRec(int[] nums1, int lh1, int rh1, int[] nums2, int lh2, int rh2) {
        int length1 = rh1 - lh1 + 1;
        int length2 = rh2 - lh2 + 1;

        // make sure the first array length is not longer than the second
        if (length1 > length2)
            return findMedianSortedArraysRec(nums2, lh2, rh2, nums1, lh1, rh1);

        // midIndex of both array
        int mid1 = lh1 + (rh1 - lh1) / 2;
        int mid2 = lh2 + (rh2 - lh2) / 2;
        // left and right half number of both array
        int lhalf1 = mid1 - lh1 + 1;
        int rhalf1 = rh1 - mid1;
        int lhalf2 = mid2 - lh2 + 1;
        int rhalf2 = rh2 - mid2;

        // base case 1
        if (length1 <= 0) {
            if (length2 <= 0)
                return 0.0;
            return (nums2[mid2] + nums2[lh2 + (rh2 - lh2 + 1) / 2]) / 2.0;
        }

        // base case 2
        if (length1 == 1) {
            if (length2 == 1)
                return (nums1[lh1] + nums2[lh2]) / 2.0;

            // compare nums1[lh1] with nums2[mid2] and nums2[mid2 + 1]
            if (nums1[lh1] < nums2[mid2]) {
                if (length2 % 2 == 0 || nums1[lh1] < nums2[mid2 - 1])
                    return findMedianSortedArraysRec(nums1, lh1 + 1, rh1, nums2, lh2, rh2 - 1);
                return (nums1[lh1] + nums2[mid2]) / 2.0;
            } else if (nums1[lh1] > nums2[mid2 + 1])
                return findMedianSortedArraysRec(nums1, lh1, rh1 - 1, nums2, lh2 + 1, rh2);
            else {
                int diff = Math.min(lhalf2, rhalf2);
                return findMedianSortedArraysRec(nums1, lh1, rh1, nums2, lh2 + diff, rh2 - diff);
            }
        }

        boolean bothOdd = length1 % 2 == 1 && length2 % 2 == 1;

        // split both array into half and throw away the same length on the left and right
        // be careful if both array is odd length
        if (nums1[mid1] < nums2[mid2]) {
            if (nums1[mid1 + 1] > nums2[mid2 + 1]) {
                int diff = Math.min(lhalf1, rhalf1);
                return findMedianSortedArraysRec(nums1, lh1 + diff, rh1 - diff, nums2, lh2, rh2);
            } else {
                int diff = Math.min(lhalf1, rhalf2);
                if (bothOdd && nums1[mid1] > nums2[mid2 - 1])
                    return (nums1[mid1] + Math.min(nums1[mid1 + 1], nums2[mid2])) / 2.0;
                return findMedianSortedArraysRec(nums1, lh1 + diff, rh1, nums2, lh2, rh2 - diff);
            }
        } else {
            if (nums1[mid1 + 1] < nums2[mid2 + 1]) {
                int diff = Math.min(lhalf2, rhalf2);
                return findMedianSortedArraysRec(nums1, lh1, rh1, nums2, lh2 + diff, rh2 - diff);
            } else {
                int diff = Math.min(lhalf2, rhalf1);
                if (bothOdd && nums2[mid2] > nums1[mid1 - 1])
                    return (nums2[mid2] + Math.min(nums2[mid2 + 1], nums1[mid1])) / 2.0;
                return findMedianSortedArraysRec(nums1, lh1, rh1 - diff, nums2, lh2 + diff, rh2);
            }
        }
    }

    public static void main(String[] args) {
/*
        int a = 0;
        if (a == 0)
        {System.out.println("if");}
        else{
        a-=1;
        System.out.println(a);}
*/
/*      int a = new Scanner(System.in).nextInt();
       assert (a==1);*/
    }


}
