// Generated by view binder compiler. Do not edit!
package com.example.clovercycle.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
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
  public final Button button;

  @NonNull
  public final Button button3;

  @NonNull
  public final FloatingActionButton focusLocation;

  @NonNull
  public final TextView job1;

  @NonNull
  public final TextView job2;

  @NonNull
  public final TextView job3;

  @NonNull
  public final TextView job4;

  @NonNull
  public final TextView job5;

  @NonNull
  public final TextView job6;

  @NonNull
  public final TextView job7;

  @NonNull
  public final TextView job8;

  @NonNull
  public final MapView mapView;

  @NonNull
  public final ScrollView scrollView;

  @NonNull
  public final LinearLayout scrollViewLayout;

  private ActivityMapsBinding(@NonNull RelativeLayout rootView,
      @NonNull RelativeLayout MapsActivityComponent, @NonNull Button button,
      @NonNull Button button3, @NonNull FloatingActionButton focusLocation, @NonNull TextView job1,
      @NonNull TextView job2, @NonNull TextView job3, @NonNull TextView job4,
      @NonNull TextView job5, @NonNull TextView job6, @NonNull TextView job7,
      @NonNull TextView job8, @NonNull MapView mapView, @NonNull ScrollView scrollView,
      @NonNull LinearLayout scrollViewLayout) {
    this.rootView = rootView;
    this.MapsActivityComponent = MapsActivityComponent;
    this.button = button;
    this.button3 = button3;
    this.focusLocation = focusLocation;
    this.job1 = job1;
    this.job2 = job2;
    this.job3 = job3;
    this.job4 = job4;
    this.job5 = job5;
    this.job6 = job6;
    this.job7 = job7;
    this.job8 = job8;
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
      RelativeLayout MapsActivityComponent = (RelativeLayout) rootView;

      id = R.id.button;
      Button button = ViewBindings.findChildViewById(rootView, id);
      if (button == null) {
        break missingId;
      }

      id = R.id.button3;
      Button button3 = ViewBindings.findChildViewById(rootView, id);
      if (button3 == null) {
        break missingId;
      }

      id = R.id.focusLocation;
      FloatingActionButton focusLocation = ViewBindings.findChildViewById(rootView, id);
      if (focusLocation == null) {
        break missingId;
      }

      id = R.id.job1;
      TextView job1 = ViewBindings.findChildViewById(rootView, id);
      if (job1 == null) {
        break missingId;
      }

      id = R.id.job2;
      TextView job2 = ViewBindings.findChildViewById(rootView, id);
      if (job2 == null) {
        break missingId;
      }

      id = R.id.job3;
      TextView job3 = ViewBindings.findChildViewById(rootView, id);
      if (job3 == null) {
        break missingId;
      }

      id = R.id.job4;
      TextView job4 = ViewBindings.findChildViewById(rootView, id);
      if (job4 == null) {
        break missingId;
      }

      id = R.id.job5;
      TextView job5 = ViewBindings.findChildViewById(rootView, id);
      if (job5 == null) {
        break missingId;
      }

      id = R.id.job6;
      TextView job6 = ViewBindings.findChildViewById(rootView, id);
      if (job6 == null) {
        break missingId;
      }

      id = R.id.job7;
      TextView job7 = ViewBindings.findChildViewById(rootView, id);
      if (job7 == null) {
        break missingId;
      }

      id = R.id.job8;
      TextView job8 = ViewBindings.findChildViewById(rootView, id);
      if (job8 == null) {
        break missingId;
      }

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

      return new ActivityMapsBinding((RelativeLayout) rootView, MapsActivityComponent, button,
          button3, focusLocation, job1, job2, job3, job4, job5, job6, job7, job8, mapView,
          scrollView, scrollViewLayout);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
