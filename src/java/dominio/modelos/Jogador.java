package dominio.modelos;

@ValueObject
public class Jogador {
 
  public String nome;
  
  public Jogador(String nome) {
    this.nome = nome;
  }
}