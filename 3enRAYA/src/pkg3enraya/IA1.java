package pkg3enraya;

public class IA1 extends IA0 {
    private int[][] caselles;
 
    public IA1(String nombre){
        super(nombre);
        this.caselles = new int[][]{
            {3,2,3},
            {2,4,2},
            {3,2,3}
        };
    }
    
    public Moviment calcularMillorMoviment() {
        int[] casella = new int[2];
        int valorCasella;
        int millorValor = 0;
        Moviment moviment;
        
        for (int f = 0; f < this.caselles.length; f++){
            for (int c = 0; c < this.caselles[0].length; c++) {
                if (this.taulell.validarCasillaBuida(f, c)){ 
                    valorCasella = this.caselles[f][c];
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
        d = Math.random() * 10;
        i = (int) d;
        canviar = i < 5;

        return canviar;
    }
            
    @Override
    public Moviment moviment() {
        return this.calcularMillorMoviment();
    }
}
