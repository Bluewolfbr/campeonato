import static org.junit.Assert.*;
import org.junit.Test;

public class GrupoTest {
  
  Campeonato campeonato;
  
  @Before
  public void inicializaCampeonato(){
    this.campeonato = new Campeonato("Campeonato Brasileiro");
    campeonato.iniciar();
  }
  
  
}