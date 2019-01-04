package mx.unam.ciencias.edd.test;

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Iterator;
import org.junit.Test;
import org.junit.Assert;
import mx.unam.ciencias.edd.IteradorArbolBinario;
import mx.unam.ciencias.edd.ArbolBinarioOrdenado;


/**
 * Clase para pruebas unitarias de la clase {@link
 * ArbolBinarioOrdenado}.
 */
public class TestArbolBinarioOrdenado {

    private int total;
    private Random random;
    private ArbolBinarioOrdenado<Integer> arbol;

    /* Valida el iterador de un árbol ordenado, y recursivamente
     * revisa sus hijos. */
    private static <T extends Comparable<T>> void
                      iteradorOrdenadoValido(IteradorArbolBinario<T> it) {
        T elemento = it.dame();
        try {
            if (it.hayIzquierdo()) {
                it.izquierdo();
                T izquierdo = it.dame();
                Assert.assertTrue(izquierdo.compareTo(elemento) <= 0);
                iteradorOrdenadoValido(it);
                it.padre();
            }
            if (it.hayDerecho()) {
                it.derecho();
                T derecho = it.dame();
                Assert.assertTrue(elemento.compareTo(derecho) <= 0);
                iteradorOrdenadoValido(it);
                it.padre();
            }
        } catch (NoSuchElementException sdee) {
            Assert.fail();
        }
    }

    /**
     * Valida un árbol ordenado. Comprueba que para todo nodo A se
     * cumpla que si A tiene como hijo izquierdo a B, entonces B ≤
     * A, y si A tiene como hijo derecho a C, entonces A ≤ C.
     * @param arbol el árbol a revisar.
     */
    public static <T extends Comparable<T>> void
                     arbolOrdenadoValido(ArbolBinarioOrdenado<T> arbol) {
        if (arbol.getNumeroDeElementos() == 0)
            return;
        iteradorOrdenadoValido(arbol.iterador());
    }

    /**
     * Crea un árbol binario para cada prueba.
     */
    public TestArbolBinarioOrdenado() {
        random = new Random();
        arbol = new ArbolBinarioOrdenado<Integer>();
        total = random.nextInt(100);
    }

    /**
     * Prueba unitaria para {@link ArbolBinarioOrdenado#agrega}.
     */
    @Test public void testAgrega() {
        for (int i = 0; i < total; i++) {
            int n = random.nextInt(100);
            arbol.agrega(n);
            TestArbolBinario.arbolValido(arbol);
            Assert.assertTrue(arbol.getNumeroDeElementos() == i+1);
            IteradorArbolBinario<Integer> it = arbol.busca(n);
            Assert.assertTrue(it != null);
            Assert.assertTrue(it.dame() == n);
            arbolOrdenadoValido(arbol);
        }
    }

    /* Llena el árbol con elementos no repetidos. */
    private void llenaConNoRepetidos(int[] a) {
        for (int i = 0; i < total; i++) {
            int r;
            boolean repetido = false;
            do {
                r = random.nextInt(1000);
                repetido = false;
                for (int j = 0; j < i; j++)
                    if (r == a[j])
                        repetido = true;
            } while (repetido);
            a[i] = r;
            arbol.agrega(a[i]);
        }
        for (int i : a)
            Assert.assertTrue(arbol.busca(i) != null);
    }

    /**
     * Prueba unitaria para {@link ArbolBinarioOrdenado#elimina}.
     */
    @Test public void testElimina() {
        int[] a = new int[total];
        llenaConNoRepetidos(a);
        int n = total;
        while (arbol.getNumeroDeElementos() > 0) {
            Assert.assertTrue(arbol.getNumeroDeElementos() == n);
            int i = random.nextInt(total);
            if (a[i] == -1)
                continue;
            int e = a[i];
            IteradorArbolBinario<Integer> it = arbol.busca(e);
            Assert.assertTrue(it != null);
            Assert.assertTrue(it.dame() == e);
            arbol.elimina(e);
            it = arbol.busca(e);
            Assert.assertTrue(it == null);
            Assert.assertTrue(arbol.getNumeroDeElementos() == --n);
            TestArbolBinario.arbolValido(arbol);
            arbolOrdenadoValido(arbol);
            a[i] = -1;
        }
    }

    /**
     * Prueba unitaria para {@link ArbolBinarioOrdenado#busca}.
     */
    @Test public void testBusca() {
        int[] a = new int[total];
        llenaConNoRepetidos(a);
        for (int i : a) {
            IteradorArbolBinario<Integer> it = arbol.busca(i);
            Assert.assertTrue(it != null);
            Assert.assertTrue(it.dame() == i);
        }
        int m = 1500 + random.nextInt(100);
        Assert.assertTrue(arbol.busca(m) == null);
    }
}
