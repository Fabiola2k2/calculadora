package com.example.calculadoraequipo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    private TextView tv_operacion, tv_resultado;
    private Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9;
    private Button btn_dividir, btn_multiplicar, btn_restar, btn_sumar, btn_igual, btn_porcentaje;
    private Button btn_parentesis, btn_c, btn_eliminar, btn_punto;
    private String data_str;
    private boolean decimal_bool=false,par_bool=false,band_bool=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_operacion = findViewById(R.id.tv_operacion);
        tv_resultado = findViewById(R.id.tv_resultado);

        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);

        btn_dividir = findViewById(R.id.btn_dividir);
        btn_multiplicar = findViewById(R.id.btn_multiplicar);
        btn_restar = findViewById(R.id.btn_restar);
        btn_sumar = findViewById(R.id.btn_sumar);
        btn_igual = findViewById(R.id.btn_igual);
        btn_porcentaje = findViewById(R.id.btn_porcentaje);
        btn_parentesis = findViewById(R.id.btn_parentesis);
        btn_c = findViewById(R.id.btn_c);
        btn_eliminar = findViewById(R.id.btn_eliminar);
        btn_punto = findViewById(R.id.btn_punto);

    }

    public void calcular(View view){
        btn_0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                data_str = tv_operacion.getText().toString();
                tv_operacion.setText(data_str+"0");
            }
        });
        btn_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                data_str = tv_operacion.getText().toString();
                tv_operacion.setText(data_str+"1");
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                data_str = tv_operacion.getText().toString();
                tv_operacion.setText(data_str+"2");
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                data_str = tv_operacion.getText().toString();
                tv_operacion.setText(data_str+"3");
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                data_str = tv_operacion.getText().toString();
                tv_operacion.setText(data_str+"4");
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                data_str = tv_operacion.getText().toString();
                tv_operacion.setText(data_str+"5");
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                data_str = tv_operacion.getText().toString();
                tv_operacion.setText(data_str+"6");
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                data_str = tv_operacion.getText().toString();
                tv_operacion.setText(data_str+"7");
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                data_str = tv_operacion.getText().toString();
                tv_operacion.setText(data_str+"8");
            }
        });
        btn_9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                data_str = tv_operacion.getText().toString();
                tv_operacion.setText(data_str+"9");
            }
        });

        btn_c.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                tv_operacion.setText("");
                tv_resultado.setText("0");
                //decimal_bool = false;
            }
        });

        btn_punto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(!decimal_bool){
                    data_str = tv_operacion.getText().toString();
                    tv_operacion.setText(data_str+".");
                }
                decimal_bool = true;
            }
        });

        btn_dividir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                data_str = tv_operacion.getText().toString();
                tv_operacion.setText(data_str+"/");
                decimal_bool=false;
            }
        });
        btn_multiplicar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                data_str = tv_operacion.getText().toString();
                tv_operacion.setText(data_str+"*");
                decimal_bool=false;
            }
        });
        btn_sumar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                data_str = tv_operacion.getText().toString();
                tv_operacion.setText(data_str+"+");
                decimal_bool=false;
            }
        });
        btn_restar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                data_str = tv_operacion.getText().toString();
                tv_operacion.setText(data_str+"-");
                decimal_bool=false;
            }
        });

        btn_eliminar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String text = tv_operacion.getText().toString();
                if(text.length()>1) {
                    text=text.substring(0,text.length()-1);
                    tv_operacion.setText(text);
                    if (text.charAt(text.length()-1)=='.') {
                        decimal_bool=true;
                    }else {
                        decimal_bool=false;
                    }
                }else {
                    tv_operacion.setText("");
                    decimal_bool=false;
                }
            }
        });

        btn_parentesis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(par_bool){
                    if(band_bool){
                        data_str = tv_operacion.getText().toString();
                        tv_operacion.setText(data_str+"*(");
                        band_bool=false;
                    }else {
                        data_str = tv_operacion.getText().toString();
                        tv_operacion.setText(data_str+")");
                        band_bool=true;
                    }
                }else{
                    if(band_bool){
                        data_str = tv_operacion.getText().toString();
                        tv_operacion.setText(data_str+"(");
                        band_bool=false;
                    }else {
                        data_str = tv_operacion.getText().toString();
                        tv_operacion.setText(data_str+")");
                        band_bool=true;
                    }
                }
                decimal_bool=false;
            }
        });

        btn_igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    data_str = tv_operacion.getText().toString();
                    data_str = data_str.replace("×", "*");
                    data_str = data_str.replace("%", "/100");
                    data_str = data_str.replace("÷", "/");

                    Context rhino = Context.enter();
                    rhino.setOptimizationLevel(-1);

                    String resultadofinal_str = "";

                    Scriptable script = rhino.initStandardObjects();
                    resultadofinal_str = rhino.evaluateString(script, data_str, "Javascript", 1, null).toString();

                    tv_resultado.setText(resultadofinal_str);
                    decimal_bool = false;
                }catch (Exception e){
                    tv_resultado.setText("Formato invalido");
                }
            }
        });
    }
}


