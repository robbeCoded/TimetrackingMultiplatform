package de.cgi.peopleinspace.persondetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.cgi.common.remote.Assignment
import de.cgi.common.repository.PeopleInSpaceRepositoryInterface
import de.cgi.peopleinspace.persondetails.navigation.PersonDetailsDestination
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

data class PersonDetailsUiState(
    val person: Assignment? = null,
    val isLoading: Boolean = false,
    val userMessage: Int? = null
)

class PersonDetailsViewModel(
    savedStateHandle: SavedStateHandle,
    peopleInSpaceRepository: PeopleInSpaceRepositoryInterface,
) : ViewModel() {

    private val personName: String? = savedStateHandle[PersonDetailsDestination.personArg]

    val uiState = peopleInSpaceRepository.fetchPeopleAsFlow()
        .map { list ->
            val person = list.find { it.name == personName }
            PersonDetailsUiState(person)
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), PersonDetailsUiState(isLoading = true))
}
