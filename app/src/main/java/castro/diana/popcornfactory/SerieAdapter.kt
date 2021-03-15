package castro.diana.popcornfactory

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.vista.view.*


class SerieAdapter: BaseAdapter {
    var series = ArrayList<Serie>()
    var context: Context? = null

    constructor(context: Context, series: ArrayList<Serie>){
        this.context = context
        this.series = series
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var serie = series[position]
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view = inflator.inflate(R.layout.vista, null)

        view.iv_imagen.setImageResource(serie.image)
        view.tv_titulo.setText(serie.title)
        view.iv_imagen.setOnClickListener {
            var intent = Intent(context, Detalle::class.java)
            intent.putExtra("titulo", serie.title)
            intent.putExtra("image", serie.image)
            intent.putExtra("header", serie.header)
            intent.putExtra("sinopsis", serie.sinopsis)
            intent.putExtra("numberSeats", (20-serie.seats.size))
            intent.putExtra("position", position)
            context!!.startActivity(intent)
        }
        return view
    }

    override fun getItem(position: Int): Any {
        return series[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return series.size
    }
}