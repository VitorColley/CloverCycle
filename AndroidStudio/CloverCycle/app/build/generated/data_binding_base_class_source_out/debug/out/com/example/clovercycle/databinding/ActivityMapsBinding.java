// Generated by view binder compiler. Do not edit!
package com.example.clovercycle.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.clovercycle.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mapbox.maps.MapView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMapsBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final RelativeLayout MapsActivityComponent;

  @NonNull
  public final FloatingActionButton focusLocation;

  @NonNull
  public final MapView mapView;

  private ActivityMapsBinding(@NonNull RelativeLayout rootView,
      @NonNull RelativeLayout MapsActivityComponent, @NonNull FloatingActionButton focusLocation,
      @NonNull MapView mapView) {
    this.rootView = rootView;
    this.MapsActivityComponent = MapsActivityComponent;
    this.focusLocation = focusLocation;
    this.mapView = mapView;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMapsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMapsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_maps, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMapsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      RelativeLayout MapsActivityComponent = (RelativeLayout) rootView;

      id = R.id.focusLocation;
      FloatingActionButton focusLocation = ViewBindings.findChildViewById(rootView, id);
      if (focusLocation == null) {
        break missingId;
      }

      id = R.id.mapView;
      MapView mapView = ViewBindings.findChildViewById(rootView, id);
      if (mapView == null) {
        break missingId;
      }

      return new ActivityMapsBinding((RelativeLayout) rootView, MapsActivityComponent,
          focusLocation, mapView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}