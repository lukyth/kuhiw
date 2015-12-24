package com.kanitkorn.android.kuhiw;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantCommentFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    public static RestaurantCommentFragment newInstance(String param1) {
        RestaurantCommentFragment fragment = new RestaurantCommentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    public RestaurantCommentFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurant_comment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final View thatView  = getView();
        Button button = (Button) thatView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) thatView.findViewById(R.id.edit_text);
                LayoutInflater vi = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View v = vi.inflate(R.layout.comment, null);

                TextView textView = (TextView) v.findViewById(R.id.comment);
                textView.setText(editText.getText().toString());

                ViewGroup insertPoint = (ViewGroup) thatView.findViewById(R.id.comment_wrapper);
                insertPoint.addView(v, 0);
                editText.setText("");
            }
        });
    }

}
