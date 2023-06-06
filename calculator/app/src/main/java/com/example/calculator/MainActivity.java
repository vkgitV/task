package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends cal implements View.OnClickListener {
    TextView resulttv ;
    TextView solutiontv;
    MaterialButton btnc,btnopnbrc,btnclsbrc,btndiv,btnminus,btnplus,btnx,btnequal,btnmod;
    MaterialButton btn7,btn8,btn9,btn6,btn5,btn3,btn4,btn2,btn1,btn0,btndot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resulttv=findViewById(R.id.resulttv);
        solutiontv=findViewById(R.id.solutiontv);

        assingnId(btn0,R.id.btn0);
        assingnId(btn1,R.id.btn1);
        assingnId(btn2,R.id.btn2);
        assingnId(btn3,R.id.btn3);
        assingnId(btn4,R.id.btn4);
        assingnId(btn5,R.id.btn5);
        assingnId(btn6,R.id.btn6);
        assingnId(btn7,R.id.btn7);
        assingnId(btn8,R.id.btn8);
        assingnId(btn9,R.id.btn9);
        assingnId(btnplus,R.id.btnplus);
        assingnId(btnminus,R.id.btnminus);
        assingnId(btndiv,R.id.btndiv);
        assingnId(btnx,R.id.btnx);
        assingnId(btndot,R.id.btndot);
        assingnId(btnc,R.id.btnc);
        assingnId(btnequal,R.id.btnequal);
        assingnId(btnopnbrc,R.id.btnopnbrc);
        assingnId(btnclsbrc,R.id.btnclsbrc);
        assingnId(btnmod,R.id.btnmod);



    } void assingnId(MaterialButton btn,int id){
        btn=findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();
        String dataToCalculate = solutiontv.getText().toString();


        if (buttonText.equals("=")) {
            solutiontv.setText(resulttv.getText());
            return;
        }
        if(buttonText.equals("AC")) {
        solutiontv.setText("");
        resulttv.setText("0");
        return;
        }
        if (buttonText.equals("C")){
            dataToCalculate=dataToCalculate.substring(0,dataToCalculate.length()-1);
        }
      else{dataToCalculate = dataToCalculate + buttonText;
       }

        solutiontv.setText(dataToCalculate);
        String finalresult=getResult(dataToCalculate);

        if(!finalresult.equals("Error")){
            resulttv.setText(finalresult);
        }
    }
    String getResult(String data){
        try {
          Context context=Context.enter();
          context.setOptimizationLevel(-1);
          Scriptable scriptable= context.initStandardObjects();
         String finalResult= context.evaluateString(scriptable,data,"javascript",1,null).toString();
         if(finalResult.endsWith(".0")) {
         finalResult=finalResult.replace(".0","");
         }
          return finalResult;
        }catch (Exception a){
            return "Error";
        }
}}