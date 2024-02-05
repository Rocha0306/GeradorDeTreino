
import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

public class ClasseBase extends Dados {

    private int  PerguntaInical;
    private int EscolhaCadastro;

    Scanner InputUser = new Scanner(System.in);
    public void MensagemInicial() {
        System.out.println("\nSeja bem vindo ao Gerador de Treinos da Vibranium Treinamentos\n");
        System.out.println(":] :] ;] ;]");
    }



    public void Caminho() {
        System.out.println("Certo, voce já possui cadastro? 1 - Sim ou 2 - Não: ");
        this.EscolhaCadastro = InputUser.nextInt();

        // Verificação da entrada
        while (this.EscolhaCadastro != 1 && this.EscolhaCadastro != 2) {
            System.out.println("o Numero inserido é invalido, por favor faça novamente seguindo as orientaçoes");
            System.out.println("Certo, voce já possui cadastro? 1 - Sim ou 2 - Não");
            this.EscolhaCadastro = InputUser.nextInt();

        }


        if (this.EscolhaCadastro == 2) {

            getNome();
            getIdade();
            getPeso();
            getAltura();
            getEmail();
            CriarLogin();
            ConexaoBancoDeDadosAlimentar();
            Classes_Switch Switch = new Classes_Switch();
            Switch.SwitchAluno();


        }

        else {
            VerificarInfoBD();


        }

    }

    }






















