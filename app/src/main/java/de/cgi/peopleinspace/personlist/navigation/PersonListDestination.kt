package de.cgi.peopleinspace.personlist.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import de.cgi.peopleinspace.navigation.PeopleInSpaceNavigationDestination
import de.cgi.peopleinspace.personlist.PersonListRoute

object PersonListDestination : PeopleInSpaceNavigationDestination {
    override val route = "person_list_route"
    override val destination = "person_list_destination"
}

fun NavGraphBuilder.personListGraph(navigateToPerson: (String) -> Unit) {
    composable(route = PersonListDestination.route) {
        PersonListRoute(navigateToPerson)
    }
}
