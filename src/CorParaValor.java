import javax.swing.JOptionPane;

public class CorParaValor {

    private double TOLERANCIA_PADRAO = 5.0;
    private Faixas faixas = new Faixas();

    // Método principal para converter cores em valor de resistência
    public void corParaValor() {
        // Obtendo as cores das três faixas do resistor
        String cor1 = obterCor("Escolha a cor da 1ª faixa:", "Marrom", "Vermelho", "Laranja", "Amarelo", "Verde", "Azul", "Violeta", "Cinza", "Branco");
        if (cor1 == null) {
            JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário. Saindo...");
            return;
        }

        String cor2 = obterCor("Escolha a cor da 2ª faixa:", "Preto", "Marrom", "Vermelho", "Laranja", "Amarelo", "Verde", "Azul", "Violeta", "Cinza", "Branco");
        if (cor2 == null) {
            JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário. Saindo...");
            return;
        }

        String cor3 = obterCor("Escolha a cor da 3ª faixa:", "Dourado", "Prata", "Preto", "Marrom", "Vermelho", "Laranja", "Amarelo", "Verde", "Azul", "Violeta", "Cinza", "Branco");
        if (cor3 == null) {
            JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário. Saindo...");
            return;
        }

        // Calcular o valor da resistência e exibir as faixas de cores
        try {
            double valorResistencia = calcularResistencia(cor1, cor2, cor3);
            exibirFaixasDeCores(cor1, cor2, cor3, valorResistencia, TOLERANCIA_PADRAO);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }

    // Método privado para obter a cor escolhida pelo usuário
    private String obterCor(String mensagem, String... opcoes) {
        try {
            String corEscolhida = (String) JOptionPane.showInputDialog(null, mensagem, "Escolha de Cor",
                    JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

            // Verificar se o usuário pressionou "Cancelar" ou deixou em branco
            if (corEscolhida == null || corEscolhida.trim().isEmpty()) {
                return null;
            }

            return corEscolhida;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao obter cor: " + e.getMessage());
            return null;
        }
    }

    // Método para calcular o valor da resistência
    private double calcularResistencia(String cor1, String cor2, String cor3) {
        try {
            // Obtendo os valores associados às cores
            String valor1 = faixas.setValorPelaCor(cor1);
            String valor2 = faixas.setValorPelaCor(cor2);
            double valor3 = faixas.setValorPelaCor3(cor3);

            // Atribuindo o valor da resistência à variável resistenciaCalculada
            double valorFinal = Double.parseDouble(valor1 + valor2) * valor3;
            return valorFinal;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Erro ao calcular resistência: Valor não é um número válido.");
        }
    }

    // Método para exibir as faixas de cores
    private void exibirFaixasDeCores(String cor1, String cor2, String cor3, double valorResistencia, double tolerancia) {
        JOptionPane.showMessageDialog(null, String.format(
                "As cores do resistor são: %s, %s, %s, Dourado\n" +
                        "O valor da resistência é: %.2f ohms\n" +
                        "A tolerância do resistor é: %.0f%%",
                cor1, cor2, cor3, valorResistencia, tolerancia));
    }
}
