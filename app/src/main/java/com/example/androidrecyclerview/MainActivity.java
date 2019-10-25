package com.example.androidrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerViewUsser;
    List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewUsser = findViewById(R.id.recycler_user);
        recyclerViewUsser.setLayoutManager(new LinearLayoutManager(this));

        final UserAdapter userAdapter = new UserAdapter();
        recyclerViewUsser.setAdapter(userAdapter);

        User user1 = new User("Thuy", 4);
        User user2 = new User("Thuong", 10);
        User user3 = new User("Hoa", 8);

        users = new ArrayList<User>();

        users.add(user1);
        users.add(user2);
        users.add(user3);

        userAdapter.users = users;

       findViewById(R.id.button_add).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(MainActivity.this,"click",Toast.LENGTH_SHORT).show();
               users.add(new User("Mai", 6));
               userAdapter.notifyDataSetChanged();
           }
       });

        findViewById(R.id.button_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"updated",Toast.LENGTH_SHORT).show();
                users.get(0).name = "Anh";
                userAdapter.notifyDataSetChanged();
            }
        });



    }
}
