import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) {
        while (true) {
            CorParaValor corParaValor = new CorParaValor();
            ValorParaCor valorParaCor = new ValorParaCor();
            String[] options = {"Cor para Valor", "Valor para Cor", "Sair"};
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Escolha uma opção:",
                    "Conversor de Resistor",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (choice == 0) {
                corParaValor.corParaValor();
            } else if (choice == 1) {
                valorParaCor.valorParaCor();
            } else {
                break;
            }
        }
    }
}