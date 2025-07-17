public class App
{
    public static void main(String[] args) throws Exception
    {
        Empresa empresa = new Empresa("Universidade Estadual da Paraíba", "UEPB");
        Departamento departamento = new Departamento(empresa, "Laboratório de programação II");
        
        // Cruiando os funcionarios e o gerente.
        Funcionario gerente = new Funcionario(10001, "Janderson", "673.890.590-44", "38.754.244-9", "10/10/1990", "Superior Completo", 16550.98f, departamento);
        
        Funcionario funcionario = new Funcionario();
        funcionario.setMatricula(1002);
        funcionario.setNome("Carmilena");
        funcionario.setCpf("123.456.789-00");
        funcionario.setRg("12.345.678-9");
        funcionario.setDataNascimento("01/01/1995");
        funcionario.setGrauDeFormacao("Superior Incomplete");
        funcionario.setSalario(2900.49f);

        Funcionario funcionario1 = new Funcionario(1002, "Josefina", "470.105.360-07", "33.482.173-3", "17/12/2000", "Superior Completo", 2800.98f, departamento);
        Funcionario funcionario2 = new Funcionario(1003, "Zunim Zoião", "799-157-146-69", "12.121.333-4", "10/09/2001", "Fundamental Incompleto", 12.90f, departamento);
        Funcionario funcionario3 = new Funcionario(1004, "Doquinha", "888.936.454-99", "10.101.010-0", "18/10/1967", "Fundamental Incompleto", 12.90f, departamento);
        Funcionario funcionario4 = new Funcionario(1004, "Coxinha", "999.047.565-00", "01.010.101-1", "18/10/1967", "Fundamental Incompleto", 12.90f, departamento);
        
        // Adicionando esses funcionarios no departamento.
        departamento.setGerente(gerente);
        departamento.lotarFuncionario(funcionario);
        departamento.lotarFuncionario(funcionario1);
        departamento.lotarFuncionario(funcionario2);
        departamento.lotarFuncionario(funcionario3);
        departamento.lotarFuncionario(funcionario4);

        // Bota esse departamento aí na empresa.
        empresa.addDepartamento(departamento);
        empresa.setFuncionarios(departamento.getFuncionarios());
        empresa.addGerente(departamento.getGerente());

        // Mostra aí os dados da empresa.
        System.out.println("\n" + empresa.toString());

        // Printa os dados do departamento.
        System.out.println(departamento.toString());

        // Abrindo um projeto e mostrando os dados.
        Projeto projeto = new Projeto(1, "Pesquisa em Java", 10.50f, 30, departamento);
        System.out.println(projeto.toString());
        
    }
}