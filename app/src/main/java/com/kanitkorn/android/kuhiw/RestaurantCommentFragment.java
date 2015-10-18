package com.kanitkorn.android.kuhiw;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantCommentFragment extends Fragment {


    public static RestaurantCommentFragment newInstance() {
        return new RestaurantCommentFragment();
    }

    public RestaurantCommentFragment() {
        super();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurant_comment, container, false);
    }


}
