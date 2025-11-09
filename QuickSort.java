import java.util.ArrayList;

public class QuickSort {
 
    
    public void quicksort(ArrayList<Restaurante> listaParaAlgoritmo, int inicio, int fin){
        if(inicio>=fin) return;
        
        
        int pivote = (inicio+fin)/2;
        Restaurante pivoteValor = listaParaAlgoritmo.get(pivote);
   
        int menor=inicio;
        int mayor= fin;
        
        while(menor <=mayor){
        
        while (listaParaAlgoritmo.get(menor).getPuntuacionTotal() < pivoteValor.getPuntuacionTotal()) {
            menor++;
            
        }
        while (listaParaAlgoritmo.get(menor).getPuntuacionTotal() < pivoteValor.getPuntuacionTotal()) {
            mayor--;
        }
       if (menor <= mayor) {
            Restaurante temp = listaParaAlgoritmo.get(menor);
            listaParaAlgoritmo.set(menor, listaParaAlgoritmo.get(mayor));
            listaParaAlgoritmo.set(mayor, temp);
            menor++;
            mayor--;
        }
        }
        
        if (inicio < mayor) {
        quicksort(listaParaAlgoritmo, inicio, mayor);
        }
            if (menor < fin) {
        quicksort(listaParaAlgoritmo, menor, fin);
    }
        
        
        
    }
    public void quicksort(ArrayList<Restaurante> listaParaAlgoritmo) {
        
        quicksort(listaParaAlgoritmo, 0, listaParaAlgoritmo.size() - 1);
    }
       

}
