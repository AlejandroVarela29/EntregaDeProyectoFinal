class Producto {
    String nombre;
    double costo;
    int cantidadVendida;

    public Producto(String nombre, double costo, int cantidadVendida) {
        this.nombre = nombre;
        this.costo = costo;
        this.cantidadVendida = cantidadVendida;
    }

    public double calcularIngresos() {
        return costo * cantidadVendida;
    }
}