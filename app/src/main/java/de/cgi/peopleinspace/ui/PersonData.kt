package de.cgi.peopleinspace.ui

import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import de.cgi.common.remote.Assignment

class PersonProvider : CollectionPreviewParameterProvider<Assignment>(
    listOf(
        Assignment("ISS", "Chris Cassidy"),
        Assignment("ISS", "Anatoli Ivanishin")
    )
)
