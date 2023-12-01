class EstadoFinanciero {
    Producto[] productos;

    public EstadoFinanciero(Producto[] productos) {
        this.productos = productos;
    }

    public double calcularIngresosTotales() {
        double ingresosTotales = 0;
        for (Producto producto : productos) {
            ingresosTotales += producto.calcularIngresos();
        }
        return ingresosTotales;
    }

    public double calcularCostosTotales() {
        double costosTotales = 0;
        for (Producto producto : productos) {
            costosTotales += producto.costo;
        }
        return costosTotales;
    }

    public double calcularUtilidad() {
        return calcularIngresosTotales() - calcularCostosTotales();
    }
}
