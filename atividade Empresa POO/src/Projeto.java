public class Projeto
{
    private Departamento deptResponsavel;
    private int codigo = 0;
    private String titulo = "";
    private float valorInvestimento = 0f;
    private int qntHoras = 0;

    /// Construtor
    public Projeto()
    {
        this.codigo = 0;
        this.titulo = "";
        this.valorInvestimento = 0f;
        this.qntHoras = 0;
        this.deptResponsavel = null;
    }

    public Projeto(int codigo, String titulo, float valorInvestimento, int qntHoras, Departamento deptResponsavel)
    {
        this.codigo = codigo;
        this.titulo = titulo;
        this.valorInvestimento = valorInvestimento;
        this.qntHoras = qntHoras;
        this.deptResponsavel = deptResponsavel;
    }

    //#region getters e setters;
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDeptResponsavel(Departamento deptResponsavel) {
        this.deptResponsavel = deptResponsavel;
    }

    public void setQntHoras(int qntHoras) {
        this.qntHoras = qntHoras;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setValorInvestimento(float valorInvestimento) {
        this.valorInvestimento = valorInvestimento;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public Departamento getDeptResponsavel() {
        return this.deptResponsavel;
    }

    public int getQntHoras() {
        return this.qntHoras;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public float getValorInvestimento() {
        return this.valorInvestimento;
    }
    //#endregion


    @Override
    public String toString()
    {
        return "Projeto " + titulo + " do departamento " + deptResponsavel.getNome() + 
        ".\nHoras esperadas para esse projeto: " + qntHoras + "."
        + "\nCódigo #" + codigo
        + "\nValor investido nesse projeto: " + valorInvestimento + "R$\n";
    }
}
