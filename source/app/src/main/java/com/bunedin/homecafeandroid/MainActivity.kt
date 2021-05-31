package com.bunedin.homecafeandroid

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        var data:MutableList<ListData> = setData()
        var adapter = CustomAdapter()
        adapter.listData = data
        main_recycler_view.adapter = adapter
        main_recycler_view.layoutManager = GridLayoutManager(this, 2)

        main_btn_pay.setOnClickListener {
            if (main_total_price.text == "0") {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Add Item")
                builder.setMessage("Please Add Item")
                builder.setPositiveButton("OK") { dialogInterface, i ->

                }

                builder.show()
            }
        }
    }

    //initialize main activity
    fun init(){
        setSupportActionBar(findViewById(R.id.main_toolbar))

        val drawer = findViewById<DrawerLayout>(R.id.main_drawer)
        val nav_view = findViewById<NavigationView>(R.id.main_navigation_view)
        val drawerToggle = ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close);

        drawer.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Main"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                main_drawer.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_main -> {

            }
            R.id.nav_balance -> {
                val balanceIntent = Intent(this, Balance::class.java)
                startActivity(balanceIntent)
            }
            R.id.nav_management_menu -> {
                val managementMenu = Intent(this, ManagementMenu2::class.java)
                startActivity(managementMenu)
            }
            R.id.nav_management_order -> {
                val managementOrder = Intent(this, ManagementOrder::class.java)
                startActivity(managementOrder)
            }
            R.id.nav_statistic -> {

            }
        }
        main_drawer.closeDrawer(GravityCompat.START)
        return true
    }
    data class ListData(var title:String, var price:Int) {}

    fun setData(): MutableList<ListData> {
        var data: MutableList<ListData> = mutableListOf()
        for(num in 1..10) {
            var listData = ListData("${num} 번째 타이틀", 1)
            data.add(listData)
        }
        return data
    }


}