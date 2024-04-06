// See https://aka.ms/new-console-template for more information

class Program
{
    static void Main()
    {
        List<string> lista_one = new List<string>();

        
        lista_one.Add("elemento1");
        lista_one.Add("elemento2");
        lista_one.Add("elemento3");

        Console.WriteLine("Lista completa: ");
        foreach (string item in lista_one)
        {
            Console.WriteLine(item);
        }

        Console.WriteLine("Primer elemento: " + lista_one[0]);
        Console.WriteLine("Segundo elemento: " + lista_one[1]);

        lista_one.RemoveAt(1);
        Console.WriteLine("Lista después de eliminar el segundo elemento: ");
        foreach (string item in lista_one)
        {
            Console.WriteLine(item);
        }

        Console.WriteLine("Longitud de la lista: " + lista_one.Count);
    }
}

