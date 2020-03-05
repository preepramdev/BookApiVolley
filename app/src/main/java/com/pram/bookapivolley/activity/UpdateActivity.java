package com.pram.bookapivolley.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.pram.bookapivolley.R;
import com.pram.bookapivolley.fragment.UpdateFragment;
import com.pram.bookapivolley.model.Book;

public class UpdateActivity extends AppCompatActivity {

    private Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        initInstances();

        if (getIntent() != null) {
            book = getIntent().getParcelableExtra("book");
        }

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, UpdateFragment.newInstance(book))
                    .commit();
        }
    }

    private void initInstances() {

    }
}
