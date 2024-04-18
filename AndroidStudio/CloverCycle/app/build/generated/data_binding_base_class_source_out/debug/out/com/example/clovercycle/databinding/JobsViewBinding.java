// Generated by view binder compiler. Do not edit!
package com.example.clovercycle.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
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

public final class JobsViewBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView addressLabelTv;

  @NonNull
  public final TextView addressTv;

  @NonNull
  public final TextView amountLabelTv;

  @NonNull
  public final TextView amountTV;

  @NonNull
  public final RecyclerView idRVJobs;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final Button menuBtn;

  @NonNull
  public final TextView nameLabelTv;

  @NonNull
  public final TextView nameTv;

  private JobsViewBinding(@NonNull ConstraintLayout rootView, @NonNull TextView addressLabelTv,
      @NonNull TextView addressTv, @NonNull TextView amountLabelTv, @NonNull TextView amountTV,
      @NonNull RecyclerView idRVJobs, @NonNull ImageView imageView, @NonNull Button menuBtn,
      @NonNull TextView nameLabelTv, @NonNull TextView nameTv) {
    this.rootView = rootView;
    this.addressLabelTv = addressLabelTv;
    this.addressTv = addressTv;
    this.amountLabelTv = amountLabelTv;
    this.amountTV = amountTV;
    this.idRVJobs = idRVJobs;
    this.imageView = imageView;
    this.menuBtn = menuBtn;
    this.nameLabelTv = nameLabelTv;
    this.nameTv = nameTv;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static JobsViewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static JobsViewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.jobs_view, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static JobsViewBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.addressLabelTv;
      TextView addressLabelTv = ViewBindings.findChildViewById(rootView, id);
      if (addressLabelTv == null) {
        break missingId;
      }

      id = R.id.addressTv;
      TextView addressTv = ViewBindings.findChildViewById(rootView, id);
      if (addressTv == null) {
        break missingId;
      }

      id = R.id.amountLabelTv;
      TextView amountLabelTv = ViewBindings.findChildViewById(rootView, id);
      if (amountLabelTv == null) {
        break missingId;
      }

      id = R.id.amountTV;
      TextView amountTV = ViewBindings.findChildViewById(rootView, id);
      if (amountTV == null) {
        break missingId;
      }

      id = R.id.idRVJobs;
      RecyclerView idRVJobs = ViewBindings.findChildViewById(rootView, id);
      if (idRVJobs == null) {
        break missingId;
      }

      id = R.id.imageView;
      ImageView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.menuBtn;
      Button menuBtn = ViewBindings.findChildViewById(rootView, id);
      if (menuBtn == null) {
        break missingId;
      }

      id = R.id.nameLabelTv;
      TextView nameLabelTv = ViewBindings.findChildViewById(rootView, id);
      if (nameLabelTv == null) {
        break missingId;
      }

      id = R.id.nameTv;
      TextView nameTv = ViewBindings.findChildViewById(rootView, id);
      if (nameTv == null) {
        break missingId;
      }

      return new JobsViewBinding((ConstraintLayout) rootView, addressLabelTv, addressTv,
          amountLabelTv, amountTV, idRVJobs, imageView, menuBtn, nameLabelTv, nameTv);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}