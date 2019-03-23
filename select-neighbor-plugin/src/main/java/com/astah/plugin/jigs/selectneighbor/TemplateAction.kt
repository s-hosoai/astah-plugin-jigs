package com.astah.plugin.jigs.selectneighbor


import com.change_vision.jude.api.inf.AstahAPI
import com.change_vision.jude.api.inf.presentation.INodePresentation
import com.change_vision.jude.api.inf.ui.IPluginActionDelegate
import com.change_vision.jude.api.inf.ui.IWindow

class TemplateAction : IPluginActionDelegate {

    override fun run(window: IWindow): Any? {
        val diagramViewManager = AstahAPI.getAstahAPI().viewManager.diagramViewManager
        val targetNodes = diagramViewManager.selectedPresentations
                .filterIsInstance<INodePresentation>()
                .flatMap { node -> node.links.filter { it.source == node } }
                .map { it.target }
                .toTypedArray()
        diagramViewManager.select(targetNodes)
        return null
    }
}
