package cofrinho;

public abstract class Moeda {
  public double valor;

  public Moeda(double valor) {
    this.valor = valor;
  }

  public abstract String info();
  public abstract double converter();

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    Moeda moeda = (Moeda) obj;
    return Double.compare(moeda.valor, valor) == 0;
  }

}
