package com.test.turtlemint.ui.comments

import androidx.lifecycle.ViewModel
import com.test.shared.core.di.FragmentScoped
import com.test.shared.core.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap


@Module
internal abstract class CommentsModule {

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeFragment(): CommentsFragment

    @Binds
    @IntoMap
    @ViewModelKey(CommentsViewModel::class)
    internal abstract fun bindViewModel(viewModel: CommentsViewModel): ViewModel


}
