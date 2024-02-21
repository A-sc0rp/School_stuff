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
    LocalDateTime date = LocalDateTime.now();
    String text = date.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
    LocalDateTime parsedDate = LocalDateTime.parse(text, DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));

   private boolean writeOnFile(int mode, Contatto cont) throws IOException
   {
        File file = new File("rubrica.txt");
        switch(mode){
            case 0 -> {
                if(file.createNewFile()) return true;
                else{
                    file.delete();
                    return file.createNewFile();
                }
            }
            case 1 ->{
                try(BufferedWriter bw = Files.newBufferedWriter(Path.of("rubrica.txt"))){
                    for(Contatto contatto:rubrica){
                        bw.write(contatto.toString());
                        bw.newLine();
                    }
                    return true;
                }
            }
        }
        return true;
   }
    public void addContact() throws IOException
    {
        Contatto cont = new Contatto();
        try
        {
            if (writeOnFile(0, cont))
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
                cont.setUltimaModifica(parsedDate);
                System.out.println("Perfetto, il nuovo contatto è stato creato");
                rubrica.add(cont);
                try
                {
                    if (writeOnFile(1, cont))
                    {
                        System.out.println("Contatto è stato salvato sulla rubrica");
                    } else System.out.println("Qualcosa è andato storto, riprova");
                } catch (FileNotFoundException e)
                {
                    System.out.println("File non trovato, imbecille");
                }
            } else System.out.println("File non esiste in questa directory");
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
    public void modify(){
        System.out.println("Telefono?");
        tast.nextLine();
        String str = tast.nextLine().toLowerCase();
        for(Contatto cont : rubrica){
            if(cont.getTelefono().equals(str)){
                System.out.println("Trovato, cosa vuoi modificare?");

                System.out.println("""
                        1- Nome
                        2- Cognome
                        3- Etichetta
                        4- Numero di telefono
                        """);
                int sc=tast.nextInt();
                switch(sc){
                    case 1:{
                        System.out.println("Scrivi qua il nuovo nome ");
                        tast.nextLine();
                        String string =tast.nextLine().toLowerCase();
                        cont.setNome(string);
                        cont.setUltimaModifica(parsedDate);
                        System.out.println("Fatto :3");
                    }
                    break;
                    case 2:{
                        System.out.println("Scrivi qua il nuovo cognome ");
                        tast.nextLine();
                        String string = tast.nextLine().toLowerCase();
                        cont.setCongnome(string);
                        cont.setUltimaModifica(parsedDate);
                        System.out.println("Fatto :3");
                    }
                    break;
                    case 3:{
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
                        cont.setUltimaModifica(parsedDate);
                    }
                    break;
                    case 4:{
                        System.out.println("Scrivi qua il nuovo numero di telefono ");
                        String string = tast.nextLine().toLowerCase();
                        cont.setTelefono(string);
                        cont.setUltimaModifica(parsedDate);
                        System.out.println("Fatto :3");
                    }
                    break;
                }
            }
            System.out.println("Non ho trovato il contatto secondo il numero specificato, forse lo devi ancora inserire:)");
        }
    }
    public void printRubrica(){
       rubrica.sort(Comparator.comparing(Contatto::getNome));
       for(Contatto cont: rubrica){
           System.out.println(cont.toString());
       }
    }
}
