import java.io.IOException;
import java.util.*;
public class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner tast = new Scanner(System.in);
        Rubrica rubrica = new Rubrica();
        boolean infinite = true;
        while(infinite)
        {
            System.out.println("Benvenuto nella nostra rubrica, attualmente ha "+rubrica.rubrica.size()+" contatti");
            System.out.println("""
                    Cosa desidera fare?
                    
                    1 - aggiungere contatto
                    
                    2 - modificare contatto
                    
                    3 - eliminare contatto
                    
                    4 - visualizzare la rubrica
                    
                    5 - uscire dal programma
                    
                    """);
            int sc = tast.nextInt();
            switch (sc)
            {
                case 1 ->rubrica.addContact();

                case 2 ->rubrica.modify();

                case 3 -> rubrica.removeContact();

                case 4 -> rubrica.printRubrica();

                case 5 ->
                {
                    System.out.println("Arrivederla!");
                    infinite = false;
                }
            }

        }
    }
}