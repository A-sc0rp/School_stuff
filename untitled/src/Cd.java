import java.util.Scanner;
import java.util.ArrayList;
public class Cd
{
    private String autore, nomeAlbum;
    private int durata, numBrani;

    public String getAutore()
    {
        return autore;
    }

    public int getDurata()
    {
        return durata;
    }

    public int getNumBrani()
    {
        return numBrani;
    }

    public String getNomeAlbum()
    {
        return nomeAlbum;
    }

    public void setAutore(String autore)
    {
        this.autore = autore;
    }

    public void setDurata(int durata)
    {
        this.durata = durata;
    }

    public void setNomeAlbum(String nomeAlbum)
    {
        this.nomeAlbum = nomeAlbum;
    }

    public void setNumBrani(int numBrani)
    {
        this.numBrani = numBrani;
    }

    @Override
    public String toString()
    {
        return "Cd{" +
                "autore='" + autore + '\'' +
                ", nomeAlbum='" + nomeAlbum + '\'' +
                ", durata=" + durata +
                ", numBrani=" + numBrani +
                '}';
    }
}

