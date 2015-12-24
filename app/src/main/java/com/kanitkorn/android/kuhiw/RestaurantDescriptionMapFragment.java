package com.kanitkorn.android.kuhiw;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class RestaurantDescriptionMapFragment extends SupportMapFragment implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, OnMapReadyCallback {

    private GoogleMap mMap;
    private GoogleApiClient mGoogleApiClient;

    private TextView title;
    private TextView description;
    private View view;
    private RelativeLayout pdb;

    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    public static RestaurantDescriptionMapFragment newInstance(String param1) {
        RestaurantDescriptionMapFragment fragment = new RestaurantDescriptionMapFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    public RestaurantDescriptionMapFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }

        buildGoogleApiClient();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_map, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        view = getView();

        setupMap();

        title = (TextView) view.findViewById(R.id.place_title);
        description = (TextView) view.findViewById(R.id.place_description);

        pdb = (RelativeLayout) view.findViewById(R.id.place_info_box);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab_place);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RestaurantActivity.class);
                intent.putExtra("title", title.getText());
                intent.putExtra("description", description.getText());
                startActivity(intent);
            }
        });

    }

    private void setupMap() {
        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        LatLng startPlace = new LatLng(13.846302, 100.569925);

        if(mParam1.equals(getString(R.string.restaurant1_name))) {
            mMap.addMarker(new MarkerOptions()
                    .title(getString(R.string.restaurant1_name))
                    .snippet(getString(R.string.restaurant1_description))
                    .position(startPlace));
        } else if(mParam1.equals(getString(R.string.restaurant2_name))) {
            mMap.addMarker(new MarkerOptions()
                    .title(getString(R.string.restaurant2_name))
                    .snippet(getString(R.string.restaurant2_description))
                    .position(new LatLng(13.846302, 100.569911)));
        } else if(mParam1.equals(getString(R.string.restaurant3_name))) {
            mMap.addMarker(new MarkerOptions()
                    .title(getString(R.string.restaurant3_name))
                    .snippet(getString(R.string.restaurant3_description))
                    .position(new LatLng(13.846302, 100.569897)));
        } else if(mParam1.equals(getString(R.string.restaurant4_name))) {
            mMap.addMarker(new MarkerOptions()
                    .title(getString(R.string.restaurant4_name))
                    .snippet(getString(R.string.restaurant4_description))
                    .position(new LatLng(13.846302, 100.569883)));
        } else if(mParam1.equals(getString(R.string.restaurant5_name))) {
            mMap.addMarker(new MarkerOptions()
                    .title(getString(R.string.restaurant5_name))
                    .snippet(getString(R.string.restaurant5_description))
                    .position(new LatLng(13.846302, 100.569869)));
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(startPlace, 18));
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnectionSuspended(int arg0) {

    }

    @Override
    public void onConnected(Bundle connectionHint) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }
}
