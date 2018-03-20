package pkg3enraya;

import java.util.*;

public class Sessio {

    private String horaInici;
    private Jugador[] jugadors;
    private Partida partida;
    private Ranking ranking;

    public Sessio() {
        this.ranking = new Ranking();
        this.jugadors = new Jugador[2];
        this.jugadors[0] = this.crearHumano();
    }

    private Jugador crearHumano() {
        String nombre;
        Scanner opcioTriada = new Scanner(System.in);
        System.out.print("                         ¿Cuál es tu nombre? --> ");
        nombre = opcioTriada.next();
        Jugador humano = new Jugador(nombre);

        return humano;
    }

    private Jugador crearIA(int nivel) {
        Jugador jugadorIA = null;

        switch (nivel) {
            case 0:
                jugadorIA = new IA0("CPU");
                break;
            case 1:
                jugadorIA = new IA1("CPU");
                break;
            case 2:
                jugadorIA = new IA2("CPU");
                break;
            case 3:
                jugadorIA = new IA3("CPU");
                break;
            case 4:
                jugadorIA = new IA4("CPU");
                break;
            default:
                break;
        }

        return jugadorIA;
    }

    private Partida crearPartida(Jugador j1, Jugador j2) {
        Partida p = new Partida(this, this.ranking, j1, j2);
        this.partida = p;

        return p;
    }

    private void mostrarDespedida() {
        System.out.println("************************************");
        System.out.println("*        ¡Hasta la próxima!        *");
        System.out.println("************************************");

        for (int i = 0; i < 10; i++) {
            System.out.println("            Adioooooooos");
        }
        System.out.println("************************************");

    }

    private void mostrarRanking() {
        this.ranking.mostrarRanking();
        this.iniciarSessio();
    }

    private void nuevaPartida() {
        Partida partida;
        int dificultad;
        
        // Triar nivell de dificultat
        dificultad = this.triarDicicultat();
        this.jugadors[1] = this.crearIA(dificultad);

        if (this.sorteigTorn()) {
            System.out.println("                  Te ha tocado jugar con blancas. Empiezas tú.");
            partida = this.crearPartida(this.jugadors[0], this.jugadors[1]);
            this.partida.setTurnos(); // Mejor aqui o en crear partida??
        } else {
            System.out.println("                   Te ha tocado jugar con negras. Empieza la CPU.");
            partida = this.crearPartida(this.jugadors[1], this.jugadors[0]);
            this.partida.setTurnos(); // Mejor aqui o en crear partida??
        }
        System.out.println("                            ¡¡¡¡ Suerte !!!!");
        System.out.println("");
        partida.jugar();
    }

    // Devuelve true si tocan blancas
    private boolean sorteigTorn() {
        boolean blancas;
        double d;
        int i;
        d = Math.random() * 10;
        i = (int) d;
        blancas = i < 5;

        return blancas;
    }

    private int triarDicicultat() {
        int opcio;
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.println("                               NIVEL DE DIFICULTAD");
        System.out.println("                               -------------------");
        System.out.println("");
        System.out.println("                                 0 - Muy fácil");
        System.out.println("                                 1 - Fácil");
        System.out.println("                                 2 - Medio");
        System.out.println("                                 3 - Difícil");
        System.out.println("                                 4 - Muy difícil");
        System.out.println("");
        System.out.print("                         Elige el nivel de dificultad --> ");
        opcio = sc.nextInt();

        return opcio;
    }

    private int verMenu() {
        int opcion;
        Scanner opcioTriada;
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("*********************************************************************************");
        System.out.println("*                           Inicio de sesión: " + this.horaInici + "                             *");
        System.out.println("*********************************************************************************");
        System.out.println("*                                                                               *");
        System.out.println("*                                     MENU                                      *");
        System.out.println("*                                     ----                                      *");
        System.out.println("*                                                                               *");
        System.out.println("*                              1- Nueva partida                                 *");
        System.out.println("*                               2- Ver Ranking                                  *");
        System.out.println("*                              3- Cerrar sesión                                 *");
        System.out.println("*                                                                               *");
        System.out.println("*********************************************************************************");
        System.out.println("");
        System.out.print("                         Elige una opción: 1, 2 o 3 --> ");

        // Triar opció
        opcioTriada = new Scanner(System.in);
        opcion = opcioTriada.nextInt();

        return opcion;
    }

    public String consultarHora() {
        Calendar calendario = new GregorianCalendar();
        int horas, minutos;
        String horaS, minutosS, time;

        horas = calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        horaS = Integer.toString(horas);
        minutosS = Integer.toString(minutos);
        if (minutosS.length() == 1) {
            minutosS = "0" + minutosS;
        }
        time = horaS + "'" + minutosS;

        return time;
    }

    public void iniciarSessio() {
        int opcion = this.verMenu();

        switch (opcion) {
            case 1:
                this.nuevaPartida();
                break;
            case 2:
                this.mostrarRanking();
                break;
            case 3:
                this.mostrarDespedida();
                break;
            default:
                System.out.println("Opció desconeguda!!!");
                break;
        }
    }

    public void setHoraInici(String hora) {
        if (this.horaInici == null) {
            this.horaInici = hora;
        }
    }
}
