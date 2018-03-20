package pkg3enraya;

public class IA2 extends IA1 {

    public IA2(String nombre) {
        super(nombre);
    }

    public Moviment intentarGuanyar() {        
        
        return this.taulell.getMovimentGuanyador(this, true);
    }

    @Override
    public Moviment moviment() {
        Moviment moviment = this.intentarGuanyar();
        if (moviment == null) {
            moviment = this.calcularMillorMoviment();
        }
        
        return moviment;
    }
}
