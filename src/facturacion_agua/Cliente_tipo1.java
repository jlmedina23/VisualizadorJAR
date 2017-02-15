/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacion_agua;

/**
 *
 * @author Javier López Medina
 */
public class Cliente_tipo1 extends Cliente {

    public Cliente_tipo1(String DNI, String Nombre, double m_cubicos) {
        super(DNI, Nombre, m_cubicos);
    }
    
    @Override
    public void calcularAlcantarillado(){
        double aux = m_cubicos * ALCANTARILLADO_RAZON;
        double descuento = aux * 0.25;
        alcantarillado = aux - 0.25;
    }
    
    @Override
    public void calcularDepuracion() {
        double aux = m_cubicos * DEPURACION_RAZON;
        double descuento = aux * 0.25;
        depuracion = aux - descuento;
    }
}
