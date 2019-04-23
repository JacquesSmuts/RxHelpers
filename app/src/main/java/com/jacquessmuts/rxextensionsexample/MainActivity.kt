package com.jacquessmuts.rxextensionsexample

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.jacquessmuts.rxextensions.LazyPublishSubject
import com.jacquessmuts.rxextensions.RxHelper
import com.jacquessmuts.rxextensions.computationThread
import com.jacquessmuts.rxextensions.filterRapidClicks
import com.jacquessmuts.rxextensions.subscribeAndLogE
import com.jacquessmuts.rxextensions.uiThread
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        setDefault()

        setObservable()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    val stringPublisher by LazyPublishSubject<String>()

    fun setDefault() {

        Timber.plant(Timber.DebugTree())

        RxHelper.setDefaultErrorHandling { throwable ->
            // Every time .subscribeAndLogE catches an error, this will run
            Timber.e(throwable)
        }

        // events faster than 500ms will be filtered out by .filterRapidClick()
        RxHelper.setMaximumClickRapidity(500)

    }

    fun setObservable() {

        stringPublisher
            .filterRapidClicks() // filters out rapid events within 300ms
            .computationThread() // Puts this on computation thread
            .uiThread() // Puts this back on ui/main thread
            .map {
                throw Exception("testttttt")
            }
            .subscribeAndLogE { string ->
                //do something with string
            }

        stringPublisher.onNext("test")

    }
}
