package Logic;

/**
 *
 * @author maryse
 */
public class ListaDoble {

    Nodo cabeza;
// métodos de la clase (implementación en apartado 8.9)

    public ListaDoble() {
        cabeza = null;
    }

    public ListaDoble insertarCabezaLista(int entrada) {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.adelante = cabeza;
        if (cabeza != null) {
            cabeza.atras = nuevo;
        }
        cabeza = nuevo;
        return this;
    }

    public ListaDoble insertaDespues(Nodo anterior, int entrada) {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.adelante = anterior.adelante;
        if (anterior.adelante != null) {
            anterior.adelante.atras = nuevo;
        }
        anterior.adelante = nuevo;
        nuevo.atras = anterior;
        return this;
    }

    public void eliminar(int entrada) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.dato == entrada) {
                if (actual == cabeza) {
                    cabeza = actual.adelante;
                    if (cabeza != null) {
                        cabeza.atras = null;
                    }
                } else {
                    actual.atras.adelante = actual.adelante;
                    if (actual.adelante != null) {
                        actual.adelante.atras = actual.atras;
                    }
                }
                break; // Terminar el bucle después de eliminar el nodo
            }
            actual = actual.adelante;
        }
    }

    public void visualizar() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.adelante;
        }
        System.out.println();
    }

    public boolean buscarLista(int destino) {
    Nodo actual = cabeza;

    while (actual != null) {
        if (actual.dato == destino) {
            return true;
            
        }
        actual = actual.adelante;
    }
    return false;
   
}

    public String toString() {
    StringBuilder sb = new StringBuilder();
    Nodo actual = cabeza;
    while (actual != null) {
        sb.append(actual.dato).append(" ");
        actual = actual.adelante;
    }
    return sb.toString();
    }
}
