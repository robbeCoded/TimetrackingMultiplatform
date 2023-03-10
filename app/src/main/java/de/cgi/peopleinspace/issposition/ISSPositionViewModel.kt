package de.cgi.peopleinspace.issposition

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.cgi.common.remote.IssPosition
import de.cgi.common.repository.PeopleInSpaceRepositoryInterface
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

data class ISSPositionUiState(
    val position: IssPosition = IssPosition(0.0,0.0),
    val isLoading: Boolean = false,
    val userMessage: Int? = null
)

class ISSPositionViewModel(
    peopleInSpaceRepository: PeopleInSpaceRepositoryInterface
) : ViewModel() {

    val uiState = peopleInSpaceRepository.pollISSPosition()
        .map {
            ISSPositionUiState(it)
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), ISSPositionUiState(isLoading = true))

}
