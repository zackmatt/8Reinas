//Transcribiendo el programa en python, No me sale aún...
class ochoReinas {
    final int filaColumna = 8;
    int[] reinas = new int[9];
    boolean solucion;

    public boolean solucionReinas() {
        solucion = false;
        colocarReina(1);
        return solucion;
    }

    private void colocarReina(int i_reina) {
        int fila = 0; // inicializa posibles movimientos en la fila 
        do {
            fila++; //omitir fila 0 con el incremento
            reinas[i_reina] = fila; // prueba a colocar reina i_reina en fila 1,
            // a la vez queda anotado el movimiento
            if (validarPosicion(i_reina)) {
                if (i_reina < filaColumna){
                    colocarReina(i_reina + 1);
                    // backtraking
                    if (!solucion) {
                        reinas[i_reina] = 0;
                    }
                } else // todas las reinas colocadas
                {
                    solucion = true;
                    System.out.println("Tablero de Ajedrez");
                }
                int reina = reinas[i_reina];
                ochoReinas id = new ochoReinas();
                id.dibujarAjedrez(reina);
            }
        } while (!solucion && (fila < 8));
    }

    public void dibujarAjedrez(int reina){
        //dibuja la tabla de ajedrez y colocando las reinas una en cada columna
        int dibujar = reina;
        if(dibujar >= 0){
            switch (dibujar){
                case 1: System.out.println("["+ dibujar +"]"+"[ "+"]"+"[ "+"]"+"[ "+"]"+"[ "+"]"+"[ "+"]"+"[ "+"]"+"[ "+"]");
                    break;
                case 2: System.out.println("[ "+"]"+"["+dibujar+"]"+"[ "+"]"+"[ "+"]"+"[ "+"]"+"[ "+"]"+"[ "+"]"+"[ "+"]");
                    break;
                case 3: System.out.println("[ "+"]"+"[ "+"]"+"["+dibujar +"]"+"[ "+"]"+"[ "+"]"+"[ "+"]"+"[ "+"]"+"[ "+"]");
                    break;
                case 4: System.out.println("[ "+"]"+"[ "+"]"+"[ "+"]"+"["+dibujar+"]"+"[ "+"]"+"[ "+"]"+"[ "+"]"+"[ "+"]");
                    break;
                case 5: System.out.println("[ "+"]"+"[ "+"]"+"[ "+"]"+"[ "+"]"+"["+dibujar+"]"+"[ "+"]"+"[ "+"]"+"[ "+"]");
                    break;
                case 6: System.out.println("[ "+"]"+"[ "+"]"+"[ "+"]"+"[ "+"]"+"[ "+"]"+"["+dibujar+"]"+"[ "+"]"+"[ "+"]");
                    break;
                case 7: System.out.println("[ "+"]"+"[ "+"]"+"[ "+"]"+"[ "+"]"+"[ "+"]"+"[ "+"]"+"["+dibujar+"]"+"[ "+"]");
                    break;
                case 8: System.out.println("[ "+"]"+"[ "+"]"+"[ "+"]"+"[ "+"]"+"[ "+"]"+"[ "+"]"+"[ "+"]"+"["+dibujar+"]");
                    break;
                default:
                    break;
            }
        }else{
            System.out.print(" ");
        }
    }
    
    private boolean validarPosicion(int i_reina) {
        /* Verifica si alguna reina de la columna i_reina es atacada por
         alguna reina colocada anteriormente */
        int r;
        boolean libre;
        libre = true;
        for (r = 1; r <= i_reina - 1; r++) {
            // No esté en la misma fila
            libre = libre && (reinas[i_reina] != reinas[r]);
            // No esté en alguna de las dos diagonales
            libre = libre && ((i_reina + reinas[i_reina]) != (r + reinas[r]));
            libre = libre && ((i_reina - reinas[i_reina]) != (r - reinas[r]));
        }
        return libre;
    }

    public static void main(String[] a) {
        ochoReinas reina = new ochoReinas();
        reina.solucionReinas();
    }
}
