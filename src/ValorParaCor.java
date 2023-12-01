import javax.swing.JOptionPane;

public class ValorParaCor {

    private Faixas faixas = new Faixas();
    private double TOLERANCIA_PADRAO = 5.0;

    // Método principal para converter valor de resistência em cores
    public void valorParaCor() {
        // Obtendo o valor da resistência
        String valorResistenciaStr = obterValorResistencia("Digite o valor da resistência (ex: 123):");

        // Verificar se o usuário pressionou "Cancelar" ou deixou em branco
        if (valorResistenciaStr == null || valorResistenciaStr.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário ou valor em branco. Saindo...");
            return;
        }

        // Convertendo o valor da resistência para cores
        try {
            String[] cores = converterValorParaCores(valorResistenciaStr);

            // Exibindo uma caixa de diálogo com as cores associadas ao valor da resistência
            exibirFaixasDeCores(cores);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }

    // Método para obter o valor da resistência
    private String obterValorResistencia(String mensagem) {
        return JOptionPane.showInputDialog(null, mensagem, "Digite o Valor da Resistência", JOptionPane.PLAIN_MESSAGE);
    }

    // Método para converter o valor da resistência para cores
    private String[] converterValorParaCores(String valorResistenciaStr) {
        // Validando se o valor da resistência é numérico
        try {
            int valorResistencia = Integer.parseInt(valorResistenciaStr);
            if (valorResistencia < 0 || valorResistencia > 999999999) {
                throw new IllegalArgumentException("Valor da resistência fora do intervalo permitido.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Valor da resistência inválido. Deve ser um número inteiro.");
        }

        // Obtendo cada dígito do valor da resistência
        char[] digitos = valorResistenciaStr.toCharArray();

        // Convertendo cada dígito para a cor correspondente
        String[] cores = new String[digitos.length];
        for (int i = 0; i < digitos.length; i++) {
            try {
                cores[i] = faixas.setCorPeloValor(Character.getNumericValue(digitos[i]));
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Erro ao converter dígito para cor: " + e.getMessage());
            }
        }

        return cores;
    }

    // Método privado para exibir as faixas de cores
    private void exibirFaixasDeCores(String[] cores) {
        JOptionPane.showMessageDialog(null, String.format(
                "As cores do resistor são: %s, %s, %s, Dourado\n A tolerância do resistor é: %.0f%%",
                cores[0], cores[1], cores[2], TOLERANCIA_PADRAO));
    }
}
