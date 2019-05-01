import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        int op;
        int carencia;
        do {


            carencia = JOptionPane.showConfirmDialog(null, "Tem carência?", "Fianciamento", JOptionPane.YES_NO_OPTION);
            if (carencia == JOptionPane.NO_OPTION) {
                op = menu() + 1;
                acao(op);
            } else if (carencia == JOptionPane.YES_OPTION) {
                op = menu() + 1;
                acao2(op);
            }
        } while (carencia != JOptionPane.CLOSED_OPTION);
    }

    public static int menu() {
        Object[] menu = {"Valor a vista", "Valor parcela", "Total parcelas", "Taxa Financiamento"};
        Object selecionado = JOptionPane.showOptionDialog(null, "Escolha o que deseja calcular:", "Financiamento", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, menu, null);
        return Integer.parseInt(selecionado.toString());
    }

    public static void acao(int i) {
        MatFinan matFinan = new MatFinan();
        double percEnt, valorVista, valorParc, taxa;
        int numParc;

        switch (i) {
            case 1:
                percEnt = percEnt();
                valorParc = valorParc();
                taxa = taxa();
                numParc = numParc();
                valorVista = matFinan.calculaValorAVista(percEnt, valorParc, taxa, numParc, 0, 0);
                JOptionPane.showMessageDialog(null, "O valor a vista é de: " + valorVista);
                break;
            case 2:
                valorVista = valorVista();
                percEnt = percEnt();
                taxa = taxa();
                numParc = numParc();
                valorParc = matFinan.calculaValorParcela(percEnt, valorVista, taxa, numParc, 0, 0);
                JOptionPane.showMessageDialog(null, "O valor da parcela é de: " + valorParc);
                break;
            case 3:
                valorVista = valorVista();
                percEnt = percEnt();
                valorParc = valorParc();
                taxa = taxa();
                numParc = matFinan.calculaNumeroParcelas(percEnt, valorVista, valorParc, taxa, 0, 0);
                JOptionPane.showMessageDialog(null, "O número de parcelas é de: " + numParc);
                break;
            case 4:
                percEnt = percEnt();
                valorVista = valorVista();
                valorParc = valorParc();
                numParc = numParc();
                taxa = matFinan.calculaTaxaFinanciamento(0.03, percEnt, valorVista, valorParc, numParc, 0, 0);
                JOptionPane.showMessageDialog(null, "A taxa é de: " + taxa * 100 + "%");
                break;
        }
    }

    public static void acao2(int i) {
        MatFinan matFinan = new MatFinan();
        double percEnt, valorVista, valorParc, taxa, taxaCarencia;
        int numParc, tempCarencia;

        switch (i) {
            case 1:
                percEnt = percEnt();
                valorParc = valorParc();
                taxa = taxa();
                numParc = numParc();
                taxaCarencia = taxaCarencia();
                tempCarencia = tempCarencia();
                valorVista = matFinan.calculaValorAVista(percEnt, valorParc, taxa, numParc, taxaCarencia, tempCarencia);
                JOptionPane.showMessageDialog(null, "O valor a vista é de: " + valorVista);
                break;
            case 2:
                valorVista = valorVista();
                percEnt = percEnt();
                taxa = taxa();
                numParc = numParc();
                taxaCarencia = taxaCarencia();
                tempCarencia = tempCarencia();
                valorParc = matFinan.calculaValorParcela(percEnt, valorVista, taxa, numParc, taxaCarencia, tempCarencia);
                JOptionPane.showMessageDialog(null, "O valor da parcela é de: " + valorParc);
                break;
            case 3:
                valorVista = valorVista();
                percEnt = percEnt();
                valorParc = valorParc();
                taxa = taxa();
                taxaCarencia = taxaCarencia();
                tempCarencia = tempCarencia();
                numParc = matFinan.calculaNumeroParcelas(percEnt, valorVista, valorParc, taxa, taxaCarencia, tempCarencia);
                JOptionPane.showMessageDialog(null, "O número de parcelas é de: " + numParc);
                break;
            case 4:
                percEnt = percEnt();
                valorVista = valorVista();
                valorParc = valorParc();
                numParc = numParc();
                taxaCarencia = taxaCarencia();
                tempCarencia = tempCarencia();
                taxa = matFinan.calculaTaxaFinanciamento(0.03, percEnt, valorVista, valorParc, numParc, taxaCarencia, tempCarencia);
                JOptionPane.showMessageDialog(null, "A taxa é de: " + taxa * 100 + "%");
                break;
        }
    }

    static double percEnt() {
        return Double.parseDouble(JOptionPane.showInputDialog("Digite a porcentagem de entrada:")) / 100;
    }

    static double taxa() {
        return Double.parseDouble(JOptionPane.showInputDialog("Digite a taxa do financiamento (em %):")) / 100;
    }

    static double taxaCarencia() {
        return Double.parseDouble(JOptionPane.showInputDialog("Digite a taxa de carência (em %):")) / 100;
    }

    static double valorVista() {
        return Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a vista:"));
    }

    static double valorParc() {
        return Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da parcela:"));
    }

    static int numParc() {
        return Integer.parseInt(JOptionPane.showInputDialog("Digite o total de parcelas:"));
    }

    static int tempCarencia() {
        return Integer.parseInt(JOptionPane.showInputDialog("Digite o periodo de carência:"));
    }

}
