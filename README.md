# RxHelpers
Extension functions and delegates for RxJava

[![CircleCI](https://circleci.com/gh/JacquesSmuts/RxHelpers.svg?style=svg)](https://circleci.com/gh/JacquesSmuts/RxHelpers) [ ![Download](https://api.bintray.com/packages/jacquessmuts/RxHelpers/rxhelpers/images/download.svg) ](https://bintray.com/jacquessmuts/RxHelpers/rxhelpers/_latestVersion)

This app provides a few extension functions and delegates for RxJava in Kotlin


Download
--------

```groovy
implementation 'com.jacquessmuts:rxhelpers:{version}'
```


Usage
-----

| Extension  | Description | Example |
| ------------- | ------------- | ------------- |
| .filterRapidClicks() | Throttles out events within 300ms | Most of them. [ButtonRapidClickActivity](https://github.com/JacquesSmuts/RxStarter/blob/master/app/src/main/java/com/jacquessmuts/rxstarter/java/sample/ButtonRapidClickActivity.java)  |
| .subscribeAndLogE{} | same as .subscribe{}, except it logs an error by default. | [SingleActivity](https://github.com/JacquesSmuts/RxStarter/blob/master/app/src/main/java/com/jacquessmuts/rxstarter/java/sample/SingleActivity.java) |