package com.example.gdgders1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtUsername;
    EditText edtPassword;
    Button btnGiris;
    Button btnKayitOl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsername = findViewById(R.id.editUsername);
        edtPassword = findViewById(R.id.editPassword);
        btnGiris = findViewById(R.id.btnGiris);
        btnKayitOl = findViewById(R.id.btnKayıtOl);

        btnKayitOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnGiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kullaniciGirisUser = edtUsername.getText().toString();
                String kullaniciGirisPassword = edtPassword.getText().toString();
                if (Util.userList.size() == 0) {
                    Toast.makeText(getApplicationContext(), "Kullanıcı Bulunamadı", Toast.LENGTH_SHORT).show();
                } else {
                    for (int i = 0; i < Util.userList.size(); i++) {
                        if (Util.userList.get(i).getUserName().equals(kullaniciGirisUser)) {
                            if (Util.userList.get(i).getUserPassword().equals(kullaniciGirisPassword)) {

                                Toast.makeText(getApplicationContext(), "Giriş Başarılı..", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(MainActivity.this, UserActivity.class);
                                intent.putExtra("username", kullaniciGirisUser);
                                startActivity(intent);

                            } else {
                                Toast.makeText(getApplicationContext(), "Hatalı Şifre", Toast.LENGTH_SHORT).show();
                            }

                        }

                    }
                }

            }
        });
    }


}
