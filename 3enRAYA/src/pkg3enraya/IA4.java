package pkg3enraya;

public class IA4 extends IA3 {

    public IA4(String nombre) {
        super(nombre);
    }

    private void actualitzarColumnes(int adversari, int estrategia[][]) {
        for (int c = 0; c < 3; c++) {
            if (this.taulell.getCasilla(0, c) != adversari
                    && this.taulell.getCasilla(1, c) != adversari
                    && this.taulell.getCasilla(2, c) != adversari) {
                estrategia[0][c]++;
                estrategia[1][c]++;
                estrategia[2][c]++;
            }
        }
    }

    private void actualitzarDiagonals(int adversari, int estrategia[][]) {
        if (this.taulell.getCasilla(0, 0) != adversari
                && this.taulell.getCasilla(1, 1) != adversari
                && this.taulell.getCasilla(2, 2) != adversari) {
            estrategia[0][0]++;
            estrategia[1][1]++;
            estrategia[2][2]++;
        }
        if (this.taulell.getCasilla(0, 2) != adversari
                && this.taulell.getCasilla(1, 1) != adversari
                && this.taulell.getCasilla(2, 0) != adversari) {
            estrategia[0][2]++;
            estrategia[1][1]++;
            estrategia[2][0]++;
        }
    }

    private void actualitzarFiles(int adversari, int estrategia[][]) {
        for (int f = 0; f < 3; f++) {
            if (this.taulell.getCasilla(f, 0) != adversari
                    && this.taulell.getCasilla(f, 1) != adversari
                    && this.taulell.getCasilla(f, 2) != adversari) {
                estrategia[f][0]++;
                estrategia[f][1]++;
                estrategia[f][2]++;
            }
        }
    }

    private void actualitzarValorCaselles(int estrategia[][]) {
        this.actualitzarFiles(this.getAdversari(), estrategia);
        this.actualitzarColumnes(this.getAdversari(), estrategia);
        this.actualitzarDiagonals(this.getAdversari(), estrategia);
    }

    @Override
    public Moviment moviment() {
        int[][] estrategia;
        Moviment moviment;
        
        if ((moviment = this.getMovimentGuanyador(super.getTorn())) != null) {
            return this.getMovimentGuanyador(super.getTorn()); //==============>
        }

        if ((moviment = this.getMovimentGuanyador(this.getAdversari())) != null) {
            return this.getMovimentGuanyador(this.getAdversari()); // =========>
        }
        
        estrategia = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};        
        this.actualitzarValorCaselles(estrategia);        

        return this.calcularMillorMoviment(estrategia);
    }
}
