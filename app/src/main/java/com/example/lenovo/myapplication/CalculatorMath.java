package com.example.lenovo.myapplication;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Stack;

/**
 * Created by lenovo on 2017/10/14.
 */

public class CalculatorMath {

    /**
     * 数据栈和符号栈
     */
    Stack<BigDecimal> Number;
    Stack<Character> Operator;
    int length;

    public CalculatorMath(int length) {
        this.length = length;
    }


    public  String GetResult(String exp) {
        this.Number = new Stack<BigDecimal>();
        this.Operator = new Stack<Character>();
         Calculate(exp);
        return this.Number.peek().toString();
    }

    public void Push(double Mnumber){

    }





    public void Calculate(String EE) {
        int index = 0;
        int sign = 0;
        while (index < EE.length()) {
            char op = EE.charAt(index);

            if ((op <= '9' && op >= '0') || op == '.') {

                index++;

            } else {

                if (index > 0) {



                    char opp = EE.charAt(index-1);
                    if (op == '-' && !((opp <= '9' && opp >= '0') || opp == '.')) {

                        index++;

                        continue;
                    }
                }
                if (sign != index) {

                    String numStr = EE.substring(sign, index);

                    BigDecimal num = new BigDecimal(numStr);

                    Number.push(num);
                }

                //************************************
                Analysis(op);
                sign = ++index;
            }
        }
    }



    public void Analysis(char op) {
        if (Operator.empty() || Compare(op, Operator.peek())) {

            Operator.push(op);
        }
        else
            {
            makeNum(op);
        }
    }




    private void makeNum(char op) {
        BigDecimal result = null;


        while (!Operator.empty() && !Compare(op, Operator.peek())) {

            char op2 = Operator.pop();

            if (op == ')' && op2 == '(') {
                return;
            }


            BigDecimal num1 = null;
            BigDecimal num2 = Number.pop();
            if (Number.empty()) {



                num1 = new BigDecimal(0);
            } else {
                num1 = Number.pop();
            }
            switch (op2) {



                case '+':
                    result = num1.add(num2);
                    break;
                case '-':
                    result = num1.subtract(num2);
                    break;
                case '*':
                    result = num1.multiply(num2);
                    break;
                case '/':
                    result = num1.divide(num2, new MathContext(length));
                    break;
                case '^':
                    result = num1.pow(num2.intValue());
                    break;
                case'%':
                    result=num1.remainder(num2);
                    break;
                default:
                    Operator.pop();
                    break;
            }
            Number.push(result);
        }
        if (op != ')') {
            Operator.push(op);
        }
    }

    public boolean Compare(char c1, char c2) {
        if (c1 == '=') {

            return false;
        } else if (c1 == ')')
        {

            return false;
        } else if (c1 == '(')
        {

            return true;
        } else if (c2 == '(')
        {

            return true;
        } else if (c1 == '^')
        {

            return true;
        }
        else if ((c1 == '*' || c1 == '/'|| c1=='%') && (c2 == '-' || c2 == '+'))
        {
            return true;
        }
        else

            {
            return false;
        }

    }
}







