package com.tinuade.simplecalc;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "CalculatorActivity";
    Calculator calculator;
    private EditText operandOne, operandTwo;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculator = new Calculator();
        operandOne = findViewById(R.id.operandOne);
        operandTwo = findViewById(R.id.operandTwo);
        result = findViewById(R.id.result_textView);
    }

    public void onAdd(View view) {
        compute(Calculator.Operator.ADD);
    }

    public void onSub(View view) {
        compute(Calculator.Operator.SUB);
    }

    public void onDiv(View view) {
        compute(Calculator.Operator.DIV);
    }

    public void onMul(View view) {
        compute(Calculator.Operator.MUL);
    }

    public void compute(Calculator.Operator operator) {
        double operand1;
        double operand2;

        try {
            operand1 = getOperand(operandOne);
            operand2 = getOperand(operandTwo);
        } catch (NumberFormatException nfe) {
            result.setText(getString(R.string.computationError));
            return;
        }

        String results;
        switch (operator) {
            case ADD:
                results = String.valueOf(calculator.add(operand1, operand2));
                break;
            case DIV:
                results = String.valueOf(calculator.div(operand1, operand2));
                break;
            case MUL:
                results = String.valueOf(calculator.mul(operand1, operand2));
                break;
            case SUB:
                results = String.valueOf(calculator.sub(operand1, operand2));
                break;
            default:
                results = getString(R.string.computationError);
                break;
        }
        result.setText(results);

    }

    /**
     * @return the operand value entered in an EditText as double.
     */
    private static Double getOperand(EditText operandEditText) {
        String operandText = getOperandText(operandEditText);
        return Double.valueOf(operandText);
    }

    private static String getOperandText(EditText operandText) {
        return operandText.getText().toString();
    }
}
