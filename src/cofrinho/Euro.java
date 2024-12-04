package cofrinho;

public class Euro extends Moeda{
  public Euro(double valor) {
    super(valor);
  }

  @Override
  public String info() {
    return "Moeda de Euro, valor: " + super.valor;
  }

  @Override
  public double converter() {
    return super.valor * 6.50;
  }
}
