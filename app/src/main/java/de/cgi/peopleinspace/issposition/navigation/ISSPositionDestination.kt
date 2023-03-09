package de.cgi.peopleinspace.issposition.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import de.cgi.peopleinspace.issposition.ISSPositionRoute
import de.cgi.peopleinspace.navigation.PeopleInSpaceNavigationDestination


object ISSPositionDestination : PeopleInSpaceNavigationDestination {
    override val route = "iss_position_route"
    override val destination = "iss_position_destination"
}

fun NavGraphBuilder.issPositionGraph() {
    composable(route = ISSPositionDestination.route) {
        ISSPositionRoute()
    }
}
