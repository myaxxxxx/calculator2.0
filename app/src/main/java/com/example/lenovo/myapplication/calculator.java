package com.example.lenovo.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.textSize;

public class calculator extends AppCompatActivity {
    private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,bz,bp,bd,bm,br,be;
    private TextView textView;
    private  StringBuffer stringBuffer = new StringBuffer();
    private String result = "";
   private  static CalculatorMath  calculatorMath= new CalculatorMath(20);




    public static void setEditTextHintSize(EditText editText, String hintContent, int hintSize) {
        // 设置hint字体大小
        SpannableString ss = new SpannableString(hintContent);
        AbsoluteSizeSpan ass = new AbsoluteSizeSpan(hintSize, true);
        ss.setSpan(ass, 0, ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        // 设置hint
        editText.setHint(new SpannedString(ss)); // 一定要进行转换,否则属性会消失
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        textView = (TextView)findViewById(R.id.textView);

        /*
      b1 = (Button)super.findViewById(R.id.one);
        b2 = (Button)super.findViewById(R.id.two);
        b3 = (Button)super.findViewById(R.id.three);
        b4 = (Button)super.findViewById(R.id.four);
        b5 = (Button)super.findViewById(R.id.five);
        b6 = (Button)super.findViewById(R.id.six);
        b7 = (Button)super.findViewById(R.id.seven);
        b8 = (Button)super.findViewById(R.id.eight);
        b9 = (Button)super.findViewById(R.id.nine);
        bz = (Button)super.findViewById(R.id.zero);
        bp = (Button)super.findViewById(R.id.plus);
        bd = (Button)super.findViewById(R.id.divide);
        bm = (Button)super.findViewById(R.id.multy);
        br= (Button)super.findViewById(R.id.reduce);
        be = (Button)super.findViewById(R.id.equal);
        editText =(EditText)super.findViewById(R.id.textView);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String d;
                String s = b1.getText().toString();
                if(editText.getText().toString().length()>5){
                    d =editText.getText().toString();
                    d=d+s;
                   // setEditTextHintSize(editText,d,5);
                    editText.setTextSize(15);
                    editText.setText(d);


                    SpannableString ss = new SpannableString(d);
                    ss.setSpan(textSize,0,d.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    editText.setText(ss);


                }else {
                /*
                    d = editText.getText().toString();
                    d = d + s;
                   // setEditTextHintSize(editText, d, 20);
                    editText.setTextSize(50);
                    editText.setText(d);
                }
            }
        });*/
        /*

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = b2.getText().toString();
                editText.append(s);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.getText().toString();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.getText().toString();
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.getText().toString();
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.getText().toString();
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.getText().toString();
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.getText().toString();
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.getText().toString();
            }
        });

        bz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.getText().toString();
            }
        });

        bm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.getText().toString();
            }
        });

        br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.getText().toString();
            }
        });

        bp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.getText().toString();
            }
        });

        bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.getText().toString();
            }
        });

        be.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.getText().toString();

            }
        });

        */

    }

    public void clickMe(View v){
        if(result.length()>0&&stringBuffer.toString().contains("=")){
            stringBuffer = new StringBuffer();
        }
        Button button = (Button)v;
        switch (button.getId()){
            case R.id.one:
            {
                if (stringBuffer.length() != 0 && stringBuffer.charAt(stringBuffer.length() - 1) == ')') {
                    break;
                }
                stringBuffer.append(1);
                break;
            }

            case R.id.two:
            {
                if (stringBuffer.length() != 0 && stringBuffer.charAt(stringBuffer.length() - 1) == ')') {
                    break;
                }
                stringBuffer.append(2);
                break;
            }

            case R.id.three:
            {
                if (stringBuffer.length() != 0 && stringBuffer.charAt(stringBuffer.length() - 1) == ')') {
                    break;
                }
                stringBuffer.append(3);
                break;
            }

            case R.id.four:
            {
                if (stringBuffer.length() != 0 && stringBuffer.charAt(stringBuffer.length() - 1) == ')') {
                    break;
                }
                stringBuffer.append(4);
                break;
            }

            case R.id.five:
            {
                if (stringBuffer.length() != 0 && stringBuffer.charAt(stringBuffer.length() - 1) == ')') {
                    break;
                }
                stringBuffer.append(5);
                break;
            }

            case R.id.six:
            {
                if (stringBuffer.length() != 0 && stringBuffer.charAt(stringBuffer.length() - 1) == ')') {
                    break;
                }
                stringBuffer.append(6);
                break;
            }

            case R.id.seven:
            {
                if (stringBuffer.length() != 0 && stringBuffer.charAt(stringBuffer.length() - 1) == ')') {
                    break;
                }
                stringBuffer.append(7);
                break;
            }

            case R.id.eight:
            {
                if (stringBuffer.length() != 0 && stringBuffer.charAt(stringBuffer.length() - 1) == ')') {
                    break;
                }
                stringBuffer.append(8);
                break;
            }

            case R.id.nine:
            {
                if (stringBuffer.length() != 0 && stringBuffer.charAt(stringBuffer.length() - 1) == ')') {
                    break;
                }
                stringBuffer.append(9);
                break;
            }

            case R.id.zero:
            {
                if (stringBuffer.length() != 0 && stringBuffer.charAt(stringBuffer.length() - 1) == ')') {
                    break;
                }
                stringBuffer.append(0);
                break;
            }


            case R.id.dot:
                if (stringBuffer.length() != 0) {
                    char c = stringBuffer.charAt(stringBuffer.length() - 1);
                    if (c >= '0' && c <= '9') {
                        stringBuffer.append(".");
                    }
                }
                break;


            case R.id.C:
                if (stringBuffer.length() != 0) {
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                }
                break;



            case R.id.AC:
                stringBuffer = new StringBuffer();
                result = "";
                break;
            case R.id.plus:
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
            case R.id.reduce:
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
            //***************************************************
            case R.id.mu:
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
            case R.id.div:
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




            case R.id.equals:
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
                        } catch (Exception e1) {
                            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                            Toast.makeText(this, "表达式错误", Toast.LENGTH_LONG).show();
                        }

                    }
                }
                break;


            case R.id.T:
                Intent intentjz = new Intent(calculator.this, MainActivity.class);
                startActivity(intentjz);
                break;





        }

        textView.setText(stringBuffer.toString());
    }


}




