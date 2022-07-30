package com.test.turtlemint.base

import com.test.shared.network.repository.PreferenceStorage
import dagger.android.support.DaggerFragment
import javax.inject.Inject

open class BaseFragment : DaggerFragment() {
    @Inject
    lateinit var preferenceStorage: PreferenceStorage


}