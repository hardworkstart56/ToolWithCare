package com.example.tatastrive.toolwithcare;

import android.content.Intent;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    CheckBox checkBox;
    final static  int pickbycamera=10;
    android.support.v7.view.ActionMode actionMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Home Page");
        toolbar.setSubtitle("welcome User..!");
        checkBox=findViewById(R.id.mycheckBox);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            class ActionBarCallback implements android.support.v7.view.ActionMode.Callback {

                @Override
                public boolean onCreateActionMode(android.support.v7.view.ActionMode actionMode, Menu menu) {

                    actionMode.getMenuInflater().inflate(R.menu.contextual_menu, menu);
                    return true;
                }

                @Override
                public boolean onPrepareActionMode(android.support.v7.view.ActionMode actionMode, Menu menu) {

                    actionMode.setTitle("My Action Mode Done");
                    Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                    return false;
                }

                @Override
                public boolean onActionItemClicked(android.support.v7.view.ActionMode actionMode, MenuItem menuItem) {


                    // You can add Functionality to your Menu Buttons here.
                    // Apply switch case statements in case there are more than one Menu Buttons.

                    return false;
                }

                @Override
                public void onDestroyActionMode(android.support.v7.view.ActionMode actionMode) {

                    // This is called when Action Mode is completed.

                }
            }

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                    actionMode = MainActivity.this.startSupportActionMode(new ActionBarCallback());

                }else{

                    actionMode.finish();

                }
            }
        });


        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.action_settings:
                startActivity(new Intent(Settings.ACTION_DATE_SETTINGS));
                Toast.makeText(MainActivity.this, "Settings Clicked", Toast.LENGTH_SHORT).show();
                break;

            case R.id.action_camera:

                Toast.makeText(MainActivity.this, "Camera Clicked", Toast.LENGTH_SHORT).show();
                Intent invokecam=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(invokecam);
                break;

            case R.id.action_logout:

                Toast.makeText(MainActivity.this, "Logout Clicked", Toast.LENGTH_SHORT).show();
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}

