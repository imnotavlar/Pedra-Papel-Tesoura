import java.util.Scanner;
import java.util.Random;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in); //scanner
        Random aleatorio = new Random(); //aleatorio

        //variaveis de vida
        int vidauser = 3, vidarobo = 3;

        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();

        System.out.println();
        System.out.println("Seja bem-vindo " + nome + " ao jogo Pedra, Papel ou Tesoura!");
        System.out.println();

        int verificadorderespexplicacao = 1;

        //explicação do jogo
        while (verificadorderespexplicacao == 1) {
            System.out.println("Deseja receber uma explicação de como funciona o jogo?");
            System.out.println("Digite Sim ou Não!");
            String respexplicacao = sc.nextLine();
            System.out.println();

            if (respexplicacao.equalsIgnoreCase("sim") || respexplicacao.equalsIgnoreCase("s")) {
                System.out.println("\uD83C\uDFAE Você jogará contra um robô que escolherá aleatoriamente entre Pedra, Papel ou Tesoura.");
                System.out.println("❤\uFE0F Tanto você quanto o robô terão 3 vidas, e a cada rodada perdida irá perder 1 vida!");
                System.out.println("\uD83C\uDFC6 O vencedor será aquele que não zerar a quantidade de vidas! Boa sorte! \uD83C\uDF40");
                System.out.println();
                verificadorderespexplicacao = 0;
            } else if (respexplicacao.equalsIgnoreCase("não") || respexplicacao.equalsIgnoreCase("nao") || respexplicacao.equalsIgnoreCase("n")) {
                verificadorderespexplicacao = 0;
            } else {
                System.out.println("⛔ Resposta inválida!");
                System.out.println();
            }
        } //fim do while de explicacao

        System.out.println("Vamos começar o jogo!");
        System.out.println();

        int verificadorgeral = 1;

        while (verificadorgeral == 1) {
            //reinicia as vidas a cada nova partida
            vidauser = 3;
            vidarobo = 3;

            while (vidauser > 0 && vidarobo > 0) {
                System.out.print("Escolha entre pedra, papel ou tesoura: ");
                String escolhauser = sc.nextLine();
                System.out.println();

                if (escolhauser.equalsIgnoreCase("pedra") && escolhauser.equalsIgnoreCase("papel") && escolhauser.equalsIgnoreCase("tesoura")) {
                    System.out.println("⛔ Escolha inválida!");
                    System.out.println();
                    continue;
                }

                int gerarescolharobo = aleatorio.nextInt(3);
                String escolharobo;
                if (gerarescolharobo == 0) {
                    escolharobo = "Pedra";
                } else if (gerarescolharobo == 1) {
                    escolharobo = "Papel";
                } else {
                    escolharobo = "Tesoura";
                }

                System.out.println("\uD83D\uDC64 | " + nome + " escolheu: " + escolhauser);
                System.out.println("\uD83E\uDD16 | Robô escolheu: " + escolharobo);
                System.out.println();

                //empate
                if (escolhauser.equalsIgnoreCase(escolharobo)) {
                    System.out.println("🤝 Empate! Ninguém perdeu vida.");
                }
                //robo vence
                else if ((escolhauser.equalsIgnoreCase("pedra") && escolharobo.equalsIgnoreCase("Papel")) ||
                        (escolhauser.equalsIgnoreCase("papel") && escolharobo.equalsIgnoreCase("Tesoura")) ||
                        (escolhauser.equalsIgnoreCase("tesoura") && escolharobo.equalsIgnoreCase("Pedra"))) {
                    System.out.println("\uD83C\uDFC5 O vencedor dessa rodada foi: \uD83E\uDD16 Robô");
                    vidauser--;
                }
                //usuario vence
                else {
                    System.out.println("\uD83C\uDFC5 O vencedor dessa rodada foi: " + nome);
                    vidarobo--;
                }

                System.out.println("\uD83D\uDC64 " + nome + " possui " + vidauser + " vidas!");
                System.out.println("\uD83E\uDD16 Robô possui " + vidarobo + " vidas!");
                System.out.println();

            } //fim do while de rodada

            //mensagem final da partida
            if (vidauser == 0) {
                System.out.println("\uD83C\uDFC6 | O vencedor foi: Robô! Mais sorte na próxima...");
                System.out.println();
            } else {
                System.out.println("\uD83C\uDFC6 | O vencedor foi: " + nome + "! Parabéns por derrotar o Robô!");
                System.out.println();
            }

            //nova partida
            System.out.println("Deseja jogar uma nova partida?");
            String respnovapartida = sc.nextLine();

            if (respnovapartida.equalsIgnoreCase("não") || respnovapartida.equalsIgnoreCase("nao") ||
                    respnovapartida.equalsIgnoreCase("n")) {
                System.out.println("Obrigado por jogar!");
                verificadorgeral = 0;
            } else {
                System.out.println();
            }

        } //fim do while geral

    }

} //fim do programa
