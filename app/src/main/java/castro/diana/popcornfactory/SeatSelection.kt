package castro.diana.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_seat_selection.*

class SeatSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_selection)

        val bundle = intent.extras
        var positionMovie = -1
        var seats = 0
        var id: Int = 0
        var radio: RadioButton
        var name = ""

        if(bundle!=null) {
            name = bundle.getString("name").toString()
            tv_titleSeats.setText(name)
            positionMovie = bundle.getInt("id")
            seats = bundle.getInt("seats")
        }

        btn_confirm.setOnClickListener {
            //TODO añadir lógica para reservar el lugar seleccionado por el usuario

            val intent: Intent = Intent(this, Compra::class.java)


            intent.putExtra("name", name)



            if(row1.checkedRadioButtonId != -1){
                id = row1.checkedRadioButtonId
                radio = findViewById(id)
                if (radio.isChecked){
                    radio.setBackgroundResource(R.drawable.radio_disabled)
                    Toast.makeText(this, radio.text, Toast.LENGTH_SHORT).show()
                    intent.putExtra("seat", radio.text)
                    radio.isChecked = false
                    radio.isEnabled = false
                    seats -1
                }
            }else if (row2.checkedRadioButtonId != -1){
                id = row2.checkedRadioButtonId
                radio = findViewById(id)
                if (radio.isChecked){
                    radio.setBackgroundResource(R.drawable.radio_disabled)
                    Toast.makeText(this, radio.text, Toast.LENGTH_SHORT).show()
                    intent.putExtra("seat", radio.text)
                    radio.isChecked = false
                    radio.isEnabled = false
                    seats -1
                }
            }else if(row3.checkedRadioButtonId != -1){
                id = row3.checkedRadioButtonId
                radio = findViewById(id)
                if (radio.isChecked){
                    radio.setBackgroundResource(R.drawable.radio_disabled)
                    Toast.makeText(this, radio.text, Toast.LENGTH_SHORT).show()
                    intent.putExtra("seat", radio.text)
                    radio.isChecked = false
                    radio.isEnabled = false
                    seats -1
                }
            }else if(row4.checkedRadioButtonId != -1){
                id = row4.checkedRadioButtonId
                radio = findViewById(id)
                if (radio.isChecked){
                    radio.setBackgroundResource(R.drawable.radio_disabled)
                    Toast.makeText(this, radio.text, Toast.LENGTH_SHORT).show()
                    intent.putExtra("seat", radio.text)
                    radio.isChecked = false
                    radio.isEnabled = false
                    seats -1
                }
            }


            //TODO hacer una nueva actividad donde se vea el resumen de la compra (que tome el nombre del cliente y se vea que se seleccionó)

            Toast.makeText(this, "Enjoy the movie!", Toast.LENGTH_LONG).show()

            this.startActivity(intent)
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