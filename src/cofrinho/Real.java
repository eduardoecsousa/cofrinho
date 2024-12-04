package cofrinho;

public class Real extends Moeda{
  public Real(double valor) {
    super(valor);
  }

  @Override
  public String info() {
    return "Moeda de Real, valor: " + super.valor;
  }

  @Override
  public double converter() {
    return super.valor * 1;
  }
}
