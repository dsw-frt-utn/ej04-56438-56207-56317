package data;

import domain.*;
import java.util.ArrayList;
import java.util.Optional;

public class Persistencia {
    private static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    private static ArrayList<Responsable> responsables = new ArrayList<>();
    private static ArrayList<Sucursal> sucursales = new ArrayList<>();
    
    private static void inicializarResponsables(){
        Responsable r1 = new Responsable("Carlos Gómez", "25444111", "3815551111");
        Responsable r2 = new Responsable("Laura Pérez", "30111222", "3815552222");
        responsables.add(r1);
        responsables.add(r2);
    }
    
    private static void inicializarSucursales(){
        Sucursal s1 = new Sucursal("SUC01", "Av. Belgrano 1200", "Tucumán", responsables.get(0));
        Sucursal s2 = new Sucursal("SUC02", "San Martín 450", "Yerba Buena", responsables.get(1));
        
        sucursales.add(s1);
        sucursales.add(s2);
    }
    
    private static void inicializarVehiculos(){
       
    Sucursal s1 = sucursales.get(0);
    Sucursal s2 = sucursales.get(1);
    
    Marca renault = new Marca("Renault", "Francia");
    Marca ford = new Marca("Ford", "EE.UU.");
    Marca iveco = new Marca("Iveco", "Italia");
    Marca mercedes = new Marca("Mercedes", "Alemania");
    
    VehiculoElectrico v1 = new VehiculoElectrico(16.0, "AE123FG", renault, "Kangoo E-Tech", 2020, 1000.0, s1, VehiculoTipo.ELECTRICO);
    VehiculoElectrico v2 = new VehiculoElectrico(16.0, "AF456HI", ford, "E-Transit", 2021, 1300.0, s2, VehiculoTipo.ELECTRICO);
  
    VehiculoCombustible v3 = new VehiculoCombustible(8.0, 1.5, "AC789JK", iveco, "Daily", 2023, 1200.0, s1, VehiculoTipo.COMBUSTIBLE);
    VehiculoCombustible v4 = new VehiculoCombustible(7.0, 1.0, "AD321LM", mercedes, "Sprinter", 2020, 1200.0, s2, VehiculoTipo.COMBUSTIBLE);    
        vehiculos.add(v1);
        vehiculos.add(v2);
        vehiculos.add(v3);
        vehiculos.add(v4);
    }
    
    public static ArrayList<Vehiculo> getVehiculos(){
        return vehiculos;
    }
    
    public static Optional<Vehiculo> getVehiculo(String patente){
        return vehiculos.stream()
                .filter(v -> v.getPatente().equals(patente))
                .findFirst();
    }
    
    public static void inicializar(){
        inicializarResponsables();
        inicializarSucursales();
        inicializarVehiculos();
    }
}
