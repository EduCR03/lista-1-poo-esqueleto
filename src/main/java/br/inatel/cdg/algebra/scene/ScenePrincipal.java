package br.inatel.cdg.algebra.scene;

import br.inatel.cdg.algebra.reta.Ponto;
import br.inatel.cdg.algebra.reta.Reta;
import javafx.beans.binding.DoubleExpression;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ScenePrincipal {

    //Button representa botoes
    private Button btnCalcL, btnCalcA;

    //Label representam rótulos
    private Label lblP1X,lblP1Y, lblP2X, lblP2Y;

    //TextField Representam áreas de texto
    private TextField txtP1X,txtP1Y,txtP2X,txtP2Y, txtCoefA, txtCoefL;

    public void criaScenePrincipal(Stage stage){

        //Criando os labels para os pontos e os campos de texto para os dados

        //criei um texto e um lugar para digitarem o P1X
        lblP1X = new Label("Digite P1.X"); //rótulos
        txtP1X = new TextField(); //área de texto onde vc digitara alguma coisa

        //criando um texto e um lugar pra digitarem o P1Y
        lblP1Y = new Label("Digite P1.Y");
        txtP1Y = new TextField();

        //... P2X
        lblP2X = new Label("Digite P2.X");
        txtP2X = new TextField();

        //...P2Y
        lblP2Y = new Label("Digite P2.Y");
        txtP2Y = new TextField();

        //Orgnizando as areas que eu criei, onde serao inseridos os numeros
        //Hbox é usado para agrupar de forma horizontal os dados quando aparecerem na telinha

        //Nesse caso a frase "Digite P1X" ficara do lado do espaço onde sera digitado os numeros
        HBox hboxP1X = new HBox(lblP1X, txtP1X);

        //Agora a mesma coisa para o P1Y e sua frase
        HBox hboxP1Y = new HBox(lblP1Y, txtP1Y);

        //...P2X
        HBox hboxP2X = new HBox(lblP2X, txtP2X);

        //..P2Y
        HBox hBoxP2Y = new HBox(lblP2Y, txtP2Y);

        //organizando as linhas de forma vertical, onde eu entro com as coordenadas, uma em cima da outra
        VBox vboxCoords = new VBox(hboxP1X, hboxP1Y, hboxP2X, hBoxP2Y);

        //lugares onde os valores serao mostrados
        //Coeficiente Angular
        txtCoefA = new TextField(); //criando esse "Espaço"
        txtCoefA.setEditable(false); //para que a frase nao possa ser alterada
        txtCoefA.setText("Coef. Angular: ");

        //Coeficiente Linear
        txtCoefL = new TextField();
        txtCoefL.setEditable(false);
        txtCoefL.setText("Coef. Linear: ");

        //Organizando uma do lado da outra essas duas areas que apareceram os resultados
        HBox hBoxResp = new HBox(txtCoefA, txtCoefL);


        //Criando o botao
        //Coeficiente Angular
        btnCalcA = new Button("Calclar Coef Angular");

        //coeficiente Linear
        btnCalcL = new Button("Calcular Coef Linear");

        //Agora vem a parte complicada

        //Criando as funçoes dos botoes
        //coef Angular
        btnCalcA.setOnAction(evento->{
            //Criando a reta e passando os parametros que ela necessita
            Reta reta = criarReta(Double.parseDouble(txtP1X.getText()), Double.parseDouble(txtP1Y.getText()));
            //mostrando o resultado
            txtCoefA.setText("Coef Angular" + reta.calcCoefAng());
        });

        //coef Linar
        btnCalcL.setOnAction(evento -> {
            Reta reta = criarReta(Double.parseDouble(txtP1X.getText()), Double.parseDouble(txtP1Y.getText()));
            txtCoefL.setText("Coef Linear" + reta.calcCoefLin());
        });

        //Deixando os botoes Horizontalmente
        HBox hBoxBtn = new HBox(btnCalcA, btnCalcL);

        //CRIANDO O LAYOUT FINAL

        //deixando tudo o que criamos um cima de outro aqui
        VBox layoutFinal = new VBox(vboxCoords, hBoxResp, hBoxBtn);

        //Criando o Scene
        Scene scene = new Scene(layoutFinal, 300, 200);

        stage.setTitle("Calculadora de Coeficientes da reta");
        stage.setScene(scene);
        stage.show();


    }

    //Funcao que sera chamada para a criaçao da reta
    private Reta criarReta(double x, double y){
        //criando os pontos
        Ponto p1 = new Ponto(Double.parseDouble(txtP1X.getText()), Double.parseDouble(txtP1Y.getText()));

        Ponto p2 = new Ponto(Double.parseDouble(txtP2X.getText()), Double.parseDouble(txtP2Y.getText()));

        //passando os pontos criados pra reta
        Reta reta = new Reta(p1, p2);

        return reta;
    }


}
