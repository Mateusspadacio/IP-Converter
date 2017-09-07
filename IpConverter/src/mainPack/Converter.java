/*
 * @Author Mateus R R Spadacio
 * @version 1.0
 * 
 * */

package mainPack;

import java.util.Scanner;


public class Converter {

	Scanner in = new Scanner(System.in);
	public int ipv4[] = new int[4];
	public int getOctet[] = new int[32];
	public int saveSum[] = new int[8];
	int aux, sum, cont = 0, auxSum = 8, j = 0;
	
	StringBuilder ipv6 = new StringBuilder();
	
	
	
	public void receiveIp(){
		
		System.out.println("Write the first octet in decimal");
		ipv4[0] = in.nextInt();
		System.out.println("Write the second octet in decimal");
		ipv4[1] = in.nextInt();
		System.out.println("Write the third octet in decimal");
		ipv4[2] = in.nextInt();
		System.out.println("Write the fourth octet in decimal");
		ipv4[3] = in.nextInt();
	
		for(int i = 0; i < 4; i++){
			if(ipv4[i] > 255){
				System.out.println("*** The ip address is incorrect !!!");
				receiveIp();
			}
		}
		
	}
	
	
	public void print(){
		for(int i = 0; i <= 31; i++){
			System.out.print(getOctet[i]);
		}
		System.out.println("\n");
	}
	
	
	public void converting(){
		
		
		
		for(int i = 0; i < 4; i++){
			
			aux = ipv4[i];
			
			if(aux >= 128){
				aux = aux - 128;
				getOctet[cont] = 1;
				cont++;
			}else{
				cont++;
			}
			
			if(aux >= 64){
				aux = aux - 64;
				getOctet[cont] = 1;
				cont++;
			}else{
				cont++;
			}
			
			if(aux >= 32){
				aux = aux - 32;
				getOctet[cont] = 1;
				cont++;
			}else{
				cont++;
			}
			
			if(aux >= 16){
				aux = aux - 16;
				getOctet[cont] = 1;
				cont++;
			}else{
				cont++;
			}
			
			if(aux >= 8){
				aux = aux - 8;
				getOctet[cont] = 1;
				cont++;
			}else{
				cont++;
			}
			
			if(aux >= 4){
				aux = aux - 4;
				getOctet[cont] = 1;
				cont++;
			}else{
				cont++;
			}
			
			if(aux >= 2){
				aux = aux - 2;
				getOctet[cont] = 1;
				cont++;
			}else{
				cont++;
			}
			
			if(aux >= 1){
				aux = aux - 1;
				getOctet[cont] = 1;
				cont++;
			}else{
				cont++;
			}
			
			
			
			
		}
		
		
	}
	
	
	
	public void convertingHexa(){
		
			int i = 0;
			while(true){
			
				if(getOctet[i] == 1){
					sum = sum + auxSum;
				}else{
					sum = sum + 0;
				}
				
				if(auxSum == 1){
					saveSum[j] = sum;
					auxSum = 8;
					sum = 0;
					System.out.println(saveSum[j]);
					j++;		
				}else{
					auxSum = auxSum / 2;
				}
				
				
				i++;
				
				if(i == 32){
					break;
				}
			}
			
			
			
			
	}
	
	public void ipv6Complete(){
		
		for(int i = 0; i < 8; i++){
			if(i == 4){
				ipv6.append(":"+Integer.toString(saveSum[i], 16).toUpperCase());
			}else{
				ipv6.append(Integer.toString(saveSum[i], 16).toUpperCase());
			}
		}
		
		System.out.println("Tunel 6to4 is -> 2002:"+ipv6+":0:0:0:0:0 /64");
		
	}
	
}
