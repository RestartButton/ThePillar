package src.Entidades;

import src.Main;

public class Personagem extends Entidade {

    private int forca;

    public Personagem(String nome, int vida, int forca) {
        this.setNome(nome);
        this.setVida(vida);
        this.forca = forca;
    }

    public void atacar(Entidade alvo) {
        int valor = alvo.getVida() - this.forca;
        alvo.setVida(valor);
        String texto = Main.jogador.getNome() + " atacou " + Main.inimigo.getNome() + " desarmado.";
        System.out.println(texto);
    }

    public void atacar(Entidade alvo, int adicional) {
        int valor = alvo.getVida() - (this.forca + adicional);
        alvo.setVida(valor);
    }

    public void falar() {
        if(this.getVida() < 10) {
            System.out.println("Argh!");
        } else {
            System.out.println("A aventura me espera!");
        }
    }

    public void falar(Entidade alvo) {
        
        System.out.println("Mas que criatura vil!");
        
    }
}
