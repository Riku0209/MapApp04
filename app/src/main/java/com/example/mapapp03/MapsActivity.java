package com.example.mapapp03;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // シドニーの緯度経度を設定して、そこにマーカーを設置
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));

        //日本の緯度経度を設定して、そこにマーカーを設置
        LatLng aomori = new LatLng(40.95795,140.8781 );
        mMap.addMarker(new MarkerOptions().position(aomori).title("Marker in Aomori"));

        // 北米の緯度経度を設定して、そこにマーカーを設置
        LatLng america = new LatLng(64.81, -156.062);
        mMap.addMarker(new MarkerOptions().position(america).title("Marker in America"));


        //カメラの位置とズームを設定
        LatLng center = new LatLng(31,-171);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(center,2));

//        //線を描く
//        PolylineOptions line = new PolylineOptions();
//        line.add(aomori);
//        line.add(america);
////        //色、太さ、測地線
////        line.color(Color.RED);
////        line.width(20);
////        line.geodesic(true);
//         mMap.addPolyline(line);
//
//        //３地点を結ぶ半透明の三角形を描く
//        PolylineOptions line2 = new PolylineOptions();
//        line2.add(aomori);
//        line2.add(sydney);
//        mMap.addPolyline(line2);
//
//        PolylineOptions line3 = new PolylineOptions();
//        line3.add(sydney);
//        line3.add(america);
//        mMap.addPolyline(line3);

        //３地点を結ぶ半透明の三角形を描く
        PolygonOptions options = new PolygonOptions();
        options.strokeColor(Color.BLUE);
        options.add(aomori,sydney,america);
        options.fillColor(Color.argb(70,0,0,500));
        mMap.addPolygon(options);

    }
}
