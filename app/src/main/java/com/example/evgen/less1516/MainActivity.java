package com.example.evgen.less1516;


import android.content.Context;
import android.content.Intent;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.util.Log;
import android.view.View.OnClickListener;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.charset.MalformedInputException;
import java.util.ArrayList;


public  class MainActivity extends ActionBarActivity implements OnClickListener {


    String[] dopf;
    String oper;
    EditText et;
    TextView tv;
    Button bplus;
    Button bminus;
    Button ravno;
    Button bt1;
    Button bt2;
    Button bt3;
    Button bt4;
    Button bt5;
    Button bt6;
    Button bt7;
    Button bt8;
    Button bt9;
    Button bt10;
    Button bdot;
    Button cle;
    ArrayList<Float> res = new ArrayList<Float>();
    ListView lis;
    float num1;
    float num2;

    final static int CLEAR = 1;
    final static int DONT_CLEAR = 0;

    int n;
    final static int ADD = 1;
    final static int MINUS = 2;
    final static int RAVNO = 3;
    final static int mult = 4;
    final static int div = 5;
    int currentOperation = 0;
    int ccd = 0;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // найдем View-элементы

        lis = (ListView) findViewById(R.id.lis);
        lis.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.dopf, android.R.layout.simple_list_item_1);
        lis.setAdapter(adapter);


        et = (EditText) findViewById(R.id.et);
        tv = (TextView) findViewById(R.id.tv);
        bplus = (Button) findViewById(R.id.bplus);

        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
        bt4 = (Button) findViewById(R.id.bt4);
        bt5 = (Button) findViewById(R.id.bt5);
        bt6 = (Button) findViewById(R.id.bt6);
        bt7 = (Button) findViewById(R.id.bt7);
        bt8 = (Button) findViewById(R.id.bt8);
        bt9 = (Button) findViewById(R.id.bt9);
        bt10 = (Button) findViewById(R.id.bt10);

        bminus = (Button) findViewById(R.id.bminus);
        ravno = (Button) findViewById(R.id.ravno);

        et.setKeyListener(DigitsKeyListener.getInstance(true, true));

        registerListeners();
        //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        et.setInputType(InputType.TYPE_NULL);

            }




    public void registerListeners() {


        bt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (ccd == CLEAR) {
                    et.setText("");
                }
                ccd = DONT_CLEAR;
                et.append("1");
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (ccd == CLEAR) {
                    et.setText("");
                }
                ccd = DONT_CLEAR;
                et.append("2");
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (ccd == CLEAR) {
                    et.setText("");
                }
                ccd = DONT_CLEAR;
                et.append("3");
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (ccd == CLEAR) {
                    et.setText("");
                }
                ccd = DONT_CLEAR;
                et.append("4");
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (ccd == CLEAR) {
                    et.setText("");
                }
                ccd = DONT_CLEAR;
                et.append("5");
            }
        });
        bt6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (ccd == CLEAR) {
                    et.setText("");
                }
                ccd = DONT_CLEAR;
                et.append("6");
            }
        });
        bt7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (ccd == CLEAR) {
                    et.setText("");
                }
                ccd = DONT_CLEAR;
                et.append("7");
            }
        });
        bt8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (ccd == CLEAR) {
                    et.setText("");
                }
                ccd = DONT_CLEAR;
                et.append("8");
            }
        });
        bt9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (ccd == CLEAR) {
                    et.setText("");
                }
                ccd = DONT_CLEAR;
                et.append("9");
            }
        });
        bdot.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (ccd == CLEAR) {
                    et.setText("");
                }
                ccd = DONT_CLEAR;
                et.append(".");
            }
        });
        bt10.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (ccd == CLEAR) {
                    et.setText("");
                }
                ccd = DONT_CLEAR;
                et.append("0");
            }
        });

        bplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ccd == CLEAR) {
                    et.setText("");
                }
                ccd = DONT_CLEAR;
                calc(ADD);
                et.append("+");
            }
        });


        bminus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (ccd == CLEAR) {
                    et.setText("");
                }
                ccd = DONT_CLEAR;
                calc(MINUS);
                et.append("-");

            }
        });

        ravno.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (ccd == CLEAR) {
                    et.setText("");
                }
                ccd = DONT_CLEAR;
                calc(RAVNO);
            }
        });


    }


/*Функция перевода из десятичного в двоичное значение*/
        private float decToBin(float bin) {
            int i, b;
            long result = 0;

            for(i=0; bin > 0; i++)  {
                b = (int) (bin % 2);
                bin = (bin-b)/2;
                result += b * Math.pow(10,i);
            }
            return result;
        }

    /*Функция перевода из двличного в десятичное значение*/
    public float binToDec(float dec) {
            int result = 0;
            int mult = 1;

            while(dec > 0) {
                result += mult * ((int)dec % 10);
                dec /= 10;
                mult *= 2;
            }
            return result;
        }




    private void calc(int n1) {

        res.add(Float.parseFloat(et.getText().toString()));

        if (n1 != RAVNO) {
            n = n1;
        } else if (n1 == RAVNO) {
            n = 0;
        }

        switch (currentOperation) {

    /*Прибавление*/
            case ADD:
                num1 = res.get(0);
                num2 = res.get(1);

                res.removeAll(res);

                res.add(num1 + num2);

                et.setText(String.format("%.0f", res.get(0)));
                break;

      /*Вычитание*/
            case MINUS:
                num1 = res.get(0);
                num2 = res.get(1);

                res.removeAll(res);

                res.add(num1 - num2);

                et.setText(String.format("%.0f", res.get(0)));
                break;
            //Умножение
            case mult:
                
                num1 = res.get(0);
                num2 = res.get(1);
                res.removeAll(res);
                res.add(num1 * num2);
                et.setText(String.format("%.0f", res.get(0)));
                break;
            case div:
                num1 = res.get(0);
                num2 = res.get(1);

                res.removeAll(res);

                res.add(num1 / num2);

                et.setText(String.format("%.0f", res.get(0)));
                break;
        }


            ccd = CLEAR;
            currentOperation = n;
            if (n1 == RAVNO) {
                num1 = 0;
                num2 = 0;
                res.removeAll(res);
            }

        }


    }



