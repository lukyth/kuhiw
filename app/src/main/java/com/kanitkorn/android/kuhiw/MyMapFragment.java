package com.kanitkorn.android.kuhiw;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MyMapFragment extends SupportMapFragment implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, OnMapReadyCallback {

    private GoogleMap mMap;
    private GoogleApiClient mGoogleApiClient;

    private TextView title;
    private TextView description;
    private View view;
    private RelativeLayout pdb;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

        final Activity activity = getActivity();

        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        assert getView() != null;
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LocationManager locationManager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
                if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                    Toast.makeText(activity, "GPS is disable!", Toast.LENGTH_LONG).show();
                } else {
//                    Location currentPosition = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
//                    if (currentPosition != null) {
//                        LatLng latLng = new LatLng(currentPosition.getLatitude(),
//                                currentPosition.getLongitude());
//                        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 19);
//                        mMap.animateCamera(cameraUpdate);
//                    }
                }
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng startPlace = new LatLng(13.846302, 100.569925);

//        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(false);

        mMap.addMarker(new MarkerOptions()
                .title(getString(R.string.restaurant1_name))
                .snippet(getString(R.string.restaurant1_description))
                .position(startPlace));

        mMap.addMarker(new MarkerOptions()
                .title(getString(R.string.restaurant2_name))
                .snippet(getString(R.string.restaurant2_description))
                .position(new LatLng(13.846302, 100.569911)));

        mMap.addMarker(new MarkerOptions()
                .title(getString(R.string.restaurant3_name))
                .snippet(getString(R.string.restaurant3_description))
                .position(new LatLng(13.846302, 100.569897)));

        mMap.addMarker(new MarkerOptions()
                .title(getString(R.string.restaurant4_name))
                .snippet(getString(R.string.restaurant4_description))
                .position(new LatLng(13.846302, 100.569883)));

        mMap.addMarker(new MarkerOptions()
                .title(getString(R.string.restaurant5_name))
                .snippet(getString(R.string.restaurant5_description))
                .position(new LatLng(13.846302, 100.569869)));

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {

            @Override
            public boolean onMarkerClick(Marker marker) {
                title.setText(marker.getTitle());
                description.setText(marker.getSnippet());
                if (pdb.getVisibility() == View.GONE) {
                    pdb.setVisibility(View.VISIBLE);
                }
                return true;
            }

        });

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng point) {
                if (pdb.getVisibility() == View.VISIBLE) {
                    pdb.setVisibility(View.GONE);
                }
            }
        });

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(startPlace, 22));
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
