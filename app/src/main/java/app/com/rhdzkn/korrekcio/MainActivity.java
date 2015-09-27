package app.com.rhdzkn.korrekcio;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    // Változók inicializálása
    public EditText text_L1, text_L2, text_L3, text_R1, text_R2, text_R3;
    public float[] value_L = { 0.000f, 0.000f, 0.000f }, value_R = { 0.000f, 0.000f, 0.000f }, value_Elforgatott_bal = { 0.000f, 0.000f, 0.000f }, value_Elforgatott_jobb = { 0.000f, 0.000f, 0.000f };
    public float value_atlag_L, value_atlag_R, value_eredeti_atlag, value_Elforgatott_atlag;
    public TextView atlag_L, atlag_R, text_eredeti_atlag, text_Elforgatott_L1, text_Elforgatott_L2, text_Elforgatott_L3, text_Elforgatott_R1, text_Elforgatott_R2, text_Elforgatott_R3, text_Elforgatott_atlag;
    public TextView text_ROT, text_TRANS;
    public float value_ROT, value_TRANS;
    public int i;

    public EditText text_RENDPT, text_AENDPT, text_ARAMPEO, text_ARAMPEU, text_RRAMPEO, text_RRAMPEU, text_M12Y, text_M12Z;
    public TextView text_RENDPT_ROT,text_AENDPT_ROT, text_ARAMPEO_ROT, text_ARAMPEU_ROT, text_RRAMPEO_ROT, text_RRAMPEU_ROT, text_M12Y_Y, text_M12Z_X;
    public float value_RENDPT, value_AENDPT, value_ARAMPEO, value_ARAMPEU, value_RRAMPEO, value_RRAMPEU, value_M12Y, value_M12Z;
    public TextView ko_L1, ko_L2, ko_L3, ko_R1, ko_R2, ko_R3, ko_RENDPT, ko_AENDPT, ko_ARAMPEO, ko_ARAMPEU, ko_RRAMPEO, ko_RRAMPEU, ko_M12Y, ko_M12Z;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_L1 = (EditText) findViewById(R.id.edit_L1);
        text_L2 = (EditText) findViewById(R.id.edit_L2);
        text_L3 = (EditText) findViewById(R.id.edit_L3);
        text_R1 = (EditText) findViewById(R.id.edit_R1);
        text_R2 = (EditText) findViewById(R.id.edit_R2);
        text_R3 = (EditText) findViewById(R.id.edit_R3);

        atlag_L = (TextView) findViewById(R.id.text_L_atlag);
        atlag_R = (TextView) findViewById(R.id.text_R_atlag);

        text_eredeti_atlag = (TextView) findViewById(R.id.text_E_atlag);

        text_Elforgatott_L1 = (TextView) findViewById(R.id.text_Elforgatott_L1);
        text_Elforgatott_L2 = (TextView) findViewById(R.id.text_Elforgatott_L2);
        text_Elforgatott_L3 = (TextView) findViewById(R.id.text_Elforgatott_L3);
        text_Elforgatott_R1 = (TextView) findViewById(R.id.text_Elforgatott_R1);
        text_Elforgatott_R2 = (TextView) findViewById(R.id.text_Elforgatott_R2);
        text_Elforgatott_R3 = (TextView) findViewById(R.id.text_Elforgatott_R3);

        text_Elforgatott_atlag = (TextView) findViewById(R.id.text_Elforgatott_atlag);

        text_ROT = (TextView) findViewById(R.id.text_ROT_VAL);
        text_TRANS = (TextView) findViewById(R.id.text_TRANS_VAL);

        text_L1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (text_L1.length() == 0 || text_L1.getText().toString().equals("-") || text_L1.getText().toString().equals("0"))
                {
                    value_L[0] = 0.000f;
                }
                else
                {
                    value_L[0] = Float.parseFloat(text_L1.getText().toString());
                }
                atlag_L();
                elforgatott();
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        text_L2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (text_L2.length() == 0 || text_L2.getText().toString().equals("-") || text_L2.getText().toString().equals("0"))
                {
                    value_L[1] = 0.000f;
                }
                else {
                    value_L[1] = Float.parseFloat(text_L2.getText().toString());
                }
                atlag_L();
                elforgatott();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        text_L3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (text_L3.length() == 0 || text_L3.getText().toString().equals("-") || text_L3.getText().toString().equals("0"))
                {
                    value_L[2] = 0.000f;
                }
                else
                {
                    value_L[2] = Float.parseFloat(text_L3.getText().toString());
                }
                atlag_L();
                elforgatott();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        text_R1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (text_R1.length() == 0 || text_R1.getText().toString().equals("-") || text_R1.getText().toString().equals("0"))
                {
                    value_R[0] = 0.000f;
                }
                else
                {
                    value_R[0] = Float.parseFloat(text_R1.getText().toString());
                }
                atlag_R();
                elforgatott();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        text_R2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (text_R2.length() == 0 || text_R2.getText().toString().equals("-") || text_R2.getText().toString().equals("0"))
                {
                    value_R[1] = 0.000f;
                }
                else
                {
                    value_R[1] = Float.parseFloat(text_R2.getText().toString());
                }
                atlag_R();
                elforgatott();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        text_R3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (text_R3.length() == 0 || text_R3.getText().toString().equals("-") || text_R3.getText().toString().equals("0"))
                {
                    value_R[2] = 0.000f;
                }
                else
                {
                    value_R[2] = Float.parseFloat(text_R3.getText().toString());
                }
                atlag_R();
                elforgatott();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        text_RENDPT = (EditText) findViewById(R.id.edit_RENDPT);
        text_AENDPT = (EditText) findViewById(R.id.edit_AENDPT);
        text_ARAMPEO = (EditText) findViewById(R.id.edit_ARAMPEO);
        text_ARAMPEU = (EditText) findViewById(R.id.edit_ARAMPEU);
        text_RRAMPEO = (EditText) findViewById(R.id.edit_RRAMPEO);
        text_RRAMPEU = (EditText) findViewById(R.id.edit_RRAMPEU);
        text_M12Y = (EditText) findViewById(R.id.edit_M12Y);
        text_M12Z = (EditText) findViewById(R.id.edit_M12Z);

        ko_L1 = (TextView) findViewById(R.id.ko_L1);
        ko_L2 = (TextView) findViewById(R.id.ko_L2);
        ko_L3 = (TextView) findViewById(R.id.ko_L3);
        ko_R1 = (TextView) findViewById(R.id.ko_R1);
        ko_R2 = (TextView) findViewById(R.id.ko_R2);
        ko_R3 = (TextView) findViewById(R.id.ko_R3);
        ko_RENDPT = (TextView) findViewById(R.id.ko_RENDPT);
        ko_AENDPT = (TextView) findViewById(R.id.ko_AENDPT);
        ko_ARAMPEO = (TextView) findViewById(R.id.ko_ARAMPEO);
        ko_ARAMPEU = (TextView) findViewById(R.id.ko_ARAMPEU);
        ko_RRAMPEO = (TextView) findViewById(R.id.ko_RRAMPEO);
        ko_RRAMPEU = (TextView) findViewById(R.id.ko_RRAMPEU);
        ko_M12Y = (TextView) findViewById(R.id.ko_M12Y);
        ko_M12Z = (TextView) findViewById(R.id.ko_M12Z);

        text_RENDPT_ROT = (TextView) findViewById(R.id.text_RENDPT_ROT);
        text_AENDPT_ROT = (TextView) findViewById(R.id.text_AENDPT_ROT);
        text_ARAMPEO_ROT = (TextView) findViewById(R.id.text_ARAMPEO_ROT);
        text_ARAMPEU_ROT = (TextView) findViewById(R.id.text_ARAMPEU_ROT);
        text_RRAMPEO_ROT = (TextView) findViewById(R.id.text_RRAMPEO_ROT);
        text_RRAMPEU_ROT = (TextView) findViewById(R.id.text_RRAMPEU_ROT);
        text_M12Y_Y = (TextView) findViewById(R.id.text_M12Y_Y);
        text_M12Z_X = (TextView) findViewById(R.id.text_M12Z_X);

        text_RENDPT.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (text_RENDPT.length() == 0 || text_RENDPT.getText().toString().equals("-") || text_RENDPT.getText().toString().equals("0"))
                {
                    value_RENDPT = 0.000f;
                }
                else
                {
                    value_RENDPT = Float.parseFloat(text_RENDPT.getText().toString());
                }
                text_RENDPT_ROT.setText(String.valueOf(String.format("%.03f", value_RENDPT / 1000)));
                ko_RENDPT.setText(String.valueOf(String.format("%.03f", (value_RENDPT / 1000) - Float.valueOf(String.format("%.03f", Float.parseFloat(text_RENDPT_ROT.getText().toString()))))));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        text_AENDPT.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (text_AENDPT.length() == 0 || text_AENDPT.getText().toString().equals("-") || text_AENDPT.getText().toString().equals("0"))
                {
                    value_AENDPT = 0.000f;
                }
                else
                {
                    value_AENDPT = Float.parseFloat(text_AENDPT.getText().toString());
                }
                text_AENDPT_ROT.setText(String.valueOf(String.format("%.03f", 0 - (value_AENDPT / 1000))));
                ko_AENDPT.setText(String.valueOf(String.format("%.03f", (value_AENDPT / 1000) + Float.valueOf(String.format("%.03f", Float.parseFloat(text_AENDPT_ROT.getText().toString()))))));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        text_ARAMPEO.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (text_ARAMPEO.length() == 0 || text_ARAMPEO.getText().toString().equals("-") || text_ARAMPEO.getText().toString().equals("0"))
                {
                    value_ARAMPEO = 0.000f;
                }
                else
                {
                    value_ARAMPEO = Float.parseFloat(text_ARAMPEO.getText().toString());
                }

                text_ARAMPEO_ROT.setText(String.valueOf(String.format("%.03f", 0 - (value_ARAMPEO / 1000) * 2)));
                ko_ARAMPEO.setText(String.valueOf(String.format("%.03f", (value_ARAMPEO / 1000) + (Float.valueOf(String.format("%.03f", Float.parseFloat(text_ARAMPEO_ROT.getText().toString())))) / 2 )));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        text_ARAMPEU.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (text_ARAMPEU.length() == 0 || text_ARAMPEU.getText().toString().equals("-") || text_ARAMPEU.getText().toString().equals("0"))
                {
                    value_ARAMPEU = 0.000f;
                }
                else
                {
                    value_ARAMPEU = Float.parseFloat(text_ARAMPEU.getText().toString());
                }
                text_ARAMPEU_ROT.setText(String.valueOf(String.format("%.03f", 0 - (value_ARAMPEU / 1000) * 2)));
                ko_ARAMPEU.setText(String.valueOf(String.format("%.03f", (value_ARAMPEU / 1000) + (Float.valueOf(String.format("%.03f", Float.parseFloat(text_ARAMPEU_ROT.getText().toString())))) / 2 )));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        text_RRAMPEO.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (text_RRAMPEO.length() == 0 || text_RRAMPEO.getText().toString().equals("-") || text_RRAMPEO.getText().toString().equals("0"))
                {
                    value_RRAMPEO = 0.000f;
                }
                else
                {
                    value_RRAMPEO = Float.parseFloat(text_RRAMPEO.getText().toString());
                }
                text_RRAMPEO_ROT.setText(String.valueOf(String.format("%.03f", (value_RRAMPEO / 1000) * 2)));
                ko_RRAMPEO.setText(String.valueOf(String.format("%.03f", (value_ARAMPEO / 1000) - (Float.valueOf(String.format("%.03f", Float.parseFloat(text_RRAMPEO_ROT.getText().toString())))) / 2 )));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        text_RRAMPEU.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (text_RRAMPEU.length() == 0 || text_RRAMPEU.getText().toString().equals("-") || text_RRAMPEU.getText().toString().equals("0"))
                {
                    value_RRAMPEU = 0.000f;
                }
                else
                {
                    value_RRAMPEU = Float.parseFloat(text_RRAMPEU.getText().toString());
                }
                text_RRAMPEU_ROT.setText(String.valueOf(String.format("%.03f", (value_RRAMPEU / 1000) * 2)));
                ko_RRAMPEU.setText(String.valueOf(String.format("%.03f", (value_RRAMPEU / 1000) - (Float.valueOf(String.format("%.03f", Float.parseFloat(text_RRAMPEU_ROT.getText().toString())))) / 2 )));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        text_M12Y.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (text_M12Y.length() == 0 || text_M12Y.getText().toString().equals("-") || text_M12Y.getText().toString().equals("0"))
                {
                    value_M12Y = 0.000f;
                }
                else
                {
                    value_M12Y= Float.parseFloat(text_M12Y.getText().toString());
                }
                text_M12Y_Y.setText(String.valueOf(String.format("%.03f", value_M12Y / 1000)));
                ko_M12Y.setText(String.valueOf(String.format("%.03f", (value_M12Y / 1000) - (Float.valueOf(String.format("%.03f", Float.parseFloat(text_M12Y_Y.getText().toString())))))));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        text_M12Z.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (text_M12Z.length() == 0 || text_M12Z.getText().toString().equals("-") || text_M12Z.getText().toString().equals("0"))
                {
                    value_M12Z = 0.000f;
                }
                else
                {
                    value_M12Z= Float.parseFloat(text_M12Z.getText().toString());
                }
                text_M12Z_X.setText(String.valueOf(String.format("%.03f", 0 - (value_M12Z / 1000))));
                ko_M12Z.setText(String.valueOf(String.format("%.03f", (value_M12Z / 1000) + (Float.valueOf(String.format("%.03f", Float.parseFloat(text_M12Z_X.getText().toString())))))));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_quit) {
            killApplication();
            return true;
        }
        if (id == R.id.action_zero) {
            doZero();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void doZero()
    {
        for (int i = 0; i < 3; i++)
        {
            value_L[i] = 0.000f;
            value_R[i] = 0.000f;
        }
        text_L1.setText("");
        text_L2.setText("");
        text_L3.setText("");
        text_R1.setText("");
        text_R2.setText("");
        text_R3.setText("");
        text_RENDPT.setText("");
        value_RENDPT = 0.000f;
        text_AENDPT.setText("");
        value_AENDPT = 0.000f;
        text_ARAMPEO.setText("");
        value_ARAMPEO = 0.000f;
        text_ARAMPEU.setText("");
        value_ARAMPEU = 0.000f;
        text_RRAMPEO.setText("");
        value_RRAMPEO = 0.000f;
        text_RRAMPEU.setText("");
        value_RRAMPEU = 0.000f;
        text_M12Y.setText("");
        value_M12Y = 0.000f;
        text_M12Z.setText("");
        value_M12Z = 0.000f;
    }
    public void killApplication()
    {
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

    void atlag_L()
    {
        value_atlag_L  = 0.000f;
        for (i=0; i < 3; i++)
        {
            value_atlag_L += value_L[i];
        }
        value_atlag_L /= 3000;
        atlag_L.setText(String.valueOf(String.format("%.03f", value_atlag_L)));
        eredeti_atlag();
    }

    void atlag_R()
    {
        value_atlag_R  = 0.000f;
        for (i=0; i < 3; i++)
        {
            value_atlag_R += value_R[i];
        }
        value_atlag_R /= 3000;
        atlag_R.setText(String.valueOf(String.format("%.03f", value_atlag_R)));
        eredeti_atlag();
    }

    void eredeti_atlag()
    {
        value_eredeti_atlag = 0.000f;
        value_ROT = 0.000f;
        value_eredeti_atlag = (value_atlag_R - value_atlag_L) / 2;
        text_eredeti_atlag.setText(String.valueOf(String.format("%.03f", value_eredeti_atlag)));
        if(value_eredeti_atlag<0)
        {
            value_ROT = (0 - (value_eredeti_atlag)) * 2;
        }
        else
        {
            value_ROT = (0 - value_eredeti_atlag) * 2;
        }
        text_ROT.setText(String.valueOf(String.format("%.03f", value_ROT)));
    }

    void elforgatott()
    {
        value_Elforgatott_atlag = 0.000f;
        for (i=0; i < 3; i++)
        {
            value_Elforgatott_bal[i] = 0.000f;
            value_Elforgatott_jobb[i] = 0.000f;
            value_Elforgatott_bal[i] = (value_L[i] / 1000) + value_eredeti_atlag;
            value_Elforgatott_jobb[i] = (value_R[i] / 1000) - value_eredeti_atlag;
        }

        text_Elforgatott_L1.setText(String.valueOf(String.format("%.03f", value_Elforgatott_bal[0])));
        text_Elforgatott_L2.setText(String.valueOf(String.format("%.03f", value_Elforgatott_bal[1])));
        text_Elforgatott_L3.setText(String.valueOf(String.format("%.03f", value_Elforgatott_bal[2])));
        text_Elforgatott_R1.setText(String.valueOf(String.format("%.03f", value_Elforgatott_jobb[0])));
        text_Elforgatott_R2.setText(String.valueOf(String.format("%.03f", value_Elforgatott_jobb[1])));
        text_Elforgatott_R3.setText(String.valueOf(String.format("%.03f", value_Elforgatott_jobb[2])));

        for (i=0; i < 3; i++)
        {
            value_Elforgatott_atlag += (value_Elforgatott_bal[i] + value_Elforgatott_jobb[i]);
        }
        value_Elforgatott_atlag /= 6;
        text_Elforgatott_atlag.setText(String.valueOf(String.format("%.03f", value_Elforgatott_atlag)));
        value_TRANS = (0 + value_Elforgatott_atlag);
        text_TRANS.setText(String.valueOf(String.format("%.03f", value_TRANS)));

        ko_L1.setText(String.valueOf(String.format("%.03f", value_Elforgatott_bal[0] - value_TRANS)));
        ko_L2.setText(String.valueOf(String.format("%.03f", value_Elforgatott_bal[1] - value_TRANS)));
        ko_L3.setText(String.valueOf(String.format("%.03f", value_Elforgatott_bal[2] - value_TRANS)));
        ko_R1.setText(String.valueOf(String.format("%.03f", value_Elforgatott_jobb[0] - value_TRANS)));
        ko_R2.setText(String.valueOf(String.format("%.03f", value_Elforgatott_jobb[1] - value_TRANS)));
        ko_R3.setText(String.valueOf(String.format("%.03f", value_Elforgatott_jobb[2] - value_TRANS)));
    }

}
