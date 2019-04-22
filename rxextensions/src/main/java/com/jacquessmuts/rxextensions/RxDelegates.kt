package com.jacquessmuts.rxextensions

import io.reactivex.subjects.PublishSubject
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by jacquessmuts on 2019-04-22
 * Delegates
 */
/**
 * identical to lazy loaded PublishSubject, but more concise
 */
class LazyPublishSubject<T> : ReadWriteProperty<Any?, PublishSubject<T>> {

    val publisher: PublishSubject<T> by lazy {
        PublishSubject.create<T>()
    }
    override fun getValue(thisRef: Any?, property: KProperty<*>): PublishSubject<T> {
        return publisher
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: PublishSubject<T>) {
    }
}