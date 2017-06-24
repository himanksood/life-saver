package com.example.dell.home1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MyNewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_new_activity);
        getSupportActionBar().show();

    }

    public void clicked1(View v) {
        final String[] arrCourses1 = {"Police", "Ambulance",
                "Fire Department ", "Emergency Helpline"};
        AlertDialog.Builder bld = new AlertDialog.Builder(this);
        bld.setItems(arrCourses1, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                Toast.makeText(MyNewActivity.this, arrCourses1[which],
                        Toast.LENGTH_SHORT).show();
                switch (which) {

                    case 0:

                        Intent a = new Intent(
                                Intent.ACTION_CALL, Uri
                                .parse("tel:100"));
                        startActivity(a);
                        break;
                    case 1:

                        Intent b = new Intent(
                                Intent.ACTION_CALL, Uri
                                .parse("tel:102"));
                        startActivity(b);
                        break;
                    case 2:


                        Intent c = new Intent(
                                Intent.ACTION_CALL, Uri
                                .parse("tel:101"));
                        startActivity(c);
                        break;
                    case 3:


                        Intent d = new Intent(
                                Intent.ACTION_CALL, Uri
                                .parse("tel:911"));
                        startActivity(d);
                        break;

                    default:
                }
            }
        });
        AlertDialog al = bld.create();
        al.show();

    }

    public void clicked3(View v) {
        final String[] arrCourses3 = {"Medical Assistance", "Restaurants",
                "Cinema Halls", "Cash Withdrawal Machine"};
        AlertDialog.Builder bld = new AlertDialog.Builder(this);
        bld.setItems(arrCourses3, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                Toast.makeText(MyNewActivity.this, arrCourses3[which],
                        Toast.LENGTH_SHORT).show();
                switch (which) {

                    case 0:
                        Intent b = new Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("geo:0,0?q=Hospitals+nearby"));
                        startActivity(b);

                        break;
                    case 1:
                        Intent c = new Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("geo:0,0?q=Restaurants+nearby"));
                        startActivity(c);


                        break;
                    case 2:


                        Intent x = new Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("geo:0,0?q=Nearby+Cinema+Hall"));
                        startActivity(x);
                        break;
                    case 3:

                        Intent d = new Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("geo:0,0?q=Nearby+ATM's"));
                        startActivity(d);
                        break;

                    default:
                }
            }
        });
        AlertDialog al = bld.create();
        al.show();

    }

    public void clicked4(View v) {
        final String[] arrCourses = {"Order Pizza", "Phone Recharge",
                "Online Banking", "Search", "Flashlight"};
        AlertDialog.Builder bld = new AlertDialog.Builder(this);
        bld.setItems(arrCourses, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                Toast.makeText(MyNewActivity.this, arrCourses[which],
                        Toast.LENGTH_SHORT).show();
                switch (which) {
                    case 0:

                        Toast.makeText(MyNewActivity.this, "Opening Website",
                                Toast.LENGTH_SHORT).show();
                        Intent d = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://pizzaonline.dominos.co.in"));
                        startActivity(d);
                        break;

                    case 1:

                        Toast.makeText(MyNewActivity.this, "Opening Website",
                                Toast.LENGTH_SHORT).show();
                        Intent e = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://www.rechargeitnow.com"));
                        startActivity(e);
                        break;

                    case 2:

                        Toast.makeText(MyNewActivity.this, "Opening secure webpage",
                                Toast.LENGTH_SHORT).show();
                        Intent f = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://www.onlinesbi.com"));
                        startActivity(f);
                        break;

                    case 3:

                        Toast.makeText(MyNewActivity.this, "Redirecting to Google",
                                Toast.LENGTH_SHORT).show();
                        Intent g = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://www.google.com"));
                        startActivity(g);
                        break;
                    case 4:

startActivity(new Intent(MyNewActivity.this,torch.class));
                        break;

                    default:
                }
            }
        });
        AlertDialog al = bld.create();
        al.show();

    }

    public void clicked5(View v) {
        Intent i = new Intent("com.example.jas.home1.MyActivity");
        startActivity(i);
    }

    public void clicked6(View v) {

        Intent intent = new Intent();
        intent.setType("video/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivity(intent);
        //startActivityForResult(Intent.createChooser(intent,"Select Video"),2);

//        Intent i = new Intent("com.example.jas.home1.videoActivity");
//        startActivity(i);
    }


    public void clicked8(View v) {


        Intent z = new Intent(
                Intent.ACTION_VIEW,
                Uri.parse("geo:0,0?q="));
        startActivity(z);
    }

    public void clicked9(View v) {
        String facebookPackageName = "com.facebook.katana";

        try {
            //check if facebook app installed
            getPackageManager().getApplicationInfo(facebookPackageName, 0);

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("facebook:/newsfeed"));
            startActivity(intent);

        } catch (PackageManager.NameNotFoundException e) {
            // Didn't installed
            Toast.makeText(getApplicationContext(), "Facebook not found! INSTALL.", Toast.LENGTH_LONG).show();

            //Start Market to download and install Facebook App
            Uri uri = Uri.parse("market://details?id=" + facebookPackageName);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    }

    public void clicked10(View v) {

        Intent i = new Intent("com.example.jas.home1.about");
        startActivity(i);
    }

    public void clicked11(View v) {

        Intent i = new Intent("com.example.jas.home1.callblocker");
        startActivity(i);
    }

}
