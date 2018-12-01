package io.smallibs.aktor

interface Actor<T> : ActorBuilder {

    val context: ActorContext<T>

    fun behavior(): Behavior<T>? // FIXME can have a default behavior to avoid null

    fun start(behavior: Behavior<T>, stacked: Boolean) // FIXME avoid boolean use an enum Stacked or Direct

    infix fun start(receiver: Receiver<T>) {
        start(Behavior(receiver))
    }

    infix fun start(behavior: Behavior<T>) {
        start(behavior, false)
    }

    fun start(receiver: Receiver<T>, stacked: Boolean) { // FIXME avoid boolean use an enum Stacked or Direct
        start(Behavior(receiver), stacked)
    }

    fun finish()

}
