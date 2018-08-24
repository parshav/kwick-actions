import com.intellij.ide.util.PropertiesComponent
import com.intellij.openapi.actionSystem.ActionManager

object DataStore {

    const val KEY = "kwick.storage.key"

    private val pc by lazy {  PropertiesComponent.getInstance() }

    fun updateData(values: Array<String>) = pc.setValues(KEY, values)

    fun getData() = pc.getValues(KEY)

    fun getCommand(id: Int) = getData()?.let {
            if (id + 1 > it.size) "" else it[id] } ?: run { "" }
}