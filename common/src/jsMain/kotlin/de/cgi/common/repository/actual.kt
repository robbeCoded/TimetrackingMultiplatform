package de.cgi.common.repository

import de.cgi.common.di.PeopleInSpaceDatabaseWrapper
import io.ktor.client.engine.js.*
import org.koin.dsl.module

actual fun platformModule() = module {
    single {
        PeopleInSpaceDatabaseWrapper(null)
    }
    single { Js.create() }
}
