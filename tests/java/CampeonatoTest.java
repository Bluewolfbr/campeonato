import java.utils.*;

public class CampeonatoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();
  
  public static final Integer TOTAL_GRUPOS = 8;
  public static final Integer TOTAL_TIMES = 32;
  public static final Integer TOTAL_PARTIDAS_RODADA = 16;
  @Test
  public void testHasJogador() {
    
    Jogador onezinoGabriel = new Jogador("Onezino Gabriel");
    
    List jogadores = Arrays.asList(
      new Jogador("Onezino Gabriel"),
      new Jogador("Wesckley Gomes")
    );
    
    
    Campeonato campeonato = new Campeonato("Campeonato Brasileiro", jogadores);
    
    Assert.equalsTrue(campeonato.has(onezinoGabrel));    
  }
  
  @Test
  public void testCampeonatoInicializado(){
    Campeonato campeonato = new Campeonato("Campeonato Brasileiro");
    
    Assert.equalsFalse(campeonato.isIniciado());
    //iniciar
    campeonato.iniciar();
    Assert.equalsTrue(campeonato.isIniciado());
    Assert.equalsFalse(campeonato.isConcluido());
  }
  
  @Test
  public void testQuantidadeGruposTimes(){
    Campeonato campeonato = new Campeonato("Campeonato Brasileiro");
    campeonato.iniciar();
    
    Integer expectedGrupos = CampeonatoTest.TOTAL_GRUPOS;// quantidade padrao de grupos
    Integer resultGrupos = campeonato.getGrupos().size();
    
    Assert.equals(expectedGrupos, resultGrupos);
    
    Integer expectedTimes = CampeonatoTest.TOTAL_TIMES;// quantidade padrao de grupos
    Integer resultTimes = campeonato.getTimes().size();
    
    Assert.equals(expectedTimes, resultTimes);
  }
  
  @Test
  public void testNovaRodada() {
    
    thrown.expect(RodadaNaoFinalizadaException.class);
    Campeonato campeonato = new Campeonato("Campeonato Brasileiro");
    campeonato.iniciar();
    campeonato.novaRodada();
  }
  @Test
  public void testNovaRodada() {
    
    Campeonato campeonato = new Campeonato("Campeonato Brasileiro");
    campeonato.iniciar();
    Rodada rodada = campeonato.getRodada();
    
    for(Partida partida : rodada.getPartidas()){
      partida.simularResultado();
    }    
    assertTrue(rodada.isConcluido());
    
    campeonato.novaRodada();
    
    Rodada novaRodada = campeonato.getRodada();
    assertNotSame("Rodadas diferente", rodada, novaRodada);
  }
}