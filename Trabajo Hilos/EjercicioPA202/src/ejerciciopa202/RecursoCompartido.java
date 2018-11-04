/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejerciciopa202;
/*
UNIVERSIDAD AUTONOMA DEL ESTADO DE MEXICO
CENTRO UNIVERSITARIO UAEM ZUMPANGO
INGENIERIA EN COMPUTACION
PROGRAMACION AVANZADA 2018-B

DESCRIPCION: Clase de recursos compartidos para los hilos 

ARCHIVO: RecursoCompartido.java

FECHA: 23/Octubre/2018
ALUMNOS(S): Guillermo López Rubio
PROFESOR: Asdrúbal López Chau
*/
/**
 *
 * @author Luis
 */
public class RecursoCompartido {
    
    private boolean flagWinner = false; //True  = someone has arrived
    private String nameWinner = "";
    static int index=0;
    

    public synchronized boolean isFlagWinner() {
        return flagWinner;
    }

    public synchronized void setFlagWinner(boolean flagWinner) {
        this.flagWinner = flagWinner;
    }

    public String getNameWinner() {
        return nameWinner;
    }
    /**
     * Permite imprimir en consola la tabla de pociciones
     * @param nameWinner 
     */
    public synchronized void setNameWinner(String nameWinner) {
        if (!isFlagWinner()) {
            this.nameWinner = nameWinner;
            flagWinner = true;
            System.out.println("     Tabla de Pociciones   ");
            index++;
            System.out.println(" " +index+"  | "+ nameWinner);
           // System.out.println(index);
        }else{
            //this.nameWinner = nameWinner;
            //System.out.println("despues llego: "+nameWinner);
            index++;
            System.out.println(" " +index+"  | "+ nameWinner);
        }
        
    }
}
