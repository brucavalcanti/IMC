package com.cavalcantirbuno.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btnCalcular;
    EditText editPeso,editAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcular = findViewById(R.id.btnCalcular);
        editAltura = findViewById(R.id.editAltura);
        editPeso = findViewById(R.id.editPeso);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ResultadoActivity.class);
                String peso = editPeso.getText().toString();
                String altura = editAltura.getText().toString();

                i.putExtra("peso",peso);
                i.putExtra("altura",altura);
                if(!(peso.isEmpty()) && !(altura.isEmpty())){
                    i.putExtra("peso",Double.parseDouble(peso));
                    i.putExtra("altura",Double.parseDouble(altura));
                    startActivity(i);
                }else{
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Alerta");
                    alertDialog.setMessage("Você precisa informar os valores");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();//pode ser substituido pela lambda function (dialog, which) -> dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }

            }
        });

    }
}