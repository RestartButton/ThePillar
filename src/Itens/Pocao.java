package src.Itens;

import src.Main;

public class Pocao extends Item {
    private int cura;

    public Pocao(int cura) {
        this.setNome("Pocao");
        this.cura = cura;
    }

    public void usar() {
        int valor = Main.jogador.getVida() + this.cura;
        Main.jogador.setVida(valor);
        String texto = Main.jogador.getNome() + " recuperou " + cura + " de vida.";
        System.out.println(texto);
    }
}
