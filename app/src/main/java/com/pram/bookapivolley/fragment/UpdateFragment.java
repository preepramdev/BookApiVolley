package com.pram.bookapivolley.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.VolleyError;
import com.pram.bookapivolley.R;
import com.pram.bookapivolley.api.callback.VolleyResponseCallback;
import com.pram.bookapivolley.api.controller.BookApiController;
import com.pram.bookapivolley.dialog.OneButtonDialogFragment;
import com.pram.bookapivolley.dialog.TwoButtonDialogFragment;
import com.pram.bookapivolley.manager.Contextor;
import com.pram.bookapivolley.model.Book;


/**
 * Created by nuuneoi on 11/16/2014.
 */
@SuppressWarnings("unused")
public class UpdateFragment extends Fragment implements
        OneButtonDialogFragment.OnDialogListener,
        TwoButtonDialogFragment.OnDialogListener {
    private static final String TAG = "UpdateFragment";
    private Context mContext;
    private View mRootView;
    private BookApiController apiController;
    private Book mBook;

    private TextView tvBookId;
    private EditText edtBookTitle;
    private EditText edtBookAuthor;
    private EditText edtBookPages;
    private Button btnUpdate;
    private Button btnCancel;

    public UpdateFragment() {
        super();
    }

    @Override
    public void onOneButtonClick() {
        requireActivity().finish();
    }

    @Override
    public void onTwoButtonPositiveClick() {
        requireActivity().finish();
    }

    @Override
    public void onTwoButtonNegativeClick() {

    }

    @SuppressWarnings("unused")
    public static UpdateFragment newInstance(Book book) {
        UpdateFragment fragment = new UpdateFragment();
        Bundle args = new Bundle();
        args.putParcelable("book", book);
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_update, container, false);
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
            mBook = getArguments().getParcelable("book");
        }

        tvBookId = mRootView.findViewById(R.id.tvBookId);
        edtBookTitle = mRootView.findViewById(R.id.edtBookTitle);
        edtBookAuthor = mRootView.findViewById(R.id.edtBookAuthor);
        edtBookPages = mRootView.findViewById(R.id.edtBookPages);
        btnUpdate = mRootView.findViewById(R.id.btnUpdate);
        btnCancel = mRootView.findViewById(R.id.btnCancel);

        if (mBook != null) {
            String id = mBook.getId().toString();
            String title = mBook.getTitle();
            String author = mBook.getAuthor();
            String pages = mBook.getPages();

            tvBookId.setText(id);
            edtBookTitle.setText(mBook.getTitle());
            edtBookAuthor.setText(mBook.getAuthor());
            edtBookPages.setText(mBook.getPages());
        }

        btnUpdate.setOnClickListener(v -> {
            updateBook();
        });

        btnCancel.setOnClickListener(v -> {
            callTwoButtonDialog("Leave?", "Ok", "Cancel");
        });
    }

    private void updateBook() {
        String title = edtBookTitle.getText().toString();
        String author = edtBookAuthor.getText().toString();
        String pages = edtBookPages.getText().toString();

        mBook.setTitle(title);
        mBook.setAuthor(author);
        mBook.setPages(pages);

        apiController.updatePutBook(mBook, new VolleyResponseCallback() {
            @Override
            public void onResponse(Object response) {
                Log.e(TAG, "onResponse: " + response);
                callOneButtonDialog("Updated", "Ok");
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "onErrorResponse: " + error.getMessage());
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
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance State here
    }

    @SuppressWarnings("UnusedParameters")
    private void onRestoreInstanceState(Bundle savedInstanceState) {
        // Restore Instance State here
    }
}
