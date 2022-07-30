package com.test.turtlemint.base

import com.test.shared.network.repository.PreferenceStorage
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity() {


    @Inject
    lateinit var preferenceStorage: PreferenceStorage

}
