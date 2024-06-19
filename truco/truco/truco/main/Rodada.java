package main;

import java.util.Random;
import java.util.Scanner;

public class Rodada {


    public int pontosRodada;
    Jogador j1;
    Jogador j2;
    Carta vira;
    Baralho baralho;
    public int md3J1 = 0;
    public int md3J2 = 0;
    
    public Rodada(Jogador j1, Jogador j2, Baralho baralho) {
        this.pontosRodada = 1;
        this.j1 = j1;
        this.j2 = j2;
        this.baralho = baralho;
    }

    public Jogador jogar(Scanner le){
        this.vira = baralho.baralho.pop();
        while(md3J1 != 2 && md3J2 != 2){
            System.out.println("░█░█░▀█▀░█▀▄░█▀█░░░█▄█░█▀█░█▀█░▀█▀░█░░░█░█░█▀█░░░░\n" +
                               "░▀▄▀░░█░░█▀▄░█▀█░░░█░█░█▀█░█░█░░█░░█░░░█▀█░█▀█░░▀░\n" +
                               "░░▀░░▀▀▀░▀░▀░▀░▀░░░▀░▀░▀░▀░▀░▀░▀▀▀░▀▀▀░▀░▀░▀░▀░░▀░\n");
            System.out.println("vira: " + vira.naipe + " " + vira.numero);

            //Mão do usuário
            System.out.println("\nEssa é sua mão atual " + j1.nome);
            System.out.println("--------MAO--------");
            for (Carta carta : j1.mao){
                System.out.println(j1.mao.indexOf(carta)+1+" - "+carta.naipe + " " + carta.numero);
            }
            System.out.println("-------------------\n");

            System.out.println("O que deseja fazer?");
            System.out.println("1 - Jogar uma carta");
            System.out.println("2 - TRUCO!!!");
            int opcao = le.nextInt();
            le.nextLine();

            switch(opcao){
                case 1:
                    escolherCarta(le,1);

                    break;
                case 2:
                    if(pontosRodada == 1){
                        pontosRodada = 3;
                    }else {
                        pontosRodada += 3;
                    }

                    System.out.println("Voce pediu TRUCO, e agora a rodada ta valendo " + pontosRodada + " pts!");
                        escolherCarta(le,2);


                    break;
            }

        }


        //Finalizando rodada
        //retorna jogador ganhador da rodada
        if(md3J2 == 2){
            return j2;
        } else {
            return j1;
        }

    }

    private void vencedorRodada(Carta cartaJ1, Carta cartaJ2, int manilha, int ptsMd3){
        System.out.println("======================================");
        System.out.println("Carta de " + j1.nome + " " + cartaJ1.naipe + " " + cartaJ1.numero);
        System.out.println("Carta de " + j2.nome + " " + cartaJ2.naipe + " " + cartaJ2.numero);
        System.out.println("======================================");


        //Manilha Empate
        if(cartaJ1.getForcaNum() == manilha && cartaJ2.getForcaNum()==manilha){
            //Comparando naipe
            if(cartaJ1.getForcaNai() > cartaJ2.getForcaNai()){
                System.out.println(j1.nome + " Ganhou a rodada");
                md3J1 += ptsMd3;
            } else if(cartaJ1.getForcaNai() < cartaJ2.getForcaNai()){
                System.out.println(j2.nome + " Ganhou a rodada");
                md3J2 += ptsMd3;
            }
        } else if(cartaJ1.getForcaNum() == manilha){
            //J1 Ganha manilha
            System.out.println(j1.nome + " Ganhou a rodada");
            md3J1 += ptsMd3;
        } else if(cartaJ2.getForcaNum()==manilha){
            //J2 Ganha manilha
            System.out.println(j2.nome + " Ganhou a rodada");
            md3J2 += ptsMd3;
        } else{

            //Se não ganhar pela manilha
            //Compara carta mais forte pelo numero
            if(cartaJ1.getForcaNum() > cartaJ2.getForcaNum()){
                System.out.println(j1.nome + " Ganhou a rodada");
                md3J1 += ptsMd3;
            } else if(cartaJ1.getForcaNum() < cartaJ2.getForcaNum()){
                System.out.println(j2.nome + " Ganhou a rodada");
                md3J2 += ptsMd3;
            } else {
                System.out.println("Empate!");
                md3J1 += ptsMd3;
                md3J2 += ptsMd3;
            }
        }
        System.out.println("======================================\n");
    }

    public void finalizaRodada(){
        //Zerando pontos da rodada  e dos jogadores
        md3J1 = 0;
        md3J2 = 0;
        pontosRodada = 1;

        //Colocando cartas no baralho e embaralhando
        this.baralho.baralho = baralho.getBaralho();

        //resetando mao dos jogadores a cada fim de rodada
        j1.mao = j1.getMao(baralho.baralho);
        j2.mao = j1.getMao(baralho.baralho);
    }


    private void escolherCarta(Scanner le, int ptsMd3){
        System.out.println("Digite qual carta jogar:");
        int cartaEscolhida = le.nextInt();
        le.nextLine();

        Carta cartaJ1 = j1.mao.remove(cartaEscolhida-1);
        Carta cartaJ2 = j2.mao.remove(0);

        vencedorRodada(cartaJ1,cartaJ2,vira.getForcaNum()+1,ptsMd3);
    }


}
