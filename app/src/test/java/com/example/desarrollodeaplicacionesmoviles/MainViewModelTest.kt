import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.Assert.*
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations



class MainViewModelTest {
    @Rule
    var instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private val observer: Observer<String>? = null
    private var viewModel: MainViewModel? = null
    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = MainViewModel()
        viewModel!!.getResult().observeForever(observer!!)
    }

    @Test
    fun testCompareStrings() {
        viewModel!!.compareStrings("hello", "world")
        Mockito.verify(observer).onChanged("Las cadenas son diferentes.")
    }
}