package com.pram.bookapivolley.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.pram.bookapivolley.R;
import com.pram.bookapivolley.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInstances();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, MainFragment.newInstance())
                    .commit();
        }
    }

    private void initInstances() {

    }
}
