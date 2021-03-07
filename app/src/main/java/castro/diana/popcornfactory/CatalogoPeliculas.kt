package castro.diana.popcornfactory

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_catalogo_peliculas.*
import kotlinx.android.synthetic.main.pelicula.view.*

class CatalogoPeliculas : AppCompatActivity() {
    var adapter: PeliculaAdapter? = null
    var peliculas = ArrayList<Pelicula>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo_peliculas)

        cargarPeliculas()

        adapter = PeliculaAdapter(this, peliculas)
        gridview.adapter = adapter
    }

    fun cargarPeliculas(){
        peliculas.add(Pelicula(getString(R.string.titleBones), R.drawable.bones, R.drawable.bonesheader, getString(R.string.descBones)))
        peliculas.add(Pelicula(getString(R.string.titleDrHouse), R.drawable.drhouse, R.drawable.househeader, getString(R.string.descDrHouse)))
        peliculas.add(Pelicula(getString(R.string.titleBigHero6), R.drawable.bighero6, R.drawable.headerbighero6, getString(R.string.descBigHero6)))
        peliculas.add(Pelicula(getString(R.string.titleDrWho), R.drawable.drwho, R.drawable.drwhoheader, getString(R.string.descDrWho)))
        peliculas.add(Pelicula(getString(R.string.titleFriends), R.drawable.friends, R.drawable.friendsheader, getString(R.string.descFriends)))
        peliculas.add(Pelicula(getString(R.string.titleInception), R.drawable.inception, R.drawable.inceptionheader, getString(R.string.descInception)))
        peliculas.add(Pelicula(getString(R.string.titleLeapYear), R.drawable.leapyear, R.drawable.leapyearheader, getString(R.string.descLeapYear)))
        peliculas.add(Pelicula(getString(R.string.titleToyStory), R.drawable.toystory, R.drawable.toystoryheader, getString(R.string.descToyStory)))
        peliculas.add(Pelicula(getString(R.string.titleSmallville), R.drawable.smallville, R.drawable.smallvilleheader, getString(R.string.descSmallville)))
        peliculas.add(Pelicula(getString(R.string.title1917), R.drawable.diecinuevediecisiete, R.drawable.diecinuevediecisieteheader, getString(R.string.desc1917)))
        peliculas.add(Pelicula(getString(R.string.titleMenInBlack), R.drawable.mib, R.drawable.mibheader, getString(R.string.descMenInBlack)))
        peliculas.add(Pelicula(getString(R.string.titleSuits), R.drawable.suits, R.drawable.suitsheader, getString(R.string.descSuits)))
    }

}

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
        var view = inflator.inflate(R.layout.pelicula, null)
        view.iv_pelicula.setImageResource(pelicula.image)
        view.tv_pelicula_titulo.setText(pelicula.title)

        view.iv_pelicula.setOnClickListener {
            var intent = Intent(context, DetallePelicula::class.java)
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