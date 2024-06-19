import main.Baralho;
import main.Jogador;
import main.Rodada;


import java.util.Scanner;


public class Main {



    public static void main(String[] args) {
        //SCANNER
        Scanner le = new Scanner(System.in);

        //Baralho ja preenchido e embaralho
        Baralho baralho = new Baralho();

        System.out.println("████████╗██████╗ ██╗   ██╗ ██████╗ ██████╗ \n" +
                           "╚══██╔══╝██╔══██╗██║   ██║██╔════╝██╔═══██╗\n" +
                           "   ██║   ██████╔╝██║   ██║██║     ██║   ██║\n" +
                           "   ██║   ██╔══██╗██║   ██║██║     ██║   ██║\n" +
                           "   ██║   ██║  ██║╚██████╔╝╚██████╗╚██████╔╝\n" +
                           "   ╚═╝   ╚═╝  ╚═╝ ╚═════╝  ╚═════╝ ╚═════╝ ");
        System.out.println("Digite seu nome:");
        String nome = le.next();
        le.nextLine();

        Jogador j1 = new Jogador(nome,baralho);
        Jogador j2 = new Jogador("Com.",baralho);

        Rodada rodada = new Rodada(j1,j2,baralho);

        while(j1.pontos < 4 && j2.pontos < 4){
            rodada.jogar(le).pontos += rodada.pontosRodada;
            rodada.finalizaRodada();

            System.out.println("-------------------------------------------");
            System.out.println("Pontos de " + j1.nome + " " + j1.pontos + " pts");
            System.out.println("Pontos de " + j2.nome + " " + j2.pontos + " pts");
            System.out.println("--------------------------------------------");
        }

        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("               Fim de Jogo");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");


    }
}