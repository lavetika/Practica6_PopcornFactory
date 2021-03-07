package castro.diana.popcornfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_detalle_pelicula.*

class DetallePelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

        val bundle = intent.extras

        if (bundle != null){

            iv_pelicula_header.setImageResource(bundle.getInt("header"))
            tv_nombre_pelicula.setText(bundle.getString("nombre"))
            tv_pelicula_desc.setText(bundle.getString("sinopsis"))

            //var image: ImageView = findViewById(R.id.iv_pelicula_imagen) as ImageView
            //var title: TextView = findViewById(R.id.tv_nombre_pelicula) as TextView
            //var sinopsis: TextView = findViewById(R.id.tv_pelicula_desc) as TextView
        }
    }
}