package com.example.expenselogger_test_utils

import com.example.expenselogger.executor.threading.AsyncExecutor
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineDispatcher

public class TestAsyncExecutor : AsyncExecutor {

    override val main: CoroutineDispatcher
        get() = TestCoroutineDispatcher()
    override val io: CoroutineDispatcher
        get() = TestCoroutineDispatcher()
    override val default: CoroutineDispatcher
        get() = TestCoroutineDispatcher()
}
