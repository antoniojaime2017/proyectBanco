package com.example.js.arreglocuentasbanco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RetirarSaldo extends AppCompatActivity {

    private TextView txtSaldoActualRetiro;
    private EditText edRetiro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retirar_saldo);

        txtSaldoActualRetiro = (TextView)findViewById(R.id.txtSaldoActualRetiro);

        edRetiro = (EditText)findViewById(R.id.edRetiro);

        txtSaldoActualRetiro.setText("Tu saldo actual es de: "+VariableNoCuenta.saldo+"");
    }

    public void cuentaRetiro(View view)
    {
        if(VariableNoCuenta.saldo>0.0)
        {
            if(Double.parseDouble(edRetiro.getText().toString())< VariableNoCuenta.saldo || Double.parseDouble(edRetiro.getText()+"") == VariableNoCuenta.saldo)
            {

                VariableNoCuenta.saldo= VariableNoCuenta.saldo-(Integer.parseInt(edRetiro.getText().toString()));
                modificarsaldo();
                txtSaldoActualRetiro.setText("Tu saldo actual es de: "+VariableNoCuenta.saldo+"");
                Toast.makeText(getApplicationContext(),"El retiro se ha efectuado exitosamente!",Toast.LENGTH_LONG).show();
                edRetiro.setText("");
            }
            else
            {
                Toast.makeText(getApplicationContext(),"No cuentas con el suficiente saldo para hacer dicho retiro",Toast.LENGTH_LONG).show();
                edRetiro.setText("");
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(),"No cuentas con el suficiente saldo",Toast.LENGTH_LONG).show();
            edRetiro.setText("");
        }
    }

    public void modificarsaldo()
    {
        if (VariableNoCuenta.noCuentaAcce== Integer.parseInt(VariableNoCuenta.aObjects[1][0]+""))
        {
            VariableNoCuenta.aObjects[0][1] = VariableNoCuenta.saldo;
        }
        else
        {
            VariableNoCuenta.aObjects[1][1] = VariableNoCuenta.saldo;
        }
    }
}
