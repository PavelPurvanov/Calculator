package bg.tu_varna.sit.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    static String disp = "0"; //textView1 value
    static String dispdown = ""; //textView2 value
    static int decimal = 0;
    static double m = 0;
    static double result = 0;
    static int pending = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // AC
    public void clsa(View view) {
        result = 0;
        pending = 0;
        disp = "0";
        dispdown = "";
        decimal = 0;
        TextView textView = findViewById(R.id.textView1);
        textView.setText(disp);
        TextView edittext = findViewById(R.id.textView2);
        edittext.setText(dispdown);
    }

    // +
    public void plus(View view) {
        String message = dispdown;
        if (message.equals(".") || message.equals("-") || message.equals(".-"))
            message = "0";
        if (message.equals("")) {
            disp = result + "+";
            pending = 1;
        } else {
            double n = Double.parseDouble(message);
            perform(n);
            disp = result + "+";
            pending = 1;
        }
        TextView textView = findViewById(R.id.textView1);
        textView.setText(disp);
        TextView edittext = findViewById(R.id.textView2);
        edittext.setText("");
        dispdown = "";
    }

    // -
    public void minus(View view) {
        String message = dispdown;
        if (message.equals(".") || message.equals("-") || message.equals(".-"))
            message = "0";
        if (message.equals("")) {
            disp = result + "-";
            pending = 2;
        } else {
            double n = Double.parseDouble(message);
            perform(n);
            disp = result + "-";
            pending = 2;
        }
        TextView textView = findViewById(R.id.textView1);
        textView.setText(disp);
        TextView edittext = findViewById(R.id.textView2);
        edittext.setText("");
        dispdown = "";
    }

    // X
    public void multiply(View view) {
        String message = dispdown;
        if (message.equals(".") || message.equals("-") || message.equals(".-"))
            message = "0";
        if (message.equals("")) {
            disp = result + "x";
            pending = 3;
        } else {
            double n = Double.parseDouble(message);
            perform(n);
            disp = result + "x";
            pending = 3;
        }
        TextView textView = findViewById(R.id.textView1);
        textView.setText(disp);
        TextView edittext = findViewById(R.id.textView2);
        edittext.setText("");
        dispdown = "";
    }

    // ÷
    public void divide(View view) {
        String message = dispdown;
        if (message.equals(".") || message.equals("-"))
            message = "0";
        if (message.equals("")) {
            disp = result + "÷";
            pending = 4;
        } else {
            double n = Double.parseDouble(message);
            perform(n);
            disp = result + "÷";
            pending = 4;
        }
        TextView textView = findViewById(R.id.textView1);
        textView.setText(disp);
        TextView edittext = findViewById(R.id.textView2);
        edittext.setText("");
        dispdown = "";
    }

    // √
    public void root(View view) {
        String message = dispdown;
        if (message.equals(".") || message.equals("-"))
            message = "0";
        if (message.equals("")) {
            disp = "√()";
            pending = 5;
        } else {
            double n = Double.parseDouble(message);
            perform(n);
            disp = "√()";
            pending = 5;
        }
        TextView textView = findViewById(R.id.textView1);
        textView.setText(disp);
        TextView edittext = findViewById(R.id.textView2);
        edittext.setText("");
        dispdown = "";
    }

    // +/-
    public void sign(View view) {
        if (dispdown.equals("")) {
            dispdown = "-";
        } else {
            if (dispdown.substring(0, 1).equals("-")) {
                dispdown = dispdown.substring(1);
            } else {
                dispdown = "-" + dispdown;
            }
        }
        TextView edittext = findViewById(R.id.textView2);
        edittext.setText(dispdown);
    }

    // =
    public void equal(View view) {
        String message = dispdown;
        if (message.equals(".") || message.equals("-") || message.equals(".-"))
            message = "0";
        if (message.equals("")) {
            disp = "=" + result;
            pending = 0;
        } else {
            double n = Double.parseDouble(message);
            perform(n);
            disp = "=" + result;
            pending = 0;
        }
        TextView textView = findViewById(R.id.textView1);
        textView.setText(disp);
        TextView edittext = findViewById(R.id.textView2);
        edittext.setText("");
        dispdown = "";
    }

    /*pending  case 1: + , case 2: - , case 3: X , case 4: / , case 5: √ */
    public void perform(double n) {
        switch (pending) {
            case 0: {
                result = n;
                break;
            }
            case 1: {
                result += n;
                break;
            }
            case 2: {
                result -= n;
                break;
            }
            case 3: {
                result *= n;
                break;
            }
            case 4: {
                result /= n;
                break;
            }
            case 5: {
                result = Math.sqrt(n);
                break;
            }
        }
        decimal = 0;
    }

    // NUMBER BUTTONS
    public void point(View view) {
        if (decimal == 0) {
            dispdown = dispdown + ".";
            TextView edittext = findViewById(R.id.textView2);
            edittext.setText(dispdown);
            decimal = 1;
        }
    }

    public void zero(View view) {
        dispdown = dispdown + "0";
        TextView edittext = findViewById(R.id.textView2);
        edittext.setText(dispdown);
    }

    public void one(View view) {
        dispdown = dispdown + "1";
        TextView edittext = findViewById(R.id.textView2);
        edittext.setText(dispdown);
    }

    public void two(View view) {
        dispdown = dispdown + "2";
        TextView edittext = findViewById(R.id.textView2);
        edittext.setText(dispdown);
    }

    public void three(View view) {
        dispdown = dispdown + "3";
        TextView edittext = findViewById(R.id.textView2);
        edittext.setText(dispdown);
    }

    public void four(View view) {
        dispdown = dispdown + "4";
        TextView edittext = findViewById(R.id.textView2);
        edittext.setText(dispdown);
    }

    public void five(View view) {
        dispdown = dispdown + "5";
        TextView edittext = findViewById(R.id.textView2);
        edittext.setText(dispdown);
    }

    public void six(View view) {
        dispdown = dispdown + "6";
        TextView edittext = findViewById(R.id.textView2);
        edittext.setText(dispdown);
    }

    public void seven(View view) {
        dispdown = dispdown + "7";
        TextView edittext = findViewById(R.id.textView2);
        edittext.setText(dispdown);
    }

    public void eight(View view) {
        dispdown = dispdown + "8";
        TextView edittext = findViewById(R.id.textView2);
        edittext.setText(dispdown);
    }

    public void nine(View view) {
        dispdown = dispdown + "9";
        TextView edittext = findViewById(R.id.textView2);
        edittext.setText(dispdown);
    }
    // NUMBER BUTTONS END

    // DEL
    public void delete(View view) {
        if (dispdown.equals("")) {

        } else {
            if (dispdown.substring(dispdown.length() - 1).equals("."))
                decimal = 0;
            dispdown = dispdown.substring(0, (dispdown.length() - 1));
            TextView edittext = findViewById(R.id.textView2);
            edittext.setText(dispdown);
        }
    }

    // MC
    public void mc(View view) {
        dispdown = m + "";
        TextView edittext = findViewById(R.id.textView2);
        edittext.setText(dispdown);
    }

    // M+
    public void mplus(View view) {
        String message = dispdown;
        if (message.equals(".") || message.equals("-") || message.equals(".-"))
            message = "0";
        if (message.equals("")) {
            disp = result + " M+";
        } else {
            double n = Double.parseDouble(message);
            perform(n);
            disp = result + " M+";
            pending = 0;
        }
        TextView textView = findViewById(R.id.textView1);
        textView.setText(disp);
        TextView edittext = findViewById(R.id.textView2);
        edittext.setText("");
        dispdown = "";
        m += result;
    }

    // M-
    public void mminus(View view) {
        String message = dispdown;
        if (message.equals(".") || message.equals("-") || message.equals(".-"))
            message = "0";
        if (message.equals("")) {
            disp = result + " M-";
        } else {
            double n = Double.parseDouble(message);
            perform(n);
            disp = result + " M-";
            pending = 0;
        }
        TextView textView = findViewById(R.id.textView1);
        textView.setText(disp);
        TextView edittext = findViewById(R.id.textView2);
        edittext.setText("");
        dispdown = "";
        m -= result;
    }
}
