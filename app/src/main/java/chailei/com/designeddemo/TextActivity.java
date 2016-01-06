package chailei.com.designeddemo;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class TextActivity extends AppCompatActivity implements TextWatcher, View.OnFocusChangeListener {

    private TextInputLayout textInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        textInput = (TextInputLayout) findViewById(R.id.text_input);
        textInput.getEditText().addTextChangedListener(this);
        textInput.getEditText().setOnFocusChangeListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {


    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
//        if(s.length() == 11){
//            textInput.setErrorEnabled(false);
//        }else{
//            textInput.setErrorEnabled(true);
//            textInput.setError("手机号码必须是11位");
//        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if(!hasFocus){
            EditText text = (EditText) v;
            Editable str = text.getText();

             if(str.length() == 11){
            textInput.setErrorEnabled(false);
             }else{
            textInput.setErrorEnabled(true);
            textInput.setError("手机号码必须是11位");
          }
        }else {
            textInput.setErrorEnabled(false);
        }
    }
}
