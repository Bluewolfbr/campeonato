package dominio.modelos;

public abstract class Placar {
  
  public static Placar aberto() {
    return new PlacarAberto();
  }
  
  
  public static Placar de(Integer golsMandante, Integer golsVisitante) {
    return new PlacarResultado(golsMandante, golsVisitante);
  }
  
  private static class PlacarResultado extends Placar{
    Integer golsMandante;
    Integer golsVisitante;
    
    public PlacarResultado(golsMandante, golsVisitante) {
      this.golsMandante = golsMandante;
      this.golsVisitante = golsVisitante;
    }
  }
  
  private static class PlacarAberto extends Placar {
    
  }
}

