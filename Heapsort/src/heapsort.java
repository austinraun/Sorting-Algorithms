/**
 * Course: EECS 114 Fall 2015
 *
 * First Name: Austin
 * Last Name: Raun
 * Lab Section: 3A
 * email address: araun@uci.edu
 *
 *
 * Assignment: lab5
 * Filename : heapsort.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */

package lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class heapsort {
	private static int N;
    public static void Heapsort(int arr[]){       
        BuildMaxHeap(arr);        
        for (int i = N; i > 1; i--){
            swap(arr,1, i);
            N = N-1;
            MaxHeapify(arr, 1); 
            for (int k = 1; k < arr.length; k++){
                System.out.print(arr[k]+" ");    
            }
            System.out.println();
        }
    }       
    public static void BuildMaxHeap(int arr[]){
        N = arr.length-1;
        for (int i = (N)/2; i >= 1; i--){
            MaxHeapify(arr, i);        
        }
    }       
    public static void MaxHeapify(int arr[], int i){ 
        int left = 2*i;
        int right = 2*i + 1;
        int max = i;
        if (left <= N && arr[left] > arr[i]){
            max = left;
        }
        if (right <= N && arr[right] > arr[max]){      
            max = right;
        }
        if (max != i){
            swap(arr, i, max);
            MaxHeapify(arr, max);
        }
        
    }    

    public static void swap(int arr[], int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp; 
    }    

    public static void main(String[] args) throws FileNotFoundException {
    	System.out.println("input1.txt:");
    	
    	String filename = args[0];
    	try{
	        Scanner scan = new Scanner(new File(filename));        
	        int n, i;    
	        n = scan.nextInt();    
	        int arr[] = new int[ n + 1 ];
	        arr[0] = n;
	        for (i = 1; i <= n; i++){
	            arr[i] = scan.nextInt();
	        	System.out.print(arr[i]+ " ");
	        }
	        System.out.println();
	        Heapsort(arr);
	        scan.close();
	    }
    	catch(FileNotFoundException e){
	      			e.printStackTrace();
	    }
    }    
}