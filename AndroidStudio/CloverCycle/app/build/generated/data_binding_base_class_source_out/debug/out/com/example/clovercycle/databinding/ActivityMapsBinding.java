// Generated by view binder compiler. Do not edit!
package com.example.clovercycle.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
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
  public final ListView actualListView;

  @NonNull
  public final FloatingActionButton focusLocation;

  @NonNull
  public final RelativeLayout jobsListView;

  @NonNull
  public final MapView mapView;

  @NonNull
  public final ScrollView scrollView;

  @NonNull
  public final LinearLayout scrollViewLayout;

  private ActivityMapsBinding(@NonNull RelativeLayout rootView, @NonNull ListView actualListView,
      @NonNull FloatingActionButton focusLocation, @NonNull RelativeLayout jobsListView,
      @NonNull MapView mapView, @NonNull ScrollView scrollView,
      @NonNull LinearLayout scrollViewLayout) {
    this.rootView = rootView;
    this.actualListView = actualListView;
    this.focusLocation = focusLocation;
    this.jobsListView = jobsListView;
    this.mapView = mapView;
    this.scrollView = scrollView;
    this.scrollViewLayout = scrollViewLayout;
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
      id = R.id.actualListView;
      ListView actualListView = ViewBindings.findChildViewById(rootView, id);
      if (actualListView == null) {
        break missingId;
      }

      id = R.id.focusLocation;
      FloatingActionButton focusLocation = ViewBindings.findChildViewById(rootView, id);
      if (focusLocation == null) {
        break missingId;
      }

      RelativeLayout jobsListView = (RelativeLayout) rootView;

      id = R.id.mapView;
      MapView mapView = ViewBindings.findChildViewById(rootView, id);
      if (mapView == null) {
        break missingId;
      }

      id = R.id.scrollView;
      ScrollView scrollView = ViewBindings.findChildViewById(rootView, id);
      if (scrollView == null) {
        break missingId;
      }

      id = R.id.scrollViewLayout;
      LinearLayout scrollViewLayout = ViewBindings.findChildViewById(rootView, id);
      if (scrollViewLayout == null) {
        break missingId;
      }

      return new ActivityMapsBinding((RelativeLayout) rootView, actualListView, focusLocation,
          jobsListView, mapView, scrollView, scrollViewLayout);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
