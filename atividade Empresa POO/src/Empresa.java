import java.util.ArrayList;

public class Empresa
{
    private ArrayList<Departamento> departamentos;
    private ArrayList<Funcionario> gerentes;
    private ArrayList<Funcionario> funcionarios;
    private String nome = "";
    private String sigla = "";

    //#region Construtores
    public Empresa()
    {
        this.nome = "";
        this.sigla = "";
        this.departamentos = new ArrayList<Departamento>();
        this.gerentes = new ArrayList<Funcionario>();
        this.funcionarios = new ArrayList<Funcionario>();
    }

    public Empresa(String nome, String sigla)
    {
        this.nome = nome;
        this.sigla = sigla;
        this.departamentos = new ArrayList<Departamento>();
        this.gerentes = new ArrayList<Funcionario>();
        this.funcionarios = new ArrayList<Funcionario>();
    }
    //#endregion
    

    //#region Getters e Setters
    public ArrayList<Departamento> getDepartamentos() {
        return departamentos;
    }

    public ArrayList<Funcionario> getGerentes() {
        return gerentes;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setDepartamentos(ArrayList<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public void setGerentes(ArrayList<Funcionario> gerentes) {
        this.gerentes = gerentes;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    //#endregion

    // Adiciona um departamento a empresa e atribui a o departamento a esta empresa.
    public void addDepartamento(Departamento departamento)
    {
        this.departamentos.add(departamento);
        departamento.setEmpresa(this);
    }

    // Adiciona um departamento a empresa e atribui a o departamento a esta empresa.
    public void addGerente(Funcionario gerente)
    {
        this.gerentes.add(gerente);
    }

    @Override
    public String toString()
    {
        String departamentosDessaEmpresa = "\n";

        int qntDepartamentos = this.departamentos.size();
        for (int i = 0; i < qntDepartamentos; i++)
        {
            departamentosDessaEmpresa += this.departamentos.get(i).getNome();
            departamentosDessaEmpresa += "\n";
        }

        return "Empresa " + nome + "(" + sigla + ")" + "\n"
        + "Departamentos: " + departamentosDessaEmpresa + "\n";
    }

} 
