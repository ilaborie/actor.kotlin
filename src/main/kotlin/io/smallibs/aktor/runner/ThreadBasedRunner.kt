package io.smallibs.aktor.runner

import io.smallibs.aktor.ActorRunner
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ThreadBasedRunner(nbThread: Int) : ActorRunner {

    private val actorService: ExecutorService = Executors.newFixedThreadPool(nbThread)

    override fun execute(run: () -> Unit) {
        this.actorService.execute(run)
    }

}
