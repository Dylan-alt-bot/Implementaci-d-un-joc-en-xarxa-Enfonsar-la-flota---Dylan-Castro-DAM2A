package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static char[][] playerBoard =
            new char[5][5];

    public static void main(String[] args){

        initBoard();

        try{

            Socket socket = new Socket("localhost", 5000);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            Scanner sc = new Scanner(System.in);

            System.out.println(in.readLine());

            while(true){

                printBoard();

                System.out.print("Fila (0-4): ");

                int x = sc.nextInt();

                System.out.print("Columna (0-4): ");

                int y = sc.nextInt();

                out.println(x + "," + y);

                String resposta = in.readLine();

                System.out.println("Resultat: " + resposta);

                if(resposta.equals("INVALID")){

                    System.out.println("Coordenades invàlides!");

                    continue;
                }



                if(playerBoard[x][y] != '~'){

                    System.out.println("Ja has disparat aquí!");

                    continue;
                }

                updateBoard(x, y, resposta);

                if(resposta.equals("WIN")) {

                    printBoard();

                    System.out.println("Has guanyat!");

                    break;
                }

            }

            socket.close();

        }catch(Exception e){

            e.printStackTrace();
        }

    }


    static void initBoard(){

        for(int i=0;i<5;i++)
            for(int j=0;j<5;j++)
                playerBoard[i][j]='~';

    }


    static void updateBoard(
            int x,
            int y,
            String result){

        if(result.equals("HIT") || result.equals("WIN")) {
            playerBoard[x][y]='X';
        }
        else{
            playerBoard[x][y]='O';
        }

    }


    static void printBoard(){

        System.out.println();

        System.out.print("   ");

        for(int i=0;i<5;i++)
            System.out.print(i+" ");

        System.out.println();

        for(int i=0;i<5;i++){

            System.out.print(i+"  ");

            for(int j=0;j<5;j++){

                System.out.print(playerBoard[i][j] + " ");

            }

            System.out.println();
        }

        System.out.println();
    }
}