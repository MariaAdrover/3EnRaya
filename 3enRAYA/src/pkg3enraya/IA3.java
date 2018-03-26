package pkg3enraya;

public class IA3 extends IA2 {

    public IA3(String nombre) {
        super(nombre);
    }

    @Override
    public Moviment moviment() {        
        if (this.getMovimentGuanyador(super.getTorn()) != null) {
            return this.getMovimentGuanyador(super.getTorn()); // =============>
        }
        
        if (this.getMovimentGuanyador(this.getAdversari()) != null) {
            return this.getMovimentGuanyador(this.getAdversari()); // =========>
        }

        return this.calcularMillorMoviment();
    }

}
