package io.smallibs.aktor

import io.smallibs.aktor.runner.CoroutineBasedRunner
import io.smallibs.aktor.runner.ThreadBasedRunner
import java.util.concurrent.Executors

interface ActorRunner {

    fun execute(run: () -> Unit)

    companion object {
        fun coroutine(): ActorRunner =
            CoroutineBasedRunner()

        fun threaded(nbThread: Int? = null): ActorRunner {
            val nb = nbThread ?: Runtime.getRuntime().availableProcessors()
            return ThreadBasedRunner(nb.coerceAtLeast(2))
        }
    }

}
