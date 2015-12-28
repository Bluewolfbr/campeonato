package dominio.modelos;

public class Rodada {
  
  List<Partida> partidas;
  
  public boolean isConcluido() {
    for(Partida partida: partidas) {
      if(!partida.isConcluido())
        return false;
    }
    return true;
  }
}