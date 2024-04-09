// Generated by view binder compiler. Do not edit!
package com.example.clovercycle.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
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

public final class ActivityRegisterBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final EditText addressInputTf;

  @NonNull
  public final RadioButton collectorRb;

  @NonNull
  public final TextInputEditText emailInputTf;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final EditText passwordInputTf;

  @NonNull
  public final Button registerButtonBtn;

  @NonNull
  public final TextInputEditText userNameInputTf;

  @NonNull
  public final RadioButton userRb;

  private ActivityRegisterBinding(@NonNull ConstraintLayout rootView,
      @NonNull EditText addressInputTf, @NonNull RadioButton collectorRb,
      @NonNull TextInputEditText emailInputTf, @NonNull ImageView imageView,
      @NonNull EditText passwordInputTf, @NonNull Button registerButtonBtn,
      @NonNull TextInputEditText userNameInputTf, @NonNull RadioButton userRb) {
    this.rootView = rootView;
    this.addressInputTf = addressInputTf;
    this.collectorRb = collectorRb;
    this.emailInputTf = emailInputTf;
    this.imageView = imageView;
    this.passwordInputTf = passwordInputTf;
    this.registerButtonBtn = registerButtonBtn;
    this.userNameInputTf = userNameInputTf;
    this.userRb = userRb;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_register, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityRegisterBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.addressInputTf;
      EditText addressInputTf = ViewBindings.findChildViewById(rootView, id);
      if (addressInputTf == null) {
        break missingId;
      }

      id = R.id.collectorRb;
      RadioButton collectorRb = ViewBindings.findChildViewById(rootView, id);
      if (collectorRb == null) {
        break missingId;
      }

      id = R.id.emailInputTf;
      TextInputEditText emailInputTf = ViewBindings.findChildViewById(rootView, id);
      if (emailInputTf == null) {
        break missingId;
      }

      id = R.id.imageView;
      ImageView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.passwordInputTf;
      EditText passwordInputTf = ViewBindings.findChildViewById(rootView, id);
      if (passwordInputTf == null) {
        break missingId;
      }

      id = R.id.registerButtonBtn;
      Button registerButtonBtn = ViewBindings.findChildViewById(rootView, id);
      if (registerButtonBtn == null) {
        break missingId;
      }

      id = R.id.userNameInputTf;
      TextInputEditText userNameInputTf = ViewBindings.findChildViewById(rootView, id);
      if (userNameInputTf == null) {
        break missingId;
      }

      id = R.id.userRb;
      RadioButton userRb = ViewBindings.findChildViewById(rootView, id);
      if (userRb == null) {
        break missingId;
      }

      return new ActivityRegisterBinding((ConstraintLayout) rootView, addressInputTf, collectorRb,
          emailInputTf, imageView, passwordInputTf, registerButtonBtn, userNameInputTf, userRb);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
