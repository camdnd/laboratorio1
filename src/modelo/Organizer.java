package modelo;

import java.lang.*;
import java.util.AbstractCollection.*;
import java.util.AbstractList.*;
import java.util.ArrayList;
import java.util.ArrayList.*;

public class Organizer  {

	public Organizer()
	{
		
	}

	public int[] combSortForIntegers(int[] numbers) {
		   
	    int gap = numbers.length;
	    boolean swapped = true;
	    while (gap > 1 || swapped) {
	        if (gap > 1) {
	            gap = (int) (gap / 1.3);
	        }
	        swapped = false;
	        for (int i = 0; i + gap < numbers.length; i++) {
	            if (numbers[i] > (numbers[i + gap]) ) {
	                int t = numbers[i];
	                numbers[i] = numbers[i + gap];
	                numbers[i + gap] = t;
	                swapped = true;
	            }
	        }
	    }
	    
	    return numbers;
	}
	
	
	public double[] combSortForRealNumbers(double[] numbers) {
			   
	    int gap = numbers.length;
	    boolean swapped = true;
	    while (gap > 1 || swapped) {
	        if (gap > 1) {
	            gap = (int) (gap / 1.3);
	        }
	        swapped = false;
	        for (int i = 0; i + gap < numbers.length; i++) {
	            if (numbers[i] > (numbers[i + gap]) ) {
	                double t = numbers[i];
	                numbers[i] = numbers[i + gap];
	                numbers[i + gap] = t;
	                swapped = true;
	            }
	        }
	    }  
	    
	    return numbers;
	}
	    
	    
	 public int[] shellSortInteger(int arr[]){
	        int n = arr.length;
	        
	        for (int gap = n/2; gap > 0; gap /= 2){
	            
	        	for (int i = gap; i < n; i += 1){ 
	                int temp = arr[i];
	 
	                int j;
	                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
	                    arr[j] = arr[j - gap];
	
	                arr[j] = temp;
	            }
	        }
	        
	        return arr;
	 }
	    
	 public double[] shellSortRealnumbers(double arr[]){
	        int n = arr.length;
	        
	        for (int gap = n/2; gap > 0; gap /= 2){
	            
	        	for (int i = gap; i < n; i += 1){ 
	                double temp = arr[i];
	 
	                int j;
	                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
	                    arr[j] = arr[j - gap];
	
	                arr[j] = temp;
	            }
	        }
	        return arr;
	 }
	    
	 public int[] gnomeSortInteger(int[] a)
	 {
	   int i=1;
	   int j=2;
	  
	   while(i < a.length) {
	     if ( a[i-1] <= a[i] ) {
	       i = j; j++;
	     } else {
	       int tmp = a[i-1];
	       a[i-1] = a[i];
	       a[i--] = tmp;
	       i = (i==0) ? j++ : i;
	     }
	   }
	   return a;
	 }
	 
	    
	 public double[] gnomeSortRealNumbers(double[] a)
	 {
	   int i=1;
	   int j=2;
	  
	   while(i < a.length) {
	     if ( a[i-1] <= a[i] ) {
	       i = j; j++;
	     } else {
	       double tmp = a[i-1];
	       a[i-1] = a[i];
	       a[i--] = tmp;
	       i = (i==0) ? j++ : i;
	     }
	   }
	   
	   return a;
	 }
	 

	
}
	
	
	

