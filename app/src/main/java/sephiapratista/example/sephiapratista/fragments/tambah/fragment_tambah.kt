package sephiapratista.example.sephiapratista.fragments.tambah

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.sephiapratista.sephiapratista.R
import sephiapratista.example.sephiapratista.model.Jadwal
import sephiapratista.example.sephiapratista.viewmodel.JadwalViewModel
import kotlinx.android.synthetic.main.fragment_tambah.*
import kotlinx.android.synthetic.main.fragment_tambah.view.*

class fragment_tambah : Fragment() {

    private lateinit var mJadwalViewModel: JadwalViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tambah, container, false)

        mJadwalViewModel = ViewModelProvider(this).get(JadwalViewModel::class.java)

        view.btn_add.setOnClickListener {
            masukkanDataKeDatabase()
        }
        return view
    }
    private fun masukkanDataKeDatabase(){
        val hari = edt_hari.text.toString()
        val jam = edt_jam.text.toString()
        val menit = edt_menit.text.toString()
        val waktu = jam + ":" + menit
        val mk = edt_nama_mk.text.toString()
        val nm_dosen = edt_nm_dosen.text.toString()

        if (cekInput(hari, jam, menit, mk, nm_dosen)){
            val jadwal = Jadwal(0, hari, waktu, mk, nm_dosen)

            mJadwalViewModel.tambahJadwal(jadwal)
            Toast.makeText(requireContext(), "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show()

            //navigasi kembali
            findNavController().navigate(R.id.action_fragment_tambah_to_fragment_list)
        }else {
            Toast.makeText(requireContext(), "Silahkan isi dulu datanya", Toast.LENGTH_SHORT).show()
        }
    }

    private fun cekInput(
        hari: String,
        jam: String,
        menit: String,
        mk: String,
        dosen: String
    ):Boolean {
        return !(TextUtils.isEmpty(hari) && TextUtils.isEmpty(jam) && TextUtils.isEmpty(menit) &&
                TextUtils.isEmpty(mk) && TextUtils.isEmpty(dosen))
    }
}
