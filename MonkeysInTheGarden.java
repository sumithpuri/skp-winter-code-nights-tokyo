/* 

[Input Format]
The First Line consists of Total Number of Trees (N). Each of the Following N Lines contains the Height of Trees in a Clockwise Fashion.

[Constraints]
1 <= Total Trees <= 30
1 <= Height Of Trees(H) <= 10000

[Output Format]
You must Print an Integer which will be the Maximum Possible Travel Time.

[Explanation of the Solution]
Surprisingly, this Problem is under the Object-Oriented Programming (OOP) Section of the Problems! Initially, I was on the Lookout for a 'Mathematically Superior' Solution. But I Couldn't Reach Anywhere — In the End, I have a Simple Solution at O(n²). Iterate through Each 'Combination of Trees' and then Find the Clockwise and Anti-Clockwise Distance — At Each Iteration, the Minimum of the Two is Added to the Length of Each Tree. If this Value is Greater than the Maximum Path Length (Previous Iterations) — Replace the Maximum Path Length.

[Sample Input]
4
1
2
3
4

[Sample Output]
8

*/

// Techgig Core Java Basics Problem - Monkeys in the Garden
// Author: Sumith Puri [I Bleed Java!]; GitHub: @sumithpuri
// Tested On 30-12-2022 - All OK

import java.io.*;  
import java.util.*;  
import java.lang.Math;  

public class MonkeysInTheGarden {  

    public static void main(String args[] ) throws Exception {  
    
     Scanner scanner = new Scanner (System.in);  
       
     int n = scanner.nextInt();  
     int h[] = new int[n], max=0;  
     int cwLen=0,acLen=0,hiLen=0,toLen=0;  
    
     for(int i=0;i<n;i++) {  
       h[i] = scanner.nextInt();        
     }  
     max=h[0];  
    
     for(int i=0;i<n;i++) {  
    
       for(int j=i+1;j<n;j++) {  
         cwLen=Math.abs(((n-j)+i)); // clockwise  
         acLen=Math.abs((j-i));     // anti-clockwise  
         hiLen=(cwLen<=acLen)?(cwLen):(acLen);  
         toLen=hiLen+h[i]+h[j];     // path length    
         if(toLen>max) max=toLen;   // maximum path length  
       }  
     }  
          
     System.out.println (max);   
    }  
}  