package com.example.helloworld

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import java.util.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (this.checkSystemSupport(this)) {

            val bottomNavigation: MeowBottomNavigation = findViewById(R.id.bottomNavBar)

            addFragment(HomeFragment.newInstance())
            bottomNavigation.show(1)
            bottomNavigation.add(MeowBottomNavigation.Model(0, R.drawable.ic_info))
            bottomNavigation.add(MeowBottomNavigation.Model(1, R.drawable.ic_camera))
            bottomNavigation.add(MeowBottomNavigation.Model(2, R.drawable.ic_search))

            bottomNavigation.setOnClickMenuListener {
                when (it.id) {
                    0 -> {
                        replaceFragment(AboutFragment.newInstance())
                    }
                    1 -> {
                        replaceFragment(HomeFragment.newInstance())

                    }
                    2 -> {
                        replaceFragment(BrowseFragment.newInstance())

                    }
                }
            }
        }



    }

    private fun checkSystemSupport(activity: Activity): Boolean {

        // checking whether the API version of the running Android >= 24
        // that means Android Nougat 7.0
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            val openGlVersion =
                (Objects.requireNonNull(activity.getSystemService(Context.ACTIVITY_SERVICE)) as ActivityManager).deviceConfigurationInfo.glEsVersion

            // checking whether the OpenGL version >= 3.0
            if (openGlVersion.toDouble() >= 3.0) {
                true
            } else {
                Toast.makeText(
                    activity,
                    "App needs OpenGl Version 3.0 or later",
                    Toast.LENGTH_SHORT
                ).show()
                activity.finish()
                false
            }
        } else {
            Toast.makeText(
                activity,
                "App does not support required Build Version",
                Toast.LENGTH_SHORT
            ).show()
            activity.finish()
            false
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