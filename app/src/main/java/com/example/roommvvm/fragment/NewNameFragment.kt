package com.example.roommvvm.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders

import com.example.roommvvm.R
import com.example.roommvvm.viewmodel.NewStudentViewModel
import kotlinx.android.synthetic.main.fragment_new_name.*

/**
 * A simple [Fragment] subclass.
 */
class NewNameFragment : Fragment() {

    private var listener: OnFragmentInteractionListener? = null

    private lateinit var mViewModel: NewStudentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewModel = ViewModelProviders.of(this).get(NewStudentViewModel::class.java)
    }
    // untuk memanggil viewmodel class NewStudentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_name, container, false)
    }
    //untuk memeriksa apakah di kolom edit text sudah terisi atau belum kalau belum ada text nama dibutuhkan
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button.setOnClickListener {
            val input = editText.text.toString().trim()

            if (input.isEmpty()) {
                Toast.makeText(activity, "Nama dibutuhkan", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
    //mengecek apakah edittext terlalu panjang apa tidak kalau panjang ada text nama terlalu panjang
            if (input.length > 30) {
                Toast.makeText(activity, "Nama terlalu panjang", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

           // berfungsi untuk passing data input ke fungsi storeMovie pada class NewStudentViewModel
            mViewModel.storeMovie(input)

            Toast.makeText(activity, "$input entered", Toast.LENGTH_SHORT).show()
            listener?.goToStudentListFragment()
        }
    }
    //untuk mengetahui interaksi  fragment
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
    //untuk merubah fragment menjadi daftar  nama
    interface OnFragmentInteractionListener {
        fun goToStudentListFragment()
    }

    companion object {
        @JvmStatic
        fun newInstance() = NewNameFragment()
    }
}
