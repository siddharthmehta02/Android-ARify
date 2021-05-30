package com.example.helloworld

import android.animation.LayoutTransition
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation:MeowBottomNavigation = findViewById(R.id.bottomNavBar)

        addFragment(HomeFragment.newInstance())
        bottomNavigation.show(1)
        bottomNavigation.add(MeowBottomNavigation.Model(0, R.drawable.ic_info))
        bottomNavigation.add(MeowBottomNavigation.Model(1, R.drawable.ic_camera))
        bottomNavigation.add(MeowBottomNavigation.Model(2, R.drawable.ic_search))

        bottomNavigation.setOnClickMenuListener {
            when(it.id){
                0->{
                    replaceFragment(AboutFragment.newInstance())
                }
                1->{
                    replaceFragment(HomeFragment.newInstance())

                }
                2->{
                    replaceFragment(BrowseFragment.newInstance())

                }
            }
        }



    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentTransition=supportFragmentManager.beginTransaction()
            fragmentTransition.replace(R.id.frameLayout,fragment).addToBackStack(Fragment::class.java.simpleName).commit()
    }

    private fun addFragment(fragment: Fragment){
        val fragmentTransition=supportFragmentManager.beginTransaction()
        fragmentTransition.add(R.id.frameLayout,fragment).addToBackStack(Fragment::class.java.simpleName).commit()
    }
}