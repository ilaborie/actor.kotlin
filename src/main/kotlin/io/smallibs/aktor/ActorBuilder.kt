package io.smallibs.aktor

interface ActorBuilder {

    infix fun <R> actorFor(receiver: Receiver<R>): ActorReference<R> =
        actorFor(receiver, null) // FIXME not nullable

    fun <R> actorFor(receiver: Receiver<R>, name: String?): ActorReference<R> =
        actorFor(Behavior(receiver), name)

    infix fun <R> actorFor(behavior: Behavior<R>): ActorReference<R> =
        actorFor(behavior, null) // FIXME not nullable

    // FIXME name not nullable, lets use a random one here
    fun <R> actorFor(behavior: Behavior<R>, name: String?): ActorReference<R>

}
