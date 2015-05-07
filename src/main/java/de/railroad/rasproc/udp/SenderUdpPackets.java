package de.railroad.rasproc.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SenderUdpPackets
{

	public void send() throws IOException
	{
		//	BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress iPAddress = InetAddress.getByName("localhost");
		byte[] sendData = new byte[13];
		byte[] receiveData = new byte[20];
		//String sentence = "Hallo";
		//sendData = sentence.getBytes();
		// Nachricht empfangen: CanFrame [prio=00 , command=00 , respond=00 , hashHigh=03 hashLow=00 , dlc=05 , dByte0=00 , dByte1=00 , dByte2=00 , dByte3=00 , dByte4=00 , dByte5=00 , dByte6=00 , dByte7=00 ]
		sendData[0] = 0x00; //  prio
		sendData[1] = 0x22; //  command
		sendData[2] = 0x03; //  hashHigh
		sendData[3] = 0x00; //  hashLow
		sendData[4] = 0x08; //  dlc
		sendData[5] = 0x00; //  dbyte0
		sendData[6] = 0x01; //  dbyte1
		sendData[7] = 0x00; //  dbyte2
		sendData[8] = 0x01; //  dbyte3
		sendData[9] = 0x01; //  dbyte4
		sendData[10] = 0x00; // dbyte5
		sendData[11] = 0x00; // dbyte6
		sendData[12] = 0x00; // dbyte7

		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, iPAddress, 15730);
		clientSocket.send(sendPacket);

		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

		//		clientSocket.receive(receivePacket);
		//		String modifiedSentence = new String(receivePacket.getData());
		//		System.out.println("FROM SERVER:" + modifiedSentence);
		clientSocket.close();
	}
}

/**
 * sendData[0] = 0x00; // prio sendData[1] = 0x00; // command sendData[2] = 0x03; // hashHigh
 * sendData[3] = 0x00; // hashLow sendData[4] = 0x05; // dlc sendData[5] = 0x00; // dbyte0
 * sendData[6] = 0x00; // dbyte1 sendData[7] = 0x00; // dbyte2 sendData[8] = 0x00; // dbyte3
 * sendData[9] = 0x00; // dbyte4 sendData[10] = 0x00; // dbyte5 sendData[11] = 0x00; // dbyte6
 * sendData[12] = 0x00; // dbyte7
 */
