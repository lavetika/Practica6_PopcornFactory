package castro.diana.popcornfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_catalogo.*


class Catalogo : AppCompatActivity() {
    var adapterPeliculas: PeliculaAdapter? = null
    var adapterSeries: SerieAdapter? = null

    var peliculas = ArrayList<Pelicula>()
    var series = ArrayList<Serie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo)

        cargarPeliculas()
        cargarSeries()

        adapterPeliculas = PeliculaAdapter(this, peliculas)
        adapterSeries = SerieAdapter(this, series)

        gridviewPeliculas.adapter = adapterPeliculas
        gridviewSeries.adapter = adapterSeries
    }

    fun cargarPeliculas(){

        peliculas.add(Pelicula(getString(R.string.titleBigHero6), R.drawable.bighero6, R.drawable.headerbighero6, getString(R.string.descBigHero6), arrayListOf<Cliente>()))
        peliculas.add(Pelicula(getString(R.string.titleInception), R.drawable.inception, R.drawable.inceptionheader, getString(R.string.descInception), arrayListOf<Cliente>()))
        peliculas.add(Pelicula(getString(R.string.titleLeapYear), R.drawable.leapyear, R.drawable.leapyearheader, getString(R.string.descLeapYear), arrayListOf<Cliente>()))
        peliculas.add(Pelicula(getString(R.string.titleToyStory), R.drawable.toystory, R.drawable.toystoryheader, getString(R.string.descToyStory), arrayListOf<Cliente>()))
        peliculas.add(Pelicula(getString(R.string.title1917), R.drawable.diecinuevediecisiete, R.drawable.diecinuevediecisieteheader, getString(R.string.desc1917), arrayListOf<Cliente>()))
        peliculas.add(Pelicula(getString(R.string.titleMenInBlack), R.drawable.mib, R.drawable.mibheader, getString(R.string.descMenInBlack), arrayListOf<Cliente>()))
    }

    fun cargarSeries(){
        series.add(Serie(getString(R.string.titleBones), R.drawable.bones, R.drawable.bonesheader, getString(R.string.descBones), arrayListOf<Cliente>()))
        series.add(Serie(getString(R.string.titleDrHouse), R.drawable.drhouse, R.drawable.househeader, getString(R.string.descDrHouse), arrayListOf<Cliente>()))
        series.add(Serie(getString(R.string.titleDrWho), R.drawable.drwho, R.drawable.drwhoheader, getString(R.string.descDrWho), arrayListOf<Cliente>()))
        series.add(Serie(getString(R.string.titleFriends), R.drawable.friends, R.drawable.friendsheader, getString(R.string.descFriends), arrayListOf<Cliente>()))
        series.add(Serie(getString(R.string.titleSmallville), R.drawable.smallville, R.drawable.smallvilleheader, getString(R.string.descSmallville), arrayListOf<Cliente>()))
        series.add(Serie(getString(R.string.titleSuits), R.drawable.suits, R.drawable.suitsheader, getString(R.string.descSuits), arrayListOf<Cliente>()))
    }

}
