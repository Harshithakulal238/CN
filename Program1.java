/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;
import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) {
        Scanner scr=new Scanner(System.in);
        System.out.println("Enter the number of packets");
        int no_of_packet=scr.nextInt();
        System.out.println("Enter the Bucket capacity");
        int buck_capacity=scr.nextInt();
        System.out.println("Enter the output rate");
        int output_rate=scr.nextInt();
        int []packet=new int[no_of_packet];
        int []accept=new int[no_of_packet];
        int []remain=new int[no_of_packet];
        int []sent=new int[no_of_packet];
        System.out.println("Enter the size of the packets");
        for(int i=0;i<no_of_packet;i++){
            packet[i]=scr.nextInt();
        }
        for(int i=0;i<no_of_packet;i++){
            if(packet[i]>buck_capacity){
                accept[i]=buck_capacity;
                sent[i]=output_rate;
                remain[i]=(i>0)?(remain[i-1]+packet[i]-accept[i]):0;
            }
            else{
                accept[i]=packet[i];
                int total=accept[i]+(i>0?remain[i-1]:0);
                sent[i]=Math.min(total, output_rate);
                remain[i]=Math.max(total-sent[i], 0);
            }
        }
        System.out.println("Clock\t\tPacket\t\tAccept\t\tSent\t\tRemaining");
        for(int i=0;i<no_of_packet;i++){
           if(packet[i]>buck_capacity){
               //System.out.printf("%-6d%-12d%-12s%-6d%-9d%n",(i+1),packet[i],accept[i]+"Dropped"+(packet[i]-accept[i]),sent[i],remain[i]);
               System.out.println((i+1)+"\t\t"+packet[i]+"\t\t"+(accept[i]+"dropped("+remain[i]+")")+"\t"+sent[i]+"\t\t"+remain[i]);
           }
          // if(accept[i]==0)
               // System.out.printf("%-6d%-12d%-7s%-6d%-9d%n",(i+1),packet[i],"Dropped",sent[i],remain[i]);
           else
            //System.out.printf("%-6d%-12d%-12d%-6d%-9d%n",(i+1),packet[i],accept[i],sent[i],remain[i]);
                System.out.println((i+1)+"\t\t"+packet[i]+"\t\t"+accept[i]+"\t\t"+sent[i]+"\t\t"+remain[i]);
        }
        scr.close();
    }
}

