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