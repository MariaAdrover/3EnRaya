package pkg3enraya;

public class Taulell {

    // 0 ----> BLANCAS
    // 1 ----> NEGRAS
    // -1 ----> casilla libre
    private int[][] caselles;
    private Partida partida;

    public Taulell(Partida partida) {
        this.caselles = new int[3][3];
        this.partida = partida;

        for (int f = 0; f < 3; f++) {
            for (int c = 0; c < 3; c++) {
                this.caselles[f][c] = -1;
            }
        }
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

    public int comprovarGuanyadorColumnes() {
        // Comprovar ses columnes
        for (int c = 0; c < 3; c++) {
            if ((this.caselles[0][c] != -1) && (this.caselles[0][c] == this.caselles[1][c])
                    && (this.caselles[1][c] == this.caselles[2][c])) {
                return this.caselles[0][c];
            }
        }

        return -1;
    }

    public int comprovarGuanyadorDiagonals() {
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

    public int comprovarGuanyadorFiles() {
        // Comprovar ses files
        for (int f = 0; f < 3; f++) {
            if ((this.caselles[f][0] != -1) && (this.caselles[f][0] == this.caselles[f][1])
                    && (this.caselles[f][1] == this.caselles[f][2])) {
                return this.caselles[f][0];
            }
        }

        return -1;
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

    public int[] getCasillaLibre() { // Es millor que retorni directament un moviment?
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

    // Devuelve un movimiento ganador, de un jugador o de su contrario
    // fitxaIA = true: nos devuelve un movimiento ganador, si lo hay, mirando las fichas del jugador que le pasamos
    // fitxaIA = false: comprueba si el contrario tiene un movimiento ganador, mirando las fichas del jugador 
    //                  contrario al que le pasamos, y nos devuelve el movimiento que lo bloquea
    public Moviment getMovimentGuanyador(Jugador j, boolean fitxaIA) {
        Moviment moviment;
        int fitxa;

        if (fitxaIA) {
            fitxa = j.getTorn();
        } else {
            if (j.getTorn() == 0) {
                fitxa = 1;
            } else {
                fitxa = 0;
            }            
        }
        
        moviment = this.getFilaGuanyadora(j, fitxa);
        if (moviment == null) {
            moviment = this.getColumnaGuanyadora(j, fitxa);
            if (moviment == null) {
                moviment = this.getDiagonalGuanyadora(j, fitxa);
            }
        }

        return moviment;
    }
    
    public Moviment getFilaGuanyadora(Jugador j, int fitxa) {
        Moviment moviment = null;

        for (int f = 0; f < this.caselles.length; f++) {
            if (this.caselles[f][0] == fitxa && (this.caselles[f][0] == this.caselles[f][1]) && this.caselles[f][2] == -1) {
                moviment = new Moviment(j, f, 2);
                return moviment;
            }
            if (this.caselles[f][0] == fitxa && (this.caselles[f][0] == this.caselles[f][2]) && this.caselles[f][1] == -1) {
                moviment = new Moviment(j, f, 1);
                return moviment;
            }
            if (this.caselles[f][1] == fitxa && (this.caselles[f][1] == this.caselles[f][2]) && this.caselles[f][0] == -1) {
                moviment = new Moviment(j, f, 0);
                return moviment;
            }
        }

        return moviment;
    }

    public Moviment getColumnaGuanyadora(Jugador j, int fitxa) {
        Moviment moviment = null;

        for (int c = 0; c < this.caselles.length; c++) {
            if (this.caselles[0][c] == fitxa && (this.caselles[0][c] == this.caselles[1][c]) && this.caselles[2][c] == -1) {
                moviment = new Moviment(j, 2, c);
                return moviment;
            }
            if (this.caselles[0][c] == fitxa && (this.caselles[0][c] == this.caselles[2][c]) && this.caselles[1][c] == -1) {
                moviment = new Moviment(j, 1, c);
                return moviment;
            }
            if (this.caselles[1][c] == fitxa && (this.caselles[1][c] == this.caselles[2][c]) && this.caselles[0][c] == -1) {
                moviment = new Moviment(j, 0, c);
                return moviment;
            }
        }

        return moviment;
    }

    public Moviment getDiagonalGuanyadora(Jugador j, int fitxa) {
        Moviment moviment = null;

        if (this.caselles[0][0] == fitxa && (this.caselles[0][0] == this.caselles[1][1]) && this.caselles[2][2] == -1) {
            moviment = new Moviment(j, 2, 2);
            return moviment;
        }

        if (this.caselles[0][0] == fitxa && (this.caselles[0][0] == this.caselles[2][2]) && this.caselles[1][1] == -1) {
            moviment = new Moviment(j, 1, 1);
            return moviment;
        }

        if (this.caselles[1][1] == fitxa && (this.caselles[1][1] == this.caselles[2][2]) && this.caselles[0][0] == -1) {
            moviment = new Moviment(j, 0, 0);
            return moviment;
        }

        if (this.caselles[0][2] == fitxa && (this.caselles[0][2] == this.caselles[1][1]) && this.caselles[2][0] == -1) {
            moviment = new Moviment(j, 2, 0);
            return moviment;
        }

        if (this.caselles[0][2] == fitxa && (this.caselles[0][2] == this.caselles[2][0]) && this.caselles[1][1] == -1) {
            moviment = new Moviment(j, 1, 1);
            return moviment;
        }

        if (this.caselles[1][1] == fitxa && (this.caselles[1][1] == this.caselles[2][0]) && this.caselles[0][2] == -1) {
            moviment = new Moviment(j, 0, 2);
            return moviment;
        }

        return moviment;
    }
    
    // Revisar
    // Nombre
    // No mostrar sempre la mateixa info
    public void mostrarTaulell(String nombre, int turno) {
        System.out.println("");
        System.out.println("**********************");
        System.out.println("Jugada nº " + turno);
        System.out.println("Mueve: " + nombre); // TO DO 
        System.out.println("");
        System.out.println(this.partida.getNomBlanques() + " ----> O");
        System.out.println(this.partida.getNomNegres() + " ----> X");
        System.out.println("");
        System.out.println("    1 2 3");
        System.out.println("    - - -");
        for (int i = 0; i < 3; i++) {
            System.out.print(" " + (i + 1) + "|");
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
        System.out.println("");
    }

    public void moure(Moviment moviment) {
        if (moviment.getBlancas()) {
            this.caselles[moviment.getFila()][moviment.getColumna()] = 0;
        } else {
            this.caselles[moviment.getFila()][moviment.getColumna()] = 1;
        }
    }

    public boolean validarCasillaBuida(Moviment moviment) {

        return (this.caselles[moviment.getFila()][moviment.getColumna()] == -1);
    }

    // Per verificar que la casella està buida per IA1, pero passant-li la fila i la columna del taulell
    public boolean validarCasillaBuida(int fila, int columna) {

        return this.caselles[fila][columna] == -1;
    }

    public boolean validarMovimiento(Moviment moviment) {

        return !(moviment.getFila() > 2 || moviment.getFila() < 0 || moviment.getColumna() > 2
                || moviment.getColumna() < 0 || this.validarCasillaBuida(moviment) == false);
    }

}
