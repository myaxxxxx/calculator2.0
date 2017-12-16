package com.example.lenovo.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lenovo on 2017/10/16.
 */

public class exchangeright extends Fragment {


    private List<String> list = new ArrayList<String>();
    private Spinner mySpinnerright;
    private ArrayAdapter<String> adapter;
    private Button b;

    private int num=8;
    TextView textView1,textView2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstenceState){


        View view = inflater.inflate(R.layout.exchangeright,container,false);

        b= (Button)view.findViewById(R.id.exchange2);
        textView1=(TextView)view.findViewById(R.id.exchange_text3) ;
        textView2=(TextView)view.findViewById(R.id.exchange_text4) ;
        list.add("g");
        list.add("cm");
        list.add("s");
        //   list.add("六进制");
        //   list.add("六进制");
        mySpinnerright =(Spinner)view.findViewById(R.id.exchangeright);
        ////
        adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_spinner_item, list);
        mySpinnerright.setAdapter(adapter);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Exchange(textView2.getText().toString(),textView1.getText().toString(),num);
                Toast.makeText(getActivity(), num+"", Toast.LENGTH_SHORT).show();
            }
        });
        mySpinnerright.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                /* 将所选mySpinner 的值带入myTextView 中*/
                //myTextView.setText("您选择的是："+ adapter.getItem(arg2));
                // Toast.makeText(getActivity(), adapter.getItem(arg2), Toast.LENGTH_SHORT).show();


                /* 将mySpinner 显示*/
                arg0.setVisibility(View.VISIBLE);
            }
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                // myTextView.setText("NONE");
                Toast.makeText(getActivity(), "456", Toast.LENGTH_SHORT).show();
                arg0.setVisibility(View.VISIBLE);
            }



        });

        mySpinnerright.setOnTouchListener(new Spinner.OnTouchListener(){
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                /**
                 Toast.makeText(getActivity(), "6685", Toast.LENGTH_SHORT).show();
                 */

                Toast.makeText(getActivity(), "请选择", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        /*下拉菜单弹出的内容选项焦点改变事件处理*/
        mySpinnerright.setOnFocusChangeListener(new Spinner.OnFocusChangeListener(){
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub
                Toast.makeText(getActivity(), "99999", Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }


    private  void Exchange(String s1 , String s2 , int k){
        try {

               double s = Double.parseDouble(s1);
               // textView1.setText(n1+"");

              //  Scanner sc = new Scanner(s2);
        //    double s = sc.nextDouble();
                String sum="";

                if(k==2){
                   s=s*1000;
                }

                if(k==8){
                    s=s*100;
                }

                if(k==16){
                   s=s*60;
                }

                /*
                while(s != 0){
                    sum = (int) (sum + s % 10 * (Math.pow(2,i)));
                    s = s / 10;
                    i ++;
                }*/
                textView1.setText(s + "");

        } catch (Exception e){

        }

    }

}

