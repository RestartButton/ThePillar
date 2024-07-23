package src.Mapas;

public abstract class Lugar {
    
    protected String prompt = "";
    protected String inicio = "";

    public String resolve() {
        String text = this.prompt;
        this.prompt = "";
        return text;
    }

    public String initialResolve() {
        return this.prompt;
    }
    
    public abstract boolean trigger(String escolha);
}
