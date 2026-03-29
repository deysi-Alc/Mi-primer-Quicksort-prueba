import java.util.ArrayList;

public class MergeSort {

    /**
     * Punto de entrada del algoritmo Merge Sort.
     * @param lista La lista de Restaurante a ordenar.
     */
    public void mergeSort(ArrayList<Restaurante> lista) {
        if (lista == null || lista.size() <= 1) {
            return; // La lista ya está ordenada o vacía
        }
        
        int medio = lista.size() / 2;
        
        // 1. Dividir
        ArrayList<Restaurante> izquierda = new ArrayList<>(lista.subList(0, medio));
        ArrayList<Restaurante> derecha = new ArrayList<>(lista.subList(medio, lista.size()));
        
        // 2. Conquistar (Llamada recursiva)
        mergeSort(izquierda);
        mergeSort(derecha);
        
        // 3. Combinar (Fusión)
        merge(lista, izquierda, derecha);
    }

    /**
     * Combina dos sublistas ordenadas en una sola lista final.
     */
    private void merge(
        ArrayList<Restaurante> listaPrincipal, 
        ArrayList<Restaurante> izquierda, 
        ArrayList<Restaurante> derecha) 
    {
        int i = 0, j = 0, k = 0;

        // Mientras haya elementos en ambas sublistas
        while (i < izquierda.size() && j < derecha.size()) {
            
            // Comparar por puntuacionTotal
            if (izquierda.get(i).getPuntuacionTotal() >= derecha.get(j).getPuntuacionTotal()) {
                listaPrincipal.set(k++, izquierda.get(i++));
            } else {
                listaPrincipal.set(k++, derecha.get(j++));
            }
        }

        // Añadir elementos restantes de la izquierda
        while (i < izquierda.size()) {
            listaPrincipal.set(k++, izquierda.get(i++));
        }

        // Añadir elementos restantes de la derecha
        while (j < derecha.size()) {
            listaPrincipal.set(k++, derecha.get(j++));
        }
    }
    
    // --- Método de Prueba (Opcional, para verificar en tu main) ---
    /**
     * @param args
     */
    public static void main(String[] args) {
        // 1. Crear datos de prueba (simulando tu clase Restaurante)
        ArrayList<Restaurante> restaurantes = new ArrayList<>();
        restaurantes.add(new Restaurante("Sabores", 4.5, 100, 450.0));
        restaurantes.add(new Restaurante("El Buen Sazón", 3.0, 50, 150.0));
        restaurantes.add(new Restaurante("La Casona", 5.0, 200, 1000.0));
        
        System.out.println("Lista antes de ordenar:");
        restaurantes.forEach(r -> System.out.println(r.toString() + " -> Total: " + r.getPuntuacionTotal()));
        
        // 2. Ordenar
        MergeSort sorter = new MergeSort();
        sorter.mergeSort(restaurantes);
        
        System.out.println("\nLista después de ordenar (Mayor a menor Total):");
        restaurantes.forEach(r -> System.out.println(r.toString() + " -> Total: " + r.getPuntuacionTotal()));
    }
}