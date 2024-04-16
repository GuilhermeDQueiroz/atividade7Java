import java.util.Date;

class Voo {
    private int numeroVoo;
    private Date dataVoo;
    private boolean[] ocupacaoCadeiras;
    private int totalCadeiras;

    public Voo(int numeroVoo, Date dataVoo, int totalCadeiras) {
        this.numeroVoo = numeroVoo;
        this.dataVoo = dataVoo;
        this.totalCadeiras = totalCadeiras;
        this.ocupacaoCadeiras = new boolean[totalCadeiras];
    }

    public int proximoLivre() {
        for (int i = 0; i < totalCadeiras; i++) {
            if (!ocupacaoCadeiras[i]) {
                return i + 1;
            }
        }
        return -1;
    }

    public boolean verifica(int numeroCadeira) {
        if (numeroCadeira >= 1 && numeroCadeira <= totalCadeiras) {
            return ocupacaoCadeiras[numeroCadeira - 1];
        }
        return false;
    }

    public boolean ocupa(int numeroCadeira) {
        if (numeroCadeira >= 1 && numeroCadeira <= totalCadeiras) {
            if (!ocupacaoCadeiras[numeroCadeira - 1]) {
                ocupacaoCadeiras[numeroCadeira - 1] = true;
                return true; // Cadeira ocupada com sucesso
            }
        }
        return false;
    }

    public int vagas() {
        int vagasDisponiveis = 0;
        for (boolean ocupada : ocupacaoCadeiras) {
            if (!ocupada) {
                vagasDisponiveis++;
            }
        }
        return vagasDisponiveis;
    }

    public int getVoo() {
        return numeroVoo;
    }

    public Date getData() {
        return dataVoo;
    }
}
