package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.activitylifecycle.databinding.ActivityMainBinding;

public class ShowGuess extends AppCompatActivity {
private ActivityMainBinding binding2;
private TextView showdata;
    /*to get all extras we put in the intent instead of unsing getIntent().getObjectExtra("name", value) multiple time we use Bundle class and create and create a bundle object which will bring
    all the extras in bundle
     */
    //Bundle should be created in the onCreate method beacuse after creating , we will have some data to bundle up , so create in oncreate class

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_guess);
        Bundle extra = getIntent().getExtras();//this brings all the extras form main activity
        showdata = findViewById(R.id.textView);
        if(extra != null){
            String newest = extra.getString("guess").toUpperCase().replace('A', 'x');

            showdata.setText(newest);
//            Log.d("checking", "on create : " +extra.getBoolean("aBoolean") );
//            Log.d("checking", "on create : " +extra.getInt("age") );
//            Log.d("checking", "on create : " +extra.getString("nothing speacial") );
        }
        showdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                intent.putExtra("message_back", "coding is running successfully");
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        //if(getIntent().getStringExtra("guess") != null){
          //  showdata.setText(getIntent().getStringExtra("guess"));
        //}
//        binding2.button.setOnClickListener(v -> {
//            Intent intent = new Intent(ShowGuess.this , MainActivity.class);
//            startActivity(intent);
//        });
    }
}