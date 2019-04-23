package com.jacquessmuts.rxextensions

import android.util.Log
import java.io.PrintWriter
import java.io.StringWriter

/**
 * Created by jacquessmuts on 2019-04-23
 * Object for use in setting defaults and handling errors
 */

object RxHelper {

    const val TAG = "RxHelperDefault"

    private val DEFAULT_LOG_BEHAVIOUR: (error: Throwable) -> Unit =  {
        Log.e(TAG, getStackTraceFrom(it))
    }

    @Volatile
    internal var errorHandler = DEFAULT_LOG_BEHAVIOUR

    fun setDefaultErrorHandling(onError: (error: Throwable) -> Unit) {
        errorHandler = onError
    }

    /**
     * Returns a message based on the throwable
     */
    private fun getStackTraceFrom(t: Throwable): String {
        val sw = StringWriter(256)
        val pw = PrintWriter(sw, false)
        t.printStackTrace(pw)
        pw.flush()
        return sw.toString()
    }
}

