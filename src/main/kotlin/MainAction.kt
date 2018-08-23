import com.intellij.openapi.actionSystem.ActionManager
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.popup.JBPopupFactory
import com.intellij.openapi.ui.popup.Balloon
import com.intellij.ui.awt.RelativePoint
import com.intellij.openapi.actionSystem.DataKeys
import com.intellij.openapi.ui.MessageType
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.wm.WindowManager
import java.util.*


class MainAction : AnAction() {

    companion object {
        const val SLOT_0 = "kwick.mainaction.0"
        const val SLOT_1 = "kwick.mainaction.1"
        const val SLOT_2 = "kwick.mainaction.2"
        const val SLOT_3 = "kwick.mainaction.3"
    }

    var event: AnActionEvent? = null

    override fun actionPerformed(e: AnActionEvent) {

        event = e
        handleAction(ActionManager.getInstance().getId(this))
    }

    private fun handleAction(action: String) = when (action) {

        SLOT_0 -> {
            ShortcutDialog.display()
        }
        SLOT_1 -> {
            validateAndAct(0)
        }
        SLOT_2 -> {
            validateAndAct(1)
        }
        SLOT_3 -> {
            validateAndAct(2)
        }
        else -> { }
    }

    private fun validateAndAct(id: Int) {
        val command = Main.getCommand(id)
        if (command.isNotEmpty()) {
            Runtime.getRuntime().exec(command)
            popup("Ran command $command")
        } else {
            popup("No Command found.")
        }
    }

    private fun popup(text: String) {
        val statusBar = WindowManager.getInstance()
                .getStatusBar(DataKeys.PROJECT.getData(event!!.dataContext))

        JBPopupFactory.getInstance()
                .createHtmlTextBalloonBuilder(text, MessageType.INFO, null)
                .setFadeoutTime(7500)
                .createBalloon()
                .show(RelativePoint.getCenterOf(statusBar.component),
                        Balloon.Position.atRight)
    }
}