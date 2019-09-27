package com.example.weathermvvm.module

import com.example.weathermvvm.ui.dashboard.DashboardFragment
import com.example.weathermvvm.ui.home.HomeFragment
import com.example.weathermvvm.ui.notifications.NotificationsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityFragmentModule {

    @ContributesAndroidInjector
    abstract fun bindHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun bindDashboardFragment(): DashboardFragment

    @ContributesAndroidInjector
    abstract fun bindNotificationFragment(): NotificationsFragment
}