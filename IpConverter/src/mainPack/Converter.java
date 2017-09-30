/*
 * @Author Mateus R R Spadacio
 * @version 1.0
 * 
 * */

package mainPack;

import java.util.Scanner;


public class Converter {
	
	/* Variables and Objects */
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
	
		//Verify ip address
		for(int i = 0; i < 4; i++){
			if(ipv4[i] > 255){
				System.out.println("*** The ip address is incorrect !!!");
				receiveIp();
			}
		}
		
	}
	
	//Print the generated binaries
	public void print(){
		for(int i = 0; i <= 31; i++){
			System.out.print(getOctet[i]);
		}
		System.out.println("\n");
	}
	
	/*
	*It uses BCD 8421 to convert ip address
	*/
	public void converting(){
		for(int i = 0; i < 4; i++){
			bits = 128;
			aux = ipv4[i];
			while(true){
				if(aux >= bits){
					aux -= bits;
					getOctet[cont] = 1;
					cont++;
				}else{
					cont++;
				}
				
				if(bits == 1){
					break;
				}
				bits /= 2;
			}
			
		}	
		
	}
	
	
	
	public void convertingHexa(){
		
			int i = 0;
			while(true){
				//Checks whether the bit is on or off
				if(getOctet[i] == 1){	
					sum = sum + auxSum; //add 8 or 4 or 2 or 1
				}else{
					sum = sum + 0;
				}
				//Reset variables and go to the next octet
				if(auxSum == 1){
					saveSum[j] = sum;
					auxSum = 8;
					sum = 0;
					System.out.println(saveSum[j]);
					j++;		
				}else{
					//If it didn't finish
					auxSum = auxSum / 2; 
					/* 8/2 = 4 next
					*  4/2 = 2 next
					*  2/2 = 1 end
					*/
				}
				
				
				i++;
				
				//After checking each bit, it stops
				if(i == 32){
					break;
				}
			}
			
			
			
			
	}
	
	public void ipv6Complete(){
		
		for(int i = 0; i < 8; i++){
			if(i == 4){
				ipv6.append(":"+Integer.toString(saveSum[i], 16).toUpperCase()); //Hexadecimal conversion
			}else{
				ipv6.append(Integer.toString(saveSum[i], 16).toUpperCase()); //Hexadecimal conversion
			}
		}
		
		System.out.println("Tunel 6to4 is -> 2002:"+ipv6+":0:0:0:0:0 /64");
		
	}
	
}
