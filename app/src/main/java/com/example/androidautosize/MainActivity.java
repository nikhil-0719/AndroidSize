package com.example.androidautosize;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TextViewCompat;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtAutoSizeTextViewDynamic =findViewById(R.id.autoTextViewDynamic);
        TextView textView=findViewById(R.id.textView);
        EditText editText=findViewById(R.id.editText);
        EditText editTextWithPresetChanges =findViewById(R.id.editTextPreset);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                txtAutoSizeTextViewDynamic.setText(s.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        editTextWithPresetChanges.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                TextViewCompat.setAutoSizeTextTypeUniformWithPresetSizes(textView, getResources().getIntArray(R.array.autosize), TypedValue.COMPLEX_UNIT_SP);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textView.setText(s);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}