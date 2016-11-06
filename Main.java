import java.util.*;

public class Main {
	private static int e;
	private static boolean[] assignment;
	private static int iter = 0;

	@SuppressWarnings("unchecked") //is this okay.
	public static void main( String[] args) {
		
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
		String clauses = null;
	
		int numOfVars = 0;
		int numOfClauses = 0;
		String s = null;
		ArrayList<String> inputs = new ArrayList<String>();
		while(in.hasNextLine()) {
			s = in.nextLine();
			numOfVars = in.nextInt();
			numOfClauses = in. nextInt();
			int i = 0;
			in.nextLine();
			while (i < numOfClauses){

				clauses = in.nextLine();

				inputs.add(clauses);
				i++;
			}
			break;
		
		}
		//System.out.println(" ");
		

		String[] tokens = null;
		ArrayList<Integer> tokens2 = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> mlist = new ArrayList<ArrayList<Integer>>();
		for (int j = 0; j < inputs.size(); j++ ) {
			tokens = (inputs.get(j)).split(" ");
			for (int b = 0; b < tokens.length; b++) {
				tokens2.add(Integer.parseInt(tokens[b]));
			}
			mlist.add((ArrayList<Integer>) tokens2.clone());
			tokens2.clear();
		}

		

		if (iter == 0) {
			System.out.println();
		}
		System.out.println(s + ": " + numOfVars + " Variable(s) " + numOfClauses + " Clause(s)");
		for(int a = 0; a < mlist.size(); a++) {

			for (int z = 0; z < mlist.get(a).size(); z++) { 
			//	System.out.print((mlist.get(a).get(z)));
			}	
		}

		//System.out.println((mlist.get(1).get(0)));

		assignment = new boolean[numOfVars];
		for (int m = 0; m < numOfVars; m++ ){
			assignment[m] = true;	
			//System.out.print(assignment[m]+ " ");

		}

		//System.out.println();
		
		if (recursion(assignment, mlist, 0) == true ) {
			System.out.println("Satisfiable");
			for (int w = 0; w < assignment.length; w++) {
				System.out.print((assignment[w]) + " " );
			}
			
			/*if (iter == 0) {
				System.out.println(" ");
			}*/
		} else {
			System.out.print("Unsatisfiable");
		}
		
		//System.out.println(recursion(assignment, mlist, 0));
		
		//System.out.println(Arrays.toString(assignment));
		}
		
iter++;
	}

	public static boolean satisfiable(boolean[] arr, ArrayList<ArrayList<Integer>> mlist) {
		
	loop:	for (int i = 0; i <mlist.size(); i++) { 
			for (int j = 0; j < mlist.get(i).size(); j++) {
				int x = mlist.get(i).get(j);
				if (x > 0 == arr[Math.abs(x) - 1])  
					continue loop; 
				
					
			}
			
			return false;
		}
return true;
	}
	
	public static boolean recursion(boolean[] arr, ArrayList<ArrayList<Integer>> mlist, int counter) {
		if (counter >= arr.length ){
			return satisfiable(arr, mlist);
		} else {
			arr[counter] = true;
			//recursion(arr, mlist, counter+1);
			if (recursion(arr, mlist, counter+1))
				return true;
			else {
				arr[counter] = false;
				return recursion(arr, mlist, counter+1);
				
			}
		}
	}

}


//for (int i = 0; i < )

/*

		String problemName = args[0] + " " + args[1];
		int numVars = Integer.parseInt(args[2]);
		int numClauses = Integer.parseInt(args[3]);



		System.out.println(args[0] + " " + args[1] + ": " + numVars + " Variable(s) " + numClauses + " Clause(s)");
		//System.out.println(args.length);
		boolean helper = false;
		boolean finalAnswer = true;



			for ( int i = 4; i < args.length; i ++) { //starting with args[4], since args[0] and args[1] are the problem name, and args[2] and args[3] are numVars & numClauses


				int boolArrayLen = args.length - 4;
				boolean[] assignment = new boolean[boolArrayLen];
				for (int k = 0; k <assignment.length; k++) {
					assignment[k] = false; //initializing all the values in the boolean array to be false
				}


				if (args[i].length() > 1) {
					char firstChar = (args[i]).charAt(0);
					if ( firstChar == '-') {
						//System.out.println("hi");
						assignment[i-4] = false;
						System.out.print(assignment[i-4] + " ");
					} 

				}else {
						assignment[i-4] = true;
						System.out.print(assignment[i-4] + " ");
				}


			}*/










/*

	Statement s = (-x_1 || x_2) && (x_3 || -x_4) && (-x_2 || -x_3)

	boolean assignment = new boolean[4];

	boolean finAnswer = true;

	for each clause in statement s {
		boolean helper = false;
		for each literal in clause {
			helper = helper || literal_clause;
		}

		finAnswer = finAnswer && helper;

	}

	return finAnswer;

 */