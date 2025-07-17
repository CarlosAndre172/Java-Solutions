import java.util.ArrayList;

public class Condominio
{
    private Pessoa adm;
    private ArrayList<Unidade> unidades;

    public Condominio(Pessoa adm, ArrayList<Unidade> unidades)
    {
        this.adm = adm;
        this.unidades = unidades;
    }

    public Condominio(Pessoa adm)
    {
        this.adm = adm;
        this.unidades = new ArrayList<Unidade>();
    }

    public Pessoa getAdm()
    {
        return adm;
    }

    public ArrayList<Unidade> getUnidades()
    {
        return unidades;
    }

    public void addUnidade(Unidade unidade)
    {
        this.unidades.add(unidade);
    }

    @Override
    public String toString()
    {
        return "Administrador do condomínio:\n" + adm + "\n" + "\nQuantidade de Unidades no condomínio: " + unidades.size() + ".\n";
    }
    
} 
