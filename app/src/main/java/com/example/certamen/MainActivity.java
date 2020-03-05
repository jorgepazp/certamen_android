package com.example.certamen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btn_generar;
    private Button btn_mas;
    private Button btn_menos;
    private Button btn_c;
    private Button btn_multiplicacion;
    private Button btn_div;

    private Button isPar;
    private Button isPrimo;

    private TextView x;
    private TextView operacion;
    private TextView y;
    private TextView resultado;
    private TextView tag;

    private int num1 = 10050;
    private int num2 = 10050;
    private int result=10050;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_generar = (Button) findViewById(R.id.generate_random);
        btn_mas = (Button) findViewById(R.id.btn_mas);
        btn_menos = (Button) findViewById(R.id.btn_menos);
        btn_c = (Button) findViewById(R.id.btn_c);
        btn_multiplicacion = (Button) findViewById(R.id.btn_multiplicacion);
        btn_div = (Button) findViewById(R.id.btn_div);

        isPar = (Button) findViewById(R.id.btn_res_par);
        isPrimo = (Button) findViewById(R.id.btn_res_primo);

        x = (TextView) findViewById(R.id.numero_1);
        operacion = (TextView) findViewById(R.id.operacion);
        y = (TextView) findViewById(R.id.numero_2);
        resultado = (TextView) findViewById(R.id.resultado);
        tag = (TextView) findViewById(R.id.tag);

        final Random rand = new Random();

        btn_generar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = rand.nextInt( 100);
                num2 = rand.nextInt(100);
                x.setText(String.valueOf(num1));
                y.setText(String.valueOf(num2));
            }
        });

        btn_mas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!(num1 == 10050 && num2 == 10050)){
                    //los numeros han sido randomizados por lo que proseguimos
                    int aux = num1 + num2;
                    resultado.setText(String.valueOf(aux));
                    result = aux;
                }else{
                    resultado.setText("Error. Genere Números");
                }

            }
        });

        btn_menos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!(num1 == 10050 && num2 == 10050)){
                    //los numeros han sido randomizados por lo que proseguimos
                    int aux = num1 - num2;
                    resultado.setText(String.valueOf(aux));
                    result = aux;
            }else{
                    resultado.setText("Error. Genere Números");
                }

            }
        });

        btn_multiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!(num1 == 10050 && num2 == 10050)){
                    //los numeros han sido randomizados por lo que proseguimos
                    int aux = num1 * num2;
                    resultado.setText(String.valueOf(aux));
                    result = aux;
                }else{
                    resultado.setText("Error. Genere Números");
                }

            }
        });

        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!(num1 == 10050 && num2 == 10050)){
                    //los numeros han sido randomizados por lo que proseguimos
                    float aux = (float) num1 / (float) num2;
                    resultado.setText(String.valueOf(aux));
                    result = (int) aux;
                }else{
                    resultado.setText("Error. Genere Números");
                }

            }
        });

        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x.setText("X");
                y.setText("Y");
                resultado.setText("-");
                tag.setText("-");

                num1=10050;
                num2=10050;
                result= 10050;
            }
        });

        isPar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!(num1 == 10050 && num2 == 10050)) {

                        int aux = result % 2;
                        System.out.println(result+" mod "+2 +" = "+aux);
                        if (aux == 0) {
                            tag.setText("ES PAR");
                        } else tag.setText("ES IMPAR");

                }else{
                    tag.setText("Error, realice operación");
                }
            }
        });

        isPrimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(num1 == 10050 && num2 == 10050)) {

                    tag.setText(esPrimo(result));
                }else{
                    tag.setText("Error, realice operación");
                }
            }
        });

    }

    private String esPrimo(int res){
        if( res < 0) res = res *-1;
        for(int i =2;i <res;i++){
            if(res%i == 0){
                return "NO ES PRIMO";
            }
        }
        return "ES PRIMO";
    }

}
