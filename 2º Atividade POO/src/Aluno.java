public class Aluno {
    private String nome;
    private String[][] matrizDisciplinas;

    // Construtor que inicializa o nome e cria a matriz de disciplinas com as dimensões informadas.
    public Aluno(String nome, int numDisciplinas, int numColunas) {
        this.nome = nome;
        this.matrizDisciplinas = new String[numDisciplinas][numColunas];
    }

    // Getter e Setter para o nome do aluno.
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e Setter para a matriz de disciplinas.
    public String[][] getMatrizDisciplinas() {
        return matrizDisciplinas;
    }
    public void setMatrizDisciplinas(String[][] matrizDisciplinas) {
        this.matrizDisciplinas = matrizDisciplinas;
    }

    // Getter para acessar um valor específico na matriz (por exemplo, de uma disciplina e coluna específica).
    public String getValor(int disciplina, int coluna) {
        return matrizDisciplinas[disciplina][coluna];
    }

    // Setter para definir um valor específico na matriz.
    public void setValor(int disciplina, int coluna, String valor) {
        this.matrizDisciplinas[disciplina][coluna] = valor;
    }
}
