package _17_SearchingAndSorting;

import java.util.Arrays;

public class SearchingSorting {

    public static void main(String[] args) {
        int [] arr = {3,7,21,89,2,4};
        int [] sortedArr = {3,7,21,89,2,4};
        Arrays.sort(sortedArr);

        
        int linear = linearSearch(arr, 3);

        int l = 0;
        int r = sortedArr.length-1;
        int binary = binarySearch(sortedArr,l,r ,3);
        System.out.println(
            "original arr: "+ Arrays.toString(arr)+"\n" +
            "Linear Search: "+linear + "\n" +
            "Sorted arr: "+ Arrays.toString(sortedArr)+ "\n" +
            "Binary Search: "+binary 


        );
        
        // int [] arr = 
        
        
    }
    public static int linearSearch(int [] arr, int x){
        int ans = -1;
        for(int i = 0; i<arr.length; i++){
            if(arr[i]==x){
                ans = i;
                return ans;
            }
        }

        return ans; 

    }
    public static int binarySearch(int [] arr, int l, int r,int x){
        
        //recursive algo
        
        if(r>=l){
            int mid = (l+r)/2;
            if(arr[mid]==x){
                return mid;
            }
            else if(arr[mid]>x){
                return binarySearch(arr, l, mid-1, x);
            }
            else return binarySearch(arr, mid+1, r, x);
        }
        return -1;
       
    
    }
    public static int []  bubbleSort(){
        int [] ans = {};
        return ans;//check ans value 
    
    }
    public static int [] insertionSort(){
        int [] ans = {};
        return ans;//check ans value 
    
    }
    public static int [] selectionSort(){
        int [] ans = {};
        return ans;//check ans value 
    }
    public static int [] mergeSort(){
        int [] ans = {};
        return ans;//check ans value 
    
    }
    public static int [] quickSort(){
        int [] ans = {};
        return ans;//check ans value 
    
    }
    
}


