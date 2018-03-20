package pkg3enraya;

public class Partida {

    private int jugadaActual;
    private Jugador[] jugadors;
    private Ranking ranking;
    private Sessio sessio;
    private Taulell taulell;

    public Partida(Sessio s, Ranking r, Jugador j1, Jugador j2) {
        this.sessio = s;
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
        this.taulell = new Taulell(this);
    }

    private void gestionarGuanyador(int tornActual) {
        this.taulell.mostrarTaulell(jugadors[tornActual].getNom(), jugadaActual);
        this.mostrarGuanyador(tornActual);
        this.ranking.guanyar(this.jugadors[tornActual]);
    }

    private void gestionarMovimentIncorrecte(int tornActual) {
        System.out.println("El movimiento propuesto no es válido.");
        if (tornActual == 0) {
            this.mostrarGuanyador(1);
            this.ranking.guanyar(this.jugadors[1]);
        } else {
            this.mostrarGuanyador(0);
            this.ranking.guanyar(this.jugadors[0]);
        }
    }

    private void gestionarTablas(int tornActual) {
        this.taulell.mostrarTaulell(jugadors[tornActual].getNom(), jugadaActual);
        System.out.println("************************************");
        System.out.println("  No hay más movimientos posibles.");
        System.out.println(" La partida ha terminado en tablas.");
        System.out.println("************************************");
        System.out.println("");
        this.ranking.empatar();
    }

    private void mostrarGuanyador(int guanyador) {
        System.out.println("************************************");
        System.out.println("El ganador de la partida es " + this.jugadors[guanyador].getNom());
        System.out.println("************************************");
        System.out.println("");
    }

    public String getNomBlanques() {
        return this.jugadors[0].getNom();
    }

    public String getNomNegres() {
        return this.jugadors[1].getNom();
    }

    public void jugar() {
        boolean finPartida = false;
        int tornActual;
        Moviment moviment;

        while (!finPartida) {
            // Actualitzar torn
            tornActual = (jugadaActual + 1) % 2;
            this.taulell.mostrarTaulell(jugadors[tornActual].getNom(), jugadaActual);
            // Sol·licitar moviment
            moviment = jugadors[tornActual].moviment();
            moviment.setBlancas(tornActual == 0);
            
            // Puedo usar continue?
            if (this.taulell.validarMovimiento(moviment)) {
                this.taulell.moure(moviment);
                if ((this.taulell.comprovarGuanyador() == -1)) {
                    if (this.taulell.comprovarPle()) {
                        finPartida = true;
                        this.gestionarTablas(tornActual);
                    } else {
                        jugadaActual++;
                    }
                } else {
                    finPartida = true;
                    this.gestionarGuanyador(tornActual);
                }
            } else {
                finPartida = true;
                this.gestionarMovimentIncorrecte(tornActual);
            }
        }

        this.sessio.iniciarSessio();
    }

    public void setTurnos() {
        this.jugadors[0].setTorn(0);
        this.jugadors[1].setTorn(1);
    }
}
