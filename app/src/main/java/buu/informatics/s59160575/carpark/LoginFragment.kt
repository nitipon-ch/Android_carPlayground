package buu.informatics.s59160575.carpark


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59160575.carpark.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_login, container, false)

        binding.loginButton.setOnClickListener{
            if (usernameEdit.text.toString() == "admin" && passwordEdit.text.toString() == "password"){
                    view!!.findNavController().navigate(R.id.action_loginFragment_to_carParkFragment)
            }else{
                binding.errorText.text = "username or password is not match!!"
            }
        }

        return binding.root
    }


}
