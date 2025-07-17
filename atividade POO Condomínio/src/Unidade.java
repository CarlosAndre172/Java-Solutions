import java.util.ArrayList;

public class Unidade
{
    private Pessoa inquilino;
    private ArrayList<Pessoa> donos;

    public Unidade()
    {
        this.inquilino = new Pessoa();
        this.donos = new ArrayList<Pessoa>();
    }

    public Unidade(Pessoa inquilino, ArrayList<Pessoa> donos)
    {
        this.inquilino = inquilino;
        this.donos = donos;
    }

    public Unidade(Pessoa inquilino)
    {
        this.inquilino = inquilino;
        this.donos = new ArrayList<Pessoa>();
    }

    //#region getters e Setters
    public Pessoa getInquilino()
    {
        return inquilino;
    }
    public void setInquilino(Pessoa inquilino)
    {
        this.inquilino = inquilino;
    }
    public ArrayList<Pessoa> getDonos()
    {
        return donos;
    }
    public void setDonos(ArrayList<Pessoa> donos)
    {
        this.donos = donos;
    }
    //#endregion

    public void comprarUnidade(Pessoa dono)
    {
        this.donos.add(dono);
        dono.addUnidadeComprada(this);
    }

    public void alugarUnidade(Pessoa inquilino)
    {
        if (this.inquilino.getNome() != "Sem nome")
        {
            System.out.println("Unidade já alugada! Trocando os inquilinos.");
            this.inquilino.removerUnidadeAlugada(this);
        }
       
        this.inquilino = inquilino;
        inquilino.addUnidadeAlugada(this);
    }

    @Override
    public String toString()
    {
        String donosDaUnidade = "";
        for (Pessoa dono : this.donos)
        {
            donosDaUnidade += "\n" + dono.getNome();
        }
        return "Dados da unidade: "
                + "\n Inquilino: " + inquilino.getNome()
                + "\n Donos da unidade: " + donosDaUnidade + "\n";
    }
}
