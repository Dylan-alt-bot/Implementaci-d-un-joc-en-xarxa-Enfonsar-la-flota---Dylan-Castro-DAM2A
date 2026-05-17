package server;

import java.util.Random;

public class Tablero {

    private char[][] tablero = new char[5][5];

    public Tablero() {
        inicioTablero();
        colocarBarcos();
    }

    private void inicioTablero() {
        for(int i=0;i<5;i++)
            for(int j=0;j<5;j++)
                tablero[i][j]='~';
    }

    private void colocarBarcos() {

        Random r = new Random();

        int barcos = 5;

        while(barcos > 0){

            int x = r.nextInt(5);
            int y = r.nextInt(5);

            if(tablero[x][y]=='~'){
                tablero[x][y]='S';
                barcos--;
            }
        }
    }

    public String disparo(int x, int y){

        if(x < 0 || x >= 5 || y < 0 || y >= 5){

            return "INVALID";
        }

        if(tablero[x][y]=='S'){
            tablero[x][y]='X';

            if(victoriaPartida())
                return "WIN";

            return "HIT";
        }

        return "MISS";
    }

    private boolean victoriaPartida(){

        for(int i=0;i<5;i++)
            for(int j=0;j<5;j++)
                if(tablero[i][j]=='S')
                    return false;

        return true;
    }

}
