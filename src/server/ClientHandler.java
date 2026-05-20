package server;

import java.io.*;
import java.net.Socket;

public class ClientHandler
        implements Runnable {

    private Socket socket;
    private Tablero tablero;

    public ClientHandler(Socket socket, Tablero tablero){

        this.socket = socket;
        this.tablero = tablero;

    }

    @Override
    public void run() {

        try{

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Benvingut");

            String line;

            while((line=in.readLine())!=null){

                String[] parts = line.split(",");

                int x = Integer.parseInt(parts[0]);

                int y = Integer.parseInt(parts[1]);

                String result = tablero.disparo(x,y);

                out.println(result);

                if(result.equals("WIN"))
                    break;
            }

            socket.close();

        }catch(Exception e){

            e.printStackTrace();
        }

    }

}