import java.util.ArrayList;

public class Pessoa
{
    String nome;
    ArrayList<Unidade> unidadesAlugadas;
    ArrayList<Unidade> unidadesCompradas;

    public Pessoa()
    {
        this.nome = "Sem nome";
        this.unidadesAlugadas = new ArrayList<Unidade>();
        this.unidadesCompradas = new ArrayList<Unidade>();
    }

    //#region Getters e Setter
    public String getNome()
    {
        return nome;
    }
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    public ArrayList<Unidade> getUnidadesAlugadas()
    {
        return unidadesAlugadas;
    }
    public void setUnidadesAlugadas(ArrayList<Unidade> unidadesAlugadas)
    {
        this.unidadesAlugadas = unidadesAlugadas;
    }
    public ArrayList<Unidade> getUnidadesCompradas()
    {
        return unidadesCompradas;
    }
    public void setUnidadesCompradas(ArrayList<Unidade> unidadesCompradas)
    {
        this.unidadesCompradas = unidadesCompradas;
    }
    //#endregion

    public void addUnidadeAlugada(Unidade unidade)
    {
        this.unidadesAlugadas.add(unidade);
    }

    public void addUnidadeComprada(Unidade unidade)
    {
        this.unidadesCompradas.add(unidade);
    }

    public void removerUnidadeAlugada(Unidade unidade)
    {
        this.unidadesAlugadas.remove(unidade);
    }

    public void removerUnidadeComprada(Unidade unidade)
    {
        this.unidadesCompradas.remove(unidade);
    }

    @Override
    public String toString()
    {
        String unidadesAlugadas;
        int qntUnidadesAlugadas = this.unidadesAlugadas.size();
        if (qntUnidadesAlugadas == 0)
        {
            unidadesAlugadas = "Nenhuma unidade alugada.";
        }
        else
        {
            unidadesAlugadas = qntUnidadesAlugadas + ".";
        }
        return "Nome: " + this.nome + "\n" +
               "Unidades alugadas: " + unidadesAlugadas + "\n" +
               "Unidades compradas: " + this.unidadesCompradas.size() + "\n";
    }

}

