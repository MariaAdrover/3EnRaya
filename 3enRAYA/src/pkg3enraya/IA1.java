package pkg3enraya;

public class IA1 extends IA0 {

    private int[][] caselles;

    public IA1(String nombre) {
        super(nombre);
        this.caselles = new int[][]{
            {3, 2, 3},
            {2, 4, 2},
            {3, 2, 3}
        };
    }
    
    /* Mètode utilitzat per la IA2 i la IA3 per poder accedir a l'atribut privat 
       caselles[][] de la IA1 per calcular el millor moviment */
    public Moviment calcularMillorMoviment(){
        return this.calcularMillorMoviment(this.caselles);
    }

    public Moviment calcularMillorMoviment(int estrategia[][]) {
        int[] casella = new int[2];
        int valorCasella;
        // millorValor ha de ser -1 perque no es doni el cas de que quan la IA4 
        // utilitza el mètode, si només queda una casella amb valor 0 
        // (IA4 utilitza com a paràmetre un array amb tots els valors a 0) 
        // si no entra a cap dels if. el moviment es crearia seria a la casella [0][0]
        int millorValor = -1; // Veure documentació
        Moviment moviment;

        for (int f = 0; f < this.caselles.length; f++) {
            for (int c = 0; c < this.caselles[0].length; c++) {
                Moviment mov = new Moviment(this, f, c);
                if (this.taulell.validarCasillaBuida(mov)) {
                    valorCasella = estrategia[f][c];
                    if (valorCasella > millorValor) {
                        casella[0] = f;
                        casella[1] = c;
                        millorValor = valorCasella;
                    } else if ((valorCasella == millorValor) && this.canviarCasella()) {
                        casella[0] = f;
                        casella[1] = c;
                    }
                }
            }
        }
        moviment = new Moviment(this, casella[0], casella[1]);

        return moviment;
    }

    public boolean canviarCasella() {
        boolean canviar;
        double d;
        int i;
        d = Math.random() * 100;
        i = (int) d;
        canviar = i < 50;

        return canviar;
    }

    @Override
    public Moviment moviment() {
        return this.calcularMillorMoviment(this.caselles);
    }

}
