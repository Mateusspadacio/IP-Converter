package mainPack;

public class Start {

	
	
	public static void main(String[] args){
		
		Converter conv = new Converter();
		
		conv.receiveIp();
		conv.converting();
		conv.print();
		conv.convertingHexa();
		conv.ipv6Complete();
		
		
	}
}
