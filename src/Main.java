//compile: javac -d build/classes src/Entidades/*.java src/Itens/*.java src/*.java
//run: java -cp build/classes src/Main

package src;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import src.Entidades.*;
import src.Itens.*;
import src.Mapas.Floresta;
import src.Mapas.Lugar;
import src.Mapas.Masmorra;
import src.Mapas.Taverna;

public class Main {

    public static Personagem jogador;
    public static Monstro inimigo;
    private static Lugar mapa;
    private static Pocao pocao;
    private static Arma arma;

    private static boolean isRunning = true;

    public static void main(String[] args) {
        Main.pocao = new Pocao(5);
        Main.arma = new Arma("Machado", 5);
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem vindo ao 'The Pillar', jogador!");
        System.out.println("Digite o nome do personagem vai te acompanhar em sua aventura!");
        String nomeJogador = scanner.nextLine();
        Main.jogador = new Personagem(nomeJogador, 10, 2);
        randomMapGen();
        System.out.println(Main.mapa.initialResolve());

        while(isRunning) {
            String escolha = scanner.nextLine().toLowerCase();
            trigger(escolha);
            
            if(Main.inimigo.getVida() <= 0) {
                String texto = Main.inimigo.getNome() + " morreu.";
                System.out.println(texto);
                Main.inimigo = null;
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

    public static void trocaArma(String nome, int poder) {
        Main.arma = new Arma(nome, poder);
    }

    public static void trocaMapa(String mapa) {
        if( mapa.equals("taverna") ) {
            Main.mapa = new Taverna();
        } else if ( mapa.equals("masmorra") ) {
            Main.mapa = new Masmorra();
        } else if ( mapa.equals("floresta") ) {
            Main.mapa = new Floresta();
        }
    }

    public static void randomMapGen() {
        Random random = new Random();
        int randomValue = random.nextInt(100);
        if( randomValue <= 25 ) {
            Main.mapa = new Floresta();
        } else if( randomValue <= 80 ) {
            Main.mapa = new Taverna();
        } else {
            Main.mapa = new Masmorra();
        }
    }
    
    public static void randomMonsterGen(List<HashMap<String,Object>> monstros) {
        int totalChance = 0;
        for( HashMap<String, Object> monstro : monstros ) {
            totalChance += (int) monstro.get("chance");
        }
        
        Random random = new Random();
        int randomValue = random.nextInt(totalChance);
        
        int cumulativeChance = 0;
        for( HashMap<String, Object> monstro : monstros ) {
            cumulativeChance += (int) monstro.get("chance");
            if( randomValue < cumulativeChance ){
                Main.inimigo = new Monstro(monstro.get("name").toString(), (int) monstro.get("life"), (int) monstro.get("str"));
            }
        }
    }

    private static void trigger(String escolha) {
        //System.out.println(escolha);
        if( Main.mapa.trigger(escolha) ) {
            System.out.println(Main.mapa.resolve());
            return;
        } else if( escolha.toLowerCase().equals("curar") ) {
            Main.pocao.usar();
            return;
        } else if( escolha.toLowerCase().equals("usar pocao") ) {
            Main.pocao.usar();
            return;
        } else if( escolha.toLowerCase().equals("atacar") ) {
            if( Main.inimigo != null ) {
                Main.jogador.atacar(Main.inimigo);
                Main.inimigo.atacar(Main.jogador);
            } else {
                System.out.println("Nao ha monstros por perto!");
            }
            return;
        } else if( escolha.toLowerCase().equals("usar" + Main.arma.getNome()) ) {
            if( Main.inimigo != null ) {
                Main.arma.usar();
                Main.inimigo.atacar(Main.jogador);
            } else {
                System.out.println("Nao ha monstros por perto!");
            }
            return;
        } else if( escolha.toLowerCase().equals("usar arma") ) {
            if( Main.inimigo != null ) {
                Main.arma.usar();
                Main.inimigo.atacar(Main.jogador);
            } else {
                System.out.println("Nao ha monstros por perto!");
            }
            return;
        } else if( escolha.toLowerCase().equals("atacar com " + Main.arma.getNome()) ) {
            if( Main.inimigo != null ) {
                Main.arma.usar();
                Main.inimigo.atacar(Main.jogador);
            } else {
                System.out.println("Nao ha monstros por perto!");
            }
            return;
        } else if( escolha.toLowerCase().equals("atacar com arma") ) {
            if( Main.inimigo != null ) {
                Main.arma.usar();
                Main.inimigo.atacar(Main.jogador);
            } else {
                System.out.println("Nao ha monstros por perto!");
            }
            return;
        } else if( escolha.toLowerCase().equals("falar") ) {
            Main.jogador.falar();
            return;
        } else if( escolha.toLowerCase().equals("falar com monstro") ) {
            if( Main.inimigo != null ) {
                Main.jogador.falar(Main.inimigo);
                Main.inimigo.falar();
            } else {
                System.out.println("Nao ha monstros por perto!");
            }
            return;
        } else if( Main.inimigo != null && escolha.toLowerCase().equals("falar com " + Main.inimigo.getNome()) ) {
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