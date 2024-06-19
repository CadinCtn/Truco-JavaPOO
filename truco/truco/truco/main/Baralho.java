package main;


import java.util.*;

public class Baralho {

    public Stack<Carta> baralho;

    public Baralho(){
        this.baralho = getBaralho();
    }

    //Cria Baralho
     public Stack<Carta> getBaralho(){
        //Criando lista
        List<Carta> baralho = new ArrayList<>();
        //Criando cartas e inserindo na lista
        for(int i = 1; i < 11; i++){
            for(int n = 1; n < 5; n++){
                baralho.add(new Carta(n,i));
            }
        }
        //Embaralhando lista
        Collections.shuffle(baralho);

        //Criando pilha
        Stack<Carta> baralhoEmbaralhado = new Stack<>();
        //Inserindo valores embaralhados na pilha
        for(Carta carta : baralho){
            baralhoEmbaralhado.push(carta);
        }
        return baralhoEmbaralhado;
    }




}
