import java.sql.SQLException;
import java.util.Scanner;

public class Classes_Switch extends Dados {
    Scanner InputUser = new Scanner(System.in);
    // Opçoes Aluno

    private int EscolhaSwitchAluno;




    public void SwitchAluno() {
        System.out.println("\n1.Gerar Treino \n2.Deixar uma mensagem para o professor:");
        this.EscolhaSwitchAluno = InputUser.nextInt();


        //Verificação
        while (this.EscolhaSwitchAluno != 1 && this.EscolhaSwitchAluno != 2) {
            System.out.println("\n1.Gerar Treino \n2.Deixar uma mensagem para o professor");
            this.EscolhaSwitchAluno = InputUser.nextInt();
        }


        switch (this.EscolhaSwitchAluno) {

            case 1:
                System.out.println("\n1.Gerar Treino ABC\n2.Gerar treino ABCD\n3.Gerar treino ABCDE: ");
                int EscolhaTreino = InputUser.nextInt();

                //Verificação
                while(EscolhaTreino != 1 && EscolhaTreino != 2) {
                    System.out.println("Resposta Incorreta");
                    System.out.println("\n1.Gerar Treino ABC\n2.Gerar treino ABCD\n3.Gerar treino ABCDE: ");
                    EscolhaTreino = InputUser.nextInt();
                }

                if (EscolhaTreino == 1) {
                    GerarTreinoAlunoABC();
                    //Chamar um metodo que executa um SELECT
                }

                else if (EscolhaTreino == 2) {
                    GerarTreinoAlunoABCD();
                }

                else {
                    GerarTreinoAlunoABCDE();
                }


                break;

            case 2:

                getMensagemAluno();
                MensagemAluno();

                //chamar outro metodo que executa um INSERT INTO


                break;






        }

    }
}
