package dbTestOrangeHRM;

import java.util.Arrays;

public class SecondHighest {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 5, 8, 20, 15 };
		Arrays.sort(arr);
		
		System.out.println("Second largest:"+arr[arr.length-2]);
		

	}
}
