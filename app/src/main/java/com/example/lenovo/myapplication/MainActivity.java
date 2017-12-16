package com.example.lenovo.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Stack;

import static java.lang.Math.cos;
import static java.lang.Math.cosh;
import static java.lang.Math.log;
import static java.lang.Math.log10;
import static java.lang.Math.pow;
import static java.lang.Math.random;
import static java.lang.Math.sin;
import static java.lang.Math.sinh;
import static java.lang.Math.sqrt;
import static java.lang.Math.tan;
import static java.lang.Math.tanh;


public class MainActivity extends AppCompatActivity {
/*
    private final static String SharedPreferencesFileName="config";
    private final static String Key_UserName="UserName";
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
*/

    OutputStream out=null;
    InputStream in=null;
    String FILE_NAME = "fileDemo.txt";


    //M+  -所用到的参数
    int M1=0,M2=0;
    String memoryNum="";
    String memoryNum2="";




    Button b1,b2,b3,b4,b5,b6,b7,b8,b10,b9,b11,b12,b13,b14,b15,b16,b17,
            b18,b19,b20,b21,b22,b23,b24,b25,b26,b27,b28,b29,b30,b31,b32,b33,b34,b35,b36,b37,b38,b39,
            b40,b41,b42,b43,b44,b45,b46,b47,b48,b49,b50;
    private TextView textView2;
    private  StringBuffer stringBuffer = new StringBuffer();
    private  StringBuffer stringBuffer2 = new StringBuffer();
    private String result = "";
    private  static CalculatorMath  calculatorMath= new CalculatorMath(20);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView2 = (TextView) findViewById(R.id.editText);
        /*
        preferences=getSharedPreferences(SharedPreferencesFileName, MODE_PRIVATE);
        editor=preferences.edit();*/
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void clickMe(View v) {
        if (result.length() > 0 && stringBuffer.toString().contains("=")) {
            stringBuffer = new StringBuffer();
        }
        Button button = (Button) v;
        switch (button.getId()) {

            case R.id.b1:
                if (stringBuffer.length() == 0) {
                    stringBuffer.append("(");
                } else {
                    char c = stringBuffer.charAt(stringBuffer.length() - 1);
                    if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(') {
                        stringBuffer.append("(");
                    }
                }
                break;
            case R.id.b2:
                if (stringBuffer.length() != 0) {
                    char c = '\0';
                    int n1 = 0;// '('的个数
                    int n2 = 0;// ')'的个数
                    for (int i = 0; i < stringBuffer.length(); i++) {
                        c = stringBuffer.charAt(i);
                        if (c == '(') {
                            n1++;
                        } else if (c == ')') {
                            n2++;
                        }
                    }
                    if (n2 < n1 && (c >= '0' && c <= '9' || c == ')')) {
                        stringBuffer.append(")");
                    }
                }
                break;


            case R.id.b37: {
                if (stringBuffer.length() != 0 && stringBuffer.charAt(stringBuffer.length() - 1) == ')') {
                    break;
                }
                stringBuffer.append(1);
                break;
            }

            case R.id.b38: {
                if (stringBuffer.length() != 0 && stringBuffer.charAt(stringBuffer.length() - 1) == ')') {
                    break;
                }
                stringBuffer.append(2);
                break;
            }


            case R.id.b39: {
                if (stringBuffer.length() != 0 && stringBuffer.charAt(stringBuffer.length() - 1) == ')') {
                    break;
                }
                stringBuffer.append(3);
                break;
            }

            case R.id.b27: {
                if (stringBuffer.length() != 0 && stringBuffer.charAt(stringBuffer.length() - 1) == ')') {
                    break;
                }
                stringBuffer.append(4);
                break;
            }

            case R.id.b28: {
                if (stringBuffer.length() != 0 && stringBuffer.charAt(stringBuffer.length() - 1) == ')') {
                    break;
                }
                stringBuffer.append(5);
                break;
            }

            case R.id.b29: {
                if (stringBuffer.length() != 0 && stringBuffer.charAt(stringBuffer.length() - 1) == ')') {
                    break;
                }
                stringBuffer.append(6);
                break;
            }

            case R.id.b17: {
                if (stringBuffer.length() != 0 && stringBuffer.charAt(stringBuffer.length() - 1) == ')') {
                    break;
                }
                stringBuffer.append(7);
                break;
            }

            case R.id.b18: {
                if (stringBuffer.length() != 0 && stringBuffer.charAt(stringBuffer.length() - 1) == ')') {
                    break;
                }
                stringBuffer.append(8);
                break;
            }

            case R.id.b19: {
                if (stringBuffer.length() != 0 && stringBuffer.charAt(stringBuffer.length() - 1) == ')') {
                    break;
                }
                stringBuffer.append(9);
                break;
            }

            case R.id.b47: {
                if (stringBuffer.length() != 0 && stringBuffer.charAt(stringBuffer.length() - 1) == ')') {
                    break;
                }
                stringBuffer.append(0);
                break;
            }


            case R.id.b49:
                if (stringBuffer.length() != 0) {
                    char c = stringBuffer.charAt(stringBuffer.length() - 1);
                    if (c >= '0' && c <= '9') {
                        stringBuffer.append(".");
                    }
                }
                break;


            case R.id.b8:
                if (stringBuffer.length() != 0) {
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                }
                break;


            case R.id.b7:
                stringBuffer = new StringBuffer();
                result = "";
                break;
            case R.id.b40:
                if (result.length() != 0) {
                    stringBuffer.append(result);
                    result = "";
                }
                if (stringBuffer.length() == 0) {
                    stringBuffer.append("+");
                } else {
                    char c = stringBuffer.charAt(stringBuffer.length() - 1);
                    if (c >= '0' && c <= '9' || c == ')') {
                        stringBuffer.append("+");
                    }
                }
                break;
            case R.id.b30:
                if (result.length() != 0) {
                    stringBuffer.append(result);
                    result = "";
                }
                if (stringBuffer.length() == 0) {
                    stringBuffer.append("-");
                } else {
                    int len = stringBuffer.length();
                    char c = stringBuffer.charAt(len - 1);
                    if (c >= '0' && c <= '9' || c == '(' || c == ')') {
                        stringBuffer.append("-");
                    } else if (len >= 2) {
                        c = stringBuffer.charAt(len - 2);
                        if (c >= '0' && c <= '9' || c == '(' || c == ')') {
                            stringBuffer.append("-");
                        }
                    }
                }
                break;
            //****************
            case R.id.b20:
                if (result.length() != 0) {
                    stringBuffer.append(result);
                    result = "";
                }
                if (stringBuffer.length() != 0) {
                    char c = stringBuffer.charAt(stringBuffer.length() - 1);
                    if (c >= '0' && c <= '9' || c == ')') {
                        stringBuffer.append("*");
                    }
                }
                break;
            case R.id.b10:
                if (result.length() != 0) {
                    stringBuffer.append(result);
                    result = "";
                }
                if (stringBuffer.length() != 0) {
                    char c = stringBuffer.charAt(stringBuffer.length() - 1);
                    if (c >= '0' && c <= '9' || c == ')') {
                        stringBuffer.append("/");
                    }
                }
                break;


            case R.id.b9:
                if (result.length() != 0) {
                    stringBuffer.append(result);
                    result = "";
                }
                if (stringBuffer.length() != 0) {
                    char c = stringBuffer.charAt(stringBuffer.length() - 1);
                    if (c >= '0' && c <= '9' || c == ')') {
                        stringBuffer.append("%");
                    }
                }
                break;


            case R.id.b50:
                if (stringBuffer.length() != 0) {
                    char c = '\0';
                    int n1 = 0;// '('的个数
                    int n2 = 0;// ')'的个数
                    for (int i = 0; i < stringBuffer.length(); i++) {
                        c = stringBuffer.charAt(i);
                        if (c == '(') {
                            n1++;
                        } else if (c == ')') {
                            n2++;
                        }
                    }
                    if (n1 == n2 && (c >= '0' && c <= '9' || c == ')')) {
                        stringBuffer.append("=");
                        try {
                            result = calculatorMath.GetResult(stringBuffer.toString());

                            stringBuffer.append(result);
                            fileWrite(stringBuffer.toString());
                            /*
                            editor.putString(Key_UserName, stringBuffer.toString());
                            editor.apply();*/
                        } catch (Exception e1) {
                            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                            Toast.makeText(this, "表达式错误", Toast.LENGTH_LONG).show();
                        }

                    }
                }
                break;

            case R.id.b32:
                if (stringBuffer.length() != 0) {
                    double number;
                    number = Doublecal();
                    result = calculatorMath.GetResult(stringBuffer.toString());
                    // stringBuffer.append(result);
                    //  double n1 = Double.parseDouble(stringBuffer.toString());
                    stringBuffer2 = stringBuffer;
                    stringBuffer = new StringBuffer();
                    stringBuffer.append("sin(" + stringBuffer2 + ")=" + sin(number) + "");
                    fileWrite(stringBuffer.toString());
                }
                break;


            case R.id.b33:
                if (stringBuffer.length() != 0) {
                    double number;
                    number = Doublecal();
                    result = calculatorMath.GetResult(stringBuffer.toString());
                    // stringBuffer.append(result);
                    //  double n1 = Double.parseDouble(stringBuffer.toString());
                    stringBuffer2 = stringBuffer;
                    stringBuffer = new StringBuffer();
                    stringBuffer.append("cos(" + stringBuffer2 + ")=" + cos(number) + "");
                    fileWrite(stringBuffer.toString());
                }
                break;


            case R.id.b34:
                if (stringBuffer.length() != 0) {
                    double number;
                    number = Doublecal();
                    /*
                    try{

                    }
                    */
                    result = calculatorMath.GetResult(stringBuffer.toString());
                    // stringBuffer.append(result);
                    //  double n1 = Double.parseDouble(stringBuffer.toString());
                    stringBuffer2 = stringBuffer;
                    stringBuffer = new StringBuffer();
                    stringBuffer.append("tan(" + stringBuffer2 + ")=" + tan(number) + "");
                    fileWrite(stringBuffer.toString());
                }
                break;


            case R.id.b42:
                if (stringBuffer.length() != 0) {
                    double number;
                    number = Doublecal();
                    /*
                    try{

                    }
                    */
                    result = calculatorMath.GetResult(stringBuffer.toString());
                    // stringBuffer.append(result);
                    //  double n1 = Double.parseDouble(stringBuffer.toString());
                    stringBuffer2 = stringBuffer;
                    stringBuffer = new StringBuffer();
                    stringBuffer.append("sinh(" + stringBuffer2 + ")=" + sinh(number) + "");
                    fileWrite(stringBuffer.toString());
                }
                break;


            case R.id.b43:
                if (stringBuffer.length() != 0) {
                    double number;
                    number = Doublecal();
                    /*
                    try{

                    }
                    */
                    result = calculatorMath.GetResult(stringBuffer.toString());
                    // stringBuffer.append(result);
                    //  double n1 = Double.parseDouble(stringBuffer.toString());
                    stringBuffer2 = stringBuffer;
                    stringBuffer = new StringBuffer();
                    stringBuffer.append("cosh(" + stringBuffer2 + ")=" + cosh(number) + "");
                    fileWrite(stringBuffer.toString());
                }
                break;


            case R.id.b44:
                if (stringBuffer.length() != 0) {
                    double number;
                    number = Doublecal();
                    /*
                    try{

                    }
                    */
                    result = calculatorMath.GetResult(stringBuffer.toString());
                    // stringBuffer.append(result);
                    //  double n1 = Double.parseDouble(stringBuffer.toString());
                    stringBuffer2 = stringBuffer;
                    stringBuffer = new StringBuffer();
                    stringBuffer.append("tanh(" + stringBuffer2 + ")=" + tanh(number) + "");
                    fileWrite(stringBuffer.toString());
                }
                break;


            case R.id.b25:
                if (stringBuffer.length() != 0) {
                    double number;
                    number = Doublecal();
                    /*
                    try{

                    }
                    */
                    result = calculatorMath.GetResult(stringBuffer.toString());
                    // stringBuffer.append(result);
                    //  double n1 = Double.parseDouble(stringBuffer.toString());
                    stringBuffer2 = stringBuffer;
                    stringBuffer = new StringBuffer();
                    stringBuffer.append("log(" + stringBuffer2 + ")=" + log(number) + "");
                    fileWrite(stringBuffer.toString());
                }
                break;


            case R.id.b26:
                if (stringBuffer.length() != 0) {
                    double number;
                    number = Doublecal();
                    /*
                    try{

                    }
                    */
                    result = calculatorMath.GetResult(stringBuffer.toString());
                    // stringBuffer.append(result);
                    //  double n1 = Double.parseDouble(stringBuffer.toString());
                    stringBuffer2 = stringBuffer;
                    stringBuffer = new StringBuffer();
                    stringBuffer.append("log10(" + stringBuffer2 + ")=" + log10(number) + "");
                    fileWrite(stringBuffer.toString());
                }
                break;


            case R.id.b31:
                if (stringBuffer.length() != 0) {

                    int number;

                    long res;
                    // number=Doublecal();
                    number = Intblecal();
                    res = jiecheng(number);

                    /*
                    try{

                    }
                    */
                    result = calculatorMath.GetResult(stringBuffer.toString());
                    // stringBuffer.append(result);
                    //  double n1 = Double.parseDouble(stringBuffer.toString());
                    stringBuffer2 = stringBuffer;
                    stringBuffer = new StringBuffer();
                    stringBuffer.append(" " + stringBuffer2 + "!" + res + "");
                    fileWrite(stringBuffer.toString());
                }
                break;


            case R.id.b21:
                if (stringBuffer.length() != 0) {
                    double number;
                    number = Doublecal();
                    double re;
                    re = 1 / number;
                    /*
                    try{

                    }
                    */
                    result = calculatorMath.GetResult(stringBuffer.toString());
                    // stringBuffer.append(result);
                    //  double n1 = Double.parseDouble(stringBuffer.toString());
                    stringBuffer2 = stringBuffer;
                    stringBuffer = new StringBuffer();
                    stringBuffer.append("1/" + stringBuffer2 + "=" + re + "");
                    fileWrite(stringBuffer.toString());
                }
                break;


            case R.id.b22:
                if (stringBuffer.length() != 0) {
                    double number;
                    number = Doublecal();
                    /*
                    try{

                    }
                    */
                    result = calculatorMath.GetResult(stringBuffer.toString());
                    // stringBuffer.append(result);
                    //  double n1 = Double.parseDouble(stringBuffer.toString());
                    stringBuffer2 = stringBuffer;
                    stringBuffer = new StringBuffer();
                    stringBuffer.append("sqrt(" + stringBuffer2 + ")=" + sqrt(number) + "");
                    fileWrite(stringBuffer.toString());
                }
                break;


            case R.id.b23:
                if (stringBuffer.length() != 0) {
                    double number;
                    number = Doublecal();
                    /*
                    try{

                    }
                    */
                    result = calculatorMath.GetResult(stringBuffer.toString());
                    // stringBuffer.append(result);
                    //  double n1 = Double.parseDouble(stringBuffer.toString());
                    stringBuffer2 = stringBuffer;
                    stringBuffer = new StringBuffer();
                    stringBuffer.append("sqrt3(" + stringBuffer2 + ")=" + pow(number, 1d / 3) + "");
                    fileWrite(stringBuffer.toString());
                }
                break;


            case R.id.b41:
                if (stringBuffer.length() != 0) {
                    double number;
                    number = Doublecal();
                    /*
                    try{

                    }
                    */
                    result = calculatorMath.GetResult(stringBuffer.toString());
                    // stringBuffer.append(result);
                    //  double n1 = Double.parseDouble(stringBuffer.toString());
                    stringBuffer2 = stringBuffer;
                    stringBuffer = new StringBuffer();
                    stringBuffer.append("rad(" + stringBuffer2 + ")=" + ((180 / Math.PI) * number) + "°");
                    fileWrite(stringBuffer.toString());
                }
                break;


            case R.id.b46:
                if (stringBuffer.length() != 0) {
                    double number;
                    number = Doublecal();
                    /*
                    try{

                    }
                    */
                    result = calculatorMath.GetResult(stringBuffer.toString());
                    // stringBuffer.append(result);
                    //  double n1 = Double.parseDouble(stringBuffer.toString());
                    stringBuffer2 = stringBuffer;
                    stringBuffer = new StringBuffer();
                    stringBuffer.append("rand=" + random() + "");
                    fileWrite(stringBuffer.toString());
                }
                break;


            case R.id.b48:
                Intent intentjz = new Intent(MainActivity.this, showView.class);
                startActivity(intentjz);
                break;


            case R.id.b4: {


                if (result != "") {
                    if (M1 % 2 == 0) {
                        M1++;
                        memoryNum = result;
                        //   memory=memoryNum+"+";

                    } else {
                        M1++;
                        stringBuffer.append("+" + memoryNum);
                        Toast.makeText(MainActivity.this, memoryNum + "+", Toast.LENGTH_LONG).show();
                    }


                }

                break;
            }

            case R.id.b5: {


                if (result != "") {
                    if (M2 % 2 == 0) {
                        M2++;
                        memoryNum2 = result;
                        //   memory=memoryNum+"+";

                    } else {
                        M2++;
                        stringBuffer.append("-" + memoryNum2);
                        //  Toast.makeText(MainActivity.this,memoryNum+"+",Toast.LENGTH_LONG).show();
                    }


                }

                break;
            }


            case R.id.b3: {
                M1 = 0;
                M2 = 0;
                stringBuffer = new StringBuffer();
                result = "";


                break;
            }


            case R.id.b6: {
                if (memoryNum != "")
                    stringBuffer.append("+" + memoryNum);
                if (memoryNum2 != "")
                    stringBuffer.append("-" + memoryNum2);
                break;
            }



            case R.id.b15:
                Intent intentEx = new Intent(MainActivity.this, ExchangeMath.class);
                startActivity(intentEx);
                break;

























        }

        textView2.setText(stringBuffer.toString());
    }




    public double Doublecal(){
       double num = 0;
        char c = '\0';
        int n1 = 0;// '('的个数
        int n2 = 0;// ')'的个数
        for (int i = 0; i < stringBuffer.length(); i++) {
            c = stringBuffer.charAt(i);
            if (c == '(') {
                n1++;
            } else if (c == ')') {
                n2++;
            }
        }
        if (n1 == n2 && (c >= '0' && c <= '9' || c == ')')) {
            stringBuffer.append(" ");
            try {
                result = calculatorMath.GetResult(stringBuffer.toString());
                 num = Double.parseDouble(result);
                //    mExpressBuffer.append(mResult);
            } catch (Exception e1) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                Toast.makeText(this, "表达式错误", Toast.LENGTH_LONG).show();
            }

        }
        return num;
    }


    public int Intblecal(){
        int num = 0;
        char c = '\0';
        int n1 = 0;// '('的个数
        int n2 = 0;// ')'的个数
        for (int i = 0; i < stringBuffer.length(); i++) {
            c = stringBuffer.charAt(i);
            if (c == '(') {
                n1++;
            } else if (c == ')') {
                n2++;
            }
        }
        if (n1 == n2 && (c >= '0' && c <= '9' || c == ')')) {
            stringBuffer.append(" ");
            try {
                result = calculatorMath.GetResult(stringBuffer.toString());
                num = Integer.parseInt(result);
                //    mExpressBuffer.append(mResult);
            } catch (Exception e1) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                Toast.makeText(this, "表达式错误", Toast.LENGTH_LONG).show();
            }

        }
        return num;
    }

    private long jiecheng(int n){


            long num = 1;
            for (int i = 1; i <= n; i++) {
                num *= i;
            }
            return num;


    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public  void fileWrite(String s){
        try{
            FileOutputStream fileOutputStream=openFileOutput(FILE_NAME,MODE_APPEND);
            out=new BufferedOutputStream(fileOutputStream);
            //String content="";
            try {
                out.write(s.getBytes(StandardCharsets.UTF_8));
                out.write('\n');
                Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
            }
            finally {
                if(out!=null)
                    out.close();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public  void fileRead(){

        try {
            FileInputStream fileInputStream = openFileInput(FILE_NAME);
            in=new BufferedInputStream(fileInputStream);
            String s=" ";
            int c;
            StringBuilder stringBuilder=new StringBuilder("");
            try{
                while ((c=in.read())!=-1) {
                    stringBuilder.append((char)c);
                //   while (c=='\n'){
                     //  s=stringBuilder.toString().substring(0,stringBuilder.length()-2);
                     //  LList.ADD(s);
                      // stringBuilder=new StringBuilder("");
                //   }
             //
                }
                Toast.makeText(MainActivity.this,stringBuilder.toString(),Toast.LENGTH_LONG).show();
            }
            finally {
                if(in!=null)
                in.close();
            }
        }            catch (Exception e){
            e.printStackTrace();
        }


    }







        /*
        b1 = (Button)super.findViewById(R.id.b1);
        b2= (Button)super.findViewById(R.id.b2);
         b3= (Button)super.findViewById(R.id.b3);
         b4= (Button)super.findViewById(R.id.b4);
         b5= (Button)super.findViewById(R.id.b5);
         b6= (Button)super.findViewById(R.id.b6);
         b7= (Button)super.findViewById(R.id.b7);
         b8= (Button)super.findViewById(R.id.b8);
         b9= (Button)super.findViewById(R.id.b9);
         b10= (Button)super.findViewById(R.id.b10);
         b11 = (Button)super.findViewById(R.id.b11);
         b12= (Button)super.findViewById(R.id.b12);
         b13= (Button)super.findViewById(R.id.b13);
         b14= (Button)super.findViewById(R.id.b14);
        b15 = (Button)super.findViewById(R.id.b15);
         b16= (Button)super.findViewById(R.id.b16);
        b17= (Button)super.findViewById(R.id.b17);
        b18 = (Button)super.findViewById(R.id.b18);
        b19 = (Button)super.findViewById(R.id.b19);
         b20= (Button)super.findViewById(R.id.b20);
         b21= (Button)super.findViewById(R.id.b21);
         b22= (Button)super.findViewById(R.id.b22);
         b23= (Button)super.findViewById(R.id.b23);
         b24= (Button)super.findViewById(R.id.b24);
        b25 = (Button)super.findViewById(R.id.b25);
        b26 = (Button)super.findViewById(R.id.b26);
        b27 = (Button)super.findViewById(R.id.b27);
       b28 = (Button)super.findViewById(R.id.b28);
        b29 = (Button)super.findViewById(R.id.b29);
        b30 = (Button)super.findViewById(R.id.b30);
        b31 = (Button)super.findViewById(R.id.b31);
         b32= (Button)super.findViewById(R.id.b32);
        b33 = (Button)super.findViewById(R.id.b33);
         b34= (Button)super.findViewById(R.id.b34);
        b35 = (Button)super.findViewById(R.id.b35);
        b36 = (Button)super.findViewById(R.id.b36);
        b37 = (Button)super.findViewById(R.id.b37);
        b38= (Button)super.findViewById(R.id.b38);
         b39= (Button)super.findViewById(R.id.b39);
        b40 = (Button)super.findViewById(R.id.b40);
        b41 = (Button)super.findViewById(R.id.b41);
         b42= (Button)super.findViewById(R.id.b42);
         b43= (Button)super.findViewById(R.id.b43);
         b44= (Button)super.findViewById(R.id.b44);
         b45= (Button)super.findViewById(R.id.b45);
         b46= (Button)super.findViewById(R.id.b46);
         b47= (Button)super.findViewById(R.id.b47);
         b48= (Button)super.findViewById(R.id.b48);
         b49= (Button)super.findViewById(R.id.b49);
         b50= (Button)super.findViewById(R.id.b50);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b46.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b47.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        b49.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        */








    }


// CCCCFF  CCCCCC
