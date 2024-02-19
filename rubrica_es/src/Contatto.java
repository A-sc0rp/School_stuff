import java.time.LocalDateTime;

public class Contatto
{
    enum etichetta{
        PADRE,
        MADRE,
        GENITORE,
        FRATELLO,
        SORELLA,
        CONIUGE,
        CONVIVENTE,
        PARTNER,
        FIGLIO_A,
        PARENTE,
        LAVORO,
        ALTRO
    }
    private String nome, congnome, telefono, email;
    static etichetta etichetta;
    private LocalDateTime ultimaModifica;

    public String getNome()
    {
        return nome;
    }

    public String getEmail()
    {
        return email;
    }

    public etichetta getEtichetta()
    {
        return etichetta;
    }

    public String getCongnome()
    {
        return congnome;
    }

    public String getTelefono()
    {
        return telefono;
    }

    public LocalDateTime getUltimaModifica()
    {
        return ultimaModifica;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public void setCongnome(String congnome)
    {
        this.congnome = congnome;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setEtichetta(etichetta etichetta)
    {
        this.etichetta = etichetta;
    }

    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }

    public void setUltimaModifica(LocalDateTime ultimaModifica)
    {
        this.ultimaModifica = ultimaModifica;
    }

    @Override
    public String toString()
    {
        return "Contatto{" +
                "nome='" + nome + '\'' +
                ", congnome='" + congnome + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", etichetta='" + etichetta + '\'' +
                ", ultima modifica del contatto=" + ultimaModifica +
                '}';
    }
}
