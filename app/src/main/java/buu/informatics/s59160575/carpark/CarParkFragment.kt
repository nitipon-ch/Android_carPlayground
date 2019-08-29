package buu.informatics.s59160575.carpark


import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import buu.informatics.s59160575.carpark.databinding.FragmentCarParkBinding

/**
 * A simple [Fragment] subclass.
 */
class CarParkFragment : Fragment() {

    private val carModel :CarModel= CarModel("", "", "", "")
    private val carModelTwo :CarModel= CarModel("", "", "", "")
    private val carModelThree :CarModel= CarModel("", "", "", "")
    var model = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentCarParkBinding>(inflater,
            R.layout.fragment_car_park, container, false)

        binding.apply {
            boxOne.setOnClickListener(){
                model = 1

                showViewCard(binding)
                showCarModel(it,binding)
            }

            boxTwo.setOnClickListener(){
                model = 2
                showViewCard(binding)
                showCarModel(it,binding)
            }

            boxThree.setOnClickListener(){
                model = 3
                showViewCard(binding)
                showCarModel(it,binding)
            }

            updateButton.setOnClickListener(){
                addInfo(it,binding)
            }

            deleteButton.setOnClickListener(){
                clearAll(it,binding)
            }

            carModel = this@CarParkFragment.carModel

            showViewCard(binding)



        }

        return binding.root
    }

    private fun showViewCard(binding: FragmentCarParkBinding){

        if(model == 0){
            binding.cardViewObject.visibility = View.GONE
        }else{
            binding.cardViewObject.visibility = View.VISIBLE
        }
    }

    private fun showCarModel(view: View, binding: FragmentCarParkBinding) {
        binding.apply {
            if(model == 1){
                slotId.text = "Slot : 1"
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
                slotId.text = "Slot : 2"
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
                slotId.text = "Slot : 3"
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
    private fun clearAll(view: View , binding: FragmentCarParkBinding) {
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
                boxOne.setBackgroundColor(Color.parseColor("#8BC34A"))
            }
            if(model == 2){
                carModelTwo?.id_car = ""
                carModelTwo?.model = ""
                carModelTwo?.name = ""
                carModelTwo?.status = ""
                boxTwo.text = "ว่าง"
                boxTwo.setBackgroundColor(Color.parseColor("#8BC34A"))
            }
            if(model == 3){
                carModelThree?.id_car = ""
                carModelThree?.model = ""
                carModelThree?.name = ""
                carModelThree?.status = ""
                boxThree.text = "ว่าง"
                boxThree.setBackgroundColor(Color.parseColor("#8BC34A"))
            }


        }
    }

    private fun addInfo(view: View , binding: FragmentCarParkBinding) {

        binding.apply {


            if(model == 1){
                carModel?.id_car = idcarEdit.text.toString()
                carModel?.model = modelEdit.text.toString()
                carModel?.name = nameEdit.text.toString()
                carModel?.status = "True"
                boxOne.text = "ไม่ว่าง"
                boxOne.setBackgroundColor(Color.RED)
            }
            if(model == 2){
                carModelTwo?.id_car =   idcarEdit.text.toString()
                carModelTwo?.model = modelEdit.text.toString()
                carModelTwo?.name =  nameEdit.text.toString()
                carModelTwo?.status = "True"
                boxTwo.text = "ไม่ว่าง"
                boxTwo.setBackgroundColor(Color.RED)
            }
            if(model == 3){
                carModelThree?.id_car =  idcarEdit.text.toString()
                carModelThree?.model =  modelEdit.text.toString()
                carModelThree?.name =  nameEdit.text.toString()
                carModelThree?.status = "True"
                boxThree.text = "ไม่ว่าง"
                boxThree.setBackgroundColor(Color.RED)
            }


            invalidateAll()
        }
    }


}
