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
public class Cliente_tipo2 extends Cliente {
    
    public Cliente_tipo2(String DNI, String Nombre, double m_cubicos) {
        super(DNI, Nombre, m_cubicos);
    }
    
    @Override
    public void calcularAlcantarillado(){
        double importe = m_cubicos * ALCANTARILLADO_RAZON;
        double descuento = importe * 0.75;
        
        if(descuento < 16){
            alcantarillado = importe - descuento;
        }
        else{
            alcantarillado = importe - 16;
        }
    }
    
    @Override
    public void calcularDepuracion(){
        double importe = m_cubicos * DEPURACION_RAZON;
        double descuento = importe * 0.5;
        if(descuento < 16){
            depuracion = importe - descuento;
        }
        else{
            depuracion = importe - 16;
        }
    }
}
