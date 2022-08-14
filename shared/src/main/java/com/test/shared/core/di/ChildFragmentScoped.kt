package com.test.shared.core.di

import javax.inject.Scope

/**
 * The ChildFragmentScoped custom scoping annotation specifies that the lifespan of a dependency be
 * the same as that of a child Fragment. This is used to annotate dependencies that behave like a
 * singleton within the lifespan of a child Fragment
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
@Target(
    AnnotationTarget.ANNOTATION_CLASS,
    AnnotationTarget.CLASS,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
annotation class ChildFragmentScoped 