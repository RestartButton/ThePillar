//compile: javac -d build/classes src/Entidades/*.java src/Itens/*.java src/*.java
//run: java -cp build/classes src/Main

package src;

import java.util.Scanner;

import src.Entidades.*;
import src.Itens.*;

public class Main {

    public static Personagem jogador;
    public static Monstro inimigo;
    private static Pocao pocao;
    private static Arma arma;

    private static boolean isRunning = true;

    public static void main(String[] args) {
        Main.jogador = new Personagem("Pedro", 10, 2);
        Main.inimigo = new Monstro("Sapo", 5, 1);
        Main.pocao = new Pocao(5);
        Main.arma = new Arma("Machado", 5);

        System.out.println("Bem vindo ao 'The Pillar', jogador!");
        System.out.println(Main.jogador.getNome() + " vai te acompanhar em sua aventura!");
        System.out.println("Voce ve um sapo em sua frente, o que voce faz?");

        Scanner scanner = new Scanner(System.in);
        while(isRunning) {
            String escolha = scanner.nextLine().toLowerCase();
            trigger(escolha);
            
            if(Main.inimigo.getVida() <= 0) {
                String texto = Main.inimigo.getNome() + " morreu.";
                System.out.println(texto);
                Main.inimigo = new Monstro("Sapo", 5, 1);
            }
            if(Main.jogador.getVida() <= 0 ) {
                String texto = Main.jogador.getNome() + " morreu.";
                System.out.println(texto);
                Main.isRunning = false;
            }
        }
        scanner.close();

        System.out.println("Obrigado por jogar!");
    }

    private static void trigger(String escolha) {
        //System.out.println(escolha);
        if( escolha.toLowerCase().equals("atacar") ) {
            Main.jogador.atacar(Main.inimigo);
            Main.inimigo.atacar(Main.jogador);
            return;
        } else if( escolha.toLowerCase().equals("curar") ) {
            Main.pocao.usar();
            return;
        } else if( escolha.toLowerCase().equals("usar pocao") ) {
            Main.pocao.usar();
            return;
        } else if( escolha.toLowerCase().equals("usar" + Main.arma.getNome()) ) {
            Main.arma.usar();
            Main.inimigo.atacar(Main.jogador);
            return;
        } else if( escolha.toLowerCase().equals("usar arma") ) {
            Main.arma.usar();
            Main.inimigo.atacar(Main.jogador);
            return;
        } else if( escolha.toLowerCase().equals("atacar com " + Main.arma.getNome()) ) {
            Main.arma.usar();
            Main.inimigo.atacar(Main.jogador);
            return;
        } else if( escolha.toLowerCase().equals("atacar com arma") ) {
            Main.arma.usar();
            Main.inimigo.atacar(Main.jogador);
            return;
        } else if( escolha.toLowerCase().equals("falar") ) {
            Main.jogador.falar();
            return;
        } else if( escolha.toLowerCase().equals("falar com monstro") ) {
            Main.jogador.falar(Main.inimigo);
            Main.inimigo.falar();
            return;
        } else if( escolha.toLowerCase().equals("falar com " + Main.inimigo.getNome()) ) {
            Main.jogador.falar(Main.inimigo);
            Main.inimigo.falar();
            return;
        } else if( escolha.toLowerCase().equals("terminar") ) {
            Main.isRunning = false;
        } else if( escolha.toLowerCase().equals("sair") ) {
            Main.isRunning = false;
        } else if( escolha.toLowerCase().equals("fugir") ) {
            Main.isRunning = false;
        } else if( escolha.toLowerCase().equals("terminar aventura") ) {
            Main.isRunning = false;
        } else {
            String texto = Main.jogador.getNome() + " fica confuso com seu comando.";
            System.out.println(texto);
        }
    }
}