package de.cgi.common.repository

import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver
import de.cgi.common.di.PeopleInSpaceDatabaseWrapper
import de.cgi.peopleinspace.db.PeopleInSpaceDatabase
import io.ktor.client.engine.java.*
import org.koin.dsl.module

actual fun platformModule() = module {
    single {
        val driver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
            .also { PeopleInSpaceDatabase.Schema.create(it) }
        PeopleInSpaceDatabaseWrapper(PeopleInSpaceDatabase(driver))
    }
    single { Java.create() }
}
