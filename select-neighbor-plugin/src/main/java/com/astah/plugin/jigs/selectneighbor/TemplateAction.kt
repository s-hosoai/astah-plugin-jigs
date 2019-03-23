package com.astah.plugin.jigs.selectneighbor


import javax.swing.JOptionPane

import com.change_vision.jude.api.inf.AstahAPI
import com.change_vision.jude.api.inf.exception.ProjectNotFoundException
import com.change_vision.jude.api.inf.project.ProjectAccessor
import com.change_vision.jude.api.inf.ui.IPluginActionDelegate
import com.change_vision.jude.api.inf.ui.IWindow

class TemplateAction : IPluginActionDelegate {

    override fun run(window: IWindow): Any? {
        try {
            val api = AstahAPI.getAstahAPI()
            val projectAccessor = api.projectAccessor
            projectAccessor.project
            JOptionPane.showMessageDialog(window.parent, "Hello")
        } catch (e: ProjectNotFoundException) {
            val message = "Project is not opened.Please open the project or create new project."
            JOptionPane.showMessageDialog(window.parent, message, "Warning", JOptionPane.WARNING_MESSAGE)
        } catch (e: Exception) {
            JOptionPane.showMessageDialog(window.parent, "Unexpected error has occurred.", "Alert", JOptionPane.ERROR_MESSAGE)
            throw IPluginActionDelegate.UnExpectedException()
        }

        return null
    }
}
