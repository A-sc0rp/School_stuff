import java.nio.file.Files;
import java.nio.file.Path;
import java.time.*;
import java.time.format.*;
import java.util.*;
import java.io.*;

public class Rubrica
{
    ArrayList<Contatto> rubrica = new ArrayList<>();
    Scanner tast = new Scanner(System.in);
  public LocalDateTime parseTime()
  {
      LocalDateTime date = LocalDateTime.now();
      String text = date.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
      return LocalDateTime.parse(text, DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
  }

   private boolean writeOnFile() throws IOException
   {
        File file = new File("rubrica.txt");
        FileWriter writer = new FileWriter("rubrica.txt");
        try(BufferedWriter bw = new BufferedWriter(writer)){
            file.delete();
            file.createNewFile();
            rubrica.sort(Comparator.comparing(Contatto::getNome));
            for(Contatto contatto:rubrica){
                bw.write(contatto.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
            return true;
        }
   }


    public void addContact() throws IOException
    {
        Contatto cont = new Contatto();
        try
        {

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
                Contatto.etichetta etichettaScelta = switch (tast.nextInt())
                        {
                            case 1 -> Contatto.etichetta.PADRE;
                            case 2 -> Contatto.etichetta.MADRE;
                            case 3 -> Contatto.etichetta.GENITORE;
                            case 4 -> Contatto.etichetta.FRATELLO;
                            case 5 -> Contatto.etichetta.SORELLA;
                            case 6 -> Contatto.etichetta.CONIUGE;
                            case 7 -> Contatto.etichetta.CONVIVENTE;
                            case 8 -> Contatto.etichetta.PARTNER;
                            case 9 -> Contatto.etichetta.FIGLIO_A;
                            case 10 -> Contatto.etichetta.PARENTE;
                            case 11 -> Contatto.etichetta.LAVORO;
                            default -> Contatto.etichetta.ALTRO;
                        };
                cont.setEtichetta(etichettaScelta);
                cont.setUltimaModifica(parseTime());
                System.out.println("Perfetto, il nuovo contatto è stato creato");
                tast.nextLine();
                rubrica.add(cont);
                try
                {
                    if (writeOnFile())
                    {
                        System.out.println("Contatto è stato salvato sulla rubrica");
                    } else System.out.println("Qualcosa è andato storto, riprova");
                } catch (FileNotFoundException e)
                {
                    System.out.println("File non trovato, imbecille");
                }
        }catch(FileNotFoundException e){
            System.out.println("File non trovato, riprovi");
        }

    }
    public void removeContact(){
        System.out.println("Telefono?");
        String str = tast.nextLine().toLowerCase();
        for(Contatto cont : rubrica){
            if(cont.getTelefono().equals(str)){
                System.out.println("Trovato, rimuovo subito");
                rubrica.remove(cont);
                break;
            }
            System.out.println("Non ho trovato il contatto secondo il numero specificato, forse lo devi ancora inserire:)");
        }
    }
    public boolean modify(){
        System.out.println("Telefono?");
        String str = tast.nextLine().toLowerCase();
        for(Contatto cont : rubrica){
            if(cont.getTelefono().equals(str)){
                System.out.println("Trovato, cosa vuoi modificare?");

                System.out.println("""
                        1- Nome
                        2- Cognome
                        3- Etichetta
                        4- Numero di telefono
                        5- Email
                        """);
                int sc=tast.nextInt();
                switch (sc)
                {
                    case 1 ->
                    {
                        System.out.println("Scrivi qua il nuovo nome ");
                        tast.nextLine();
                        String string = tast.nextLine().toLowerCase();
                        cont.setNome(string);
                        cont.setUltimaModifica(parseTime());
                        System.out.println("Fatto :3");
                        return true;
                    }
                    case 2 ->
                    {
                        System.out.println("Scrivi qua il nuovo cognome ");
                        tast.nextLine();
                        String string = tast.nextLine().toLowerCase();
                        cont.setCongnome(string);
                        cont.setUltimaModifica(parseTime());
                        System.out.println("Fatto :3");
                        return true;
                    }
                    case 3 ->
                    {
                        System.out.println("Scegli una nuova etichetta ");
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
                        Contatto.etichetta etichettaScelta = switch (tast.nextInt())
                                {
                                    case 1 -> Contatto.etichetta.PADRE;
                                    case 2 -> Contatto.etichetta.MADRE;
                                    case 3 -> Contatto.etichetta.GENITORE;
                                    case 4 -> Contatto.etichetta.FRATELLO;
                                    case 5 -> Contatto.etichetta.SORELLA;
                                    case 6 -> Contatto.etichetta.CONIUGE;
                                    case 7 -> Contatto.etichetta.CONVIVENTE;
                                    case 8 -> Contatto.etichetta.PARTNER;
                                    case 9 -> Contatto.etichetta.FIGLIO_A;
                                    case 10 -> Contatto.etichetta.PARENTE;
                                    case 11 -> Contatto.etichetta.LAVORO;
                                    default -> Contatto.etichetta.ALTRO;
                                };
                        cont.setEtichetta(etichettaScelta);
                        cont.setUltimaModifica(parseTime());
                        System.out.println("Fatto :3");
                        return true;
                    }
                    case 4 ->
                    {
                        System.out.println("Scrivi qua il nuovo numero di telefono ");
                        tast.nextLine();
                        String string = tast.nextLine().toLowerCase();
                        cont.setTelefono(string);
                        cont.setUltimaModifica(parseTime());
                        System.out.println("Fatto :3");
                        return true;
                    }
                    case 5->
                    {
                        System.out.println("Inserisci qua il nuovo email ");
                        tast.nextLine();
                        String string = tast.nextLine().toLowerCase();
                        cont.setEmail(string);
                        cont.setUltimaModifica(parseTime());
                        System.out.println("Fatto :3");
                        return true;
                    }
                }
            }

        }
        System.out.println("Non ho trovato il contatto secondo il numero specificato, forse lo devi ancora inserire:)");
        return false;
    }
    public void printRubrica(){
       rubrica.sort(Comparator.comparing(Contatto::getNome));
       for(Contatto cont: rubrica){
           System.out.println(cont.toString());
       }
    }
}
