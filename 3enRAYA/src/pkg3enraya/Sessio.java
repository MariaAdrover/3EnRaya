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
                jugadorIA = new IA0("IA0");
                break;
            case 1:
                jugadorIA = new IA1("IA1");
                break;
            case 2:
                jugadorIA = new IA2("IA2");
                break;
            case 3:
                jugadorIA = new IA3("IA3");
                break;
            case 4:
                jugadorIA = new IA4("IA4");
                break;
            default:
                jugadorIA = new IA4("IA4");
                System.out.println("");
                System.out.println("------------------------ Jugarás en el nivel más difícil :-) --------------------");
                System.out.println("");
                break;
        }

        return jugadorIA;
    }

    private Partida crearPartida(Jugador j1, Jugador j2) {
        Partida p = new Partida(this.ranking, j1, j2);
        this.partida = p;

        return p;
    }

    private void mostrarDespedida() {
        System.out.println("");
        System.out.println("");
        System.out.println("                      ************************************");
        System.out.println("                      *        ¡Hasta la próxima!        *");
        System.out.println("                      ************************************");

        for (int i = 0; i < 10; i++) {
            System.out.println("                      *            Adioooooooos          *");
        }
        System.out.println("                      ************************************");
    }

    private void mostrarTorn(boolean blanques) {
        if (blanques) {
            System.out.println("");
            System.out.println("*********************************************************************************");
            System.out.println("*                   Te ha tocado jugar con blancas. Empiezas tú.                *");
            System.out.println("*********************************************************************************");
        } else {
            System.out.println("");
            System.out.println("*********************************************************************************");
            System.out.println("*                   Te ha tocado jugar con negras. Empieza la CPU.              *");
            System.out.println("*********************************************************************************");
        }
    }

    private void prepararPartida() {
        boolean iaCreada = false;
        int nivellIA;

        // Triar nivell de dificultat i crear IA
        while (!iaCreada) {
            try {
                nivellIA = this.triarDificultat();
                this.jugadors[1] = this.crearIA(nivellIA);
                iaCreada = true;
            } catch (InputMismatchException e) {
                System.out.println("");
                System.out.println("-------------------- HAS DE PULSAR UN NÚMERO: 0, 1, 2, 3 o 4 --------------------");
                System.out.println("");
            }
        }

        // Fer sorteig i crear partida
        if (this.sorteigTorn()) {
            this.mostrarTorn(true);
            this.partida = this.crearPartida(this.jugadors[0], this.jugadors[1]); // Es necessari fer un setter?
        } else {
            this.mostrarTorn(false);
            this.partida = this.crearPartida(this.jugadors[1], this.jugadors[0]);
        }
        
        // Asignar el torn que correspon a cada jugador
        this.partida.setTurnos();
        // Millor aqui, en crearPartida, en el constructor de Partida
        // o directament fent setTorn a cada Jugador, llevant el mètode setTurnos de Partida?
    }

    // Si torna true el jugador humà durà ses blanques
    private boolean sorteigTorn() {
        boolean blancas;
        double d;
        int i;
        d = Math.random() * 10;
        i = (int) d;
        blancas = i < 5;

        return blancas;
    }

    private int triarDificultat() {
        int nivellIA;
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
        nivellIA = sc.nextInt();

        return nivellIA;
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
        System.out.print("                        Elige una opción: 1, 2 o 3 --> ");

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
        boolean sortir = false;

        while (!sortir) {

            try {
                int opcion = this.verMenu();

                switch (opcion) {
                    case 1:
                        this.prepararPartida();
                        this.partida.jugar(); // Millor aquí o en prepararPartida()?
                        break;
                    case 2:
                        this.ranking.mostrarRanking();
                        break;
                    case 3:
                        this.mostrarDespedida();
                        sortir = true;
                        break;
                    default:
                        System.out.println("");
                        System.out.println("----------------------------- Opció desconeguda!!! -------------------------------");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("");
                System.out.println("----------------------- HAS DE PULSAR UN NÚMERO: 1, 2 o 3 -----------------------");
                System.out.println("");
            }
        }
    }

    public void setHoraInici(String hora) {
        if (this.horaInici == null) {
            this.horaInici = hora;
        }
    }
}
