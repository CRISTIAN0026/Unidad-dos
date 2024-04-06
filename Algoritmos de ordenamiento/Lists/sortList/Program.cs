class SortLists
{
    static void Main()
    {
        List<string> lista_one = new List<string>() { "elemento3", "elemento1", "elemento2" };

        // Ordenamiento de burbuja
        string temp;
        for (int write = 0; write < lista_one.Count; write++)
        {
            for (int sort = 0; sort < lista_one.Count - 1; sort++)
            {
                if (lista_one[sort].CompareTo(lista_one[sort + 1]) > 0)
                {
                    temp = lista_one[sort + 1];
                    lista_one[sort + 1] = lista_one[sort];
                    lista_one[sort] = temp;
                }
            }
        }
        Console.WriteLine("Lista ordenada con burbuja: ");
        foreach (string item in lista_one)
        {
            Console.WriteLine(item);
        }

        // Ordenamiento por inserción
        for (int i = 0; i < lista_one.Count; i++)
        {
            string item = lista_one[i];
            int currentIndex = i;
            while (currentIndex > 0 && lista_one[currentIndex - 1].CompareTo(item) > 0)
            {
                lista_one[currentIndex] = lista_one[currentIndex - 1];
                currentIndex--;
            }
            lista_one[currentIndex] = item;
        }
        Console.WriteLine("Lista ordenada por inserción: ");
        foreach (string item in lista_one)
        {
            Console.WriteLine(item);
        }

        // Ordenamiento por selección
        int smallest;
        for (int i = 0; i < lista_one.Count - 1; i++)
        {
            smallest = i;
            for (int index = i + 1; index < lista_one.Count; index++)
            {
                if (lista_one[index].CompareTo(lista_one[smallest]) < 0)
                {
                    smallest = index;
                }
            }
            string smallerNumber = lista_one[smallest];
            lista_one[smallest] = lista_one[i];
            lista_one[i] = smallerNumber;
        }
        Console.WriteLine("Lista ordenada por selección: ");
        foreach (string item in lista_one)
        {
            Console.WriteLine(item);
        }
    }
}
