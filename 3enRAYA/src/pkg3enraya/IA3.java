package pkg3enraya;

public class IA3 extends IA2{

    public IA3(String nombre) {
        super(nombre);
    }
    
    public Moviment intentarNoPerdre() {
        
        return this.taulell.getMovimentGuanyador(this, false);        
    }

    @Override
    public Moviment moviment() {
        Moviment moviment = this.intentarGuanyar();
        if (moviment == null) {            
            moviment = this.intentarNoPerdre();
            if (moviment == null) {
                moviment = this.calcularMillorMoviment();
            }
        }
        
        return moviment;
    }
    
}
