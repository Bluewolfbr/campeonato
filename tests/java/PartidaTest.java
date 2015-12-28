import static org.junit.Assert.*;
import static org.hamcrest.*;
import org.junit.Test;

public class PartidaTest {
  
  Campeonato campeonato;
  
  @Before
  public void inicializaCampeonato(){
    this.campeonato = new Campeonato("Campeonato Brasileiro");
    campeonato.iniciar();
    
  }
  
  
  @Test
  public void testResultadoSimulado() {
    Rodada = campeonato.getRodada();
    
    partida = rodada.getPartida(1);
    Time mandante = partida.getTime(Partida.MANDANTE);
    Time visitante = partida.getTime(Partida.VISITANTE);    
    
    partida.simularResultado();
    
    Time vencedor = partida.getVencedor();
    
    Placar placar = partida.getResultado();
    Integer golMandante = placar.getGols(Partida.MANDANTE);
    Integer golVisitante = placar.getGols(Partida.VISITANTE);
    
    assertNotNull(vencedor);
      
  }

  @Test
  public void testResultadoInformado() {
    Rodada = campeonato.getRodada();
    
    partida = rodada.getPartida(1);
    Time mandante = partida.getTime(Partida.MANDANTE);
    Time visitante = partida.getTime(Partida.VISITANTE);    
    Integer expected = 3;
    partida.resultado(
    Placar.de(expected, 2));
      
    Time vencedor = partida.getVencedor();
    
    Placar placar = partida.getResultado();
    Integer golMandante = placar.getGols(Partida.MANDANTE);
    Integer golVisitante = placar.getGols(Partida.VISITANTE);
    
    assertEquals(mandante, vencedor);
    assertThat("Placar incorreto", golMandante, either(is(expected)
                                                       .and(greaterThan(golVisitante))) );
  }
  
 
  /*
  * a - b
  * c - d <- 1 rodada
  * a - c
  * b - d <- 2 rodada
  * a - d
  * b - c <- 3 rodada
  * a - d
  * b - c <- 4 rodada
  * a - c
  * b - d <- 5 rodada
  * a - b
  * c - d <- 6 rodada
  */
  @Test
  public void testRodadaInicial(){
    Campeonato campeonato = new Campeonato("Campeonato Brasileiro");
    Rodada rodada = campeonato.getRodada();
    Integer expected = CampeonatoTest.TOTAL_PARTIDAS_RODADA;
    Integer result = rodada.getPartidas().size();
    Assert.EqualsThat(result, expected);   
  }
  
  @Test
  public void testGruposPartida(){
    Campeonato campeonato = new Campeonato("Campeonato Brasileiro");
    List<Grupo> expected = campeonato.getGrupos();
    
    List<Grupo> result = new ArrayList<>();
    Rodada rodada = campeonato.getRodada();
    
    for(Partida partida : rodada) {
      if(!result.contains(partida.getGrupo()))
        result.add(partida.getGrupo());
    }
    Assert.EqualsThat(result, expected);   
  } 
}