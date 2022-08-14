package com.test.turtlemint.ui.listissue

import androidx.lifecycle.ViewModel
import com.test.shared.core.di.FragmentScoped
import com.test.shared.core.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * Module where classes needed to create the [GitListModule] are defined.
 */
@Module
internal abstract class GitListModule {

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeFragment(): GitListFragment

    @Binds
    @IntoMap
    @ViewModelKey(GitListViewModel::class)
    internal abstract fun bindViewModel(viewModel: GitListViewModel): ViewModel


}
