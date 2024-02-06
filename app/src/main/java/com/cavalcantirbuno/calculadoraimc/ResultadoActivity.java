package com.cavalcantirbuno.calculadoraimc;

import static java.lang.Math.pow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultadoActivity extends AppCompatActivity {

    private ImageButton returnButton;
    private TextView textPeso,textAltura,textResultado,textDiagnostico;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        DecimalFormat df = new DecimalFormat("0.00");

        textPeso = findViewById(R.id.textPeso);
        textAltura = findViewById(R.id.textAltura);
        textResultado = findViewById(R.id.textResultado);
        textDiagnostico = findViewById(R.id.textDiagnostico);
        Bundle bundle = getIntent().getExtras();

        if(bundle!=null){
            Double peso = bundle.getDouble("peso");
            Double altura = bundle.getDouble("altura");

            Log.i("Debug", peso.toString());
            textPeso.setText("Peso informado: "  + peso+ " Kg");
            textAltura.setText("Altura informada: " + altura + " m");

            Double imc = peso/pow(altura,2);

            textDiagnostico.setText("O Valor do seu Imc é  " + df.format(imc) + " seu diagnóstico é: ");

            if(imc < 18.5)
            {
                textResultado.setText("Baixo");
            }else if(imc >= 18.5 && imc <= 24.9){
                textResultado.setText("Normal");
            }else if( imc >= 25 && imc <=29.9){
                textResultado.setText("Sobrepeso");
            }else if(imc >=30){
                textResultado.setText("Obesidade");
            }

        }

        returnButton = findViewById(R.id.btnReturn);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}