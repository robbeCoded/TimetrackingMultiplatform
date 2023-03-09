package de.cgi.peopleinspace.glance

import de.cgi.peopleinspace.glance.util.BaseGlanceAppWidgetReceiver

class ISSMapWidgetReceiver : BaseGlanceAppWidgetReceiver<ISSMapWidget>() {
    override fun createWidget(): ISSMapWidget = ISSMapWidget()
}