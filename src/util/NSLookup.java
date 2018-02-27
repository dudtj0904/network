package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
		try {
			while(true) {
				Scanner sc = new Scanner(System.in);
				System.out.print("> ");
				String domain = sc.nextLine();
				
				if(domain.equals("exit")) {
					System.out.println("����");
					break;
				}
				InetAddress[] inets = InetAddress.getAllByName(domain);

				for(InetAddress inet : inets) {
					byte[] addresses = inet.getAddress();
					System.out.print(domain+" : ");
					int cnt=0;
					for(byte address : addresses) {
						cnt++;
						System.out.print(address&0x000000ff);
						if(cnt!=4) System.out.print(".");
					}
					System.out.println();
					/* �ι�° ���
					 * String address = inet.getHostAddress();
					   System.out.println(domain+ " : "+address);*/
				}
			}
			
			
		} catch (UnknownHostException e) {
			System.out.println("�������� �ʴ� ������ : "+e);
		}
	}

}
