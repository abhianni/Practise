package src;

import java.util.Stack;

public class RandomAddition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] DATA = { 1, 3, 4, 5, 6, 2 };
		RandomAddition get = new RandomAddition();
		get.populateSubset(DATA, 0,  6);
	}
	
	
		/** Set a value for target sum */
	     

	   private Stack<Integer> stack = new Stack<Integer>();

	    /** Store the sum of current elements stored in stack */
	    int sumInStack = 0;

	    public void populateSubset(int[] data, int fromIndex, int TARGET_SUM) {

	   
	        if (sumInStack == TARGET_SUM) {
	            print(stack,TARGET_SUM);
	        }

	        for (int i = fromIndex; i < data.length-1; i++) {

	            if (sumInStack + data[i] <= TARGET_SUM) {
	                stack.push(data[i]);
	                sumInStack += data[i];	              
	                populateSubset(data, i + 1, TARGET_SUM);
	                sumInStack -= (Integer) stack.pop();
	            }
	        }
	    }	  
	    private void print(Stack<Integer> stack,int TARGET_SUM) {
	        StringBuilder sb = new StringBuilder();
	        sb.append(TARGET_SUM).append(" = ");
	        for (Integer i : stack) {
	            sb.append(i).append("+");
	        }
	        System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
	    }
	}


