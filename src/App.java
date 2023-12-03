import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) {
        while (true) {
            // Instanciando objetos para as operações de conversão
            CorParaValor corParaValor = new CorParaValor();
            ValorParaCor valorParaCor = new ValorParaCor();

            // Opções do menu
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

            // Tomando ação com base na escolha do usuário
            if (choice == 0) {
                corParaValor.corParaValor(); // Chamando o método de conversão de cor para valor
            } else if (choice == 1) {
                valorParaCor.valorParaCor(); // Chamando o método de conversão de valor para cor
            } else {
                break; // Saindo do loop se a opção for "Sair"
            }
        }
    }
}