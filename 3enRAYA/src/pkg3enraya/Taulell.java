package pkg3enraya;

public class Taulell {

    //  0 ----> BLANCAS
    //  1 ----> NEGRAS
    // -1 ----> casilla libre
    private int[][] caselles;

    public Taulell() {
        this.caselles = new int[3][3];

        for (int f = 0; f < 3; f++) {
            for (int c = 0; c < 3; c++) {
                this.caselles[f][c] = -1;
            }
        }
    }

    private int comprovarGuanyadorColumnes() {
        // Comprovar ses columnes
        for (int c = 0; c < 3; c++) {
            if ((this.caselles[0][c] != -1) && (this.caselles[0][c] == this.caselles[1][c])
                    && (this.caselles[1][c] == this.caselles[2][c])) {
                return this.caselles[0][c];
            }
        }

        return -1;
    }

    private int comprovarGuanyadorDiagonals() {
        // Comprovar ses diagonals

        if ((this.caselles[0][0] != -1) && (this.caselles[0][0] == this.caselles[1][1])
                && (this.caselles[1][1] == this.caselles[2][2])) {
            return this.caselles[0][0];
        }

        if ((this.caselles[0][2] != -1) && (this.caselles[0][2] == this.caselles[1][1])
                && (this.caselles[1][1] == this.caselles[2][0])) {
            return this.caselles[0][2];
        }

        return -1;
    }

    private int comprovarGuanyadorFiles() {
        // Comprovar ses files
        for (int f = 0; f < 3; f++) {
            if ((this.caselles[f][0] != -1) && (this.caselles[f][0] == this.caselles[f][1])
                    && (this.caselles[f][1] == this.caselles[f][2])) {
                return this.caselles[f][0];
            }
        }

        return -1;
    }

    public int comprovarGuanyador() {
        int jugador;

        jugador = this.comprovarGuanyadorFiles();
        if (jugador == -1) {
            jugador = this.comprovarGuanyadorColumnes();
        }
        if (jugador == -1) {
            jugador = this.comprovarGuanyadorDiagonals();
        }

        return jugador;
    }

    public boolean comprovarPle() {
        boolean lleno = true;

        for (int f = 0; f < 3; f++) {
            for (int c = 0; c < 3; c++) {
                if (caselles[f][c] == -1) {
                    lleno = false;
                }
            }
        }

        return lleno;
    }
    
    public int getCasilla(int fila, int columna) {
        int valor;
        valor = this.caselles[fila][columna];
        
        return valor;
    }

    public int[] getCasillaLibre() { 
        int[] moviment = new int[2];

        for (int f = 0; f < 3; f++) {
            for (int c = 0; c < 3; c++) {
                if (this.caselles[f][c] == -1) {
                    moviment[0] = f;
                    moviment[1] = c;
                    f = 2;
                    c = 2;
                }
            }
        }

        return moviment;
    }    
    
    public void mostrarTaulell() {
        System.out.println("");
        System.out.println("                                        1 2 3");
        System.out.println("                                        - - -");
        for (int i = 0; i < 3; i++) {
            System.out.print("                                     " + (i + 1) + "|");
            for (int j = 0; j < 3; j++) {
                switch (caselles[i][j]) {
                    case -1:
                        System.out.print("  ");
                        break;
                    case 0:
                        System.out.print(" O");
                        break;
                    default:
                        System.out.print(" X");
                        break;
                }
            }
            System.out.println("");
        }
    }

    public void moure(Moviment moviment) {
        if (moviment.getFitxa() == 0) {
            this.caselles[moviment.getFila()][moviment.getColumna()] = 0;
        } else {
            this.caselles[moviment.getFila()][moviment.getColumna()] = 1;
        }
    }

    public boolean validarCasillaBuida(Moviment moviment) {
        return (this.caselles[moviment.getFila()][moviment.getColumna()] == -1);
    }

    public boolean validarMoviment(Moviment moviment) {

        return !(moviment.getFila() > 2 || moviment.getFila() < 0 || moviment.getColumna() > 2
                || moviment.getColumna() < 0 || this.validarCasillaBuida(moviment) == false);
    }

}
