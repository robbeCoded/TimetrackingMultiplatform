package de.cgi.peopleinspace.glance

import de.cgi.peopleinspace.glance.util.BaseGlanceAppWidgetReceiver

class PeopleInSpaceWidgetReceiver : BaseGlanceAppWidgetReceiver<PeopleInSpaceWidget>() {
    override fun createWidget(): PeopleInSpaceWidget = PeopleInSpaceWidget()
}