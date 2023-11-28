package com.Register.App.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.Register.App.R
import com.Register.App.data.network.ApiFactory
import com.Register.App.databinding.FragmentLoginBinding
import com.Register.App.domain.entities.User
import javax.inject.Inject

class LoginFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (requireActivity().application as AuthApp).component
    }

    private lateinit var viewModel: MainViewModel

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding
        get() = _binding ?: throw RuntimeException("FragmentLoginBinding == null")

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity(), viewModelFactory)[MainViewModel::class.java]
        binding.buttonLogin.setOnClickListener {
            val login = binding.editTextLogin.text.toString()
            val password = binding.editTextPassword.text.toString()
            val user = User(login, password)
            viewModel.login(user)
            viewModel.token.observe(viewLifecycleOwner) {
                viewModel.getPayment(it)
                launchPaymentFragment()
            }
            viewModel.errorMessage.observe(viewLifecycleOwner) { errorMessage ->
                if (errorMessage != null) {
                    Toast.makeText(
                        requireActivity().applicationContext,
                        "Error! Login or password is empty",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun launchPaymentFragment() {
        findNavController().navigate(R.id.action_loginFragment_to_paymentsFragment)
    }

}