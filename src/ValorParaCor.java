import javax.swing.JOptionPane;

public class ValorParaCor {

    private double TOLERANCIA_PADRAO = 5.0;
    private Faixas faixas = new Faixas();

    // Método principal para converter valor de resistência em faixas de cores
    public void valorParaCor() {
        // Obtendo o valor da resistência do usuário
        String resistenciaStr = obterValor("Digite o valor da resistência em ohms:");
        if (resistenciaStr == null) {
            JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário. Saindo...");
            return;
        }

        // Convertendo a resistência para faixas de cores
        try {
            double resistencia = Double.parseDouble(resistenciaStr);
            String[] faixasDeCores = converterResistenciaParaCores(resistencia);
            exibirFaixasDeCores(resistencia, faixasDeCores, TOLERANCIA_PADRAO);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro: Valor da resistência não é um número válido.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }

    // Método privado para obter o valor da resistência digitado pelo usuário
    private String obterValor(String mensagem) {
        try {
            String resistenciaStr = JOptionPane.showInputDialog(null, mensagem, "Digite o Valor da Resistência",
                    JOptionPane.PLAIN_MESSAGE);

            // Verificar se o usuário pressionou "Cancelar" ou deixou em branco
            if (resistenciaStr == null || resistenciaStr.trim().isEmpty()) {
                return null;
            }

            return resistenciaStr;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao obter valor da resistência: " + e.getMessage());
            return null;
        }
    }

    // Método para converter o valor da resistência em faixas de cores
    private String[] converterResistenciaParaCores(double resistencia) {
        try {
            // Convertendo a resistência para um formato padronizado
            String resistenciaFormatada = String.format("%.2f", resistencia);

            // Obtendo os dígitos do valor da resistência
            char[] digitos = resistenciaFormatada.toCharArray();
            String cor1 = faixas.setCorPeloValor(Character.getNumericValue(digitos[0]));
            String cor2 = faixas.setCorPeloValor(Character.getNumericValue(digitos[1]));

            // Obtendo a faixa de multiplicação
            int expoente = digitos.length - 3;
            if (expoente < 0) expoente = 0;  // Para valores como 0.01
            String cor3 = faixas.setCorPeloValor(expoente);

            return new String[]{cor1, cor2, cor3};
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Erro ao converter resistência para cores: " + e.getMessage());
        }
    }

    // Método para exibir as faixas de cores
    private void exibirFaixasDeCores(double resistencia, String[] faixasDeCores, double tolerancia) {
        JOptionPane.showMessageDialog(null, String.format(
                "O valor da resistência é: %.2f ohms\n" +
                        "As faixas de cores do resistor são: %s, %s, %s, Dourado\n" +
                        "A tolerância do resistor é: %.0f%%",
                resistencia, faixasDeCores[0], faixasDeCores[1], faixasDeCores[2], tolerancia));
    }
}