/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dba_p2;

/**
 *
 * @author Marcos
 */
public class MovimientoSuroeste implements Movimiento{
    
    @Override
    public double calculaMovimiento(Entorno entorno, DBA_P2 miAgente){
        double distanciaSuroeste = -1;
        
        if (entorno.movimientoPosibleDiagonal(entorno.filAgente+1,entorno.colAgente-1, DIRECCIONES.SUROESTE)) 
            distanciaSuroeste = CalcularDistancia(entorno, entorno.filAgente+1,entorno.colAgente-1, miAgente.caminoRecorrido);
        
        return distanciaSuroeste;
    }
    
    
}
