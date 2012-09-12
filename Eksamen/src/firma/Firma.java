package firma;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Firma implements Runnable{

	private ServerSocket server;
	private Socket client;
	private Thread thread;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private ArrayList<Salg> salgsListe;
	
	
	
	public Firma(){
		client = new Socket();
		salgsListe = new ArrayList<Salg>();
		try {
			server = new ServerSocket(8000);
			System.out.println("server running");
			while (true){
				client = server.accept();
				thread = new Thread(this);
				thread.start();
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
	}
	@Override
	public void run() {
		
		try {
			oos = new ObjectOutputStream(client.getOutputStream());
			ois = new ObjectInputStream(client.getInputStream());
			Salg s =  (Salg) ois.readObject();
			salgsListe.add(s);
			oos.writeObject(salgsListe);
			oos.flush();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Firma f = new Firma();
	}

}
