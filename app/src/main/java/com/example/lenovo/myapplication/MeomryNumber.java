package com.example.lenovo.myapplication;

import java.util.Stack;

/**
 * Created by lenovo on 2017/10/15.
 */

public class MeomryNumber {
    Stack<String> memoryNum ;
    public  MeomryNumber(){
        this.memoryNum =new Stack<String>();
    }

    private void  Push(String string){
        memoryNum.push(string);
    }
    private  void Pop(String string){
        memoryNum.pop();
    }

    private  void Clear(String string){
        memoryNum.clear();
    }

    private  void check(String string){
        memoryNum.peek();
    }

}
