package two_pointers;
// two_pointers.LC11_ContainerWithMostWater.java
// Source: https://leetcode.com/problems/container-with-most-water/

//You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
//  Find two lines that together with the x-axis form a container, such that the container contains the most water.
//  Return the maximum amount of water a container can store.
//  Notice that you may not slant the container.

public class LC11_ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxVolume = 0;
        while(left<right){
            int minHeight = Math.min(height[left], height[right]);
            maxVolume = Math.max(maxVolume, minHeight*(right-left));
            if(height[left] < height[right]){
                int currentLeftHeight = height[left];
                while (left<right && height[left]<=currentLeftHeight) left++;
            }
            else{
                int currentRightHeight = height[right];
                while (left<right && height[right]<=currentRightHeight) right--;
            }
        }
        return maxVolume;
    }


    
    public static void main(String[] args) {
        int[] height1 = {1,8,6,2,5,4,8,3,7};
        int[] height2 = {1,1};
        int res1 =maxArea(height1);
        int res2 =maxArea(height2);

        System.out.println("result1="+res1);
        System.out.println("result2="+res2);
    }
}
