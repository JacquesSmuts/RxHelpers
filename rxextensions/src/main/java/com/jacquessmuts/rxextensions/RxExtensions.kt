package com.jacquessmuts.rxextensions

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by jacquessmuts on 2019-04-22
 * This is for custom rxJava extensions and delegates
 */

/**
 * Adds a 300ms delay for clickable objects
 */
fun <T> Observable<T>.filterRapidClicks() = throttleFirst(RxHelper.maxClickRapidity, java.util.concurrent.TimeUnit.MILLISECONDS)

/**
 *same as subscribe, except it logs errors with Timber.e() automatically
 * */
fun <T> Observable<T>.subscribeAndLogE(onNext: (it: T) -> Unit): Disposable =
    subscribe(onNext, RxHelper.errorHandler)

/**
 * Puts the Observer on the Main/UI Thread using [Observable.observeOn]. Please make sure you understand
 * the difference between [Observable.subscribeOn] and [Observable.observeOn] when using this.
 */
fun <T> Single<T>.uiThread(): Single<T> = observeOn(AndroidSchedulers.mainThread())

/**
 * Puts the Observer on the Main/UI Thread using [Observable.observeOn]. Please make sure you understand
 * the difference between [Observable.subscribeOn] and [Observable.observeOn] when using this.
 */
fun <T> Observable<T>.uiThread(): Observable<T> = observeOn(AndroidSchedulers.mainThread())

/**
 * Puts the Observer on the Computation Thread using [Observable.observeOn]. Please make sure you understand
 * the difference between [Observable.subscribeOn] and [Observable.observeOn] when using this.
 */
fun <T> Observable<T>.computationThread(): Observable<T> = observeOn(Schedulers.computation())
