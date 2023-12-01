public class Faixas {

    public String setValorPelaCor(String cor) {
        switch (cor) {
            // Mapeando cada cor para um valor numérico em String
            case "Preto":
                return "1";
            case "Marrom":
                return "1";
            case "Vermelho":
                return "2";
            case "Laranja":
                return "3";
            case "Amarelo":
                return "4";
            case "Verde":
                return "5";
            case "Azul":
                return "6";
            case "Violeta":
                return "7";
            case "Cinza":
                return "8";
            case "Branco":
                return "9";
            
            // Lançando uma exceção se a cor não estiver mapeada
            default:
                throw new IllegalArgumentException("Cor inválida: " + cor);
        }
    }

    public double setValorPelaCor3(String cor) {
        switch (cor) {
            // Mapeando cada cor para um valor numérico
            case "Preto":
                return 1.0;
            case "Marrom":
                return 10.0;
            case "Vermelho":
                return 100.0;
            case "Laranja":
                return 1000.0;
            case "Amarelo":
                return 10000.0;
            case "Verde":
                return 100000.0;
            case "Azul":
                return 1000000.0;
            case "Violeta":
                return 10000000.0;
            case "Cinza":
                return 100000000.0;
            case "Branco":
                return 1000000000.0;
            case "Dourado":
                return 0.1;
            case "Prata":
                return 0.01;
            // Lançando uma exceção se a cor não estiver mapeada
            default:
                throw new IllegalArgumentException("Cor inválida: " + cor);
        }
    }

    public String setCorPeloValor(int valor) {
        // Mapeando cada valor para uma cor
        switch (valor) {
            case 0:
                return "Preto";
            case 1:
                return "Marrom";
            case 2:
                return "Vermelho";
            case 3:
                return "Laranja";
            case 4:
                return "Amarelo";
            case 5:
                return "Verde";
            case 6:
                return "Azul";
            case 7:
                return "Violeta";
            case 8:
                return "Cinza";
            case 9:
                return "Branco";
            default:
                throw new IllegalArgumentException("Valor inválido: " + valor);
        }
    }
}   
