import com.example.desarrollodeaplicacionesmoviles.R
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var compareButton: Button
    private lateinit var resultTextView: TextView
    private var viewModel: MainViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText1 = findViewById<EditText>(R.id.editText1)
        editText2 = findViewById<EditText>(R.id.editText2)
        compareButton = findViewById<Button>(R.id.compareButton)
        resultTextView = findViewById<TextView>(R.id.resultTextView)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        compareButton.setOnClickListener(View.OnClickListener {
            val text1 = editText1.getText().toString()
            val text2 = editText2.getText().toString()
            viewModel!!.compareStrings(text1, text2)
        })
        viewModel!!.getResult().observe(
            this
        ) { result: String? ->
            resultTextView.setText(
                result
            )
        }
    }
}