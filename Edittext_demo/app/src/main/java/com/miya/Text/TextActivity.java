package com.miya.Text;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;

import text.miya.com.myapplication.R;

public class TextActivity extends AppCompatActivity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        editText = (EditText) findViewById(R.id.et_text);

        editText.addTextChangedListener(new TextWatcher() {
            String integral = editText.getText().toString().trim();

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                //第一种情况
                if (integral.toString().equals("0") || s.toString().startsWith("0")) {
                    editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});  //当输入为0的时候限制输入
                } else {
                    editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5)});
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                //第二种情况
                if (TextUtils.isEmpty(s.toString())) {
                    editText.setText("0");
                    editText.setSelection(1);
                }
                if (s.toString().length() >= 2 && s.toString().startsWith("0")) {
                    editText.setText(s.toString().substring(1));
                    editText.setSelection(s.toString().length() - 1);
                }
            }
        });
    }
}
