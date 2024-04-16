public class NumeroInteiro {
    private int numero;

    public NumeroInteiro() {
        this.numero = 0;
    }

    public NumeroInteiro(int numero) {
        this.numero = numero;
    }

    public void soma(int outroNumero) {
        this.numero += outroNumero;
    }

    public void subtrai(int outroNumero) {
        this.numero -= outroNumero;
    }

    public boolean isPrimo() {
        if (this.numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(this.numero); i++) {
            if (this.numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int getNextPrimo() {
        int candidato = this.numero + 1;
        while (true) {
            if (new NumeroInteiro(candidato).isPrimo()) {
                return candidato;
            }
            candidato++;
        }
    }

    public int getNumero() {
        return this.numero;
    }
}
