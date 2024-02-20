import com.sun.security.jgss.GSSUtil;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;
import java.io.*;
import java.time.*;
public class Rubrica
{
    ArrayDeque<Contatto> rubrica = new ArrayDeque<>();
    Scanner tast = new Scanner(System.in);
    LocalDateTime date = LocalDateTime.now();
    String text = date.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
    LocalDateTime parsedDate = LocalDateTime.parse(text, DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));

   public boolean readWriteOnFile(int mode, String path_to_the_file, Contatto cont) throws IOException{

           File file = new File(path_to_the_file);
           BufferedReader br = new BufferedReader(new FileReader(file));
           BufferedWriter bw = new BufferedWriter(new FileWriter(file));
           if(mode==0){
               return true;
           }
           else if(mode==1){
               System.out.println(br.readLine());
               br.close();
               return true;
           }
           else if(mode==2){
               try
               {
                   bw.write(cont.toString());
                   bw.flush();
                   bw.close();
               }catch(FileNotFoundException e){
                   System.out.println("Errore, file non trovato");
                   return false;

               }               return true;
           }
           return true;
   }
    public void addContact() throws IOException
    {
        Contatto cont = new Contatto();
       if(readWriteOnFile(0, "rubrica.txt", cont))
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
           rubrica.add(new Contatto());
           if(readWriteOnFile(2, "rubrica.txt", cont)){
               System.out.println("Contatto è stato salvato sulla rubrica");
           }
           else System.out.println("Qualcosa è andato storto, riprova");
       }
       else System.out.println("File non esiste in questa directory");
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
                        String string =tast.nextLine().toLowerCase();
                        cont.setNome(string);
                        cont.setUltimaModifica(parsedDate);
                        System.out.println("Fatto :3");
                    }
                    break;
                    case 2:{
                        System.out.println("Scrivi qua il nuovo cognome ");
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



}
