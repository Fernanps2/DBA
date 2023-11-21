/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dba_p2;

/**
 *
 * @author Marcos
 */
public class MovimientoSur implements Movimiento{
    
    @Override
    public double calculaMovimiento(Entorno entorno, DBA_P2 miAgente){
        double distanciaSur = -1;
        
        if (entorno.movimientoPosible(entorno.filAgente+1,entorno.colAgente)) 
            distanciaSur = CalcularDistancia(entorno, entorno.filAgente+1,entorno.colAgente, miAgente.caminoRecorrido);
        
        return distanciaSur;
    }
}
