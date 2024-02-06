package src.Itens;

import src.Main;

public class Arma extends Item {
    private int poder;

    public Arma(String nome, int poder) {
        this.setNome(nome);
        this.poder = poder;
    }

    public void usar() {
        Main.jogador.atacar(Main.inimigo, this.poder);
        String texto = Main.jogador.getNome() + " atacou " + Main.inimigo.getNome() + " com " + this.getNome() + ".";
        System.out.println(texto);
    }
}