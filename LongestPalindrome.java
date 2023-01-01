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
		String iString = "WOOWMALAYALAMBABBABNOONSHOTFARSAIPPUAKIVIKAUPPIASTTATIPADGASLOONDI";
		System.out.println(longestPalindrome(iString));
	}
}
