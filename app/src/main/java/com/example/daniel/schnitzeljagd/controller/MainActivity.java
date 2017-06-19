package com.example.daniel.schnitzeljagd.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.daniel.schnitzeljagd.App;
import com.example.daniel.schnitzeljagd.R;
import com.example.daniel.schnitzeljagd.model.DaoSession;
import com.example.daniel.schnitzeljagd.model.User;

import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaoSession session = ((App)getApplication()).getDaoSession();
        TextView tv = (TextView)findViewById(R.id.textView);

        Iterator<User> users = session.getUserDao().loadAll().iterator();
        String names = "";
        while(users.hasNext()) {
            User user = users.next();
            names += user.getUsername() + ", ";
        }
        tv.setText(names);

        final Button btn = (Button)findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name = ((EditText)findViewById(R.id.editText)).getText().toString();

                User user = new User();
                user.setUsername(name);


                DaoSession session = ((App)getApplication()).getDaoSession();
                session.getUserDao().insert(user);
                Log.d("DaoTest", "Insert new user, ID: " + user.getId() + "; Name: " + user.getUsername());

                TextView tv = (TextView)findViewById(R.id.textView);
                tv.append(user.getUsername() + ", ");
            }
        });
    }
}
