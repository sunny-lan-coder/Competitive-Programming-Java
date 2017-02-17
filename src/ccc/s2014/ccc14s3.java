package ccc.s2014;

import java.util.Scanner;
import java.util.Stack;

public class ccc14s3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();//get number of test cases
		outer: for (int i = 0; i < t; i++) {
			int n = s.nextInt(); //get number of cars
			int curridx = 1;//current car that we need
			Stack<Integer> top = new Stack<>(); //the cars that have not been used yet
			Stack<Integer> branch = new Stack<>(); //the cars pushed into the branch
			for (int j = 0; j < n; j++) {
				top.push(s.nextInt()); //get all the cars
			}
			while ((!top.isEmpty()) || (!branch.isEmpty())) { //loop while not all cars have reached end
				if (!top.isEmpty()) //if there is a car on mountain
					if (top.peek() == curridx) {//if the car matches, push it down
						curridx++;
						top.pop();
						continue;
					}
				//mountain car has already been tried
				if (!branch.isEmpty())//if there is a car in branch
					//if car in branch matches, push it down
					if (branch.peek() == curridx) {
						curridx++;
						branch.pop();
						continue;

					}

				//both have been tried now
				if (top.isEmpty()) {//if top is empty
					System.out.println("N");//then it is not possible
					continue outer;//go onto next case
				} else {//otherwise, push car to branch (no other choice)
					branch.push(top.pop());
				}

			}
			System.out.println("Y");//all cars have went down
		}
		s.close();
	}

}
