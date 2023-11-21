/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dba_p2;

/**
 *
 * @author Marcos
 */
public class MovimientoNorte implements Movimiento {
    
    @Override
    public double calculaMovimiento(Entorno entorno, DBA_P2 miAgente){
        double distanciaNorte = -1;
        
        if (entorno.movimientoPosible(entorno.filAgente-1,entorno.colAgente)) 
            distanciaNorte = CalcularDistancia(entorno, entorno.filAgente-1,entorno.colAgente, miAgente.caminoRecorrido);
        
        return distanciaNorte;
    }
}
