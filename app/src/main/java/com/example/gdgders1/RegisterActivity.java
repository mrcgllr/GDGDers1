package com.example.gdgders1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    Button btnRegister;
    EditText edtUsername;
    EditText edtPassword;
    String kullaniciUsername;
    String kullaniciPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister = findViewById(R.id.btnRegisterKayıtOl);
        edtUsername = findViewById(R.id.editRegisterUsername);
        edtPassword = findViewById(R.id.editRegisterPassword);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kullaniciUsername = edtUsername.getText().toString();
                kullaniciPassword = edtPassword.getText().toString();

                if (Util.userList.size() == 0) {
                    Util.userList.add(new User(kullaniciUsername, kullaniciPassword));
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    for (int i = 0; i <= Util.userList.size(); i++) {
                        if (Util.userList.get(i).getUserName().equals(kullaniciUsername)) {
                            Toast.makeText(getApplicationContext(), "Kullanici Adi Zaten Kayitli", Toast.LENGTH_SHORT).show();
                        } else {
                            Util.userList.add(new User(kullaniciUsername, kullaniciPassword));
                            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                }

                Toast.makeText(getApplicationContext(), "Tıklandı", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
