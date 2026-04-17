package domain;

public class VehiculoElectrico extends Vehiculo {
    private double kwhBase;

    public VehiculoElectrico(double kwhBase, String patente, Marca marca, String modelo, int anio, double capacidadCarga, Sucursal sucursal, VehiculoTipo tipo) {
        super(patente, marca, modelo, anio, capacidadCarga, sucursal, tipo);
        this.kwhBase = kwhBase;
    }

    @Override
    public double calcularConsumo(double kilometros) {
        double total = (kilometros/100) * kwhBase;

        if (capacidadCarga > 1200) {
            total = total * 1.15;
        }

        return total;
    }
}
