package labs_examples.datastructures.hashmap.labs;

/*      HashMaps Exercise_02
 *
 *      Rewrite the CustomHashMap class to meet the following requirements:
 *      1) no method has the same name as any in CustomHashMap
 *          (do not use refactor - do it manually)
 *      2) no variable has the same name as any in CustomHashMap
 *          (do not use refactor - do it manually)
 *      3) resize the HashMap when the underlying array is more than half full
 *      4) triple the size of the underlying array on resize()
 *      5) instead of checking the number of keys to resize, check the number of values
 *      6) on collisions, add new elements to the front of the LinkedList, not the end
 *      7) anytime someone tries to get/update/remove an element that does not exist, print
 *          out a message indicating that the element does not exist
 *      8) add at least one more method that you think could be useful to the HashMap
 *          review Java's built-in HashMap for inspiration
 */
public class Exercise_02 {
    public static void main(String[] args) {
        cerquilhaMapa<Integer, String> cerquilhaMapa = new cerquilhaMapa<>();
        cerquilhaMapa.por(1, "A");
        cerquilhaMapa.por(2, "B");
        cerquilhaMapa.por(3, "C");
        cerquilhaMapa.por(4, "D");
        System.out.println("1:" + cerquilhaMapa.pegue(1));
        cerquilhaMapa.remover(1);
        cerquilhaMapa.atualizar(2, "BBB");
        System.out.println("2:" + cerquilhaMapa.pegue(2));
    }
}

/* Key-Value Pair */
class Entrada<K, V> {
    private final K chave;
    private V valor;
    Entrada<K, V> proxima = null;

    Entrada(K chave, V valor) {
        this.chave = chave;
        this.valor = valor;
    }

    public K getChave() {
        return chave;
    }

    public V getValor() {
        return valor;
    }

    public void setValor(V valor) {
        this.valor = valor;
    }
}

class cerquilhaMapa<K, V> {
    private Entrada<K, V>[] mesa = new Entrada[10];
    private int altura = 0;

    private int cerquilha(K key) {
        return Math.abs(key.hashCode() % mesa.length);
    }

    public void por(K chave, V valor) {
        int indice = cerquilha(chave);
        Entrada<K, V> entrada = new Entrada<>(chave, valor);
        if (mesa[indice] == null) {
            mesa[indice] = entrada;
            altura++;
        } else {
            Entrada<K, V> entradaCabeca = mesa[indice]; // Store entry at index
            mesa[indice] = entrada;  // Overwrite entry at index
            entradaCabeca.proxima = entradaCabeca;  // Connect them
            altura++;
        }
        if (altura > mesa.length * 0.5) {
            redimensionar();
        }
    }

    private void redimensionar() {
        Entrada<K, V>[] velha = mesa;
        mesa = new Entrada[velha.length * 3];
        for (Entrada<K, V> kvEntrada : velha) {
            try {
                Entrada<K, V> entrada = kvEntrada;
                por((K) entrada.getChave(), (V) entrada.getValor());
                while (entrada.proxima != null) {
                    entrada = entrada.proxima;
                    por((K) entrada.getChave(), (V) entrada.getValor());
                }
            } catch (Exception e) {
                // do nothing
            }
        }
    }

    public V pegue(K chave) {
        int indice = cerquilha(chave);
        if (mesa[indice] == null) {
            System.out.println("Esta chave não existe.");
            return null;
        }
        Entrada<K, V> entrada = mesa[indice];
        while (entrada.getChave() != chave) {
            if (entrada.proxima == null) {
                return null;
            } else {
                entrada = entrada.proxima;
            }
        }
        return entrada.getValor();
    }

    public void remover(K chave) {
        if (pegue(chave) == null) {
            System.out.println("Esta chave não existe.");
            return;
        }
        int indice = cerquilha(chave);
        Entrada<K, V> entrada = mesa[indice];
        if (entrada.getChave().equals(chave)) {
            mesa[indice] = null;
            altura--;
            return;
        }
        while (entrada.proxima != null) {
            if (entrada.proxima.getChave() != chave) {
                entrada = entrada.proxima;
            }
        }
        if (entrada.proxima.proxima != null) {
            entrada.proxima = entrada.proxima.proxima;
            altura--;
        } else {
            entrada.proxima = null;
            altura--;
        }
    }

    public int obterAltura() {
        return mesa.length;
    }

    public void atualizar(K chave, V valor) {
        if (pegue(chave) == null) {
            System.out.println("Esta chave não existe.");
            return;
        }
        int indice = cerquilha(chave);
        Entrada<K, V> entrada = mesa[indice];
        if (entrada.getChave().equals(chave)) {
            entrada.setValor(valor);
            return;
        } else {
            while (entrada.proxima != null) {
                entrada = entrada.proxima;
            }
            entrada.setValor(valor);
            return;
        }
    }
}