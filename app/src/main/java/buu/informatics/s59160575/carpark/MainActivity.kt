package buu.informatics.s59160575.carpark

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import buu.informatics.s59160575.carpark.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val carModel :CarModel= CarModel("", "", "", "")
    private val carModelTwo :CarModel= CarModel("", "", "", "")
    private val carModelThree :CarModel= CarModel("", "", "", "")
    var model = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.boxOne.setOnClickListener(){
            model = 1
            showCarModel(it)
        }

        binding.updateButton.setOnClickListener(){
            addInfo(it)
        }

        binding.deleteButton.setOnClickListener(){
            clearAll(it)
        }

        binding.carModel = this@MainActivity.carModel

    }

    private fun hindEdit() {

        binding.idcarEdit.visibility = View.GONE
        binding.modelEdit.visibility = View.GONE
        binding.nameEdit.visibility = View.GONE


    }

    private fun showCarModel(view: View) {
        binding.apply {
            if(model == 1){

                idcarTextView.visibility = View.GONE
                modelText.visibility = View.GONE
                nameText.visibility = View.GONE
                idcarEdit.visibility = View.VISIBLE
                modelEdit.visibility = View.VISIBLE
                nameEdit.visibility = View.VISIBLE

                if(carModel?.status == "True"){
                    idcarEdit.setText( carModel?.id_car)
                    idcarEdit.setText( carModel?.model)
                    idcarEdit.setText( carModel?.name)
                    boxOne.setBackgroundColor(Color.RED)
                }



            }

            invalidateAll()

        }

    }
    private fun clearAll(view: View) {
        binding.apply {
            carModel?.id_car = ""
            carModel?.model = ""
            carModel?.name = ""
            carModel?.status = ""
            idcarEdit.setText("")
            modelEdit.setText("")
            nameEdit.setText("")
            idcarTextView.visibility = View.GONE
            modelText.visibility = View.GONE
            nameText.visibility = View.GONE
            idcarEdit.visibility = View.VISIBLE
            modelEdit.visibility = View.VISIBLE
            nameEdit.visibility = View.VISIBLE

            if(model == 1){
                boxOne.setBackgroundColor(Color.GREEN)
            }


        }
    }

    private fun addInfo(view: View) {

        binding.apply {
            carModel?.id_car = "ทะเบียน :  " + idcarEdit.text.toString()
            carModel?.model = "รุ่น :  " + modelEdit.text.toString()
            carModel?.name = "เจ้าของ :  " + nameEdit.text.toString()
            carModel?.status = "True"

            idcarEdit.visibility = View.GONE
            modelEdit.visibility = View.GONE
            nameEdit.visibility = View.GONE
            idcarTextView.visibility = View.VISIBLE
            modelText.visibility = View.VISIBLE
            nameText.visibility = View.VISIBLE

            if(model == 1){
                boxOne.setBackgroundColor(Color.RED)
            }

            invalidateAll()
        }
    }


}
