package sheridancollege.chhapari.chandanchhaparia_assignment2

import android.os.Bundle
import android.text.style.ImageSpan
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class SecondActivity : AppCompatActivity() {
    lateinit var mDb : CDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_second)

        mDb = CDatabase.getInstance(applicationContext)
        var textView1 = findViewById<TextView>(R.id.textView)
        var a:ImageSpan
        var list1 = arrayListOf<Int>()
        doAsync{
            val countrylist = mDb.Dao().getAll()

            uiThread{
                Toast.makeText(this@SecondActivity,"records found.", Toast.LENGTH_SHORT).show()

                textView1.text = "" // Display the students in text view with grade
                for (c in countrylist){
                    var image = R.drawable.canada
                    list1.add(image)
                   // findViewById<ListView>(R.id.list1).text =
                  // textView1.append("Country Name")
                    textView1.append(" ${c.countryName} :${c.goldMedals} : ${c.silverMedals} : ${c.bronzeMedals}\n")
                }



                var radio = findViewById<RadioGroup>(R.id.rg)
                radio.setOnCheckedChangeListener{rG,r->
                    when (r){
                     R.id.radioButton-> {
                         doAsync {
                             val countrylist = mDb.Dao().getOrderByName()

                             uiThread {
                                 Toast.makeText(
                                     this@SecondActivity,
                                     "records found.",
                                     Toast.LENGTH_SHORT
                                 ).show()

                                 textView1.text = "" // Display the students in text view with grade
                                 for (c in countrylist) {
                                     // textView1.append("Country Name")
                                     textView1.append(" ${c.countryName} :${c.goldMedals} : ${c.silverMedals} : ${c.bronzeMedals}\n")
                                 }

                             }
                         }
                     }

                        R.id.radioButton2->{
                            val countrylist = mDb.Dao().getOrderByTotalMedals()

                        }
                        R.id.radioButton3->{
                            val countrylist = mDb.Dao().getOrderByGoldMedals()

                        }
                    }

                }




            }
        }




    }
}