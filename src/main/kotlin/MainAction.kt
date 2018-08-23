import com.intellij.ide.util.PropertiesComponent
import com.intellij.openapi.actionSystem.ActionManager
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.popup.JBPopupFactory
import com.intellij.openapi.ui.popup.Balloon
import com.intellij.ui.awt.RelativePoint
import com.intellij.openapi.actionSystem.DataKeys
import com.intellij.openapi.ui.MessageType
import com.intellij.openapi.wm.WindowManager


class MainAction : AnAction() {

    companion object {
        const val SLOT_0 = "kwick.mainaction.0"
        const val SLOT_1 = "kwick.mainaction.1"
        const val SLOT_2 = "kwick.mainaction.2"
        const val SLOT_3 = "kwick.mainaction.3"

    }

    override fun actionPerformed(e: AnActionEvent) {

        //val r = handleAction(ActionManager.getInstance().getId(this))
//        Messages.showMessageDialog("Action", "SLOT : $r", Messages.getInformationIcon())

        ShortcutDialog.display()

        val statusBar = WindowManager.getInstance()
                .getStatusBar(DataKeys.PROJECT.getData(e.getDataContext()))

        JBPopupFactory.getInstance()
                .createHtmlTextBalloonBuilder("hello world", MessageType.INFO, null)
                .setFadeoutTime(7500)
                .createBalloon()
                .show(RelativePoint.getCenterOf(statusBar.getComponent()),
                        Balloon.Position.atRight)
    }

    private fun handleAction(action: String) = when (action) {
        SLOT_0 -> { SLOT_0 }
        SLOT_1 -> { SLOT_1 }
        SLOT_2 -> { SLOT_2 }
        SLOT_3 -> { SLOT_3 }
        else -> { "NOPE" }
    }
}