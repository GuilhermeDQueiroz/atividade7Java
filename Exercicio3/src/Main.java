import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        String inputHorario1 = solicitarHorario("Insira o primeiro horário no formato HH:MM:SS");
        Hora hora1 = new Hora(inputHorario1);

        String inputHorario2 = solicitarHorario("Insira o segundo horário no formato HH:MM:SS");
        Hora hora2 = new Hora(inputHorario2);

        int diferencaSegundos = hora1.compara(hora2);
        JOptionPane.showMessageDialog(null, "Diferença de segundos: " + diferencaSegundos);
    }

    private static String solicitarHorario(String mensagem) {
        String inputHorario;
        String[] formato;

        do {
            inputHorario = JOptionPane.showInputDialog(mensagem);
            if (inputHorario == null || inputHorario.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, insira um horário.");
                continue;
            }

            formato = inputHorario.split(":");
            if (formato.length != 3) {

                JOptionPane.showMessageDialog(null, "Por favor, insira o horário no formato correto (HH:MM:SS).");
                continue;
            }

            try {
                int horas = Integer.parseInt(formato[0]);
                int minutos = Integer.parseInt(formato[1]);
                int segundos = Integer.parseInt(formato[2]);


                if (horas < 0 || horas > 23 || minutos < 0 || minutos > 59 || segundos < 0 || segundos > 59) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos para horas, minutos e segundos.");
                    continue;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, insira valores numéricos para horas, minutos e segundos.");
                continue;
            }

            break;
        } while (true);

        return inputHorario;
    }
}
