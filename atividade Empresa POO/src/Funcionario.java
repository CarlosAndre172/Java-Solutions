public class Funcionario
{
    private int matricula = 0;
    private String nome = "";
    private String cpf = "";
    private String rg = "";
    private String dataNascimento = "";
    private String grauDeFormacao = "";
    private float salario = 0f;
    private Departamento deptPertencente;


    // Construtores
    public Funcionario()
    {
        this.matricula = 0;
        this.nome = "";
        this.cpf = "";
        this.rg = "";
        this.dataNascimento = "";
        this.grauDeFormacao = "";
        this.salario = 0f;
        this.deptPertencente = null;
    }

    public Funcionario(int matricula, String nome, String cpf, String rg, String dataNascimento, String grauDeFormacao, float salario, Departamento departamento)
    {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.grauDeFormacao = grauDeFormacao;
        this.salario = salario;
        this.deptPertencente = departamento;
    }

    //#region Getters e Setters;
    public void setFuncionario(int matricula, String nome, String cpf, String rg, String dataNascimento, String grauDeFormacao, float salario, Departamento departamento)
    {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.grauDeFormacao = grauDeFormacao;
        this.salario = salario;
        this.deptPertencente = departamento;
    }

    public void setDeptPertencente(Departamento deptPertencente)
    {
        this.deptPertencente = deptPertencente;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public void setGrauDeFormacao(String grauDeFormacao) {
        this.grauDeFormacao = grauDeFormacao;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int getMatricula()
    {
        return this.matricula;
    }
    public String getNome()
    {
        return this.nome;
    }
    public String getCpf()
    {
        return this.cpf;
    }
    public String getRg()
    {
        return this.rg;
    }
    public String getDataNascimento()
    {
        return this.dataNascimento;
    }
    public String getGrauDeFormacao()
    {
        return this.grauDeFormacao;
    }
    public float getSalario()
    {
        return this.salario;
    }
    public Departamento getDeptPertencente()
    {
        return this.deptPertencente;
    }
    //#endregion

    @Override
    public String toString()
    {
        return "Dados do de " + nome + "\n"
        + "cpf: " + cpf + "\n"
        + "RG: " + rg + "\n"
        + "Data de Nascimento: " + dataNascimento + "\n"
        + "Grau de Formação: " + grauDeFormacao + "\n"
        + "Salario: " + salario + "\n"
        + "Departamento: " + deptPertencente.getNome() + "\n"
        + "matricula: " + matricula + "\n";
    }
}
