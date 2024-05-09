package Logic;
import java.io.*;
import java.util.Random;

/**
 *
 * @author maryse
 * 
 * Lista Doble
 * Crea el objeto lista doble e inserta datos enteros generados aleatoriamente.
 * Crea objeto iterador de lista, para recorrer sus elementos y
 * aquellos fuera de rango se eliminan. El rango se lee del teclado.
 */

public class ListaEnRango {

    public static void main(String[] ar) throws IOException {
        Random r;
        int d, x1=10, x2=10;
        final int M = 29; // número de elementos de la lista
        final int MX = 999;

        ListaDoble listaDb;
        r = new Random();
        listaDb = new ListaDoble();
        for (int j = 1; j <= M; j++) {
            d = r.nextInt(MX) + 1;
            listaDb.insertarCabezaLista(d);
        }

        listaDb.visualizar();


        // crea iterador asociado a la lista
        IteradorLista iterador = new IteradorLista(listaDb);
        Nodo a;
        // recorre la lista con el iterador
        a = iterador.siguiente();
        while (a != null) {
            int w;
            w = a.getDato();
            if (!(w >= x1 && w <= x2)) // fuera de rango
            {
                listaDb.eliminar(w);
            }
            a = iterador.siguiente();
        }
        System.out.println("Elementos actuales de la lista");
        listaDb.visualizar();
    }
}
