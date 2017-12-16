package com.example.lenovo.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import static android.R.id.list;

public class showView extends AppCompatActivity {
    OutputStream out=null;
    InputStream in=null;
    String FILE_NAME = "fileDemo.txt";
    String strArray[]  = new String [100];
    ArrayList<String> LList =   new ArrayList<String>();
    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_show_view);
        listView = (ListView) findViewById(R.id.listView);
        button= (Button)super.findViewById(R.id.ACC) ;
       // Toast.makeText(showView.this,"666", Toast.LENGTH_LONG).show();
        fileRead();

      //  strArray[0]="666";

    //   String []strArray1={"666","777"};

    /*   for(String string :LList){
            //
            int i =0;
            strArray[i] = string;
            i++;
        }*/






        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,LList);
        //3.视图（ListView）加载适配器（arrayAdapter）
        listView.setAdapter(arrayAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fileOutputStream=openFileOutput(FILE_NAME,MODE_PRIVATE);
                    out=new BufferedOutputStream(fileOutputStream);
                    LList.clear();
                //    listView.invalidate();
                  //  listView.notify();

                    arrayAdapter = new ArrayAdapter<String>(showView.this,android.R.layout.simple_list_item_1,LList);
                    //3.视图（ListView）加载适配器（arrayAdapter）
                    listView.setAdapter(arrayAdapter);

                    Toast.makeText(showView.this,"删除成功", Toast.LENGTH_LONG).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }





    public  void fileRead(){

        try {
            FileInputStream fileInputStream = openFileInput(FILE_NAME);
            in=new BufferedInputStream(fileInputStream);
            String s="";
            int c;
            StringBuilder stringBuilder=new StringBuilder("");
            try{
                while ((c=in.read())!=-1) {
                    stringBuilder.append((char)c);
                  //  while(in.rea)
               /*    while (c=='\n'){
                       s=stringBuilder.toString().substring(0,stringBuilder.length()-2);
                        LList.add(s);

                        stringBuilder=new StringBuilder("");
                       continue;
                    }*/
                    //
               }
                LList.add(stringBuilder.toString());

            }
            finally {
                if(in!=null)
                    in.close();
            }
        }            catch (Exception e){
            e.printStackTrace();
        }



    }

}
