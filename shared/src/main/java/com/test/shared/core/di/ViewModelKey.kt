package com.test.shared.core.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * Annotation to be applied to a getter or setter function, that is stored in the binary output.
 * A [ViewModelKey] object will be the key in a Map generated by Dagger. The value will be the
 * ViewModel to be retrieved based on the key.
 *
 */
@Target(
    AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)
