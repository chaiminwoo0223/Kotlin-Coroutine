import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

fun main() {
    CoroutineName("나만의 코루틴") + Dispatchers.Default
    val threadPool = Executors.newSingleThreadExecutor()
    CoroutineScope(threadPool.asCoroutineDispatcher()).launch {
        printWithThread("새로운 코루틴")
    }
}

suspend fun example13() {
    val job = CoroutineScope(Dispatchers.Default).launch {
        delay(1_000L)
        printWithThread("Job 1")
        // coroutineContext.minusKey(CoroutineName.Key)
    }

    job.join()
}

class AsyncLogic {
    private val scope = CoroutineScope(Dispatchers.Default)

    fun doSomething() {
        scope.launch {
            // 무언가 코루틴이 시작되어 작업!
        }
    }

    fun destroy() {
        scope.cancel()
    }
}
