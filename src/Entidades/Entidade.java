package src.Entidades;

abstract class Entidade {
    private String nome;
    private int vida;

    public String getNome() {
        return this.nome;
    }
    public int getVida() {
        return this.vida;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }

    abstract void atacar(Entidade alvo);
    abstract void falar();

}
