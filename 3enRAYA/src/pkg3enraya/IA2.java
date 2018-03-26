package pkg3enraya;

public class IA2 extends IA1 {

    public IA2(String nombre) {
        super(nombre);
    }

    private Moviment getColumnaGuanyadora(int fitxa) {
        Moviment moviment = null;

        for (int c = 0; c < 3; c++) {
            if (this.taulell.getCasilla(0, c) == fitxa 
                    && this.taulell.getCasilla(1, c) == fitxa 
                    && this.taulell.getCasilla(2, c) == -1) {
                moviment = new Moviment(this, 2, c);
                return moviment; // ===========================================>
            }
            if (this.taulell.getCasilla(0, c) == fitxa 
                    && this.taulell.getCasilla(2, c) == fitxa 
                    && this.taulell.getCasilla(1, c) == -1) {
                moviment = new Moviment(this, 1, c);
                return moviment; // ===========================================>
            }
            if (this.taulell.getCasilla(1, c) == fitxa 
                    && this.taulell.getCasilla(2, c) == fitxa 
                    && this.taulell.getCasilla(0, c) == -1) {
                moviment = new Moviment(this, 0, c);
                return moviment; // ===========================================>
            }
        }

        return moviment;
    }

    private Moviment getDiagonalGuanyadora(int fitxa) {
        Moviment moviment = null;

        if (this.taulell.getCasilla(0, 0) == fitxa 
                && this.taulell.getCasilla(1, 1) == fitxa 
                && this.taulell.getCasilla(2, 2) == -1) {
            moviment = new Moviment(this, 2, 2);
            return moviment; // ===============================================>
        }

        if (this.taulell.getCasilla(0, 0) == fitxa 
                && this.taulell.getCasilla(2, 2) == fitxa 
                && this.taulell.getCasilla(1, 1) == -1) {
            moviment = new Moviment(this, 1, 1);
            return moviment; // ===============================================>
        }

        if (this.taulell.getCasilla(1, 1) == fitxa 
                && this.taulell.getCasilla(2, 2) == fitxa 
                && this.taulell.getCasilla(0, 0) == -1) {
            moviment = new Moviment(this, 0, 0);
            return moviment; // ===============================================>
        }

        if (this.taulell.getCasilla(0, 2) == fitxa 
                && this.taulell.getCasilla(1, 1) == fitxa 
                && this.taulell.getCasilla(2, 0) == -1) {
            moviment = new Moviment(this, 2, 0);
            return moviment; // ===============================================>
        }

        if (this.taulell.getCasilla(0, 2) == fitxa 
                && this.taulell.getCasilla(2, 0) == fitxa 
                && this.taulell.getCasilla(1, 1) == -1) {
            moviment = new Moviment(this, 1, 1);
            return moviment; // ===============================================>
        }

        if (this.taulell.getCasilla(1, 1) == fitxa 
                && this.taulell.getCasilla(2, 0) == fitxa 
                && this.taulell.getCasilla(0, 2) == -1) {
            moviment = new Moviment(this, 0, 2);
            return moviment; // ===============================================>
        }

        return moviment;
    }
    
    private Moviment getFilaGuanyadora(int fitxa) {
        Moviment moviment = null;

        for (int f = 0; f < 3; f++) {
            if (this.taulell.getCasilla(f, 0) == fitxa 
                    && this.taulell.getCasilla(f, 1) == fitxa 
                    && this.taulell.getCasilla(f, 2) == -1) {
                moviment = new Moviment(this, f, 2);
                return moviment; // ===========================================>
            }
            if (this.taulell.getCasilla(f, 0) == fitxa 
                    && this.taulell.getCasilla(f, 2) == fitxa 
                    && this.taulell.getCasilla(f, 1) == -1) {
                moviment = new Moviment(this, f, 1);
                return moviment; // ===========================================>
            }
            if (this.taulell.getCasilla(f, 1) == fitxa 
                    && this.taulell.getCasilla(f, 2) == fitxa 
                    && this.taulell.getCasilla(f, 0) == -1) {
                moviment = new Moviment(this, f, 0);
                return moviment; // ===========================================>
            }
        }

        return moviment;
    }
    
    public Moviment getMovimentGuanyador(int fitxa) {        
        if (this.getFilaGuanyadora(fitxa) != null) {
            return this.getFilaGuanyadora(fitxa); // ==========================>
        }
        
        if (this.getColumnaGuanyadora(fitxa) != null) {
            return this.getColumnaGuanyadora(fitxa); // =======================>
        }
        
        return this.getDiagonalGuanyadora(fitxa);
    }

    @Override
    public Moviment moviment() {
        Moviment moviment = this.getMovimentGuanyador(super.getTorn());
        if (moviment == null) {
            moviment = this.calcularMillorMoviment();
        }
        
        return moviment;
    }
}
