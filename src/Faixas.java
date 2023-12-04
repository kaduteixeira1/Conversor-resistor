public class Faixas {

    // Mapeia cada cor para um valor numérico em String
    public String setValorPelaCor(String cor) {
        switch (cor) {
            case "Preto":
                return "0";
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
            default:
                throw new IllegalArgumentException("Cor inválida: " + cor);
        }
    }

    // Mapeia cada cor para um valor numérico
    public double setValorPelaCor3(String cor) {
        switch (cor) {
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
            default:
                throw new IllegalArgumentException("Cor inválida: " + cor);
        }
    }

    // Mapeia cada valor para uma cor
    public String setCorPeloValor(int valor) {
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

    // Mapeia cada valor para uma cor
    public String setCorPeloValor3(int valor) {
        switch (valor) {
            case 1:
                return "Preto";
            case 2:
                return "Marrom";
            case 3:
                return "Vermelho";
            case 4:
                return "Laranja";
            case 5:
                return "Amarelo";
            case 6:
                return "Verde";
            case 7:
                return "Azul";
            case 8:
                return "Violeta";
            case 9:
                return "Cinza";
            case 10:
                return "Branco";
            default:
                throw new IllegalArgumentException("Valor inválido: " + valor);
        }
    }
}