package com.quantum.drinkwater.activity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.quantum.drinkwater.R;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Objects;



public abstract class BaseActivity extends AppCompatActivity {

    public static boolean isMainMenuPassword = false;
    private static boolean isSplashLauncher = false;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());



    }



    private Toolbar toolbar;

    public void setUpToolBar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void setUpToolBar(String mToolbarTitle) {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setTitle(mToolbarTitle);
    }

    public void setUpToolBar(String pageTitle, boolean showBackButton) {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(v -> finish());

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(pageTitle);

        if (showBackButton) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

            toolbar.setNavigationOnClickListener(v -> finish());
        }

        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        toolbar.setTitleMarginStart(0);
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public abstract int getLayoutID();

    public boolean isReadPhoneStatePermissionGranted() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.READ_PHONE_STATE)
                    == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {

                return false;
            }
        } else {
            return true;
        }
    }







//    public void loadImageWithGlide(String packageName, ImageView src) {
//        Glide.with(this)
//                .load(AppUtils.getPackageIcon(this, packageName)).
//                transition(new DrawableTransitionOptions().crossFade())
//                .into(src);
//    }


    public SimpleDateFormat getSimpleDateFormatterInDays() {
        return new SimpleDateFormat("ddMMyyyy", Locale.getDefault());
    }


    public SimpleDateFormat getDateFormatterInDays() {
        return new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
    }
    public SimpleDateFormat getSimpleDateFormatterInHours() {
        return new SimpleDateFormat("HH:mm:ss",
                Locale.getDefault());
    }

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void removeLayout(LinearLayout layout_bottom) {
        if (layout_bottom != null) {
            if (layout_bottom.getChildCount() > 0)
                layout_bottom.removeAllViews();
        }
    }




//    public void showADialog(int message, int buttonPositive, int buttonNegative, final DialogActionListner dialogActionListner) {
//        showADialog(this.getResources().getString(message), this.getResources().getString(buttonPositive), this.getResources().getString(buttonNegative), dialogActionListner);
//    }
//
//    public void showADialog(String message, String buttonPositive, String buttonNegative, final DialogActionListner dialogActionListner) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(BaseActivity.this);
//        builder.setIcon(android.R.drawable.ic_dialog_alert);
//        builder.setMessage("" + message);
//        builder.setCancelable(true);
//        builder.setPositiveButton(buttonPositive, (dialog, id) -> {
//            // User clicked OK button
//            if (dialog != null) {
//                dialog.dismiss();
//            }
//            if (dialogActionListner != null) {
//                dialogActionListner.onPositiveButton();
//            }
//        });
//
//        builder.setNegativeButton(buttonNegative, (dialog, id) -> {
//            // User clicked OK button
//            if (dialog != null) {
//                dialog.dismiss();
//            }
//            if (dialogActionListner != null) {
//                dialogActionListner.onCancel();
//            }
//        });
//        builder.setOnCancelListener(dialog -> {
//            if (dialogActionListner != null) {
//                dialogActionListner.onCancel();
//            }
//        });
//        AlertDialog dialog = builder.create();
//
//        try {
//            dialog.setCanceledOnTouchOutside(false);
//            if (!BaseActivity.this.isFinishing()) {
//                dialog.show();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public interface DialogActionListner {
//        void onPositiveButton();
//
//        void onCancel();
//    }
//
//
//



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (requestCode == 9 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//            //  takePhoto();
//        }



    }
}
