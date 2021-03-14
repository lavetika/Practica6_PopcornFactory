package castro.diana.popcornfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_seat_selection.*

class SeatSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_selection)

        val bundle = intent.extras
        var positionMov = -1

        if(bundle!=null) {
            tv_titleSeats.setText(bundle.getString("name"))
            positionMov = bundle.getInt("id")
        }

        btn_confirm.setOnClickListener {
            //TODO añadir lógica para reservar el lugar seleccionado por el usuario
            //TODO hacer una nueva actividad donde se vea el resumen de la compra (que tome el nombre del cliente y se vea que se seleccionó)

            Toast.makeText(this, "Enjoy the movie!", Toast.LENGTH_LONG).show()
        }

        row1.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId > -1){
                row2.clearCheck()
                row3.clearCheck()
                row4.clearCheck()

                row1.check(checkedId)
            }
        }

        row2.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId > -1){
                row1.clearCheck()
                row3.clearCheck()
                row4.clearCheck()

                row2.check(checkedId)
            }
        }

        row3.setOnCheckedChangeListener { group, checkedId ->
                if(checkedId > -1){
                    row1.clearCheck()
                    row2.clearCheck()
                    row4.clearCheck()

                    row3.check(checkedId)
                }
            }

        row4.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId > -1){
                row1.clearCheck()
                row2.clearCheck()
                row3.clearCheck()

                row4.check(checkedId)
            }
        }

    }
}