import com.mysql.cj.log.Log;
import java.sql.Connection;
import java.sql.Statement; //Statement é o objeto que servirá de instrumento para a execução de comandos SQL
import java.sql.DriverManager;
import java.sql.ResultSet; // java.sql.ResultSet que irá receber o retorno do método executeQuery que é responsável por executar a consulta.
import java.sql.SQLException; //irá capturar exceptions durante a conexão com o banco de dados
import java.util.*;


public class Dados {

    // Atributos
    private String Nome;
    private int Idade;
    private float Peso;

    private float Altura;

    private String Email;

    private String Cod_Cliente;

    private String MensagemAluno;


    //Objeto para permitir leitura das entradas
    Scanner InputUser = new Scanner(System.in);


    // Metodos getters e setters
    public void getNome() {
        System.out.println("Nome: ");
        this.Nome = InputUser.nextLine();

    }


    public void getIdade() {
        System.out.println("Idade: ");
        this.Idade = InputUser.nextInt();

    }

    public void getPeso() {
        System.out.println("Peso: ");
        this.Peso = InputUser.nextFloat();
    }

    public void getAltura() {
        System.out.println("Altura: ");
        this.Altura = InputUser.nextFloat();
    }

    public void getEmail() {
        System.out.println("seu Email: ");
        this.Email = InputUser.nextLine();


    }

    public void getMensagemAluno() {
        System.out.println("Escreva aqui o que deseja falar ao professor: ");
        this.MensagemAluno = InputUser.nextLine();
    }

    public void CriarLogin() {
        System.out.println("\nCerto agora que vc já preencheu essas informaçoes, digite um numero com 4 digitos");
        System.out.println("Numero: ");
        this.Cod_Cliente = InputUser.nextLine();
        //Verificacao

        while (this.Cod_Cliente.length() != 4) {
            System.out.println("Somente 4 digitos, faça novamente");
            System.out.println("Numero: ");
            this.Cod_Cliente = InputUser.nextLine();

        }


    }

    public void Login() {
        System.out.println("Digite seu codigo: ");
        this.Cod_Cliente = InputUser.nextLine();

        //Verificação
        while (this.Cod_Cliente.length() != 4) {
            System.out.println("\nCodigo Incorreto, Digite novamente!");
            System.out.println("Digite seu codigo: ");
            this.Cod_Cliente = InputUser.nextLine();
        }


    }

    public void ConexaoBancoDeDadosAlimentar() {
        try {
            Connection Conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/LOGINVIBRANIUM", "root", "Lorenzo05*");
            String ComandoSQL = String.format("INSERT INTO DADOSCADASTRO(NOME, IDADE, PESO, ALTURA, EMAIL) VALUES('%s', '%s', '%s', '%s', '%s')", this.Nome, this.Idade, this.Peso, this.Altura, this.Email);
            String ComandoSQL_Login = String.format("INSERT INTO CADASTROLOGIN(COD_CLIENTE, SENHA) VALUES('%s')", this.Cod_Cliente);
            int PrimeiroComandoSQL = Conexao.createStatement().executeUpdate(ComandoSQL);
            int SegundoComandoSQL = Conexao.createStatement().executeUpdate(ComandoSQL_Login);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void VerificarInfoBD() {


        Connection Conexao;


        try {
            System.out.println("\nAtenção! Caso o codigo não exista no banco de dados o programa será fechado automaticamente!");
            Login();
            Conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/LOGINVIBRANIUM", "root", "Lorenzo05*"); // "Conexão" é um objeto do tipo java.sql.Connection;
            String ComandoSQL = "SELECT * FROM CADASTROLOGIN";
            ResultSet ComandoCodCliente = Conexao.createStatement().executeQuery(ComandoSQL);
            String ConteudoBD;
            while (ComandoCodCliente.next()) {
                ConteudoBD = ComandoCodCliente.getString("COD_CLIENTE");
                if (this.Cod_Cliente.equals(ConteudoBD)) {
                    Classes_Switch AB = new Classes_Switch();
                    AB.SwitchAluno();
                }


            }


            Conexao.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public void GerarTreinoAlunoABC() {

        try {
            Connection Conexao;
            Conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/LOGINVIBRANIUM", "root", "Lorenzo05*"); // "Conexão" é um objeto do tipo java.sql.Connection;
            String ComandoSQL = "SELECT * FROM TREINOSABC";
            ResultSet ObjetoRS = Conexao.createStatement().executeQuery(ComandoSQL);
            while (ObjetoRS.next()) {
                System.out.println(ObjetoRS.getString("TreinoA"));
                System.out.println(ObjetoRS.getString("TreinoB"));
                System.out.println(ObjetoRS.getString("TreinoC"));


            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void GerarTreinoAlunoABCD() {
        try {
            Connection Conexao;
            Conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/LOGINVIBRANIUM", "root", "Lorenzo05*"); // "Conexão" é um objeto do tipo java.sql.Connection;
            String ComandoSQL = "SELECT * FROM TREINOSABCD";
            ResultSet ObjetoRS = Conexao.createStatement().executeQuery(ComandoSQL);
            while (ObjetoRS.next()) {
                System.out.println(ObjetoRS.getString("TreinoA"));
                System.out.println(ObjetoRS.getString("TreinoB"));
                System.out.println(ObjetoRS.getString("TreinoC"));
                System.out.println(ObjetoRS.getString("TreinoD"));


            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void GerarTreinoAlunoABCDE() {
        try {
            Connection Conexao;
            Conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/LOGINVIBRANIUM", "root", "Lorenzo05*"); // "Conexão" é um objeto do tipo java.sql.Connection;
            String ComandoSQL = "SELECT * FROM TREINOSABCD";
            ResultSet ObjetoRS = Conexao.createStatement().executeQuery(ComandoSQL);
            while (ObjetoRS.next()) {
                System.out.println(ObjetoRS.getString("TreinoA"));
                System.out.println(ObjetoRS.getString("TreinoB"));
                System.out.println(ObjetoRS.getString("TreinoC"));
                System.out.println(ObjetoRS.getString("TreinoD"));
                System.out.println(ObjetoRS.getString("TreinoE"));


            }


        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public void MensagemAluno() {
        try {
            Connection Conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/LOGINVIBRANIUM", "root", "Lorenzo05*");
            String ComandoSQL = String.format("INSERT INTO MENSAGEMALUNOS(MENSAGEMDOALUNO) VALUES('%s')", this.MensagemAluno);
            int PrimeiroComandoSQL = Conexao.createStatement().executeUpdate(ComandoSQL);
        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }



}





























