
// LC11_ContainerWithMostWater.java
// Source: https://leetcode.com/problems/container-with-most-water/

//You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
//  Find two lines that together with the x-axis form a container, such that the container contains the most water.
//  Return the maximum amount of water a container can store.
//  Notice that you may not slant the container.

public class LC11_ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = calculateArea( height,  left,  right);
        while (left<right){
            if(height[left]<height[right]){
                while(((height[left+1]<height[left])) && left<right ) left++;
                left++;
            } else {
                while(((height[right-1]<height[right]) )&& right>left ) right--;
                right--;
            }
            if(right>left){
                int newResult = calculateArea(height,  left,  right);
                if(newResult>result){
                    result=newResult;
                }
            }
            else return  result;
        }
        return result;
    }

    public static int calculateArea(int[] height, int left, int right){
        return Math.abs(left - right)*Math.min(height[right],height[left]);
    }
    
    public static void main(String[] args) {
        int[] height1 = {1,8,6,2,5,4,8,3,7};
        int[] height2 = {1,1};
        int res1 =maxArea(height1);
        int res2 =maxArea(height2);

        System.out.println("result1="+res1);
        System.out.println("result2=%s"+res2);
    }
}
