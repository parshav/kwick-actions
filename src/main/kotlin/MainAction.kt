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
        const val SLOT_1 = "kwick.mainaction.1"
        const val SLOT_2 = "kwick.mainaction.2"
        const val SLOT_3 = "kwick.mainaction.3"
        const val SLOT_4 = "kwick.mainaction.4"
        const val SLOT_5 = "kwick.mainaction.5"

        const val KEY = "kwick.storage.key"
    }

    val dummyData = arrayOf("Data 1", "Data 2")

    init {
        PropertiesComponent.getInstance().setValues(KEY, dummyData)
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

    private fun handleAction(action: String): String = when (action) {
        SLOT_1 -> { SLOT_1 }
        SLOT_2 -> { SLOT_2 }
        SLOT_3 -> { SLOT_3 }
        SLOT_4 -> { SLOT_4 }
        SLOT_5 -> { SLOT_5 }
        else -> { "NOPE" }
    }
}