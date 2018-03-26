package pkg3enraya;

public class Partida {

    private int jugadaActual;
    private Jugador[] jugadors;
    private Ranking ranking;
    private Taulell taulell;

    public Partida(Ranking r, Jugador j1, Jugador j2) {
        this.ranking = r;
        this.crearTaulell();

        if (j1 instanceof IA0) {
            ((IA0) j1).setTaulell(this.taulell);
        } else {
            ((IA0) j2).setTaulell(this.taulell);
        }
        jugadors = new Jugador[2];
        this.addJugadores(j1, j2);

        this.jugadaActual = 1;
    }

    private void addJugadores(Jugador j1, Jugador j2) {
        this.jugadors[0] = j1;
        this.jugadors[1] = j2;
    }

    private void crearTaulell() {
        this.taulell = new Taulell();
    }

    private void gestionarGuanyador(int tornActual) {
        this.taulell.mostrarTaulell();
        this.mostrarGuanyador(tornActual);
        this.ranking.guanyar(this.jugadors[tornActual]);
    }

    private void gestionarMovimentIncorrecte(int torn) {
        int adversari = this.jugadors[torn].getAdversari();
        System.out.println("                     El movimiento propuesto no es válido.");
        this.mostrarGuanyador(adversari);
        this.ranking.guanyar(this.jugadors[adversari]);
    }

    private void gestionarTablas() {
        this.taulell.mostrarTaulell();
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("                        No hay más movimientos posibles.");
        System.out.println("                       La partida ha terminado en tablas.");
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("");
        this.ranking.empatar();
    }

    private void mostrarGuanyador(int guanyador) {
        System.out.println("");
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("                       El ganador de la partida es " + this.jugadors[guanyador].getNom());
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("");
    }

    private void mostrarInfoTorn(int torn) {
        System.out.println("");
        System.out.println("                              ______________________");
        System.out.println("");
        System.out.println("                                    Jugada nº " + this.jugadaActual);
        System.out.println("                                    Mueve: " + this.jugadors[torn].getNom());
        System.out.println("");
        System.out.println("                                    " + this.jugadors[0].getNom() + " ----> O");
        System.out.println("                                    " + this.jugadors[1].getNom() + " ----> X");
    }

    public void jugar() {
        boolean finPartida = false;
        int tornActual;
        Moviment moviment;

        while (!finPartida) {
            // Actualitzar torn
            tornActual = (this.jugadaActual + 1) % 2;
            this.mostrarInfoTorn(tornActual);
            this.taulell.mostrarTaulell();
            // Sol·licitar moviment
            moviment = jugadors[tornActual].moviment();
            moviment.setFitxa(tornActual);

            if (!this.taulell.validarMoviment(moviment)) {
                finPartida = true;
                this.gestionarMovimentIncorrecte(tornActual);
            } else {
                this.taulell.moure(moviment);
            }

            if (!finPartida && this.taulell.comprovarGuanyador() != -1) {
                finPartida = true;
                this.gestionarGuanyador(tornActual);
            }

            if (!finPartida && this.taulell.comprovarPle()) {
                finPartida = true;
                this.gestionarTablas();
            } else {
                this.jugadaActual++;
            }
        }
    }

    public void setTurnos() {
        this.jugadors[0].setTorn(0);
        this.jugadors[1].setTorn(1);
    }
}
