import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String inputData = JOptionPane.showInputDialog("Informe a data no formato DD/MM/AAAA:");

        //verifica se o usuario fez a entrada dividindo em 3 barras
        String[] partes = inputData.split("/");
        if (partes.length != 3) {
            JOptionPane.showMessageDialog(null, "Formato de data inválido. O formato correto é DD/MM/AAAA.");
            return;
        }

        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int ano = Integer.parseInt(partes[2]);

        Data data = new Data(dia, mes, ano);

        //verificar se o ano e bissexto
        String bissexto = data.validaBissexto(ano) ? "Sim" : "Não";

        String mensagem = "Data informada: " + data.getDia() + "/" + data.getMes() + "/" + data.getAno() + "\n" +
                "Mês por extenso: " + data.getMesExtenso() + "\n" +
                "Ano bissexto: " + bissexto;

        JOptionPane.showMessageDialog(null, mensagem);
    }
}
