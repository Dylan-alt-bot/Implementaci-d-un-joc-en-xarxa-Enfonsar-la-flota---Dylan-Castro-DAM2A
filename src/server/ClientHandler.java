package server;

import java.net.Socket;

public class ClientHandler
        implements Runnable {

    private Socket socket;
    private Tablero tablero;

    public ClientHandler(Socket socket, Tablero tablero) {

        this.socket = socket;
        this.tablero = tablero;
    }

    @Override
    public void run() {

    }
}