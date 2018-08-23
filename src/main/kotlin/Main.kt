import com.intellij.ide.util.PropertiesComponent
import com.intellij.openapi.actionSystem.ActionManager

object Main {

    const val KEY = "kwick.storage.key"

    private val pc = PropertiesComponent.getInstance()

    fun updateData(values: Array<String>) = pc.setValues(KEY, values)

    fun getData() = pc.getValues(KEY)
}