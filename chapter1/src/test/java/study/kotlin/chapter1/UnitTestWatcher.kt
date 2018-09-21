package study.kotlin.chapter1

import org.junit.Rule
import org.junit.rules.TestWatcher
import org.junit.runner.Description

open class UnitTestWatcher {

    private var timestamp: Long = 0L

    @Rule
    @JvmField
    val watcher = object : TestWatcher() {
        override fun starting(description: Description) {
            super.starting(description)
            println("- RUNNING ${description.methodName} ...")
            timestamp = System.currentTimeMillis()
        }

        override fun succeeded(description: Description) {
            super.succeeded(description)
            println("> SUCCESS in ${System.currentTimeMillis() - timestamp}ms")
        }

        override fun failed(e: Throwable?, description: Description?) {
            super.failed(e, description)
            println("> FAILURE in ${System.currentTimeMillis() - timestamp}ms")
        }
    }
}
