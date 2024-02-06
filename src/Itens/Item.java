package src.Itens;

abstract class Item {
    private String nome;

    protected void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    abstract void usar();
    
}
