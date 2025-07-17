import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

//Acho que vou fazer função recursiva no lugar de um while deve ser mais eficiente para fazer uma interface de escolha de seleção

//Como tem que fazer a POO na perspectiva de alunos em um único txt, vai ter que criar uma classe turma para guardar a lista de alunos

//Vai primeiro pedir o nome do aluno e depois fazer o processo de adicionar as informações. 

public class App
{
    // A matriz tem seus elementos organizados da seguinte forma:
    // da coluna 1 até a 6, temos: Disciplina, Nota 1, Nota 2, Frequência, Status e Nota Final.
    static String matrizDeRelacao[][] = new String[100][6];


    public static void main(String[] args) throws Exception
    {
        // Inicializa o arquivo txt que vai guardar as disciplinas.
        File matrizDeDisciplinasTXT = new File("./Matriz de disciplinas.txt");
        inicializarMatrizTXT(matrizDeDisciplinasTXT);

        // Lê os alunos do arquivo TXT no novo formato
        ArrayList<Aluno> listaAlunos = lerAlunosTXT(new File("./Alunos.txt"));/////////////////

        // Exemplo: exibe quantos alunos foram carregados
        JOptionPane.showMessageDialog(null, "Foram carregados " + listaAlunos.size() + " alunos do arquivo.");///////////////

        // Janela Principal é a primeira janela que aparece, ela contem o menu de opções.
        File janelaPrincipal = new File("./window_layouts/main.html");
        criarJanela(janelaPrincipal.getName(), janelaPrincipal);


        String opcaoSelecionada = JOptionPane.showInputDialog("Digite sua opção aqui: ");
        opcaoSelecionada = processarEscolha(opcaoSelecionada, matrizDeRelacao);

        while(!opcaoSelecionada.equals("4"))
        {
            if (opcaoSelecionada.equals("0"))
            {
                opcaoSelecionada = JOptionPane.showInputDialog("Digite sua opção aqui: ");
                processarEscolha(opcaoSelecionada, matrizDeRelacao);
            }
            else
            {
                opcaoSelecionada = JOptionPane.showInputDialog("Digite sua opção aqui: ");
                processarEscolha(opcaoSelecionada, matrizDeRelacao);
            }
        }
        salvarMatrizEmTXT(matrizDeRelacao);
    }

    // Função que recebe o que o usuário digitou e retorna a mesma coisa, depois de ter corrido o método ou função
    // específico para a escolha. Se a escolha tiver fora do menu de 1 até 4, retorna "0".
    // Note que o primeiro caractere é o que é utilizado no switch, portanto, se digitarem 1 e depois um monte de
    // coisa nada a ver na frente, ele vai pegar o 1.
    //*  Em suma, essa função processa e executa o método de acordo com o que o usuário digitou no menu.
    public static String processarEscolha(String opcaoEscolhida, String[][] matrizQueSeraEditada)
    {
        // Essa variável armazena a 1º posição da string que o usuário digitou.
        char opcaoEscolhidaChar = opcaoEscolhida.charAt(0);
        switch (opcaoEscolhidaChar)
        {
            case '1':
                adicionarRelacaoNaMatriz(matrizQueSeraEditada, adicionarDisciplina());
                return opcaoEscolhida;

            case '2':
                String disciplinaConsultada = JOptionPane.showInputDialog("Digite a disciplina que deseja consultar: ");
                consultarDisciplina(disciplinaConsultada, matrizQueSeraEditada, 0);
                return opcaoEscolhida;

            case '3':
                mostrarDisciplinas(matrizQueSeraEditada);
                return opcaoEscolhida;

            case '4':
                return opcaoEscolhida;
            
            default:
                return "0";
        }
    }

    // Adiciona a relação de disciplina na matriz de resolução.
    public static void adicionarRelacaoNaMatriz(String[][] matrizDeRelacao, String[] relacao)
    {
        for (int i = 0; i < matrizDeRelacao.length; i++)
        {
            // Vê se a posição da linha da matriz não tem nada para saber se pode escrever algo nessa linha:
            if (matrizDeRelacao[i][0] == null)
            {
                for (int j = 0; j < 6; j++)
                {
                    matrizDeRelacao[i][j] = relacao[j];
                }
                break;
            }
        }
    }

    // Pega os dados referente a uma disciplina e retorna um array de Strings com esses dados.
    public static String[] adicionarDisciplina()
    {
        //Uma forma de fazer é declarar essa variável para armazenar o valor do input para depois converter para outros tipos
        /*
          Isso de converter o valor do input pode ser feito quando o tipo da próxima variável não será uma string, ou então
          você consegue ter um controle melhor se você vai precisar converter o input para um outro tipo de dado ou se você não vai precisar.
        */
        String input;

        /* 
        As partes seguintes vão ter atribuições aos valores do objeto que será criado, sempre vai ter um 
        nomeDoObjetoDaClasse.setAtributo( "valorQueSeráPassadoParaSerAtribuído" ) para atribuir o valor ao atributo do objeto. 
        Sempre vai ter um  nomeDoObjetoDaClasse.getAtributo() que armazena o valor desse atributo

        perceba que eu posso colocar funções dentro de funções, pq a função retorna um valor do respectivo tipo e por isso pode ser
        considerada um parâmetro
        */

        //cria o objeto aqui. Dps acionar um construtor se a atrubuição direta não der certo
        Disciplina disciplinaAluno = new Disciplina();

        // Inserir disciplina, notas e frequência;
        // ?      Precisa adicionar outro scanner porque ele é local dessa função, não dá pra chamar outro
        disciplinaAluno.setDisciplina(JOptionPane.showInputDialog("Insira a disciplina: "));

        input = JOptionPane.showInputDialog("Insira a primeira nota: ");
        disciplinaAluno.setNotaU1(Float.parseFloat(input)); //converte o input para float e atribui

        input = JOptionPane.showInputDialog("Insira a segunda nota: ");
        disciplinaAluno.setNotaU2(Float.parseFloat(input));

        input = JOptionPane.showInputDialog("Insira a frequencia (em porcentagem, mas nao digite o %): ");
        disciplinaAluno.setFreq(Integer.parseInt(input)); //converte o input para inteiro e atribui

        //Outra notação possível:  float nota1 = Float.parseFloat(JOptionPane.showInputDialog("Insira a primeira nota: "));

        disciplinaAluno.setMediaParcial((disciplinaAluno.getNotaU1() + disciplinaAluno.getNotaU2()) / 2);

        // Checa o status do aluno, se ele tá aprovado, reprovado por falta, reprovado por nota ou se ele foi pra final.	
        if (disciplinaAluno.getMediaParcial() >= 7 && disciplinaAluno.getFreq() >= 75)
        {
            disciplinaAluno.setStatus("Aprovado por media.");
        }
        else
        {
            if (disciplinaAluno.getFreq() < 75)
            {
                disciplinaAluno.setStatus("Reprovado por falta.");
            }
            else
            {
                if (disciplinaAluno.getMediaParcial() >= 4)
                {
                    disciplinaAluno.setNotaFinal((float)((5.0 - disciplinaAluno.getMediaParcial() * 0.6) / 0.4));
                    disciplinaAluno.setStatus("Na final em " + disciplinaAluno.getDisciplina() + ".");
                }
                else
                {
                    disciplinaAluno.setStatus("Reprovado por nota, sem direito a final.");
                }
            }
        }
        //? Substituí essa parte do scan que era necessária para limpar o buffer por via das dúvidas
        JOptionPane.showMessageDialog(null, "\n"); //Coloca mais uma vez para limpar o scan (a stream) antes de fechá-lo

        disciplinaAluno.setDisciplina(formatarDisciplina(disciplinaAluno.getDisciplina()));

        String[] relacaoCompleta = {disciplinaAluno.getDisciplina(), 
                        Float.toString(disciplinaAluno.getNotaU1()), 
                        Float.toString(disciplinaAluno.getNotaU2()), 
                        Integer.toString(disciplinaAluno.getFreq()), 
                        disciplinaAluno.getStatus(),
                        Float.toString(disciplinaAluno.getNotaFinal())};

        return relacaoCompleta;
    }

    // Essa função retorna a disciplina com o primeiro caractere sendo uma letra maiúscula.
    // Se o 1º Caractere não for uma letra, percorre até achar um que seja. Só então deixa maiúsculo.
    // Retorna null caso a string esteja vazia, tenha caracteres inválidos (acento solto e etc), ou só tenha números.
    public static String formatarDisciplina(String disciplinaNaoFormatada)
    {
        // Isso evita que entre uma disciplina vazia aqui, pq se n o computador grita comigo e aí é paia.
        // Se o caba botasse só um enter ele já ficava nervosinho.
        if (disciplinaNaoFormatada == null || disciplinaNaoFormatada.isEmpty())
        {
            return null;
        }
        
        // "Matches" olha pra ver se tem algum caractere que especificado dentro da string. Se tiver, retorna true.
        // \\p{L} Diz que qualquer letra de qualquer alfabeto pode ser usada, isso inclui letras acentuadas.
        // 0-9 Diz que qualquer número pode ser usado. E esse espaço em branco no final é pra permitir espaços.
        // O sinal de "+" diz que pelo menos um desses caracteres deve estar presente e que a string pode conter vários deles.
        // Como usei !matches, se a string tiver algum caractere que não seja um desses o método retorna null.
        if (!disciplinaNaoFormatada.matches("[\\p{L}0-9 ]+"))
        {
            return null;
        }
        
        // Converte tudo para minúsculas.
        disciplinaNaoFormatada = disciplinaNaoFormatada.toLowerCase();

        // Esse loop acha o 1º caractere que é uma letra.
        int charAtual = 0;
        char primeiroCaractere = disciplinaNaoFormatada.charAt(charAtual);
        while (Character.isLetter(primeiroCaractere) == false && charAtual < disciplinaNaoFormatada.length() - 1)
        {
            charAtual++; //* charAtual vai ser a posição do primeiro caractere que é uma letra.
            primeiroCaractere = disciplinaNaoFormatada.charAt(charAtual);
        }
        
        // Essa parte aqui corta tudo que vem antes do primeiro caractere que é uma letra e depois bota ele em maiúsculo.
        String disciplinaFormatada = Character.toUpperCase(primeiroCaractere) + disciplinaNaoFormatada.substring(charAtual + 1);

        // Tem que checar dnv pq se não ele volta uma string seca.
        //? Ex: 1234567890 Só tem número, aí a string ia ficar sem nada e ia acabar o mundo (pc explode).
        if (disciplinaFormatada == null || disciplinaFormatada.isEmpty() || disciplinaFormatada.isBlank())
        {
            return null;
        }

        return disciplinaFormatada;
    }

    // Procura a disciplina na matriz de relação.
    public static void consultarDisciplina(String disciplinaProcurada, String[][] matrizRelacao, int counter)
    {
        disciplinaProcurada = formatarDisciplina(disciplinaProcurada);

        // O loop continua até achar a disciplina, até achar uma posição vazia ou até chegar no final da matriz.
        // O != null previne que o programa acesse uma posição vazia, que se não o matrizRelacao[counter][0].equals(disciplinaProcurada) dá erro.
        if (counter < matrizRelacao.length && matrizRelacao[counter][0] != null)
        {
            if (matrizRelacao[counter][0].equals(disciplinaProcurada))
            {
                File consultaHTML = new File("./window_layouts/consulta_disciplina.html");
                String consultaHTML_String = lerArquivoHTML(consultaHTML);

                // Substitui na string do html esses nomes entre aspas (ques testão presentes no html como placeholders)
                // pelos valores da disciplina procurada;
                consultaHTML_String = consultaHTML_String.replace("{{Disciplina}}", matrizRelacao[counter][0]);
                consultaHTML_String = consultaHTML_String.replace("{{Nota1}}", matrizRelacao[counter][1]);
                consultaHTML_String = consultaHTML_String.replace("{{Nota2}}", matrizRelacao[counter][2]);
                consultaHTML_String = consultaHTML_String.replace("{{Frequencia}}", matrizRelacao[counter][3]);
                consultaHTML_String = consultaHTML_String.replace("{{Status}}", matrizRelacao[counter][4]);
                consultaHTML_String = consultaHTML_String.replace("{{NotaFinal}}", matrizRelacao[counter][5]);

                JFrame janelaConsulta = new JFrame(matrizRelacao[counter][0]);
                janelaConsulta.setSize(720,480);
                janelaConsulta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                janelaConsulta.setLocationRelativeTo(null);

                JLabel layoutHTML = new JLabel(consultaHTML_String, 0);
                janelaConsulta.add(layoutHTML);
                janelaConsulta.setVisible(true);

                while (janelaConsulta.isVisible())
                {
                    // Espera a janela ser fechada.
                }
                return;
            }
            else
            {
                counter++;
                consultarDisciplina(disciplinaProcurada, matrizRelacao, counter);
            }
        }
        else
        {
            JFrame janelaConsulta = new JFrame("Erro");
            janelaConsulta.setSize(200,140);
            janelaConsulta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            janelaConsulta.setLocationRelativeTo(null);
            JLabel erro = new JLabel("Disciplina não encontrada.", 0);
            janelaConsulta.add(erro);
            janelaConsulta.setVisible(true);
        }
        return;
    }

    public static void mostrarDisciplinas(String[][] matrizDeRelacao)
    {
        try
        {
            BufferedWriter escritorDisciplinasHTML = new BufferedWriter(new FileWriter("./window_layouts/lista_disciplinas.html"));
            escritorDisciplinasHTML.write("<h1> Disciplinas Cadastradas </h1>\n<ul>\n");

            int linhaAtual = 0;
            while(linhaAtual < matrizDeRelacao.length && matrizDeRelacao[linhaAtual][0] != null)
            {
                escritorDisciplinasHTML.write("<li> " + matrizDeRelacao[linhaAtual][0] + "</li>\n");
                linhaAtual++;
            }
            escritorDisciplinasHTML.write("</ul>");
            escritorDisciplinasHTML.close();
        }
        catch(IOException erroEscritaHTML)
        {
            System.out.println("Não foi possível escrever no arquivo HTML: " + erroEscritaHTML.getMessage());
        }

        File disciplinasHTML = new File("./window_layouts/lista_disciplinas.html");
        criarJanela(disciplinasHTML.getName(), disciplinasHTML);
        return;
    }

    // O txt já é incrementado por causa da própria função ReadLine(), então só precisa referenciar as posições da matriz.
    public static String[][] preencherMatrizComtxt(String[][] matrizQueSeraPreenchida, String[] arrayPreenchedor, int linhaAtual)
    {
        for (int j = 0; j < 6; j++)
        {
            matrizQueSeraPreenchida[linhaAtual][j] = arrayPreenchedor[j];
        }
        return matrizQueSeraPreenchida;
    }

    public static void inicializarMatrizTXT(File matriz)
    {
        try
        { //funcionamento padrão
            if (matriz.createNewFile())
            {  // Cria o arquivo se não existir
                System.out.println("Arquivo criado com sucesso!");
            }
            else
            {
                System.out.println("O arquivo já existe.");
                try(BufferedReader txtNaMatriz = new BufferedReader(new FileReader("./Matriz de disciplinas.txt"));)
                {
                    String linhaAtual;
                    String[] infoAluno;
                    int pos_linhaDaMatriz = 0;

                    while ((linhaAtual = txtNaMatriz.readLine()) != null)
                    {
                        // Dá o split e vai se criando um array
                        infoAluno = linhaAtual.split("\\|");
                        // Pega esse array e chama a função preencher matriz com o txt que será feito com um for. Aproveite o que já tem.
                        matrizDeRelacao = preencherMatrizComtxt(matrizDeRelacao, infoAluno, pos_linhaDaMatriz);
                        pos_linhaDaMatriz++;
                    }

                    pos_linhaDaMatriz = 0;
                }
                catch(IOException errotxtNaMatriz)
                {
                    System.out.println("Não foi possível ler o arquivo: " + errotxtNaMatriz.getMessage());
                }
            }
        }
        catch (IOException erro)
        {
            System.out.println("Erro ao criar o arquivo: " + erro.getMessage());
        }
        return;
    }

    public static String lerArquivoHTML(File arqHTML)
    {
        String linha = "";
        String documentoHTML = "";
        try (BufferedReader leitorHTML = new BufferedReader(new FileReader(arqHTML)))
        {
            while ((linha = leitorHTML.readLine()) != null)
            { 
                documentoHTML += linha;
            }
        } 
        catch (IOException e) 
        {
            return "<html><b>Erro ao carregar o arquivo! XXXX</b></html>";
        }
        // Adiciona tags HTML para que o documento seja exibido corretamente.
        // Sem elas, ia aparecer era o código do HTML, e não a interpretação dele.
        return "<html>" + documentoHTML + "</html>"; 
    }

    public static void criarJanela(String nomeDaJanela, File layoutDaJanela)
    {

        JFrame janela = new JFrame("Janela");
        janela.setSize(720,480);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);

        // Essa é uma única string contendo todo o conteúdo do documento HTML.
        String janelaHTML_String = "";
        if (layoutDaJanela != null)
        {
            janelaHTML_String = lerArquivoHTML(layoutDaJanela);
        }

        switch (nomeDaJanela)
        {
            case "main.html":

            JLabel layoutHTML = new JLabel(janelaHTML_String, 0);
            janela.add(layoutHTML);
            break;

            case "lista_disciplinas.html":
            janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JLabel layoutHTML2 = new JLabel(janelaHTML_String, 0);
            janela.add(layoutHTML2);
            

            break;

            default:
                break;
        }
        janela.setVisible(true);
        return;
    }

    public static void salvarMatrizEmTXT(String[][] matrizQueSeraSalva)
    {
        try (BufferedWriter escritorMatriz = new BufferedWriter(new FileWriter("./Matriz de disciplinas.txt")))
        {
            int linhaAtual = 0;
            while(linhaAtual < matrizQueSeraSalva.length && matrizQueSeraSalva[linhaAtual][0] != null)
            {
                escritorMatriz.write( matrizQueSeraSalva[linhaAtual][0] + "|" // Disciplina
                + matrizQueSeraSalva[linhaAtual][1] + "|"    // Nota 1
                + matrizQueSeraSalva[linhaAtual][2] + "|"    // Nota 2
                + matrizQueSeraSalva[linhaAtual][3] + "|"    // Frequência
                + matrizQueSeraSalva[linhaAtual][4] + "|"    // Status
                + matrizQueSeraSalva[linhaAtual][5] + "\n"); // Nota Final

                linhaAtual++;
            }
        }
        catch (IOException erroEscrita)
        {
            System.out.println("Erro ao escrever no arquivo: " + erroEscrita.getMessage());
        }
        return;
    }

    public static ArrayList<Aluno> lerAlunosTXT(File arquivo) 
    {
        ArrayList<Aluno> lista = new ArrayList<Aluno>();
        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) 
        {
            String linha;
            String nomeAluno = null;
            // Lista temporária para armazenar as linhas de disciplinas
            ArrayList<String> disciplinasTemp = new ArrayList<String>();

            while ((linha = leitor.readLine()) != null) 
            {
                // Se a linha estiver vazia, finaliza os dados do aluno atual
                if (linha.trim().isEmpty())
                {
                    if (nomeAluno != null) {
                        Aluno aluno = new Aluno(nomeAluno, disciplinasTemp.size(), 6);
                        for (int i = 0; i < disciplinasTemp.size(); i++) 
                        {
                            String[] dados = disciplinasTemp.get(i).split("|");
                            for (int j = 0; j < 6 && j < dados.length; j++) {
                                aluno.setValor(i, j, dados[j]);
                            }
                        }
                        lista.add(aluno);
                    }
                    nomeAluno = null;
                    disciplinasTemp.clear();
                } 
                else 
                {
                    if (linha.trim().endsWith(":")) {  // Identifica o nome do aluno
                        nomeAluno = linha.substring(0, linha.length() - 1).trim();
                    } else {
                        disciplinasTemp.add(linha.trim());
                    }
                }
            }
        }
        catch (IOException e) 
        {
            System.out.println("Erro ao ler o arquivo de alunos: " + e.getMessage());
        }
        return lista;
    }

    public static void salvarAlunosEmTXT(ArrayList<Aluno> lista, File arquivo) 
    {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivo)))
        {
            for (Aluno aluno : lista) 
            {
                // Escreve o nome do aluno seguido de ':'
                escritor.write(aluno.getNome() + ":\n");

                // Obtém a matriz de disciplinas do aluno
                String[][] matriz = aluno.getMatrizDisciplinas();
                for (int i = 0; i < matriz.length; i++) {
                    if (matriz[i][0] != null) { // Garante que a linha tenha conteúdo
                        StringBuilder linha = new StringBuilder();
                        for (int j = 0; j < 6; j++) {
                            if (matriz[i][j] != null) { // Evita valores null
                                linha.append(matriz[i][j]);
                            }
                            if (j < 5) {
                                linha.append("|");
                            }
                        }
                        escritor.write(linha.toString() + "\n");
                    }
                }
                // Linha vazia para separar os alunos
                escritor.write("\n");
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace(); // Exibe a pilha de erro para facilitar o diagnóstico
        }
    }
}





