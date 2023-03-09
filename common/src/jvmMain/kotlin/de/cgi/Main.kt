package de.cgi

import de.cgi.common.di.initKoin
import de.cgi.common.remote.PeopleInSpaceApi
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val koin = initKoin(enableNetworkLogs = true).koin
        val api = koin.get<PeopleInSpaceApi>()
        println(api.fetchPeople())
    }
}
