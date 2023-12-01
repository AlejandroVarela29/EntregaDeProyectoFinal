import java.util.Arrays;
class FlujoEfectivo {
    String[] cuentas;
    double[] ingresos;
    double[] egresos;

    public FlujoEfectivo(String[] cuentas, double[] ingresos, double[] egresos) {
        this.cuentas = cuentas;
        this.ingresos = ingresos;
        this.egresos = egresos;
    }

    public double calcularFlujoEfectivoNeto() {
        double flujoNeto = Arrays.stream(ingresos).sum() - Arrays.stream(egresos).sum();
        return flujoNeto;
    }
}