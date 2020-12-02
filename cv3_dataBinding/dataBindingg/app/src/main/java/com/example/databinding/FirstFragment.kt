package com.example.databinding

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.databinding.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null // nullable
    private val binding get() =_binding as FragmentFirstBinding // getter of non-nullable

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_first, container, false)
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container,
            false)

       // binding.textviewFirst.text = getString(R.string.app_name)

        binding.person = Person("John" ,"Doe")

        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // view.findViewById<Button>(R.id.button_first).setOnClickListener
        binding.buttonFirst.setOnClickListener {
          //  findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            Log.v("ERROR", binding.person?.name.toString())

            binding.apply {
                person?.name = binding.editText.text.toString()
                invalidateAll()
            }
        }
    }
}