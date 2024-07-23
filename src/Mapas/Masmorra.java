package src.Mapas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import src.Main;

public class Masmorra extends Lugar {
    //na masmorra pode aparecer 5 tipos de monstros: Sapo, Goblin, Ogro, Ciclope e Minotauro
    private class Sala {
        //3 tipos de sala: sala com inimigo, sala com baú e sala vazia
        String tipo;

        public Sala(String tipo) {
            this.tipo = tipo;
            if( tipo == "inimigo" ) {
                List<HashMap<String, Object>> items = new ArrayList<>();
        
                HashMap<String, Object> sapo = new HashMap<>();
                sapo.put("name", "Sapo");
                sapo.put("life", 5);
                sapo.put("str", 1); 
                sapo.put("chance", 20); 
                items.add(sapo);
                
                HashMap<String, Object> ogro = new HashMap<>();
                ogro.put("name", "Ogro");
                ogro.put("life", 77); 
                ogro.put("str", 8); 
                ogro.put("chance", 8); 
                items.add(ogro);
                
                HashMap<String, Object> minotauro = new HashMap<>();
                minotauro.put("name", "Minotauro");
                minotauro.put("life", 100); 
                minotauro.put("str", 20); 
                minotauro.put("chance", 2); 
                items.add(minotauro);

                HashMap<String, Object> goblin = new HashMap<>();
                goblin.put("name", "Goblin");
                goblin.put("life", 7); 
                goblin.put("str", 2); 
                goblin.put("chance", 50); 
                items.add(goblin);

                HashMap<String, Object> ciclope = new HashMap<>();
                ciclope.put("name", "Ciclope");
                ciclope.put("life", 60); 
                ciclope.put("str", 6); 
                ciclope.put("chance", 20); 
                items.add(ciclope);

                Main.randomMonsterGen(items);
            }
        }
        public String randomTreasureGen() {
            Random random = new Random();
            int randomValue = random.nextInt(100);
            String prompt = "";
            if( randomValue <= 5 ) {//machado lendario
                int valorAtaque = 50 + random.nextInt(51);
                Main.trocaArma("Machado Lendario", valorAtaque);
                prompt = "O bau aberto revela um Machado Lendario!" + Main.jogador.getNome() + " equipa sem pensar duas vezes!";
            } else if( randomValue <= 40 ) {//mangual
                int valorAtaque = 10 + random.nextInt(30);
                Main.trocaArma("Mangual", valorAtaque);
                prompt = "O bau escondia um Mangual." + Main.jogador.getNome() + " equipa sem pensar duas vezes!";
            } else if( randomValue <= 60 ) {//alabarda
                int valorAtaque = 10 + random.nextInt(6);
                Main.trocaArma("Alabarda", valorAtaque);
                prompt = "Como recompensa recebeu uma Alabarda." + Main.jogador.getNome() + " equipa sem pensar duas vezes!";
            } else if( randomValue <= 98 ) {//martelo
                int valorAtaque = 5 + random.nextInt(5);
                Main.trocaArma("Martelo", valorAtaque);
                prompt = "Encontrou um Martelo!" + Main.jogador.getNome() + " equipa sem pensar duas vezes!";
            } else {//machado
                int valorAtaque = 1 + random.nextInt(5);
                Main.trocaArma("Machado", valorAtaque);
                prompt = "No interior do bau esta um Machado." + Main.jogador.getNome() + " equipa sem pensar duas vezes!";
            }

            return prompt;
        }
    }

    private Sala sala;

    public Masmorra() {
        randomRoomGen();
        this.inicio = Main.jogador.getNome() + " acorda em uma sala escura, sem lembrar como chegou ai.";
        if( this.sala.tipo.equals("inimigo") ) {
            this.inicio += " Em sua frente esta " + Main.inimigo.getNome() + ", o que voce faz?";
        } else if( this.sala.tipo.equals("tesouro") ) {
            this.inicio += " Em sua frente esta um grande bau de tesouro, o que voce faz?";
        }
    }

    private void randomRoomGen(){
        Random random = new Random();
        int randomValue = random.nextInt(100);
        if( randomValue <= 32 ) {
            this.sala = new Sala("tesouro");
        } else if( randomValue <= 64 ) {
            this.sala = new Sala("vazia");
        } else {
            this.sala = new Sala("inimigo");
        }
    }

    private boolean checaMonstro() {
        if( Main.inimigo == null ) {
            return true;
        } else {
            return false;
        }
    }

    public boolean trigger(String escolha) {
        if( escolha.equals("taverna") ) {
            if(checaMonstro()) {
                Main.trocaMapa(escolha);
            } else {
                this.prompt = Main.inimigo.getNome() + " impede sua passagem!";
            }
            return true;
        } else if( escolha.equals("floresta") ) {
            if(checaMonstro()) {
                Main.trocaMapa(escolha);
            } else {
                this.prompt = Main.inimigo.getNome() + " impede sua passagem!";
            }
            return true;
        } else if( escolha.equals("proxima") ) {
            if(checaMonstro()) {
                randomRoomGen();
            } else {
                this.prompt = Main.inimigo.getNome() + " impede sua passagem!";
            }
            return true;
        } else if( escolha.equals("proxima sala") ) {
            if(checaMonstro()) {
                randomRoomGen();
            } else {
                this.prompt = Main.inimigo.getNome() + " impede sua passagem!";
            }
            return true;
        } else if( escolha.equals("prosseguir") ) {
            if(checaMonstro()) {
                randomRoomGen();
            } else {
                this.prompt = Main.inimigo.getNome() + " impede sua passagem!";
            }
            return true;
        }
        if( this.sala.tipo.equals("tesouro") ) {
            if( escolha.equals("abrir") ) {
                this.prompt = this.sala.randomTreasureGen();
                return true;
            } else if( escolha.equals("olhar") ) {
                this.prompt = "Uma sala com um bau no centro, o que poderia ter dentro?";
                return true;
            }
        } else if( this.sala.tipo.equals("vazia") ) {
            if( escolha.equals("olhar") ) {
                this.prompt = "Uma sala vazia, com musgo decorando as paredes.";
                return true;
            }
        } else {
            if( escolha.equals("olhar") ) {
                this.prompt = "Uma sala agora vazia, decorada com sangue do inimigo.";
                return true;
            }
        }
        return false;
    }
}
