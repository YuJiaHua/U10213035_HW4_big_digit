//U10213035虞家樺
import java.util.Scanner;

class Big_Digit 
{		
	private int[] ary; //Declare an integer array
	
	public int[] BigDigit(String s)
	{		
		// Processing the digital part
		String v = s.charAt(0) == '-' ? s.substring(1) : s;
		ary = new int[v.length()]; //array's length is StringS's length
		for (int i = 0; i < v.length(); i++) { //Use the loops to read each character
			String s2 = v.substring(i, i+1); //Use substring () to catch each character
			ary[i] = Integer.parseInt(s2); //Characters into an integer, stored in an array
		} 		
		return ary;
	}		
	
	//Addition
	public static void Add(int[] a, int[] b) { 
		
		// Align digit
		int length = Math.max(a.length,b.length);
		int[] op1 = copyOf(a, length);
		int[] op2 = copyOf(b, length);
		int[] result = new int[length];	
	    
		//Processing the digital carry
		int carry = 0;
		for(int i = length - 1; i >= 0; i--){
			int c = op1[i]+op2[i]+carry;	
			if(c < 10) {
				carry = 0;
			}else {
				c -= 10;
				carry = 1;
			}
			result[i] = c;
		}
		

		//Overflow processing
	    if(carry == 1){
	    	int[] newresult = newAddLength(result);
	    	for (int i : newresult) { // Print array contents 
				System.out.print(i); 
			} 
	    }else{		
	    	for (int i : result) { // Print array contents 
	    		System.out.print(i); 
	    	} 
	    }
	}
	
	//Subtraction
	public static void Sub(int[] a, int[] b) { 
		 
		// Align digit
		int length = Math.max(a.length,b.length);
		int[] op1 = copyOf(a, length);
		int[] op2 = copyOf(b, length);
		int[] result = new int[length];	
		int[] newresult = new int[length];
		
		//Processing the digital borrow
		int borrow = 0;
		for(int i = length - 1; i >= 0; i--){
			int c = op1[i]-op2[i]-borrow;	
			if(c > -1) {
				borrow = 0;
			}else {
				c += 10;
				borrow = 1;
			}
			result[i] = c;
		}
		
		//If second number more than the first number, Change two numbers position and add -
		if(borrow == 1){
			if(b.length > a.length)System.out.print("-");
			for(int i = length - 1; i >= 0; i--){
	    	int c = op2[i] - op1[i] - borrow;
	    	if(c > -1) {
				borrow = 0;
			}else {
				c += 10;
				borrow = 1;
			}
			newresult[i] = c;
			}
	    	for (int i : newresult) { // 列印陣列內容 
				System.out.print(i); 
			} 
	    }else{		
	    	for (int i : result) { // 列印陣列內容 
	    		System.out.print(i); 
	    	} 
	    }
	} 
	

	//Overflow processing
	private static int[] newAddLength(int[] a) {
		int[] v = new int[a.length + 1];
		for(int i = 0; i < a.length; i++){
			v[i + 1] = a[i];
		}
		v[0] = 1;	
		
		return v;
	}
	
	//Uniform length
	private static int[] copyOf(int[] newDigit, int length) {
		
		int[] v = new int[length];
		if(v.length > newDigit.length){
			for(int i = 0; i < newDigit.length; i++){
				v[i + (v.length - newDigit.length)] = newDigit[i];
			}
			for(int i = 0; i < length - newDigit.length; i++){
				v[i] = 0;
			}
				
		}else{
			for(int i = length - 1; i >= 0; i--){
				v[i] = newDigit[i];
			}
		}
			
		return v;
	} 
	
	
}

//Main method
public class BigDigit
{
	public static void main(String[] args){
		//Enter two positive integer
		Scanner input = new Scanner(System.in);
		String a,b;	
		System.out.println("Enter first positive number:");
		a = input.nextLine();
		System.out.println("Enter second positive number:");
		b = input.nextLine();
		
		Big_Digit BD = new Big_Digit();
		int[] A = BD.BigDigit(a);
		int[] B = BD.BigDigit(b);
		
		System.out.print("First add second = ");
		BD.Add(A, B);
		System.out.println(" ");
		System.out.print("First sub second = "); 
		BD.Sub(A, B);
	}	
}
