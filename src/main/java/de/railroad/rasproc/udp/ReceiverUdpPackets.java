package de.railroad.rasproc.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.concurrent.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import de.railroad.rasproc.model.CanUdpFrame;

public class ReceiverUdpPackets implements Runnable
{
	private static final Logger LOGGER = LoggerFactory.getLogger(ReceiverUdpPackets.class);
	DatagramSocket serverSocket;
	BlockingQueue<CanUdpFrame> udpCanFrameQueue;
	byte[] receiveData = new byte[13];
	byte[] sendData = new byte[20];

	public ReceiverUdpPackets(int port, BlockingQueue<CanUdpFrame> udpCanFrameQueue) throws SocketException
	{
		this.udpCanFrameQueue = udpCanFrameQueue;
		LOGGER.info("Öffne Port {} zum Empfang", port);
		serverSocket = new DatagramSocket(port);
	}

	@Override
	public void run()
	{
		//new Thread(() -> System.out.println("Hello Java 8!")).start();
		LOGGER.info("Empfang starten");
		try
		{
			while (true)
			{
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				serverSocket.receive(receivePacket);

				byte[] rByte = receivePacket.getData();
				//				System.out.print("Länge:" + rByte.length);
				//				System.out.print(":");
				int c = 0;
				int p = 1;
				//				for (byte b : rByte)
				//				{
				//					p++;
				//					System.out.print("." + b);
				//				}
				//				System.out.print(":");
				//				System.out.print(Tools.asHex(rByte));
				//				System.out.print(":");

				//				System.out.println(Tools.byteToString(rByte));
				CanUdpFrame cf = new CanUdpFrame();
				MDC.put("correlation", cf.getCorrelationId());
				cf.setPrio(rByte[0]);
				cf.setCommand(rByte[1]);
				//cf.setRespond(rByte[3]);
				cf.setHashHigh(rByte[2]); //+ 3
				cf.setHashLow(rByte[3]); //+ 3
				cf.setDlc(rByte[4]);
				cf.setdByte0(rByte[5]);
				cf.setdByte1(rByte[6]);
				cf.setdByte2(rByte[7]);
				cf.setdByte3(rByte[8]);
				cf.setdByte4(rByte[9]);
				cf.setdByte5(rByte[10]);
				cf.setdByte6(rByte[11]);
				cf.setdByte7(rByte[12]);
				this.udpCanFrameQueue.add(cf);
				LOGGER.info("Nachricht empfangen: {}", cf);
				//				System.out.println(cf);
				//
				//				byte[] dataByte = new byte[4];
				//				dataByte[0] = rByte[8];
				//				dataByte[1] = rByte[7];
				//				dataByte[2] = rByte[6];
				//				dataByte[3] = rByte[5];
				//				System.out.println("Converted: " + Tools.getUInt32(dataByte));
			}

		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
