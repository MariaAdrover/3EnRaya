package pkg3enraya;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TresEnRaya {
    
    public static void mostrarInstrucciones() {
        System.out.println("*********************************************************************************");
        System.out.println("*                                  3 EN RAYA                                    *");
        System.out.println("*********************************************************************************");
        System.out.println("*                                                                               *");
        System.out.println("*                                INSTRUCCIONES                                  *");
        System.out.println("*                                -------------                                  *");
        System.out.println("*                                                                               *");
        System.out.println("*                         No muevas fuera del tablero                           *");
        System.out.println("*                      No muevas en una casilla ocupada                         *");
        System.out.println("* Si mueves fuera del tablero o en una casilla ocupada perderás automáticamente *");
        System.out.println("*                                                                               *");
        System.out.println("*********************************************************************************");
    }

    public static void main(String[] args) {
        TresEnRaya.mostrarInstrucciones();
        Sessio sesion = new Sessio();
        String hora = sesion.consultarHora();
        sesion.setHoraInici(hora);
        sesion.iniciarSessio();     
    }
}
