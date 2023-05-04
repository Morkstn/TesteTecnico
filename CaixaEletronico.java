package CaixaEletronico;

import java.util.Scanner;

//link do problema: https://dojopuzzles.com/problems/caixa-eletronico/
public class CaixaEletronico {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int valorSaque, qtdNota100, qtdNota50, qtdNota20, qtdNota10;
        qtdNota100 = qtdNota50 = qtdNota20 = qtdNota10 = 0;

        System.out.print("Digite o valor do saque: R$ ");
        valorSaque = sc.nextInt();

        while (valorSaque > 0) {
            if (valorSaque >= 100) {
                qtdNota100++;
                valorSaque -= 100;
            } else if (valorSaque >= 50) {
                qtdNota50++;
                valorSaque -= 50;
            } else if (valorSaque >= 20) {
                qtdNota20++;
                valorSaque -= 20;
            } else {
                qtdNota10++;
                valorSaque -= 10;
            }
        }

        System.out.println("Notas a serem entregues:");
        if (qtdNota100 > 0) {
            System.out.println(qtdNota100 + " nota(s) de R$ 100,00");
        }
        if (qtdNota50 > 0) {
            System.out.println(qtdNota50 + " nota(s) de R$ 50,00");
        }
        if (qtdNota20 > 0) {
            System.out.println(qtdNota20 + " nota(s) de R$ 20,00");
        }
        if (qtdNota10 > 0) {
            System.out.println(qtdNota10 + " nota(s) de R$ 10,00");
        }

        sc.close();
    }
}
