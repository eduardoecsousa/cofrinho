package cofrinho;

public class Dolar extends Moeda{
  public Dolar(double valor) {
    super(valor);
  }

  @Override
  public String info() {
    return "Moeda de Dolar, valor: " + super.valor;
  }

  @Override
  public double converter() {
    return super.valor * 6.0;
  }


}
