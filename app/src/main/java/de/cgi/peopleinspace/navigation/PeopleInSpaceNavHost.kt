package de.cgi.peopleinspace.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import de.cgi.peopleinspace.issposition.navigation.issPositionGraph
import de.cgi.peopleinspace.persondetails.navigation.PersonDetailsDestination
import de.cgi.peopleinspace.persondetails.navigation.personDetailsGraph
import de.cgi.peopleinspace.personlist.navigation.PersonListDestination
import de.cgi.peopleinspace.personlist.navigation.personListGraph

@Composable
fun PeopleInSpaceNavHost(
    navController: NavHostController,
    onNavigateToDestination: (PeopleInSpaceNavigationDestination, String) -> Unit = { _, _ -> },
    onBackClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    startDestination: String = PersonListDestination.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        personListGraph(navigateToPerson = {
            onNavigateToDestination(
                PersonDetailsDestination,
                PersonDetailsDestination.createNavigationRoute(it)
            )
        })
        personDetailsGraph(onBackClick = onBackClick)
        issPositionGraph()
    }
}
