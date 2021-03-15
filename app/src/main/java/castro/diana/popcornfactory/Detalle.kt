package castro.diana.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detalle.*

class Detalle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        val bundle = intent.extras
        var ns = 0;
        var id = -1;
        var title = ""

        if (bundle != null){
            ns = bundle.getInt("numberSeats")
            title = bundle.getString("titulo")!!

            iv_header.setImageResource(bundle.getInt("header"))
            tv_nombre.setText(bundle.getString("titulo"))
            tv_desc.setText(bundle.getString("sinopsis"))
            tv_seatsLeft.setText("$ns seats available")
            id = bundle.getInt("position")
        }

        if(ns == 0){
            btn_buyTickets.isEnabled = false
        }else{
            btn_buyTickets.setOnClickListener {
                val intent: Intent = Intent(this, SeatSelection::class.java)

                intent.putExtra("id", id)
                intent.putExtra("name", title)
                intent.putExtra("ns", ns)

               this.startActivity(intent)

            }
        }

    }
}