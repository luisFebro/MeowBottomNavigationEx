// reference: https://www.youtube.com/watch?v=KbFvUK9LY9A
package com.codeinger.mymeowbottomnavigationview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.codeinger.mymeowbottomnavigationview.BookmarkFragment;
import com.codeinger.mymeowbottomnavigationview.HomeFragment;
import com.codeinger.mymeowbottomnavigationview.ProfileFragment;
import com.codeinger.mymeowbottomnavigationview.R;
import com.codeinger.mymeowbottomnavigationview.SearchFragment;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {

    private MeowBottomNavigation bnv_Main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnv_Main = findViewById(R.id.bnv_Main);
        bnv_Main.add(new MeowBottomNavigation.Model(1, R.drawable.book));
        bnv_Main.add(new MeowBottomNavigation.Model(2,R.drawable.home));
        bnv_Main.add(new MeowBottomNavigation.Model(3,R.drawable.person));

        bnv_Main.show(2,true);
        replace(new HomeFragment());
        bnv_Main.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                switch (model.getId()){
                    case 1:
                        replace(new BookmarkFragment());
                        break;
                    case 2:
                        replace(new HomeFragment());
                        break;
                    case 3:
                        replace(new ProfileFragment());
                        break;
                }
                return null;
            }
        });




    }

    private void replace(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame,fragment);
        transaction.commit();
    }
}