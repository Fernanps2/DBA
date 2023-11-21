/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dba_p2;

/**
 *
 * @author Marcos
 */
public class MovimientoEste implements Movimiento{
    
    @Override
    public double calculaMovimiento(Entorno entorno, DBA_P2 miAgente){
        double distanciaEste = -1;
        
        if (entorno.movimientoPosible(entorno.filAgente,entorno.colAgente+1))
            distanciaEste = CalcularDistancia(entorno, entorno.filAgente,entorno.colAgente+1, miAgente.caminoRecorrido);
        
        return distanciaEste;
    }
    
}
