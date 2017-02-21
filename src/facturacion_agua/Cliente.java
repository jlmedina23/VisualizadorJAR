
package facturacion_agua;

import java.text.DecimalFormat;

/**
 *
 * @author Javier López Medina
 */
public class Cliente {
    protected String DNI;
    protected String Nombre;
    protected double m_cubicos;
    protected double consumo;
    protected double alcantarillado;
    protected double depuracion;
    protected double prueba;
    
    protected static final double CONSUMO_RAZON = 0.32;
    protected static final double ALCANTARILLADO_RAZON = 0.298;
    protected final double DEPURACION_RAZON = 0.226;
    protected final double CONSERVACION = 0.83;
    
    private static final DecimalFormat dos_decimales = new DecimalFormat(".##");

    public Cliente(String DNI, String Nombre, double m_cubicos) {
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.m_cubicos = m_cubicos;
        calcularConsumo();
        calcularAlcantarillado();
        calcularDepuracion();
    }
    
    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public double getAlcantarillado() {
        return alcantarillado;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    public void calcularConsumo(){
        consumo = m_cubicos * CONSUMO_RAZON;
    }
    
    public void calcularAlcantarillado(){
        alcantarillado = m_cubicos * ALCANTARILLADO_RAZON;
    }
    
    public void calcularDepuracion(){
        depuracion = m_cubicos * DEPURACION_RAZON;
    }
    
    public double calcular_Coste(){
        double coste = consumo + alcantarillado + depuracion + CONSERVACION;
        return coste;
    }

    public void setM_cubicos(double m_cubicos) {
        this.m_cubicos = m_cubicos;
        calcularAlcantarillado();
        calcularDepuracion();
    }
    
    public void Mostrar(){
        System.out.println("Nombre: " + Nombre);
        System.out.println("DNI: " + DNI);
        System.out.println("Metros cúbicos consumidos: " + m_cubicos + " m3");
        System.out.println("Importe de consumo: " + dos_decimales.format(consumo) + " €");
        System.out.println("Importe de alcantarillado: " + dos_decimales.format(alcantarillado) + " €\t");
        System.out.println("Importe de depuración: " + dos_decimales.format(depuracion) + " €");
        System.out.println("Importe de conservación: " + CONSERVACION + " €\n");
        System.out.println("Importe total a pagar: " + dos_decimales.format(calcular_Coste()) + " €\n");
        System.out.println("================================================================");
    }
}
