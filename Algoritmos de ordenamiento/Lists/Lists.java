package Lists;

import java.util.ArrayList;

public class Lists {
    public static void main(String[] args) {
        ArrayList<Integer> lista_one = new ArrayList<Integer>();

        lista_one.add(2);
        lista_one.add(0);
        lista_one.add(3);

        System.out.println("Lista completa: " + lista_one);

        lista_one.set(0, 200);

        System.out.println("Primer elemento: " + lista_one.get(0));
        System.out.println("Segundo elemento: " + lista_one.get(1));

        boolean estaVació = lista_one.isEmpty();

        System.out.println("Método que comprueba si la lista esta vacía: " + estaVació);
        lista_one.remove(1);
        System.out.println("Lista después de eliminar el segundo elemento: " + lista_one);

        System.out.println("Limpiar lista");
        lista_one.clear();

        System.out.println("Longitud de la lista: " + lista_one.size());

    }
}
