package de.cgi.peopleinspace

import de.cgi.common.di.PeopleInSpaceDatabaseWrapper
import de.cgi.common.di.commonModule
import de.cgi.common.repository.PeopleInSpaceRepositoryInterface
import de.cgi.common.repository.platformModule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.inject
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertTrue

class PeopleInSpaceTest: KoinTest {
    private val repo : PeopleInSpaceRepositoryInterface by inject()

    @BeforeTest
    fun setUp()  {
        Dispatchers.setMain(StandardTestDispatcher())

        startKoin{
            modules(
                commonModule(true),
                platformModule(),
                module {
                    single { PeopleInSpaceDatabaseWrapper(null) }
                }
            )
        }
    }

    @Test
    fun testGetPeople() = runTest {
        val result = repo.fetchPeople()
        println(result)
        assertTrue(result.isNotEmpty())
    }
}
