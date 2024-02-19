import java.sql.SQLOutput;
import java.util.*;
import java.io.*;
public class Rubrica
{
    ArrayDeque<Contatto> rubrica = new ArrayDeque<>();
    Scanner tast = new Scanner(System.in);

    public boolean createFile()
    {
        try
        {
            File file = new File("rubrica.txt");
            if (file.createNewFile())
            {
                System.out.println("File creato con successo");
            }
            return true;
        }
        catch (IOException e)
        {
            System.out.println("Errore");
            e.printStackTrace();
            return false;
        }
    }
    public void addContact(){
        if(this.createFile()){
            Contatto cont = new Contatto();
            System.out.println("Nome?");
            cont.setNome(tast.nextLine().toLowerCase());
            System.out.println("Cognome?");
            cont.setCongnome(tast.nextLine().toLowerCase());
            System.out.println("Numero di telefono?");
            cont.setTelefono(tast.nextLine().toLowerCase());
            System.out.println("Email?");
            cont.setEmail(tast.nextLine().toLowerCase());
            System.out.println("Etichetta?");
            System.out.println("""
                    1-PADRE,
                    2-MADRE,
                    3-GENITORE,
                    4-FRATELLO,
                    5-SORELLA,
                    6-CONIUGE,
                    7-CONVIVENTE,
                    8-PARTNER,
                    9-FIGLIO_A,
                    10-PARENTE,
                    11-LAVORO,
                    12-ALTRO
                    """);
            Contatto.etichetta etichettaScelta = switch(tast.nextInt()){
                case 1-> Contatto.etichetta.PADRE;
                case 2-> Contatto.etichetta.MADRE;
                case 3-> Contatto.etichetta.GENITORE;
                case 4-> Contatto.etichetta.FRATELLO;
                case 5-> Contatto.etichetta.SORELLA;
                case 6-> Contatto.etichetta.CONIUGE;
                case 7-> Contatto.etichetta.CONVIVENTE;
                case 8-> Contatto.etichetta.PARTNER;
                case 9-> Contatto.etichetta.FIGLIO_A;
                case 10-> Contatto.etichetta.PARENTE;
                case 11-> Contatto.etichetta.LAVORO;
                default -> Contatto.etichetta.ALTRO;
            };
            cont.setEtichetta(etichettaScelta);

            rubrica.add(new Contatto());
        }
        else System.out.println("File non creato, riprova ancora");
    }




}
