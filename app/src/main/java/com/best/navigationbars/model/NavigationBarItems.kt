package com.best.navigationbars.model

import com.best.navigationbars.R

object NavigationBarItems {
    val Home = NavigationBarItem("home", "Home", R.drawable.ic_home)
    val Search = NavigationBarItem("seacrh", "Search", R.drawable.ic_heart)
    val Profile = NavigationBarItem("profile", "Profile", R.drawable.ic_doc)
    val Settings = NavigationBarItem("settings", "Settings", R.drawable.ic_person)

    fun getItems() = listOf(
        Home, Search, Profile, Settings
    )
}