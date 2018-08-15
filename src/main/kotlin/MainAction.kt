import com.intellij.openapi.actionSystem.ActionManager
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class MainAction : AnAction() {

    companion object {
        const val SLOT_1 = "kwick.action.1"
        const val SLOT_2 = "kwick.action.2"
        const val SLOT_3 = "kwick.action.3"
        const val SLOT_4 = "kwick.action.4"
        const val SLOT_5 = "kwick.action.5"
    }

    override fun actionPerformed(e: AnActionEvent) {
        handleAction(ActionManager.getInstance().getId(this))
    }

    private fun handleAction(action: String) = when (action) {
        SLOT_1 -> {}
        SLOT_2 -> {}
        SLOT_3 -> {}
        SLOT_4 -> {}
        SLOT_5 -> {}
        else -> {}
    }
}