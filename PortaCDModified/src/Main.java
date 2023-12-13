/*scrivere un programma portacd che possa contenere i cd in un array dinamico. deve contenere i metodi di eliminazione, aggiunta e ricerca dei cd secondo autore e modificare i cd secondo la posizione, comparare la durata del cd  e stampare tutti i cd */
import java.util.Scanner;
import java.util.ArrayList;

public class Main{


    public static void main(String[] args) throws java.lang.Exception{

        Scanner tast = new Scanner(System.in);
        PortaCd pcd=new PortaCd();
        boolean a=true;
        while(a){
            System.out.println("Benvenuto nel tuo porta CD, per ora hai "+pcd.cd.size()+" Cd nella tua collezione");
            System.out.println("Cosa desideri fare?");
            System.out.println("1 - stampare tutti i cd nella tua collezione, 2 - aggiungere dei nuovi cd, 3 - rimuovere il cd che non ti piace, 4 - ricercare il cd in base all'autore,5 - modifica dei cd, 6 - uscire dal programma");
            int sc=tast.nextInt();
            switch(sc){
                case 1:{
                    pcd.toAllStringCD();
                }break;
                case 2:{
                    pcd.addCd();
                }
                break;
                case 3:{
                    pcd.removeCd();
                }
                break;
                case 4:{
                    pcd.searchCd();
                }
                break;
                case 5:{
                    pcd.modCD();
                }
                break;
                case 6:{
                    System.out.println("Esco, buona giornata");
                    a=false;
                }
                break;
            }
        }
    }
}