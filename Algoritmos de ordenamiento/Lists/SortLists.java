package Lists;

import java.util.ArrayList;
import java.util.Collections;

public class SortLists {
    public static void main(String[] args) {
        ArrayList<Integer> lista_one = new ArrayList<Integer>();
        lista_one.add(1);
        lista_one.add(11);
        lista_one.add(111);

        // Ordenamiento de burbuja
        int n = lista_one.size();
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (lista_one.get(j).compareTo(lista_one.get(j + 1)) > 0) {
                    // swap arr[j+1] and arr[i]
                    Integer temp = lista_one.get(j);
                    lista_one.set(j, lista_one.get(j + 1));
                    lista_one.set(j + 1, temp);
                }
        System.out.println("Lista ordenada con burbuja: " + lista_one);

        // Ordenamiento por inserción
        for (int i = 1; i < n; ++i) {
            Integer key = lista_one.get(i);
            int j = i - 1;

            while (j >= 0 && lista_one.get(j).compareTo(key) > 0) {
                lista_one.set(j + 1, lista_one.get(j));
                j = j - 1;
            }
            lista_one.set(j + 1, key);
        }
        System.out.println("Lista ordenada por inserción: " + lista_one);

        // Ordenamiento por selección
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (lista_one.get(j).compareTo(lista_one.get(min_idx)) < 0)
                    min_idx = j;

            Collections.swap(lista_one, min_idx, i);
        }
        System.out.println("Lista ordenada por selección: " + lista_one);
    }
}
