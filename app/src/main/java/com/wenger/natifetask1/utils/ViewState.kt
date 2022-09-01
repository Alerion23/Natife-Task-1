package com.wenger.natifetask1.utils

sealed class ViewState<out T> {

    class Success<T> (val data: T): ViewState<T>()
    class Fail(val message: String?) : ViewState<Nothing>()

}
