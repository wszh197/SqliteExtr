package com.wszh.sqliteexer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.stetho.Stetho;
import com.wszh.sqliteexer.database.MyDatabaseHelper;

public class MainActivity extends AppCompatActivity {

    private MyDatabaseHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Stetho.initializeWithDefaults(this);

        mDbHelper=new MyDatabaseHelper(this,"BookStore.db",null,1);

        Button createDatabase = (Button) findViewById(R.id.activity_main_create_db_button);

        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDbHelper.getWritableDatabase();
            }
        });

    }
}
