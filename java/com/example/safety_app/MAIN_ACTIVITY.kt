package com.example.safety_app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class MAIN_ACTIVITY : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)
        // click listner
        val bottoomBar=findViewById<BottomNavigationView>(R.id.bottom_bar)
        bottoomBar.setOnItemReselectedListener {
            if(it.itemId==R.id.nav_guard){

                inflateFragment()
            }

            else if(it.itemId==R.id.nav_home){
                inflateHomeFragment()
            }
            else if(it.itemId==R.id.nav_dashboard){
                inflateDashFragment()
            }
            else if(it.itemId==R.id.nav_profile){
                inflateProfileFragment()
            }

            inflateFragment()

            true

        }

    }

    private fun inflateProfileFragment() {
        val transaction=supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,PFragment.newInstance()){
            transaction.commit()
        }
    }


    private fun inflateDashFragment() {
        val transaction=supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,DFragment.newInstance())
        transaction.commit()
    }


    private fun inflateHomeFragment() {
         val transaction=supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,HomeFragment.newInstance())
        transaction.commit()
    }


    private  fun inflateFragment(){
          val transanction=supportFragmentManager.beginTransaction()
     transanction.replace(R.id.container,GuardFragment.newInstance())
        transanction.commit()

    }

}

private fun Any.replace(container: Int, newInstance: PFragment, function: () -> Int) {

}
