package com.example.js.arreglocuentasbanco;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.LabeledIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edNoCuenta;
    private int band;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNoCuenta = (EditText)findViewById(R.id.edNoCuenta);

    }

    public void noCuentaAccesible(View view)
    {
        int noCuenta = Integer.parseInt(edNoCuenta.getText().toString());

        if (existeCuenta(noCuenta) != 0)
        {
            Intent acercaDe = new Intent(getApplicationContext(),AccionesAcercaDeNoCuenta.class);
            startActivity(acercaDe);
            VariableNoCuenta.noCuentaAcce = noCuenta;
            edNoCuenta.setText("");

        }
        else
        {
            Toast.makeText(this,"No existe dicha cuenta en la base de datos, verifique que haya sido introducida correctamente",Toast.LENGTH_LONG).show();
            edNoCuenta.setText("");
        }
    }

    public int existeCuenta(int cuenta)
    {
        for(int i=0; i<2;i++)
        {
            if (cuenta == Integer.parseInt(VariableNoCuenta.aObjects[0][0]+""))
            {
                band=1;
            }
            else if (cuenta == Integer.parseInt(VariableNoCuenta.aObjects[1][0]+""))
            {
                band=1;
            }
            else
            {
                band=0;
            }
        }
        return band;
    }

}
