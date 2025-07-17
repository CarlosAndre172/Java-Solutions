public class App
{
    public static void main(String[] args) throws Exception
    {
        // Criando o admin.
        Pessoa administrador = new Pessoa();
        administrador.setNome("Ednaldo Pereira");

        Pessoa morador1 = new Pessoa();
        morador1.setNome("Boi Bufa");

        Pessoa morador2 = new Pessoa();
        morador2.setNome("Bicho de Ziguezague");

        Pessoa morador3 = new Pessoa();
        morador3.setNome("Bebarrão");

        // Criando as unidades.
        Unidade unidade1 = new Unidade(morador1);
        Unidade unidade2 = new Unidade(morador2);
        Unidade unidade3 = new Unidade(morador3);

        // setando os donos de cada unidade.
        unidade1.comprarUnidade(morador1);

        unidade2.comprarUnidade(morador2);
        
        unidade3.comprarUnidade(morador2);
        unidade3.comprarUnidade(morador1);

        // E agora, o condominio.
        Condominio condominio = new Condominio(administrador);
        condominio.addUnidade(unidade1);
        condominio.addUnidade(unidade2);
        condominio.addUnidade(unidade3);

        System.out.println(condominio.toString());

        System.out.println("Unidade 1:\n" + unidade1.toString());
        System.out.println("Unidade 2:\n" + unidade2.toString());
        System.out.println("Unidade 3:\n" + unidade3.toString());

        // Trocando o inquilino da uni 2;
        unidade2.alugarUnidade(morador1);
        System.out.println("Unidade 2:\n" + unidade2.toString());

        // Dados de cada morador.
        System.out.println("Dados do morador 1:\n" + morador1.toString());
        System.out.println("Dados do morador 2:\n" + morador2.toString());
        System.out.println("Dados do morador 3:\n" + morador3.toString());

    }
}