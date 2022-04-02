package sheridancollege.chhapari.chandanchhaparia_assignment2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import sheridancollege.chhapari.chandanchhaparia_assignment2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var countrySpinner: Spinner
    lateinit var gold: TextView
    lateinit var silver: TextView
    lateinit var bronze: TextView
    lateinit var countryname: String
    private lateinit var binding: ActivityMainBinding
    private lateinit var mDb: CDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view= binding.root
        setContentView(view)
        mDb = CDatabase.getInstance(applicationContext)

        countrySpinner = binding.spinner
        gold = binding.txtGold
        silver = binding.txtSilver
        bronze = binding.txtBronze
        val countryList = arrayOf(
            "ROC", "Norway", "China", "France", "United States", "Sweden", "Netherlands", "Austria",
            "Switzerland", "Germany", "Japan", "Canada"
        )
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countryList)
        countrySpinner.adapter = arrayAdapter


        countrySpinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                countryname = countryList[position]

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(this@MainActivity, "Country Not Selected", Toast.LENGTH_SHORT).show()
            }

        }

        binding.btnSave.setOnClickListener{
            val country = Entity(0,
               countryName = countryname,
                goldMedals = Integer.parseInt(gold.text.toString()),
                silverMedals=Integer.parseInt(silver.text.toString()),
                bronzeMedals = Integer.parseInt(bronze.text.toString())
            )
            GlobalScope.launch {

                mDb.Dao().insert(country)
                runOnUiThread {

                    Toast.makeText(this@MainActivity,"record inserted",Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.btnView.setOnClickListener{
            var intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}
