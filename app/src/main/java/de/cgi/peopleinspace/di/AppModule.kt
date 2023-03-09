package de.cgi.peopleinspace.di

import de.cgi.peopleinspace.issposition.ISSPositionViewModel
import de.cgi.peopleinspace.persondetails.PersonDetailsViewModel
import de.cgi.peopleinspace.personlist.PersonListViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::PersonListViewModel)
    viewModelOf(::PersonDetailsViewModel)
    viewModelOf(::ISSPositionViewModel)
}
