package dominio.modelos;

import dominio.modelos.Time;
// pensar na ideia de tratar como um trait o simulador para melhorar coesao
public class Partida implements SimuladorResultado {
  
  public static final Integer MANDANTE = 0x0A;
  public static final Integer VISITANTE = 0x0B;
  
  public Placar placar = Placar.aberto();
  public Time mandante;
  public Time visitante;
  
  public Partida (Time mandante, Time visitante) {
    this.mandante = mandante;
    this.visitante = visitante;
  }
  
  public void resultado(Placar placar) {
    this.placar = placar;
  }
  
  public Time getVencedor() {
    
    if (Placar.getGols(Partida.MANDANTE) > Placar.getGols(Partida.VISITANTE)) {
      return this.mandante;
    } else if (Placar.getGols(Partida.MANDANTE) < Placar.getGols(Partida.VISITANTE)) {
      return this.visitante;
    } else {
      return null;
    }
  }
  
  public boolean isConcluido(){
    return placar != Placar.aberto();
  }
}