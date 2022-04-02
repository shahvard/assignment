package sheridancollege.chhapari.chandanchhaparia_assignment2

import android.os.Bundle
import android.text.style.ImageSpan
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class SecondActivity : AppCompatActivity() {
    lateinit var mDb : CDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_second)

        //var iLV = findViewById<ListView>(R.id.imgList)
        var cLV = findViewById<ListView>(R.id.countryList)
        var gLV = findViewById<ListView>(R.id.gList)
        var sLV = findViewById<ListView>(R.id.sList)
        var bLV = findViewById<ListView>(R.id.bList)



        var cArray: ArrayList<String> = arrayListOf()
        var imgArray: ArrayList<Int> = arrayListOf()
        var gArray: ArrayList<Int> = arrayListOf()
        var sArray: ArrayList<Int> = arrayListOf()
        var bArray: ArrayList<Int> = arrayListOf()


        mDb = CDatabase.getInstance(applicationContext)
        //var textView1 = findViewById<TextView>(R.id.textView)
        //var a:ImageSpan
        //var list1 = arrayListOf<Int>()

        var radio = findViewById<RadioGroup>(R.id.rg)
        radio.setOnCheckedChangeListener{rG,r->
            when (r){
                R.id.radioButton-> {
                    /*doAsync {
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
                    }*/
                    doAsync{
                        val countrylist = mDb.Dao().getAll()

                        uiThread{
                            Toast.makeText(this@SecondActivity,"records found.", Toast.LENGTH_SHORT).show()

                            //textView1.text = "" // Display the students in text view with grade
                            for (c in countrylist){
                                cArray.add(c.countryName)
                                gArray.add(c.goldMedals)
                                sArray.add(c.silverMedals)
                                bArray.add(c.bronzeMedals)
                                // findViewById<ListView>(R.id.list1).text =
                                // textView1.append("Country Name")
                                //textView1.append(" ${c.countryName} :${c.goldMedals} : ${c.silverMedals} : ${c.bronzeMedals}\n")
                            }

                            cLV.adapter = ArrayAdapter(this@SecondActivity, android.R.layout.simple_list_item_1, cArray)
                            gLV.adapter = ArrayAdapter(this@SecondActivity, android.R.layout.simple_list_item_1, gArray)
                            sLV.adapter = ArrayAdapter(this@SecondActivity, android.R.layout.simple_list_item_1, sArray)
                            bLV.adapter = ArrayAdapter(this@SecondActivity, android.R.layout.simple_list_item_1, bArray)

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