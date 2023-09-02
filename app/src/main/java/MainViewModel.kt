import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val result = MutableLiveData<String>()
    fun getResult(): LiveData<String> {
        return result
    }

    fun compareStrings(text1: String, text2: String) {
        if (text1 == text2) {
            result.setValue("Las cadenas son iguales.")
        } else {
            result.setValue("Las cadenas son diferentes.")
        }
    }
}
