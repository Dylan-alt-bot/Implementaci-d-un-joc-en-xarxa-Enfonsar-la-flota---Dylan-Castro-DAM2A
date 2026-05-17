package server;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        try {

            ServerSocket server = new ServerSocket(5000);

            Tablero board = new Tablero();

            System.out.println("Servidor iniciat");

            while(true){

                Socket client = server.accept();

                System.out.println("Jugador connectat");

                ClientHandler handler = new ClientHandler(client, board);

                new Thread(handler).start();
            }

        } catch(Exception e){

            e.printStackTrace();
        }
    }
}