// Generated by view binder compiler. Do not edit!
package com.example.clovercycle.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.clovercycle.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityCollectorBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button collectBtn;

  @NonNull
  public final Button endBtn;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final Button jobBtn;

  @NonNull
  public final RecyclerView jobList;

  @NonNull
  public final Button menuBtn;

  private ActivityCollectorBinding(@NonNull ConstraintLayout rootView, @NonNull Button collectBtn,
      @NonNull Button endBtn, @NonNull ImageView imageView, @NonNull Button jobBtn,
      @NonNull RecyclerView jobList, @NonNull Button menuBtn) {
    this.rootView = rootView;
    this.collectBtn = collectBtn;
    this.endBtn = endBtn;
    this.imageView = imageView;
    this.jobBtn = jobBtn;
    this.jobList = jobList;
    this.menuBtn = menuBtn;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityCollectorBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityCollectorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_collector, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityCollectorBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.collectBtn;
      Button collectBtn = ViewBindings.findChildViewById(rootView, id);
      if (collectBtn == null) {
        break missingId;
      }

      id = R.id.endBtn;
      Button endBtn = ViewBindings.findChildViewById(rootView, id);
      if (endBtn == null) {
        break missingId;
      }

      id = R.id.imageView;
      ImageView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.jobBtn;
      Button jobBtn = ViewBindings.findChildViewById(rootView, id);
      if (jobBtn == null) {
        break missingId;
      }

      id = R.id.jobList;
      RecyclerView jobList = ViewBindings.findChildViewById(rootView, id);
      if (jobList == null) {
        break missingId;
      }

      id = R.id.menuBtn;
      Button menuBtn = ViewBindings.findChildViewById(rootView, id);
      if (menuBtn == null) {
        break missingId;
      }

      return new ActivityCollectorBinding((ConstraintLayout) rootView, collectBtn, endBtn,
          imageView, jobBtn, jobList, menuBtn);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}