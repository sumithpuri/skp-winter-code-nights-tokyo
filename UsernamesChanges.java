/* 
[Question/Problem Statement is the Adapted from HackerRank]
 

Algorithms/Data Structures — [Problem Solving] 
There is a Specific Need for Changes in a List of Usernames... In a given List of Usernames — For Each Username — If 
the Username can be Modified/Moved Ahead in a Dictionary.The Allowed Modification is that Alphabets can change Positions 
in the Given Username.

Example
usernames[] = {"Aba", "Cat"}
 
"Aba" can be Changed to only "Baa" — Hence, It can Never Find a Place Ahead in the Dictionary... Hence, Output will be 
"NO". "Cat" can be Changed to "Act", "Atc", "Tca", "Tac", "Cta",  Definitely "Act" will Find a Place Before "Cat" in the 
Dictionary. Hence, Output will be "YES".

[Function Description]
Complete the function possibleChanges in the Editor Below.
 
possibleChanges has the Following Parameters:
String usernames[n]: An Array of User Names
 
Returns String[n]: An Array with "YES" or "NO" Based on Feasibility
(Actual Question Says String Array, But Signature is List of Strings)


Constraints
• [No Special Constraints Exist, But Cannot Recall Exactly]


Input Format 
"The First Line Contains an Integer, n, the Number of Elements in Usernames.",
"Each Line of the n Subsequent Lines (where 0 < i < n) contains a String usernames[i]."        

[Sample Case 0 — Sample Input For Custom Testing]         
8
Aba
Cat
Boby
Buba
Bapg
Sungi
Lapg
Acba
       
Sample Output (Each Should Be on a Separate Line) 
NO YES NO YES YES YES YES NO
   
 
[Explanation of the Solution]
This is again a Good Question from Hacker Rank to Test Your Logic / Problem Solving Abilities.. The Core Point to Handle 
is that For Each Combination of 2 Alphabets that Exists in the Username String> We Need to Check if the Latter Occurring 
Character (ASCII) is Less than the Former Occurring Character (ASCII). Example: In the String "Bapg" — For a Selection 
of "Ba" from "Bapg" — We have "a" Occurring Before "B" in the English Alphabet. We can Have Two Loops (One  Nested) to 
Decide for a Combination of Each Two Alphabets. The Time Complexity of this Solution is O(n^2).
*/

// HackerRank Core Java Problem [Usernames Changes]
// Sumith Puri [I Bleed Java!]; GitHub: @sumithpuri
// Tested On 31-12-2022 - All OK

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/*
 * HackerRank Problem Solving - Speak Ur Mind, But Ride a Fast Horse.
 * ~ Sumith Kumar Puri (c) 2021 ~ -- ~ Bengaluru, Karnataka, India ~
 * 
 */
class UsernamesChangesLogic {

	public static List<String> possibleChanges(List<String> usernames) {

		List<String> solutionStr = new ArrayList<String>();
		boolean bobbysFlag = false;
		int lowestTillNow = 0;
		for (String username : usernames) {

			bobbysFlag = false;
			String currName = username.toLowerCase();
			lowestTillNow = currName.charAt(0);
			for (int i = 0; i < currName.length(); i++) {

				int a = currName.charAt(i);

				for (int j = i + 1; j < currName.length(); j++) {

					int b = currName.charAt(j);

					if (b < a) {

						if ((i == 0) || (i != 0 & a < lowestTillNow)) {

							lowestTillNow = a;
							bobbysFlag = true;
							break;
						}
					}
				}
				if (bobbysFlag) {
					solutionStr.add("YES");
					break;
				}
			}
			if (!bobbysFlag)
				solutionStr.add("NO");
		}

		return solutionStr;
	}
}

public class UsernamesChanges {

	// kindly configure and environment variable OUTPUT_PATH
	// provide a value that will hold the output, like below
	// f:/usernames_changes.txt
	public static final String OUTPUT_PATH = "OUTPUT_PATH";

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv(OUTPUT_PATH)));

		int usernamesCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> usernames = IntStream.range(0, usernamesCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).collect(toList());

		List<String> result = UsernamesChangesLogic.possibleChanges(usernames);

		bufferedWriter.write(result.stream().collect(joining("\n")) + "\n");

		bufferedReader.close();
		bufferedWriter.close();
	}
}


