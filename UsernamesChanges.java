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