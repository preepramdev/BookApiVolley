package com.pram.bookapivolley.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.VolleyError;
import com.pram.bookapivolley.R;
import com.pram.bookapivolley.activity.UpdateActivity;
import com.pram.bookapivolley.api.callback.VolleyResponseCallback;
import com.pram.bookapivolley.api.controller.BookApiController;
import com.pram.bookapivolley.dialog.OneButtonDialogFragment;
import com.pram.bookapivolley.dialog.TwoButtonDialogFragment;
import com.pram.bookapivolley.manager.Contextor;
import com.pram.bookapivolley.model.Book;

import org.json.JSONObject;


/**
 * Created by nuuneoi on 11/16/2014.
 */
@SuppressWarnings("unused")
public class DetailFragment extends Fragment implements
        OneButtonDialogFragment.OnDialogListener,
        TwoButtonDialogFragment.OnDialogListener {
    private static final String TAG = "DetailFragment";
    private Context mContext;
    private View mRootView;
    private BookApiController apiController;
    private Book mBook;
    private int mBookId;

    private TextView tvBookId;
    private TextView tvBookTitle;
    private TextView tvBookAuthor;
    private TextView tvBookPages;
    private Button btnUpdate;
    private Button btnRemove;

    public DetailFragment() {
        super();
    }

    @Override
    public void onOneButtonClick() {
        requireActivity().finish();
    }

    @Override
    public void onTwoButtonPositiveClick() {
        removeBook();
    }

    @Override
    public void onTwoButtonNegativeClick() {

    }

    @SuppressWarnings("unused")
    public static DetailFragment newInstance(int bookId) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putInt("bookId", bookId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);

        if (savedInstanceState != null)
            onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        initInstances(rootView, savedInstanceState);
        return rootView;
    }

    private void init(Bundle savedInstanceState) {
        mContext = Contextor.getInstance().getContext();
        apiController = new BookApiController();
    }

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        mRootView = rootView;

        if (getArguments() != null) {
            mBookId = getArguments().getInt("bookId");
        }

        tvBookId = mRootView.findViewById(R.id.tvBookId);
        tvBookTitle = mRootView.findViewById(R.id.tvBookTitle);
        tvBookAuthor = mRootView.findViewById(R.id.tvBookAuthor);
        tvBookPages = mRootView.findViewById(R.id.tvBookPages);
        btnUpdate = mRootView.findViewById(R.id.btnUpdate);
        btnRemove = mRootView.findViewById(R.id.btnCancel);

        btnUpdate.setOnClickListener(v -> {
            Intent intent = new Intent(mContext, UpdateActivity.class);
            intent.putExtra("book", mBook);
            startActivity(intent);
        });

        btnRemove.setOnClickListener(v -> {
            callTwoButtonDialog("Remove?", "Ok", "Cancel");
        });

//        fetchApi();
    }

    private void fetchApi() {
        apiController.getBook(mBookId, new VolleyResponseCallback() {
            @Override
            public void onResponse(Object response) {
                JSONObject jsonObjectResponse = (JSONObject) response;

                int id = jsonObjectResponse.optInt("id");
                String title = jsonObjectResponse.optString("title");
                String author = jsonObjectResponse.optString("author");
                String pages = jsonObjectResponse.optString("pages");

                mBook = new Book(id, title, author, pages);

                if (mBook != null) {
                    tvBookId.setText(mBook.getId().toString());
                    tvBookTitle.setText(mBook.getTitle());
                    tvBookAuthor.setText(mBook.getAuthor());
                    tvBookPages.setText(mBook.getPages());
                }
            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }

    private void removeBook() {
        apiController.removeBook(mBookId, new VolleyResponseCallback() {
            @Override
            public void onResponse(Object response) {
                Log.e(TAG, "onResponse: " + response);
                callOneButtonDialog("Removed", "Ok");
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "onErrorResponse: " + error);
            }
        });
    }

    private void callOneButtonDialog(String message, String submit) {
        OneButtonDialogFragment fragment = new OneButtonDialogFragment.Builder()
                .setMessage(message)
                .setSubmit(submit)
                .build();
        fragment.show(getChildFragmentManager(), "OneButtonDialogFragment");
    }

    private void callTwoButtonDialog(String message, String positive, String negative) {
        TwoButtonDialogFragment fragment = new TwoButtonDialogFragment.Builder()
                .setMessage(message)
                .setPositive(positive)
                .setNegative(negative)
                .build();
        fragment.show(getChildFragmentManager(), "TwoButtonDialogFragment");
    }

    @Override
    public void onResume() {
        super.onResume();
        fetchApi();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance State here
    }


    @SuppressWarnings("UnusedParameters")
    private void onRestoreInstanceState(Bundle savedInstanceState) {
        // Restore Instance State here
    }
}
