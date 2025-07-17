public class Disciplina {
    private float notaU1 = 0f; //As notas aí e a média.
    private float notaU2 = 0f;
    private float mediaParcial = 0f;
    private float notaFinal = 0f;
    private int freq; // Frequência;
    private String status = "Nao Informado"; // Se o aluno foi aprovado, reprovado blablabla.
    private String disciplina = "Nao Informada";

    public void setNotaU1(float notaU1f)
    {
        this.notaU1 = notaU1f;
        return;
    }

    public void setNotaU2(float notaU2f)
    {
        this.notaU2 = notaU2f;
        return;
    }

    public void setMediaParcial(float mediaParcialf)
    {
        this.mediaParcial = mediaParcialf;
        return;
    }

    public void setNotaFinal(float notaFinalf)
    {
        this.notaFinal = notaFinalf;
        return;
    }

    public void setFreq(int freqf)
    {
        this.freq = freqf;
        return;
    }

    public void setStatus(String statusf)
    {
        this.status = statusf;
        return;
    }

    public void setDisciplina(String disciplinaf)
    {
        this.disciplina = disciplinaf;
        return;
    }

    public float getNotaU1(){return notaU1;}
    public float getNotaU2(){return notaU2;}

    public float getMediaParcial(){return mediaParcial;}
    public float getNotaFinal(){return notaFinal;}
    public int getFreq(){return freq;}
    public String getStatus(){return status;}
    public String getDisciplina(){return disciplina;}
}


//* >> Assosiação simples = Onde uma classe A tem relação com outra classe B. 
// A relação é unidirecional, mas não obrigatoriamente.
// Exemplo: Uma pessoa tem um endereço, mas um endereço não tem uma pessoa.
// Uma classe tem um atributo do tipo de outra classe;
// Pode ser bidirecional (ambas as classes se referenciam) ou unidirecional (apenas uma classe faz referência a outra).
// Em UML é representado por uma linha sólida.

//* >> Agregação = Quando uma classe possui partes de outra classe. É bem similar à associação.
// Exemplo: Um computador tem várias partes, o processador, a placa mãe, a memória, etc. Então, o pc agrega todas essas partes.
// Um objeto pode existir independentemente do outro. A placa mãe pode existir mesmo sem o computador, a memória tbm, etc.
// Uma turma precisa de alunos, mas um aluno pode existir sem uma turma.
// Em UML é representado pode um losango em branco.

//* >> Composição = É bem parecida com agregação, mas tem uma diferença. É basicamente que uma classe depende da outra para existir.
// Exemplo: Uma pessoa tem um coração. Se a pessoa morrer, o coração também morre. Então, a pessoa depende do coração para existir.
// A composição é representada por um losango preto na classe que depende da outra (UML).
// Um objeto não pode existir sem o outro.
// Um carro não pode existir sem um motor, por exemplo.