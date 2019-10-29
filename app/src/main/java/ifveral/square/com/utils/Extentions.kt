package ifveral.square.com.utils

import android.app.Activity
import ifveral.square.com.SquareApp

val Activity.squareApp: SquareApp
    get() = application as SquareApp