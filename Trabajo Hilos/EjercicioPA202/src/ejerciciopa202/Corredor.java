package ejerciciopa202;

import java.awt.Dimension;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
/*
UNIVERSIDAD AUTONOMA DEL ESTADO DE MEXICO
CENTRO UNIVERSITARIO UAEM ZUMPANGO
INGENIERIA EN COMPUTACION
PROGRAMACION AVANZADA 2018-B

DESCRIPCION: 

ARCHIVO: Corredor.java

FECHA: 18/Octubre/2018
ALUMNOS(S): Guillermo López Rubio
PROFESOR: Asdrúbal López Chau
*/
/**
 *
 * @author Luis
 */

/**
 * Clase para los hilos implementando la interfas Runnable
 */
public class Corredor implements Runnable {
    /*elementos nesesarios para las operaciones ha realizar*/
    private int ancho=0;
    JLabel label;
    JLabel label2;
    JLabel etiqueta;
    CyclicBarrier b;
    private RecursoCompartido recursoCompartido;
    /**
     * hacer correr los hilos cada uno haciendo una accion
     * (hacer que la etiqueta abance)
     */
    @Override
    public void run() {
        //int vueltas = 0;
        Random r = new Random(System.nanoTime());
        int avance = 0;
        /*mientras avance sea menor a ancho (que es la distancia a la mitad de la ventana) menos 50
        se actualizara la pocicion de la etiqueta, esto mientras el hilo no sea dormido*/
        while (avance < ancho-50) {
           /* if (recursoCompartido.isFlagWinner()) {
               // break;
            }*/
            if (r.nextInt(100) < 50) {
                avance++;
            } else {
                avance += 0;
            }
            label.setLocation(avance, label.getY());
            try {
                Thread.sleep(10 + r.nextInt(1));
            } catch (InterruptedException ex) {
            }
        }
        //recursoCompartido.setNameWinner(label.getText());
        /*
        una vez completado la trallectoria de la primera etiqueta se dara pauta a la segunda etiqueta
        esto para evitar crear mas hilos de los nesesarios para realizar la misma accion
        despues se implementa la barrera para que seria para la creacion de la tabla de pociciones, al no poder crearla esto
        no tiene sentido
        */
        run2();
        try {
            b.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BrokenBarrierException ex) {
            Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*
        etiqueta = new JLabel("Etiqueta prueva ");
        etiqueta.setSize(new Dimension(100, 40));
        etiqueta.setLocation(0, recursoCompartido.index * 15);*/
        //jPanel1.add(labels[i]);
    }
    /**
     * Funcion auxiliar para ejecucion del hilo 
     * con esta funcion se genera el movimiento de la segunda etiqueta de cada equipo rara poder terminar la carrera
     */
        public void run2() {
        //int vueltas = 0;
        Random r = new Random(System.nanoTime());
        int avance = 0;
        while (avance < ancho-105) {
           /* if (recursoCompartido.isFlagWinner()) {
               // break;
            }*/
            if (r.nextInt(100) < 50) {
                avance++;
            } else {
                avance += 0;
            }
            label2.setLocation(avance+ancho, label2.getY());
            try {
                Thread.sleep(10 + r.nextInt(1));
            } catch (InterruptedException ex) {
            }
        }
        recursoCompartido.setNameWinner(label.getText());
    }


    public Corredor(JLabel label, JLabel label2, RecursoCompartido recursoCompartido, int ancho, CyclicBarrier b) {
        this.label = label;
        this.label2 = label2;
        this.recursoCompartido = recursoCompartido;
        this.ancho=ancho;
        this.b=b;
    }
    
/*setters and getters de recursosCompartidos y el ancho*/    
    public RecursoCompartido getRecursoCompartido() {
        return recursoCompartido;
    }

    public void setRecursoCompartido(RecursoCompartido recursoCompartido) {
        this.recursoCompartido = recursoCompartido;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    
}
