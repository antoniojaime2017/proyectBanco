package com.example.js.arreglocuentasbanco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class consultarSaldo extends AppCompatActivity {


    private TextView txtSaldoActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_saldo);

        txtSaldoActual = (TextView)findViewById(R.id.txtSaldoActual);
        txtSaldoActual.setText("$"+""+VariableNoCuenta.saldo+"");
    }

}
