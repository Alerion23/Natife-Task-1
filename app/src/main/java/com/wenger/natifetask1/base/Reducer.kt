package com.wenger.natifetask1.base

interface Reducer<State, Event> {

    val initState: State

    fun reduce(state: State, event: Event): State
}