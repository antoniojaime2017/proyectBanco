package com.example.js.arreglocuentasbanco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DepositarEfectivo extends AppCompatActivity {

    private EditText edDeposito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depositar_efectivo);

        edDeposito = (EditText)findViewById(R.id.edDeposito);
    }

    public void Depositar(View view)
    {
        if(Double.parseDouble(edDeposito.getText().toString())> 0.0)
        {
            modificarsaldo();
            Toast.makeText(getApplicationContext(),"El depósito se ha efectuado exitosamente!",Toast.LENGTH_LONG).show();
            edDeposito.setText("");
        }
        else
        {
            Toast.makeText(getApplicationContext(),"El depósito solicitado es incoherente!",Toast.LENGTH_LONG).show();
            edDeposito.setText("");
        }
    }
    public void modificarsaldo()
    {
        VariableNoCuenta.saldo=VariableNoCuenta.saldo + Integer.parseInt(edDeposito.getText().toString());
        Toast.makeText(getApplicationContext(),VariableNoCuenta.saldo+"",Toast.LENGTH_LONG).show();
        if (VariableNoCuenta.noCuentaAcce == Integer.parseInt(VariableNoCuenta.aObjects[0][0]+""))
        {
            VariableNoCuenta.aObjects[0][1] = VariableNoCuenta.saldo;
        }
        if (VariableNoCuenta.noCuentaAcce == Integer.parseInt(VariableNoCuenta.aObjects[1][0]+""))
        {
            VariableNoCuenta.aObjects[1][1] = VariableNoCuenta.saldo;
        }
    }

}
