package dominio.modelos;

import java.util.List;

@Entidade(tipo=Entidade.Agregador)
public class Campeonato {

  public String nome;
  public List<Jogador> jogadores;
  public List<Grupo> grupos;
    
  @Inject
  public CampeonatoRepository campeonatoRepository;
  
  public Campeonato(String nome, List<Jogador> jogadores ) {
    // pensar na inicialização
    this.nome = nome;
  }
  
  /**
  * Inicializa campeonato só com computadores
  */
  public Campeonato(String nome){
    this.nome = nome;
  }
  
  public void iniciar(){
    List<Time> times = campeonatoRepository.getTimes();
    
    Collections.shuffle(times);
    for(Jogador jogador: jogadores) {
      
    }
  }
  
  public boolean has(Jogador jogador){
    for (int i=0; i < jogadores.size(); i++){
      if (jogador.nome == jogador.nome){
        return true;
      }
    }
    return false;
  }
  
  public boolean isIniciado(){
    return iniciado;
  }
  
   public boolean isConcluido(){
    return concluido;
  }
  
  public List<Grupo> getGrupos(){
    return grupos;
  }
}