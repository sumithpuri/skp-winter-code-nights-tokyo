/*

[Question/Problem Statement is the Property of HackerRank]
Algorithms/Data Structures — [Problem Solving] 
An Institutional Broker wants to Review their Book of Customers to see which are Most Active.. Given a List of Trades By 
Customer Name, Determine which Customers Account for atleast 5% of the Total No of Trades. Order the List Alphabetically 
Ascending By Name.


Example
n = 23
"customers = {"Bigcorp", "Bigcorp", "Acme", "Bigcorp", "Zork", "Zork", "Abe", "Bigcorp", "Acme", "Bigcorp", "Bigcorp", 
"Zork", "Bigcorp", "Zork", "Zork", "Bigcorp", "Acme", "Bigcorp", "Acme", "Bigcorp", "Acme", "Littlecorp", "Nadircorp"}."

"Bigcorp had 10 Trades out of 23, which is 43.48% of the Total Trades."
"Both Acme and Zork had 5 trades, which is 21.74% of the Total Trades."
"The Littlecorp, Nadircorp, and Abe had 1 Trade Each, which is 4.35%..."

"So the Answer is ["Acme","Bigcorp","Zork"] (In Alphabetical Order) 
Because only These Three Companies Placed at least 5% of the Trades.


Function Description
Complete the Function mostActive in the Editor Below.

mostActive has the following parameter:
String customers[n]: An Array Customer Names
(Actual Question Says String Array, But Signature is List of Strings)

Returns String[]: An Alphabetically Ascending Array


Constraints
• 1 < n < 10^5
• 1 < Length of customers[] < 20
• The First Character of customers[i] is a Capital English letter.
• All Characters of customers[i] except for the First One are Lowercase.
• Guaranteed that At least One Customer makes at least 5% of Trades.


Input Format
"The First Line contains an integer, n, The Number of Elements in customers."
"Each Line i of the n Subsequent Lines (where 0 s i< n) contains a string, customers[i]."


Sample Case 0 Input For Custom Testing
20
Omega 
Alpha
Omega 
Alpha 
Omega 
Alpha 
Omega 
Alpha 
Omega 
Alpha 
Omega 
Alpha 
Omega 
Alpha 
Omega 
Alpha 
Omega 
Alpha
Omega 
Beta



Function mostActive       
customers[] size n = 20
customers[] = [As Provided Above]


Sample Output
Alpha
Beta
Omega


Explanation
"Alpha made 10 Trades out of 20 (50% of the Total), Omega made 9 Trades (45% of the Total). and Beta made 1 Trade (5% of 
the Total). All of them have met the 5% Threshold, so all the Strings are Returned in an Alphabetically Ordered Array."
 

[Explanation of the Solution]
This is Good Practice for the Brain for Problem Solving — Involves Simple Arithmetic and Mathematical Application. 
Ideally, A Programmer would want to Optimize the Solution in Space and Time (Which I Did Not :-)

*/

// HackerRank Core Java Problem : [ Active Traders ]
// Sumith Puri [I Bleed Java!]; GitHub: @sumithpuri
// Tested On 30-12-2022 - All OK

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.IntStream;

/*
 * HackerRank Problem Solving - Ain't a Horse that Can't be Rode
 * Sumith Kumar Puri (c) 2021 - ~ Bengaluru, Karnataka, India ~
 * 
 */
class ActiveTradersLogic {

	public static List<String> mostActive(List<String> customers) {

		// How About Arrays or Custom LinkedList for a 'Very Fast' Traversal?
		Map<String, Integer> customerMap = new TreeMap<String, Integer>();
		List<String> solutionStr = new ArrayList<String>();
		int customerMapSize = customers.size();

		for (int i = 0; i < customerMapSize; i++) {

			String customerKey = customers.get(i);

			if (customerMap.containsKey(customerKey)) {

				Integer customerCount = customerMap.get(customerKey);
				customerMap.put(customerKey, ++customerCount);
			} else {
				customerMap.put(customerKey, 1);
			}
		}

		Set<String> customerMapKeys = customerMap.keySet();
		for (String customerKey : customerMapKeys) {

			Integer customerCount = customerMap.get(customerKey);
			double currentCustomerPercent = (double) (customerCount) / (double) customerMapSize;

			if (currentCustomerPercent * 100 >= 5.0) {

				solutionStr.add(customerKey);
			}
		}

		return solutionStr;
	}
}

public class ActiveTraders {

	// kindly configure and environment variable OUTPUT_PATH
	// provide a value that will hold the output, like below
	// f:/active_traders.txt
	public static final String OUTPUT_PATH = "OUTPUT_PATH";

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv(OUTPUT_PATH)));

		int customersCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> customers = IntStream.range(0, customersCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).collect(toList());

		List<String> result = ActiveTradersLogic.mostActive(customers);

		bufferedWriter.write(result.stream().collect(joining("\n")) + "\n");

		bufferedReader.close();
		bufferedWriter.close();
	}
}