package com.example.js.arreglocuentasbanco;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class AccionesAcercaDeNoCuenta extends AppCompatActivity {

    private String firstCuenta, secondCuenta;
    private RadioButton rbConsultar, rbRetirar, rbDepositar, rbSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acciones_acerca_de_no_cuenta);

        rbConsultar = (RadioButton)findViewById(R.id.rbConsultar);
        rbRetirar = (RadioButton)findViewById(R.id.rbRetirar);
        rbDepositar = (RadioButton)findViewById(R.id.rbDepositar);
        rbSalir = (RadioButton)findViewById(R.id.rbSalir);

        SharedPreferences cuentaBancariaUno = getSharedPreferences("dFC", Context.MODE_PRIVATE);
        firstCuenta = String.valueOf(cuentaBancariaUno.getInt("firstCuenta", 0));

        SharedPreferences cuentaBancariaDos = getSharedPreferences("dSC", Context.MODE_PRIVATE);
        secondCuenta = String.valueOf(cuentaBancariaDos.getInt("secondCuenta",0));

       asigCuenta();

    }

    public void consultar(View view)
    {
        rbRetirar.setChecked(false);
        rbDepositar.setChecked(false);
        rbSalir.setChecked(false);

        Intent consultarSaldo = new Intent(getApplicationContext(),consultarSaldo.class);
        startActivity(consultarSaldo);

    }

    public void retirar(View view)
    {
        rbRetirar.setChecked(false);
        rbDepositar.setChecked(false);
        rbSalir.setChecked(false);

        Intent retirarEfectivo = new Intent(getApplicationContext(),RetirarSaldo.class);
        startActivity(retirarEfectivo);
    }

    public void Depositar(View view)
    {
        rbRetirar.setChecked(false);
        rbDepositar.setChecked(false);
        rbSalir.setChecked(false);

        Intent depositarEfectivo = new Intent(getApplicationContext(),DepositarEfectivo.class);
        startActivity(depositarEfectivo);

    }

    public void salir(View view)
    {
        rbRetirar.setChecked(false);
        rbDepositar.setChecked(false);
        rbSalir.setChecked(false);

       concerUsuario();
        VariableNoCuenta.saldo=0;
        finish();
    }

   public void concerUsuario()
    {
        if(VariableNoCuenta.noCuentaAcce == Integer.parseInt(VariableNoCuenta.aObjects[0][0]+""))
        {
            SharedPreferences fUsuario =getSharedPreferences("dFC", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = fUsuario.edit();
            editor.putInt("firstCuenta", VariableNoCuenta.saldo);
            editor.commit();
        }
        else
        {
            SharedPreferences sUsuario =getSharedPreferences("dSC", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sUsuario.edit();
            editor.putInt("secondCuenta", VariableNoCuenta.saldo);
            editor.commit();
        }
    }

    public void asigCuenta()
    {
        if ( VariableNoCuenta.noCuentaAcce == Integer.parseInt(VariableNoCuenta.aObjects[0][0]+""))
        {
            VariableNoCuenta.saldo = Integer.parseInt(firstCuenta+"");
        }
        else
        {
            VariableNoCuenta.saldo = Integer.parseInt(secondCuenta+"");
        }
    }


}
