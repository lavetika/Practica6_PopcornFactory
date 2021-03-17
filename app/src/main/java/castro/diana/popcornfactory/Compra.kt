package castro.diana.popcornfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_compra.*
import kotlinx.android.synthetic.main.vista.*

class Compra : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compra)

        val bundle = intent.extras
        var numSeat = bundle?.getString("seat")

        if (bundle != null){
            tv_tituloPelicula.setText(bundle.getString("name"))
            tv_numberSeat.setText("Your seat is $numSeat")
        }

    }



}