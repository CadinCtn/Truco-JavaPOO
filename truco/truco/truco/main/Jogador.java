package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Jogador {

    public String nome;
    public List<Carta> mao;
    public int pontos = 0;

    public Jogador (String nome, Baralho baralho){
        this.nome = nome;
        this.mao = getMao(baralho.baralho);
    }

    public List<Carta> getMao(Stack<Carta> baralho){
        List<Carta> mao = new ArrayList<>();
        mao.add(baralho.pop());
        mao.add(baralho.pop());
        mao.add(baralho.pop());

        return mao;
    }


}
