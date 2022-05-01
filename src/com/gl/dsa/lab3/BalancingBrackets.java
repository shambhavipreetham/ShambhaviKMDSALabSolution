package com.gl.dsa.lab3;

import java.util.*;

public class BalancingBrackets {
	
	//Function to check if brackets are balanced
	static boolean AreBracketsBalanced(String expr)
	{
		//Using ArrayDeque
		Deque<Character> stack = new ArrayDeque<Character>();
		
		//Traversing the expression
		for(int i=0; i<expr.length(); i++)
		{
			char x = expr.charAt(i);
			
			if(x == '(' || x == '[' || x == '{') {
				
				//Push elements into the stack
				stack.push(x);
				continue;
			}
			
			/* if current character is not opening bracket, then it must be closing bracket.
			 * so, stack cannot be empty at this point */
			
			if (stack.isEmpty())
				return false;
			
			char check;
			
			switch(x) {
			
			case ')' :
				check = stack.pop();
				if(check == '[' || check == '{')
					return false;
				break;
				
			case ']' :
				check = stack.pop();
				if(check == '(' || check == '{')
					return false;
				break;
				
			case '}' :
			check = stack.pop();
			if(check == '(' || check == '[')
				return false;
			break;
		}
	}
		//Check Empty Stack
		return (stack.isEmpty());
}
	//Driver code
	public static void main(String[] args) {
		
		String expr1 = "([[{}]])";
		
		//Calling the function
		if(AreBracketsBalanced(expr1))
			System.out.println("The entered string has Balanced Brackets");
		else
			System.out.println("The entered string do not contain Balanced Brackets");
		
		String expr2 = "([[{}]]))";
		
		//Calling the function
		if(AreBracketsBalanced(expr2))
			System.out.println("The entered string has Balanced Brackets");
		else
			System.out.println("The entered string do not contain Balanced Brackets");
	}
}
