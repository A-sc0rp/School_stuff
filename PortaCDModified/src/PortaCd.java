import java.util.Scanner;
import java.util.ArrayList;

public class PortaCd
{
    Scanner tast = new Scanner(System.in);
    ArrayList<Cd> cd = new ArrayList<>();

    public void addCd(){
        cd.add(new Cd());
        System.out.println("Ok, scrivimi l'autore del disco che vuoi aggiungere");
        cd.get(cd.size()-1).setAutore(tast.nextLine().toLowerCase());
        System.out.println("Nome dell'album?");
        cd.get(cd.size()-1).setNomeAlbum(tast.nextLine().toLowerCase());
        System.out.println("Durata?");
        cd.get(cd.size()-1).setDurata(tast.nextInt());
        System.out.println("Numero dei brani?");
        cd.get(cd.size()-1).setNumBrani(tast.nextInt());
        System.out.println("Perfetto, ora hai un'altro disco");
    }

    public void removeCd(){
        tast.nextLine();
        System.out.println("Autore?");
        String str = tast.nextLine().toLowerCase();
        for(int i = 0; i<cd.size(); i++) {
            if(cd.get(i).getAutore().equals(str)) {
                cd.remove(i);
                System.out.println("Elemento rimosso");
                break;
            }
        }
    }

    public void searchCd(){
        tast.nextLine();
        System.out.println("Autore?");
        String str = tast.nextLine().toLowerCase();
        for (Cd value : cd) {
            if (value.getAutore().equals(str))
                //System.out.println("test");
                value.toString();
            break;
        }
    }

    public void modCD(){
        System.out.println("Scrivi al posizione del disco che vouoi modificare");
        int i = tast.nextInt();
        System.out.println("Cosa vuoi modiificare?");
        System.out.println("1 - autore, 2 - numero brani, 3 - nome album, 4 - durata, 5 - non voglio piu niente, fammi uscire da qui?");
        int a = tast.nextInt();
        switch (a)
        {
            case 1 ->
            {   tast.nextLine();
                cd.get(i).setAutore(tast.nextLine());
                System.out.println("Ok, fatto");
            }
            case 2 ->
            {   tast.nextLine();
                cd.get(i).setNumBrani(tast.nextInt());
                System.out.println("Ok, fatto");
            }
            case 3 ->
            {   tast.nextLine();
                cd.get(i).setNomeAlbum(tast.nextLine());
                System.out.println("Ok, fatto");
            }
            case 4 ->
            {   tast.nextLine();
                cd.get(i).setDurata(tast.nextInt());
                System.out.println("Ok, fatto");
            }
            case 5 -> System.out.println("Ok, ok, niente agressione per favore");

        }
    }

    public void toAllStringCD(){
        System.out.println(cd.toString());
    }





}