package Game.ClassCharacters;

import java.util.ArrayList;
import java.util.Arrays;

import Game.Invocation.Invocacao;

public class Necromante extends Personagens {
    String Classe;
    private int porcentagemXpGanho;
    private String[] habilidades;
    private int energiaDasTrevas; // Energia das trevas do necromante
    private ArrayList<Invocacao> reservatorioDeMortos; // Armazena invocações

    public Necromante(String nome, int vida, int mana, int ataque, int defesa, int regenVida, int regenMana, int velocidade, int porcentagemXpGanho,
                    int energiaDasTrevas, int ataqueHabilidadeEspecial, String[] habilidades) {
        super(nome, vida, mana, ataque, defesa, regenVida, regenMana, velocidade, ataqueHabilidadeEspecial);
        this.Classe = "Necromante";
        this.porcentagemXpGanho = porcentagemXpGanho;
        this.habilidades = habilidades;
        this.energiaDasTrevas = energiaDasTrevas;
        this.reservatorioDeMortos = new ArrayList<Invocacao>();
    }  

    @Override
        public String toString() {
            StringBuilder invocacoesInfo = new StringBuilder();
            for (Invocacao invocacao : reservatorioDeMortos) {
                invocacoesInfo.append(invocacao.toString()).append("\n");
            }
            return super.toString() + "\n" +  // Chama o toString da classe mãe (Personagens)
                    "Classe: " + Classe + "\n" +
                    "Porcentagem de XP ganho: " + porcentagemXpGanho + "\n" +
                    "Habilidades: " + Arrays.toString(habilidades) + "\n" +
                    "Energia das Trevas: " + energiaDasTrevas + "\n" +
                    "Reservatório de Mortos: \n" + invocacoesInfo.toString();
        }

    // Getters e setters
    public int getPorcentagemXpGanho() {
        return porcentagemXpGanho;
    }

    public String[] getHabilidades() {
        return habilidades;
    }

    public int getEnergiaDasTrevas() {
        return energiaDasTrevas;
    }

     // logica para adicionar e remover invocações

    public ArrayList<Invocacao> getReservatorioDeMortos() {
        return reservatorioDeMortos;
    }

     public void adicionarInvocacao(Invocacao invocacao) {
        reservatorioDeMortos.add(invocacao);
    }

    public void removerInvocacao(Invocacao invocacao) {
        reservatorioDeMortos.remove(invocacao);
    }

    
}
