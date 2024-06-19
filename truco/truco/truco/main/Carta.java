package main;

public class Carta {

    public String naipe;
    public String numero;

    public Carta(int naipe, int numero) {
        this.naipe = getNaipe(naipe);
        this.numero = getNumero(numero);
    }

    private String getNaipe(int valor){
        switch (valor){
            case 1:
                return "♦";
            case 2:
                return "♠";
            case 3:
                return "♥";
            case 4:
                return "♣";

            default:
                return "";
        }
    }

    private String getNumero(int valor){
        switch(valor){
            case 1:
                return "4";
            case 2:
                return "5";
            case 3:
                return "6";
            case 4:
                return "7";
            case 5:
                return "Q";
            case 6:
                return "J";
            case 7:
                return "K";
            case 8:
                return "ÁS";
            case 9:
                return "2";
            case 10:
                return "3";

            default:
                return "";
        }
    }


    public int getForcaNum(){
        switch (this.numero){
            case "4":
                return 1;
            case "5":
                return 2;
            case "6":
                return 3;
            case "7":
                return 4;
            case "Q":
                return 5;
            case "J":
                return 6;
            case "K":
                return 7;
            case "ÁS":
                return 8;
            case "2":
                return 9;
            case "3":
                return 10;
            default:
                return 0;
        }
    }

    public int getForcaNai(){
        switch (this.naipe){
            case "♦":
                return 1;
            case "♠":
                return 2;
            case "♥":
                return 3;
            case "♣":
                return 4;

            default:
                return 0;
        }
    }

}
