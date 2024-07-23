package src.Mapas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import src.Main;

public class Floresta extends Lugar {
    //na floresta pode aparecer 5 tipos de monstros: Sapo, Urso, Lobo, Goblin e Ciclope
    public Floresta() {
        List<HashMap<String, Object>> items = new ArrayList<>();
        
        // Adicionando itens à lista com suas respectivas chances
        HashMap<String, Object> sapo = new HashMap<>();
        sapo.put("name", "Sapo");
        sapo.put("life", 5);
        sapo.put("str", 1); 
        sapo.put("chance", 30); 
        items.add(sapo);
        
        HashMap<String, Object> urso = new HashMap<>();
        urso.put("name", "Urso");
        urso.put("life", 20); 
        urso.put("str", 4); 
        urso.put("chance", 20); 
        items.add(urso);
        
        HashMap<String, Object> lobo = new HashMap<>();
        lobo.put("name", "Lobo");
        lobo.put("life", 15); 
        lobo.put("str", 3); 
        lobo.put("chance", 18); 
        items.add(lobo);

        HashMap<String, Object> goblin = new HashMap<>();
        goblin.put("name", "Goblin");
        goblin.put("life", 7); 
        goblin.put("str", 2); 
        goblin.put("chance", 30); 
        items.add(goblin);

        HashMap<String, Object> ciclope = new HashMap<>();
        ciclope.put("name", "Ciclope");
        ciclope.put("life", 60); 
        ciclope.put("str", 8); 
        ciclope.put("chance", 2); 
        items.add(ciclope);

        Main.randomMonsterGen(items);
        this.inicio = "Enquanto caminhava pela floresta" + Main.jogador.getNome() + " ve um " + Main.inimigo.getNome() + " em sua frente, o que voce faz?";
    }

    public boolean trigger(String escolha) {
        if( escolha.equals("taverna") ) {
            Main.trocaMapa(escolha);
            return true;
        } else if( escolha.equals("masmorra") ) {
            Main.trocaMapa(escolha);
            return true;
        }
        return false;
    }
}
