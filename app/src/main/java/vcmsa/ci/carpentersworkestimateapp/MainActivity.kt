package vcmsa.ci.carpentersworkestimateapp

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import vcmsa.ci.carpentersworkestimateapp.R
◙
class MainActivity : AppCompatActivity() {

    private lateinit var woodCheckbox: CheckBox
    private lateinit var nailsCheckbox: CheckBox
    private lateinit var hingesCheckbox: CheckBox
    private lateinit var resultTextView: TextView
    private lateinit var calculateButton: Button
    private lateinit var hoursInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        woodCheckbox = findViewById(R.id.materialWood)
        nailsCheckbox = findViewById(R.id.materialNails)
        hingesCheckbox = findViewById(R.id.materialHinges)
        resultTextView = findViewById(R.id.resultText)
        calculateButton = findViewById(R.id.calculateBtn)
        hoursInput = findViewById(R.id.hoursInput)

        calculateButton.setOnClickListener {
            calculateTotal()
        }
    }

    private fun calculateTotal() {
        val hours = hoursInput.text.toString().toIntOrNull()

        if (hours == null || hours <= 0) {
            resultTextView.text = "Please enter a valid number of hours."
            return
        }

        var totalCost = 0

        if (woodCheckbox.isChecked) totalCost += 500
        if (nailsCheckbox.isChecked) totalCost += 20
        if (hingesCheckbox.isChecked) totalCost += 30

        if (totalCost == 0) {
            resultTextView.text = "Please select at least one material."
            return
        }

        val finalCost = totalCost * hours
        resultTextView.text = "Total Estimated Cost: R$finalCost.00"
    }
}
