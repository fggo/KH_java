package test;

import java.util.Scanner;
public class Solution {
 
    public static void main(String[] args)
    {
        int t;
        Scanner sc = new Scanner(System.in);
        String[] arrStr = new String[10];
        String strName ="";
        int sum = 0;
         
        t = sc.nextInt();
        for(int j = 0; j < t; j++)
        {
            if(j == 0)
                sc.nextLine();
             
            strName = sc.nextLine();
             
            for(int i = 0; i < arrStr.length; i++)
            {
                int idx = strName.indexOf(" ");
                arrStr[i] = strName.substring(0, idx);
                               strName = strName.substring(idx+1);
                if(strName.length() <= 2)
                {
                    arrStr[arrStr.length-1] = strName;
                    break;
                }
            }
             
            for(int k = 0; k < arrStr.length; k++)
            {
                if(Integer.parseInt(arrStr[k]) % 2 != 0)
                {
                    sum += Integer.parseInt(arrStr[k]);
                }
            }
            System.out.println("#"+(j+1)+" "+sum);
            sum =0;
            arrStr = new String[10];
            strName = "";
        }      
    }         
}
