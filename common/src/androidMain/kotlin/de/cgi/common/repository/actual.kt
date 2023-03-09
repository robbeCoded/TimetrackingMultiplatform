package de.cgi.common.repository

import com.squareup.sqldelight.android.AndroidSqliteDriver
import de.cgi.common.di.PeopleInSpaceDatabaseWrapper
import de.cgi.peopleinspace.db.PeopleInSpaceDatabase
import io.ktor.client.engine.android.*
import org.koin.dsl.module



actual fun platformModule() = module {
    single {
        val driver =
            AndroidSqliteDriver(PeopleInSpaceDatabase.Schema, get(), "peopleinspace.db")

        PeopleInSpaceDatabaseWrapper(PeopleInSpaceDatabase(driver))
    }
    single { Android.create() }
}
