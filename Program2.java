
/*package javaapplication2;
import java.util.*;
public class Program2 {
    public static boolean isPrime(int num){
        if(num<=1){
            return false;
        }
        int i=2;
        while(i<=num/2){
            if(num%i==0){
                return false;
            }
            i++;
        }
        return true;
    }
    public static int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
        
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int p,q,n,z,e,d,mlen;
        int []pt=new int[100];
        int []ct=new int[100];
        String msg;
        do{
            System.out.println("Enter 2 Prime numbers");
            p=sc.nextInt();
            q=sc.nextInt();
        }while(!isPrime(p)||!isPrime(q));
        n=p*q;
        z=(p-1)*(q-1);
        for(e=2;e<z;e++){
            if(gcd(e,z)==1)
                break;
        }
        for(d=2;d<z;d++){
            if((d*e)%z==1)
                break;
        }
        System.out.println("Public key ("+e+","+n+")");
        System.out.println("Private key ("+d+","+n+")");
        
        
        
    }
}*/

package javaapplication2;;

import java.util.*;
public class Program2{
    public static void main(String[] args) {
        String msg;
        int pt[]=new int[100];
        int ct[]=new int[100];
        int z,n,d,e,p,q,mlen;
        
        Scanner in=new Scanner(System.in);
        do{
            System.out.println("Enter the two large prime numbers for p and q");
            p=in.nextInt();
            q=in.nextInt();
        }while(prime(p)==0||prime(q)==0);
        n=p*q;
        z=(p-1)*(q-1);
        System.out.println("Value of n"+n+"\n Vlaue of z is:"+z);
        //key generation(Encryption key)
        for(e=2;e<z;e++){
            if(gcd(e,z)==1)
                break;
        }
        System.out.println("Encryptin key is"+e);
       System.out.println("Public Key:("+e+", "+n+")");
//key generation(Decryption key)
        for(d=2;d<z;d++){
            if((e*d)%z==1)
                break;
        }
        System.out.println("Decryptin key is"+d);
        System.out.println("Private Key:{"+d+", "+n+"}");
        in.nextLine();
        System.out.println("Enter the message for encryption");
        msg=in.nextLine();
        mlen=msg.length();
        for(int i=0;i<mlen;i++)
         pt[i]=msg.charAt(i);
        System.out.println("ASCII values of PT array is");
        for(int i=0;i<mlen;i++)
            System.out.println(pt[i]);
        System.out.println("Encryption:Cipher Text obtained:");
        for(int i=0;i<mlen;i++)
            ct[i]=mult(pt[i],e,n);
        for(int i=0;i<mlen;i++)
             System.out.print(ct[i]+"\t");
        
        System.out.println("\n Decryption:Plain Text obtained:");
        for(int i=0;i<mlen;i++)
            pt[i]=mult(ct[i],d,n);
        for(int i=0;i<mlen;i++)
        {
            System.out.println(pt[i]+":"+(char)pt[i]);
        }
        
    }
    public static int prime(int num){
    if(num<=1) 
        return 0; 
    for(int i=2;i<=num-1;i++){
        if (num%i==0) {
            return 0; 
        }
    }
    return 1;
}
    public static int gcd(int a, int b) {
    while(b!=0) {
        int temp=b;
        b=a%b;
        a=temp;
    }
    return a;
}
    public static int mult(int base,int exp,int n)
        {
            int res=1,j;
            for(j=1;j<=exp;j++)
            res=((res*base)%n);
            return res;
        }
}
    


    

