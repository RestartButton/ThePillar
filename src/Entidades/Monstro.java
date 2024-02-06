package src.Entidades;

import src.Main;

public class Monstro extends Entidade {
    private int forca;

    public Monstro(String nome, int vida, int forca) {
        this.setNome(nome);
        this.setVida(vida);
        this.forca = forca;
    }

    public void atacar(Entidade alvo) {
        int valor = alvo.getVida() - this.forca;
        alvo.setVida(valor);
        String texto = Main.inimigo.getNome() + " atacou " + Main.jogador.getNome() + ".";
        System.out.println(texto);
    }

    public void falar() {
        System.out.println("Ablablublergh!");
    }
}
