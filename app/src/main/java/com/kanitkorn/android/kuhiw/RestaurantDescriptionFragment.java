package com.kanitkorn.android.kuhiw;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantDescriptionFragment extends Fragment {

    public static RestaurantDescriptionFragment newInstance() {
        return new RestaurantDescriptionFragment();
    }

    public RestaurantDescriptionFragment() {
        super();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurant_description, container, false);
    }


}
