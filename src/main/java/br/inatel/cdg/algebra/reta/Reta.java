package br.inatel.cdg.algebra.reta;

public class Reta {
    // A reta tem dois pontos
    private Ponto p1,p2;

    //criando a reta com os 2 pontos ja inseridos
    public Reta(Ponto p1, Ponto p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    //o que a reta sabe fazer:

    //calcula seu coneficiente Angular
    public double calcCoefAng(){
        double coefA = 0.0;

        coefA = (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());

        return coefA;
    }

    //calcula seu coeficiente Linear
    public double calcCoefLin(){
        double coefL;

        coefL = p1.getY() - calcCoefAng()*p1.getX();

        return coefL;
    }

}
