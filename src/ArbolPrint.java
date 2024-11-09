class Nodo {
    int valor;
    Nodo izquierda, derecha;

    public Nodo(int valor) {
        this.valor = valor;
        izquierda = derecha = null;
    }
}

public class ArbolPrint {

    static void imprimirArbol(Nodo nodo, int espacio, int separacion) {
        if (nodo == null) {
            return;
        }

        espacio += separacion;

        imprimirArbol(nodo.derecha, espacio, separacion);

        System.out.println();
        for (int i = separacion; i < espacio; i++) {
            System.out.print(" ");
        }
        System.out.println(nodo.valor);

        imprimirArbol(nodo.izquierda, espacio, separacion);
    }


    static int altura(Nodo nodo) {
        if (nodo == null) {
            return -1; 
        }
        return 1 + Math.max(altura(nodo.izquierda), altura(nodo.derecha));
    }

    
    static int peso(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + peso(nodo.izquierda) + peso(nodo.derecha);
    }

    
    static int nivel(Nodo nodo, int valor, int nivelActual) {
        if (nodo == null) {
            return -1; 
        }
        if (nodo.valor == valor) {
            return nivelActual; 
        }

        
        int nivelIzquierdo = nivel(nodo.izquierda, valor, nivelActual + 1);
        if (nivelIzquierdo != -1) {
            return nivelIzquierdo;
        }
        
        return nivel(nodo.derecha, valor, nivelActual + 1);
    }

    public static void main(String[] args) {
        
        Nodo raiz = new Nodo(30);
        
        raiz.izquierda = new Nodo(20);
        raiz.derecha = new Nodo(40);
        
        raiz.izquierda.izquierda = new Nodo(10);
        raiz.izquierda.derecha = new Nodo(25);
        
        raiz.derecha.izquierda = new Nodo(35);
        raiz.derecha.derecha = new Nodo(50);

        ////si no se entiende, la orientacion del arbol esta en horizontal //////////////////////////////////////////////////
        imprimirArbol(raiz, 0, 8);

        ////LA RAIZ LA PUSE COMO NIVEL 0/////////////////////////////////////////////////////////////////////////////////////
        System.out.println("\nAltura del arbol: " + altura(raiz));
        System.out.println("Peso del arbol: " + peso(raiz));

        
        int valorBuscado = 25; 
        int nivelNodo = nivel(raiz, valorBuscado, 0);
        
        if (nivelNodo != -1) {
            System.out.println("El nivel del nodo " + valorBuscado + " es: " + nivelNodo);
        } else {
            System.out.println("El nodo " + valorBuscado + " no se encontro en el árbol.");
        }
    }
}