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
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.clovercycle.R;
import com.google.android.material.textfield.TextInputEditText;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class UserJobBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView amount;

  @NonNull
  public final TextInputEditText amountInput;

  @NonNull
  public final ImageView imageView2;

  @NonNull
  public final Button jobBtn;

  @NonNull
  public final Button menuBtn;

  @NonNull
  public final Button myjobs;

  @NonNull
  public final Button paymentsBtn;

  @NonNull
  public final TextView welcome;

  private UserJobBinding(@NonNull ConstraintLayout rootView, @NonNull TextView amount,
      @NonNull TextInputEditText amountInput, @NonNull ImageView imageView2, @NonNull Button jobBtn,
      @NonNull Button menuBtn, @NonNull Button myjobs, @NonNull Button paymentsBtn,
      @NonNull TextView welcome) {
    this.rootView = rootView;
    this.amount = amount;
    this.amountInput = amountInput;
    this.imageView2 = imageView2;
    this.jobBtn = jobBtn;
    this.menuBtn = menuBtn;
    this.myjobs = myjobs;
    this.paymentsBtn = paymentsBtn;
    this.welcome = welcome;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static UserJobBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static UserJobBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.user_job, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static UserJobBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.amount;
      TextView amount = ViewBindings.findChildViewById(rootView, id);
      if (amount == null) {
        break missingId;
      }

      id = R.id.amountInput;
      TextInputEditText amountInput = ViewBindings.findChildViewById(rootView, id);
      if (amountInput == null) {
        break missingId;
      }

      id = R.id.imageView2;
      ImageView imageView2 = ViewBindings.findChildViewById(rootView, id);
      if (imageView2 == null) {
        break missingId;
      }

      id = R.id.jobBtn;
      Button jobBtn = ViewBindings.findChildViewById(rootView, id);
      if (jobBtn == null) {
        break missingId;
      }

      id = R.id.menuBtn;
      Button menuBtn = ViewBindings.findChildViewById(rootView, id);
      if (menuBtn == null) {
        break missingId;
      }

      id = R.id.myjobs;
      Button myjobs = ViewBindings.findChildViewById(rootView, id);
      if (myjobs == null) {
        break missingId;
      }

      id = R.id.paymentsBtn;
      Button paymentsBtn = ViewBindings.findChildViewById(rootView, id);
      if (paymentsBtn == null) {
        break missingId;
      }

      id = R.id.welcome;
      TextView welcome = ViewBindings.findChildViewById(rootView, id);
      if (welcome == null) {
        break missingId;
      }

      return new UserJobBinding((ConstraintLayout) rootView, amount, amountInput, imageView2,
          jobBtn, menuBtn, myjobs, paymentsBtn, welcome);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
