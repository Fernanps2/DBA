/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dba_p2;

/**
 *
 * @author Marcos
 */
public class MovimientoOeste implements Movimiento{
    
    @Override
    public double calculaMovimiento(Entorno entorno, DBA_P2 miAgente){
        double distanciaOeste = -1;
        
        if (entorno.movimientoPosible(entorno.filAgente,entorno.colAgente-1)) 
            distanciaOeste = CalcularDistancia(entorno, entorno.filAgente,entorno.colAgente-1, miAgente.caminoRecorrido);
        
        return distanciaOeste;
    }
}
