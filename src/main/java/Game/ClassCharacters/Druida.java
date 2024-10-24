package Game.ClassCharacters;

import java.util.ArrayList;
import java.util.Arrays;

import Game.Invocation.Planta;

public class Druida extends Personagens {
    String Classe;
    private int porcentagemXpGanho;
    private int velocidadeAtaque;
    private int tempoConjuracaoPoder;
    private int alcancePoder;
    private int tempoRecargaPoderes;
    private String[] poderes; // Poderes da natureza o
    private int sementes;
    private int contadorTurnos;
    private ArrayList<Planta> plantasInvocadas;

    public Druida(String nome, int vida, int mana, int ataque, int defesa,int regenVida, int regenMana,int velocidade, int porcentagemXpGanho,
                  int velocidadeAtaque, int tempoConjuracaoPoder, 
                  int alcancePoder, int tempoRecargaPoderes, int ataqueHabilidadeEspecial, String[] poderes) {
        super(nome, vida, mana, ataque, defesa,regenVida,regenMana, velocidade, ataqueHabilidadeEspecial);
        this.Classe = "Druida";
        this.porcentagemXpGanho = porcentagemXpGanho;
        this.velocidadeAtaque = velocidadeAtaque;
        this.tempoConjuracaoPoder = tempoConjuracaoPoder;
        this.alcancePoder = alcancePoder;
        this.tempoRecargaPoderes = tempoRecargaPoderes;
        this.poderes = poderes;
        this.sementes = 1;  // O Druida começa com 1 semente
        this.contadorTurnos = 0;
        this.plantasInvocadas = new ArrayList<Planta>();
    }

    public void passarTurno() { // fazer mecanica de turnos/movimentos
        contadorTurnos++;
        if (contadorTurnos >= 5) {
            sementes++;
            contadorTurnos = 0;
            System.out.println("Uma nova semente foi criada!");
        }
    }

    public boolean criarPlanta(Planta planta) { // função que faz a criação de plantas
        if (sementes > 0) {
            plantasInvocadas.add(planta);
            sementes--;
            System.out.println("Planta criada: " + planta.getNome());
            return true;
        } else {
            System.out.println("Sem sementes suficientes!");
            return false;
        }
    }

    public ArrayList<Planta> getPlantasInvocadas() {
        return plantasInvocadas;
    }

    public int getSementes() {
        return sementes;
    }

    @Override
        public String toString() {
            StringBuilder plantasInfo = new StringBuilder();
            for (Planta planta : plantasInvocadas) {
                plantasInfo.append(planta.toString()).append("\n");
            }
            return super.toString() + "\n" +  // Chama o toString da classe mãe (Personagens)
                    "Classe: " + Classe + "\n" +
                    "Porcentagem de XP ganho: " + porcentagemXpGanho + "\n" +
                    "Velocidade de Ataque: " + velocidadeAtaque + "\n" +
                    "Tempo de Conjuração de Habilidade: " + tempoConjuracaoPoder + "\n" +
                    "Alcance de Ataque: " + alcancePoder + "\n" +
                    "Tempo de Recarga de Habilidades (em segundos): " + tempoRecargaPoderes + "\n" +
                    "Habilidades: " + Arrays.toString(poderes) +
                    "\nSementes: " + sementes + "\n" +
                    "Plantas Invocadas:\n" + plantasInfo.toString();

        }

    // Getters e setters
    public int getPorcentagemXpGanho() {
        return porcentagemXpGanho;
    }

    public int getVelocidadeAtaque() {
        return velocidadeAtaque;
    }

    public int getTempoConjuracaoPoder() {
        return tempoConjuracaoPoder;
    }

    public int getAlcancePoder() {
        return alcancePoder;
    }

    public int getTempoRecargaPoderes() {
        return tempoRecargaPoderes;
    }

    public String[] getPoderes() {
        return poderes;
    }
}



// Druida druida = new Druida("Druida", 90, 80, 50, 60);
// personagemEscolhido = druida;

// Simulando turnos para gerar sementes
// for (int i = 1; i <= 10; i++) {
//     System.out.println("Turno " + i);
//     druida.passarTurno();  // Passa um turno, a cada 5 turnos o druida ganha uma semente

//     Tentativa de criar uma planta
//     if (druida.getSementes() > 0) {
//         druida.criarPlanta(new Planta("Planta Curativa", 40, 10, 5));
//     }

//     Exibir os atributos do druida a cada turno
//     System.out.println(druida.toString());