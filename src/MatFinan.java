public class MatFinan {
    public double calculaValorAVista(double porcentagemEntrada, double valorParcela, double taxaFinanciamento, int tempoFinanciamento, double taxaCarencia, int periodoCarencia) {
        return valorParcela * ((1 - Math.pow(1 + taxaFinanciamento, -tempoFinanciamento)) / taxaFinanciamento) / (1 - porcentagemEntrada) / (Math.pow(1 + taxaCarencia, periodoCarencia - 1));
    }

    public double calculaValorParcela(double porcentagemEntrada, double valorAVista, double taxaFinanciamento, int tempoFinanciamento, double taxaCarencia, int periodoCarencia) {
        double valorEntrada = porcentagemEntrada * valorAVista;
        return (valorAVista - valorEntrada) * Math.pow(1 + taxaCarencia, periodoCarencia - 1) / ((1 - Math.pow(1 + taxaFinanciamento, -tempoFinanciamento)) / taxaFinanciamento);
    }

    public int calculaNumeroParcelas(double porcentagemEntrada, double valorAVista, double valorParcela, double taxaFinanciamento, double taxaCarencia, int periodoCarencia) {
        double valorEntrada = porcentagemEntrada * valorAVista;
        return (int) Math.ceil(-(Math.log(1 - ((valorAVista - valorEntrada) * Math.pow(1 + taxaCarencia, periodoCarencia - 1) / valorParcela * taxaFinanciamento)) / Math.log(1 + taxaFinanciamento)));
    }

    public double calculaTaxaFinanciamento(double chuteInicial, double porcentagemEntrada, double valorAVista, double valorParcela, int tempoFinanciamento, double taxaCarencia, int periodoCarencia) {
        double taxa = chuteInicial;
        double valorEntrada = porcentagemEntrada * valorAVista;
        double razao = (valorAVista - valorEntrada) * Math.pow(1 + taxaCarencia, periodoCarencia - 1) / valorParcela;
        double fi = razao * taxa + Math.pow(1 + taxa, -tempoFinanciamento) - 1;
        double di = razao - tempoFinanciamento * Math.pow(1 + taxa, -tempoFinanciamento - 1);

        while (Math.abs(fi) >= 0.00001) {
            taxa = taxa - fi / di;
            fi = razao * taxa + Math.pow(1 + taxa, -tempoFinanciamento) - 1;
            di = razao - tempoFinanciamento * Math.pow(1 + taxa, -tempoFinanciamento - 1);
        }
        return taxa;
    }

    public double calculaTaxaCarencia(double porcentagemEntrada, double valorAVista, double valorParcela, double taxaFinanciamento, int tempoFinanciamento, int periodoCarencia) {
        double valorEntrada = porcentagemEntrada * valorAVista;
        return Math.pow(valorParcela / (valorAVista - valorEntrada) * ((1 - Math.pow(1 + taxaFinanciamento, -tempoFinanciamento) / taxaFinanciamento)), 1 / (periodoCarencia - 1)) - 1;
    }

    public double calculaPeriodoCarencia(double porcentagemEntrada, double valorAVista, double valorParcela, double taxaFinanciamento, int tempoFinanciamento, double taxaCarencia) {
        //Usar Math.floor ou Math.ceil?
        double valorEntrada = porcentagemEntrada * valorAVista;
        return Math.log(valorParcela / (valorAVista - valorEntrada) * ((1 - Math.pow(1 + taxaFinanciamento, -tempoFinanciamento) / taxaFinanciamento))) / Math.log(1 + taxaCarencia) + 1;
    }
}
