package castro.diana.popcornfactory

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.vista.view.*


class PeliculaAdapter: BaseAdapter {
    var peliculas = ArrayList<Pelicula>()
    var context: Context? = null

    constructor(context: Context, peliculas: ArrayList<Pelicula>){
        this.context = context
        this.peliculas = peliculas
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var pelicula = peliculas[position]
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view = inflator.inflate(R.layout.vista, null)

        view.iv_imagen.setImageResource(pelicula.image)
        view.tv_titulo.setText(pelicula.title)
        view.iv_imagen.setOnClickListener {
            var intent = Intent(context, Detalle::class.java)
            intent.putExtra("titulo", pelicula.title)
            intent.putExtra("image", pelicula.image)
            intent.putExtra("header", pelicula.header)
            intent.putExtra("sinopsis", pelicula.sinopsis)
            context!!.startActivity(intent)
        }
        return view
    }

    override fun getItem(position: Int): Any {
        return peliculas[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return peliculas.size
    }
}