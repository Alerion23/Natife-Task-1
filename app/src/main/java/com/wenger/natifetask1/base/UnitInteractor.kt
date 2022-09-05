package com.wenger.natifetask1.base

interface UnitInteractor<State, Event> {

    operator fun invoke(state: State, event: Event)
}