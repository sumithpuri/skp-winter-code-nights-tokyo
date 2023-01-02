/**
 * Refer to the Java Code (developed by Sumith Puri) for an iterative solution for the longest palindrome in a substring. 
 * It might be asked in one of your interviews for big companies like Yahoo, Symantec, Huawei, Oracle, Microsoft, Amazon, 
 * or Google! Also, you might want to sometimes natively implement it for any of your requirements, like tools in ur org.
*/

// Find the Longest Palindrome in a [ Given String ]
// Embed in your Desktop, Mobile or Enterprise Apps
// Sumith Puri [I Bleed Java!]; GitHub: @sumithpuri
// Tested On 01-01-2023 - All OK

/**
 * @author sumith.puri
 * 
 *         O(n*n*n) : Time Complexity - Iterative Logic (Our Solution) Recursive
 *         Dynamic Programming is O (n*n) - You May Try Out!
 */

public class LongestPalindrome {

	public static String longestPalindrome(String gString) {

		String lString = gString.substring(0, 1), pString = null;

		for (int i = 0; i < gString.length() - 1; i++) {

			// this is for an odd length palindrome
			pString = findPalindrome(gString, i, i);

			if (pString.length() > lString.length()) {
				lString = pString;
			}

			// this is for an even length palindrome
			// seems like a duplicate of above, but.
			// it is not - there is a way to combine
			// and optimize this logic. left for you :-)
			pString = findPalindrome(gString, i, i + 1);

			if (pString.length() > lString.length()) {
				lString = pString;
			}
		}
		return lString;
	}

	public static String findPalindrome(String gString, int start, int end) {

		int length = gString.length();
		if (start > end)
			return null;

		while (start >= 0 && end < length && gString.charAt(start) == gString.charAt(end)) {
			start--;
			end++;
		}

		return gString.substring(start + 1, end);
	}

	public static void main(String[] args) {

		// String iString="12232133123111";
		// Modify this String to Test / Understand the Program Logic
		String iString = "WOOWMALAYALAMBABBABNOONSHOTFARSAIPPUAKIVIKAUPPIASTTATIPADGASLOONDI";
		System.out.println(longestPalindrome(iString));
	}
}
