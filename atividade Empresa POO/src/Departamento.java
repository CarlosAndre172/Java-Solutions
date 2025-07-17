import java.util.ArrayList;

public class Departamento
{
    private Funcionario gerente;
    private String nome = "";
    private Empresa empresa;
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();


    //#region Construtores
    public Departamento()
    {
        this.gerente = null;
        this.nome = "";
        this.empresa = null;
    }

    public Departamento(Empresa empresa, String nome)
    {
        this.gerente = null;
        this.nome = nome;
        this.empresa = empresa;
    }
    
    public Departamento(Funcionario gerente, String nome, Empresa empresa)
    {
        this.gerente = gerente;
        this.nome = nome;
        this.empresa = empresa;
    }
    //#endregion

    //#region Getters e Setters
    public Funcionario getGerente()
    {
        return this.gerente;
    }

    public String getNome() {
        return nome;
    }

    public Empresa getEmpresa()
    {
       return this.empresa;
    }

    public ArrayList<Funcionario> getFuncionarios()
    {
       return this.funcionarios;
    }

    public void setGerente(Funcionario gerente)
    {
        this.gerente = gerente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmpresa(Empresa empresa)
    {
        this.empresa = empresa;
    }
    //#endregion

    // Adiciona um funcionario a esse departamento e atribui o funcionario a esse departamento tambmpem.
    public void lotarFuncionario(Funcionario funcionario)
    {
        this.funcionarios.add(funcionario);
        funcionario.setDeptPertencente(this);
    }

    @Override
    public String toString()
    {
        String funcionarosDesseDepartamento = "\n";

        int qntFuncioarios = this.funcionarios.size();
        for (int i = 0; i < qntFuncioarios; i++)
        {
            funcionarosDesseDepartamento += this.funcionarios.get(i).getNome();
            funcionarosDesseDepartamento += "\n";
        }

        return "Dados do departamento " + nome + " da empresa " + empresa.getNome()
        + ".\nResponsável: " + gerente.getNome() + ".\n"
        + "Funcionários:" + funcionarosDesseDepartamento;
    }
}
