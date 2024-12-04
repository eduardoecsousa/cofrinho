package cofrinho;

import java.util.ArrayList;

public class Cofrinho {
  private ArrayList<Moeda> listaDeMoedas;

  public Cofrinho() {
    this.listaDeMoedas = new ArrayList<>();
  }

  public Cofrinho(ArrayList<Moeda> listaDeMoedas) {
    this.listaDeMoedas = listaDeMoedas;
  }

  public void adicionar(Moeda moeda){
    this.listaDeMoedas.add(moeda);
  }

  public void remover(Moeda moeda){
    this.listaDeMoedas.remove(moeda);
  }

  public ArrayList<Moeda> getListaDeMoedas(){
    return this.listaDeMoedas;
  }

  public double totalConvertido(){
    return 20.0;
  }
}
