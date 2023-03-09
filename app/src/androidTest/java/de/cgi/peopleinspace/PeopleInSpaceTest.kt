package de.cgi.peopleinspace

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import de.cgi.peopleinspace.issposition.ISSPositionMapTag
import de.cgi.peopleinspace.issposition.ISSPositionScreen
import de.cgi.peopleinspace.issposition.ISSPositionUiState
import de.cgi.peopleinspace.issposition.IssPositionKey
import de.cgi.peopleinspace.personlist.PersonListScreen
import de.cgi.peopleinspace.personlist.PersonListTag
import de.cgi.peopleinspace.personlist.PersonListUiState
import org.junit.Rule
import org.junit.Test

class PeopleInSpaceTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val peopleInSpaceRepository = de.cgi.peopleinspace.PeopleInSpaceRepositoryFake()

    @Test
    fun testPeopleListScreen() {
        composeTestRule.setContent {
            PersonListScreen(uiState = PersonListUiState(peopleInSpaceRepository.peopleList), navigateToPerson = {}, onRefresh = {})
        }

        val peopleList = peopleInSpaceRepository.peopleList
        val personListNode = composeTestRule.onNodeWithTag(PersonListTag)
        personListNode.assertIsDisplayed()
            .onChildren().assertCountEquals(peopleList.size)

        peopleList.forEachIndexed { index, person ->
            val rowNode = personListNode.onChildAt(index)
            rowNode.assertTextContains(person.name)
            rowNode.assertTextContains(person.craft)
        }
    }

    @Test
    fun testISSPositionScreen() {
        composeTestRule.setContent {
            ISSPositionScreen(uiState = ISSPositionUiState(peopleInSpaceRepository.issPosition))
        }

        composeTestRule.onNodeWithTag(ISSPositionMapTag).assertIsDisplayed()

        val expectedIssPosition = peopleInSpaceRepository.issPosition
        composeTestRule
            .onNode(SemanticsMatcher.expectValue(IssPositionKey, expectedIssPosition))
            .assertExists()
    }

}
