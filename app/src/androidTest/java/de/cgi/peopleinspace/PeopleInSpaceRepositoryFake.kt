package de.cgi.peopleinspace

import de.cgi.common.remote.Assignment
import de.cgi.common.remote.IssPosition
import de.cgi.common.repository.PeopleInSpaceRepositoryInterface
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class PeopleInSpaceRepositoryFake: PeopleInSpaceRepositoryInterface {
    val peopleList = listOf(Assignment("Apollo 11", "Neil Armstrong"),
        Assignment("Apollo 11", "Buzz Aldrin"))

    val issPosition = IssPosition(53.2743394, -9.0514163)

    override fun fetchPeopleAsFlow(): Flow<List<Assignment>> {
        return flowOf(peopleList)
    }

    override fun pollISSPosition(): Flow<IssPosition> {
        return flowOf(issPosition)
    }

    override suspend fun fetchPeople(): List<Assignment> {
        return emptyList()
    }

    override suspend fun fetchAndStorePeople() {
    }
}
