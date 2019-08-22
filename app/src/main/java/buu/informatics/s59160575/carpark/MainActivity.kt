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

        binding.boxTwo.setOnClickListener(){
            model = 2
            showCarModel(it)
        }

        binding.boxThree.setOnClickListener(){
            model = 3
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


    private fun showCarModel(view: View) {
        binding.apply {
            if(model == 1){

                if(carModel?.status == "True"){
                    idcarEdit.setText( carModel?.id_car)
                    modelEdit.setText( carModel?.model)
                    nameEdit.setText( carModel?.name)
                    boxOne.setBackgroundColor(Color.RED)
                }else{
                    idcarEdit.setText("")
                    modelEdit.setText("")
                    nameEdit.setText("")
                }
            }
            if(model == 2){

                if(carModelTwo?.status == "True"){
                    idcarEdit.setText( carModelTwo?.id_car)
                    modelEdit.setText( carModelTwo?.model)
                    nameEdit.setText( carModelTwo?.name)
                }else{
                    idcarEdit.setText("")
                    modelEdit.setText("")
                    nameEdit.setText("")
                }
            }
            if(model == 3){

                if(carModelThree?.status == "True"){
                    idcarEdit.setText( carModelThree?.id_car)
                    modelEdit.setText( carModelThree?.model)
                    nameEdit.setText( carModelThree?.name)
                }else{
                    idcarEdit.setText("")
                    modelEdit.setText("")
                    nameEdit.setText("")
                }
            }

            invalidateAll()

        }

    }
    private fun clearAll(view: View) {
        binding.apply {

            idcarEdit.setText("")
            modelEdit.setText("")
            nameEdit.setText("")

            if(model == 1){
                carModel?.id_car = ""
                carModel?.model = ""
                carModel?.name = ""
                carModel?.status = ""
                boxOne.text = "ว่าง"
                boxOne.setBackgroundColor(Color.GREEN)
            }
            if(model == 2){
                carModelTwo?.id_car = ""
                carModelTwo?.model = ""
                carModelTwo?.name = ""
                carModelTwo?.status = ""
                boxTwo.text = "ว่าง"
                boxTwo.setBackgroundColor(Color.GREEN)
            }
            if(model == 3){
                carModelThree?.id_car = ""
                carModelThree?.model = ""
                carModelThree?.name = ""
                carModelThree?.status = ""
                boxThree.text = "ว่าง"
                boxThree.setBackgroundColor(Color.GREEN)
            }


        }
    }

    private fun addInfo(view: View) {

        binding.apply {


            if(model == 1){
                carModel?.id_car = "ทะเบียน :  " + idcarEdit.text.toString()
                carModel?.model = "รุ่น :  " + modelEdit.text.toString()
                carModel?.name = "เจ้าของ :  " + nameEdit.text.toString()
                carModel?.status = "True"
                boxOne.text = "ไม่ว่าง"
                boxOne.setBackgroundColor(Color.RED)
            }
            if(model == 2){
                carModelTwo?.id_car = "ทะเบียน :  " + idcarEdit.text.toString()
                carModelTwo?.model = "รุ่น :  " + modelEdit.text.toString()
                carModelTwo?.name = "เจ้าของ :  " + nameEdit.text.toString()
                carModelTwo?.status = "True"
                boxTwo.text = "ไม่ว่าง"
                boxTwo.setBackgroundColor(Color.RED)
            }
            if(model == 3){
                carModelThree?.id_car = "ทะเบียน :  " + idcarEdit.text.toString()
                carModelThree?.model = "รุ่น :  " + modelEdit.text.toString()
                carModelThree?.name = "เจ้าของ :  " + nameEdit.text.toString()
                carModelThree?.status = "True"
                boxThree.text = "ไม่ว่าง"
                boxThree.setBackgroundColor(Color.RED)
            }


            invalidateAll()
        }
    }


}
