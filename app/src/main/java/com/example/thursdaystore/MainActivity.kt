package com.example.thursdaystore

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.thursdaystore.drawer.category.CategoryFragment
import com.example.thursdaystore.fragments.products.ProductsFragment
import com.example.thursdaystore.fragments.sub_category.SubCategoryFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), CategoryFragment.OpenSubcategory,
    SubCategoryFragment.OpenProducts,
    ProductsFragment.OpenProductTree {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        navController = findNavController(R.id.nav_host_fragment)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_category,
                R.id.nav_favorites,
                R.id.nav_basket,
                R.id.nav_purchases,
                R.id.nav_personal,
                R.id.nav_company,
                R.id.nav_feedback
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun openSubcategory() {
        navController.navigate(R.id.subCategoryFragment)
    }

    override fun openProducts() {
        navController.navigate(R.id.productsFragment)
    }

    override fun openProductTree() {
        navController.navigate(R.id.productTreeFragment)
    }
}
