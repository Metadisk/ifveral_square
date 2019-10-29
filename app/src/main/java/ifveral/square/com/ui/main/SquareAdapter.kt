package ifveral.square.com.ui.main

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ifveral.square.com.R
import ifveral.square.com.data.model.Square
import ifveral.square.com.utils.GlideApp

class SquareAdapter (private val context: Context) : RecyclerView.Adapter<SquareAdapter.SquareViewHolder>() {

    /**
     * The list of posts of the adapter
     */
    private var cakeList: List<Square> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SquareViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_squares, parent, false)

        return SquareViewHolder(itemView)
    }

    override fun onBindViewHolder(cakeViewHolder: SquareViewHolder, position: Int) {
        cakeViewHolder.bind(cakeList[position])

    }


    override fun getItemCount() = cakeList.size


    //TODO Updates the list of cakes of the adapter
    fun updateSquares(squares: List<Square>) {
        this.cakeList = squares
        notifyDataSetChanged()
    }


    class SquareViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvTitle = itemView.findViewById<TextView>(R.id.title)
        private val imgPoster = itemView.findViewById<ImageView>(R.id.image)

        fun bind(cake: Square) {
            tvTitle.text = cake.name
            GlideApp.with(itemView.context)
                .load(cake.image)
                .placeholder(itemView.context.resources.getDrawable(R.drawable.placeholder))
                .centerCrop()
                .into(imgPoster)


            itemView.setOnClickListener {

                //TODO  Display the cake description popup when a cake entry is clicked
                val builder = AlertDialog.Builder(itemView.context)
                builder.setTitle(cake.name)
                if (cake.description != null) {
                    builder.setMessage(cake.description)
                }
                builder.setNegativeButton("Dissmis",
                    DialogInterface.OnClickListener { d, arg1 -> d.cancel() })
                builder.show()

            }



        }
    }
}
