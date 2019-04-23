# RxHelpers
Extension functions and delegates for RxJava

[![CircleCI](https://circleci.com/gh/JacquesSmuts/RxHelpers.svg?style=svg)](https://circleci.com/gh/JacquesSmuts/RxHelpers) [ ![Download](https://api.bintray.com/packages/jacquessmuts/RxHelpers/rxhelpers/images/download.svg) ](https://bintray.com/jacquessmuts/RxHelpers/rxhelpers/_latestVersion)

This app provides a few extension functions and delegates for RxJava in Kotlin


Installation
--------

```groovy
implementation 'com.jacquessmuts:rxhelpers:{version}'
```


Usage
-----

| Extension  | Description | Example |
| ------------- | ------------- | ------------- |
| .filterRapidClicks() | Throttles out events within 300ms | [Example](https://github.com/JacquesSmuts/RxHelpers/blob/d62b70e295ffd60263608c3f19781a5e98bd0875/app/src/main/java/com/jacquessmuts/rxextensionsexample/MainActivity.kt#L52)  |
| .subscribeAndLogE{} | Same as .subscribe{}, except it logs an error by default. | [Example](https://github.com/JacquesSmuts/RxHelpers/blob/d62b70e295ffd60263608c3f19781a5e98bd0875/app/src/main/java/com/jacquessmuts/rxextensionsexample/MainActivity.kt#L52) |
| .computationThread() | Same as observeOn(Schedulers.computation())| [Example](https://github.com/JacquesSmuts/RxHelpers/blob/d62b70e295ffd60263608c3f19781a5e98bd0875/app/src/main/java/com/jacquessmuts/rxextensionsexample/MainActivity.kt#L52) |
| .uiThread() | Same as observeOn(AndroidSchedulers.mainThread()) | [Example](https://github.com/JacquesSmuts/RxHelpers/blob/d62b70e295ffd60263608c3f19781a5e98bd0875/app/src/main/java/com/jacquessmuts/rxextensionsexample/MainActivity.kt#L52) |

Setting Defaults
-----

You can set the default handling of some functions. The `onCreate` of your application is the most logical choice.


```kotlin

RxHelper.setDefaultErrorHandling { throwable ->
    // Every time .subscribeAndLogE catches an error, this will run
    Timber.e(throwable)
}

// events faster than 500ms will be filtered out by .filterRapidClick()
RxHelper.setMaximumClickRapidity(500)
```


