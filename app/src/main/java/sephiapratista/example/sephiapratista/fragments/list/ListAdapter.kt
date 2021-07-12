package sephiapratista.example.sephiapratista.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.sephiapratista.sephiapratista.R
import sephiapratista.example.sephiapratista.model.Jadwal
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>(){

    private var jadwalList = emptyList<Jadwal>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val curItem = jadwalList[position]
        holder.itemView.tx_hari.text = curItem.hari
        holder.itemView.tx_jam.text = curItem.waktu
        holder.itemView.tx_nama_mk.text = curItem.mataKuluah
        holder.itemView.tx_nama_dosen.text = curItem.namaDosen

        holder.itemView.cl_custom_row_layout.setOnClickListener{
            val aksi = fragment_listDirections.actionFragmentListToFragmentUpdate(curItem)
            holder.itemView.findNavController().navigate(aksi)
        }
    }

    fun tampilkanData(jadwal: List<Jadwal>){
        this.jadwalList = jadwal
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return jadwalList.size
    }
}