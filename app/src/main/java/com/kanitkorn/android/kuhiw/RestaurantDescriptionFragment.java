package com.kanitkorn.android.kuhiw;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantDescriptionFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    public static RestaurantDescriptionFragment newInstance(String param1) {
        RestaurantDescriptionFragment fragment = new RestaurantDescriptionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    public RestaurantDescriptionFragment() {

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
        return inflater.inflate(R.layout.fragment_restaurant_description, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View view = getView();
        TextView description = (TextView) view.findViewById(R.id.description);
        TextView tags = (TextView) view.findViewById(R.id.tags);
        if(mParam1.equals(getString(R.string.restaurant1_name))) {
            description.setText(getString(R.string.restaurant1_description));
            tags.setText(getString(R.string.restaurant1_tag));
        } else if(mParam1.equals(getString(R.string.restaurant2_name))) {
            description.setText(getString(R.string.restaurant2_description));
            tags.setText(getString(R.string.restaurant2_tag));
        } else if(mParam1.equals(getString(R.string.restaurant3_name))) {
            description.setText(getString(R.string.restaurant3_description));
            tags.setText(getString(R.string.restaurant3_tag));
        } else if(mParam1.equals(getString(R.string.restaurant4_name))) {
            description.setText(getString(R.string.restaurant4_description));
            tags.setText(getString(R.string.restaurant4_tag));
        } else if(mParam1.equals(getString(R.string.restaurant5_name))) {
            description.setText(getString(R.string.restaurant5_description));
            tags.setText(getString(R.string.restaurant5_tag));
        }

        setFragment(RestaurantDescriptionMapFragment.newInstance(mParam1), "restaurant_description_map");
    }

    private void setFragment(Fragment fragment, String tag) {
        getChildFragmentManager().beginTransaction()
                .replace(R.id.description_map, fragment, tag)
                .commit();
    }
}
