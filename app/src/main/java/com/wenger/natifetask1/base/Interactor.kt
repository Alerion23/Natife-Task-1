package com.wenger.natifetask1.base

interface Interactor<State, Event> {

    operator fun invoke(state: State, event: Event): Event

}