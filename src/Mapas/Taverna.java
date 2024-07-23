package src.Mapas;

import java.util.Random;

import src.Main;

public class Taverna extends Lugar {
    private class Taverneiro {
        private String nome;
        public Taverneiro() {
            this.nome = randomNameGen();
        }
        public String getNome() {
            return this.nome;
        }
        public String randomNameGen() {
            String[] nomes = {"Fabio", "Dorival", "Ze", "Arnaldo"};
            Random random = new Random();
            int indiceAleatorio = random.nextInt(nomes.length);
            String nome = nomes[indiceAleatorio];
            return nome;
        }
        public String randomPromtGen() {
            String text = "";
            return text;
        }
    }
    private Taverneiro taverneiro = new Taverneiro();
    public Taverna() {
        this.inicio = Main.jogador.getNome() + " acorda em uma taverna, depois de uma noite de bebedeira.";
    }
    public boolean trigger(String escolha) {
        if( escolha.equals(this.taverneiro.getNome()) ) {
            this.prompt = this.taverneiro.getNome() + ": \"Esse e meu nome.\"";
            return true;
        } else if( escolha.equals("comida") ) {
            this.prompt = this.taverneiro.getNome() + ": \"Voce quer que eu te de uma comida?\"";
            return true;
        } else if( escolha.equals("beber") ) {
            this.prompt = this.taverneiro.getNome() + ": \"Acho que voce ja bebeu demais!\"";
            return true;
        } else if( escolha.equals("bebida") ) {
            this.prompt = this.taverneiro.getNome() + ": \"Acho que voce ja bebeu demais!\"";
            return true;
        } else if( escolha.equals("falar") ) {
            this.prompt = this.taverneiro.getNome() + ": \"" + this.taverneiro.randomPromtGen() + "\"";
            return true;
        } else if( escolha.equals("dica") ) {
            this.prompt = this.taverneiro.getNome() + ": \"" + this.taverneiro.randomPromtGen() + "\"";
            return true;
        } else if( escolha.equals("floresta") ) {
            Main.trocaMapa(escolha);
            return true;
        } else if( escolha.equals("masmorra") ) {
            Main.trocaMapa(escolha);
            return true;
        }
        return false;
    }
}
