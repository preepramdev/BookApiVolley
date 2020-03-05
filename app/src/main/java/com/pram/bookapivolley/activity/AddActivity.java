package com.pram.bookapivolley.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.pram.bookapivolley.R;
import com.pram.bookapivolley.fragment.AddFragment;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        initInstances();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, AddFragment.newInstance())
                    .commit();
        }
    }

    private void initInstances() {

    }
}
