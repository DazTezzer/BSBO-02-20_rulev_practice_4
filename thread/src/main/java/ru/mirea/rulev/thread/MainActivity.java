package ru.mirea.rulev.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import ru.mirea.rulev.thread.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    public void run() {
                        int d = Integer.parseInt(String.valueOf(binding.editTextTextPassword.getText()));
                        int p = Integer.parseInt(String.valueOf(binding.editTextTextPersonName.getText()));
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                binding.textView.setText(String.format("%s",d/p));
                            }});

                        Log.i("TreadRulev", String.format("среднее количество пар в день за период одного месяца = %s",d/p));
                    }
                }).start();
            }
        });
    }
}