public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        if (validaData(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            this.dia = 1;
            this.mes = 1;
            this.ano = 1;
        }
    }

    //metodo para verificar se a data e valida
    private boolean validaData(int dia, int mes, int ano) {
        //verifica se o ano é positivo
        if (ano <= 0) {
            return false;
        }

        //verifica se o mês está dentro do intervalo valido (1 a 12)
        if (mes < 1 || mes > 12) {
            return false;
        }

        //verifica se o dia está dentro do intervalo valido para cada mês
        if (dia < 1 || dia > diasEmMes(mes, ano)) {
            return false;
        }

        return true;
    }

    //metodo para obter o numero de dias em um mes especifico
    private int diasEmMes(int mes, int ano) {
        switch (mes) {
            case 2:
                return validaBissexto(ano) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    //verifica se um ano é bissexto
    public boolean validaBissexto(int ano) {
        return (ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0));
    }

    public int compara(Data outraData) {
        if (this.ano != outraData.ano) {
            return this.ano > outraData.ano ? 1 : -1;
        } else if (this.mes != outraData.mes) {
            return this.mes > outraData.mes ? 1 : -1;
        } else if (this.dia != outraData.dia) {
            return this.dia > outraData.dia ? 1 : -1;
        } else {
            return 0;
        }
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public String getMesExtenso() {
        String[] meses = {
                "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
                "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
        };
        return meses[mes - 1];
    }

    public int getAno() {
        return ano;
    }
}
