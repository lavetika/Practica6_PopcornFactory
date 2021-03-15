package castro.diana.popcornfactory

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
        var positionMov = -1
        var ns = 0
        var id: Int = 0

        if(bundle!=null) {
            tv_titleSeats.setText(bundle.getString("name"))
            positionMov = bundle.getInt("id")
            ns = bundle.getInt("ns")
        }

        btn_confirm.setOnClickListener {
            //TODO añadir lógica para reservar el lugar seleccionado por el usuario

            if(row1.checkedRadioButtonId != -1){
                id = row1.checkedRadioButtonId
                var radio: RadioButton = findViewById(id)
                if (radio.isChecked){
                    radio.setBackgroundResource(R.drawable.radio_disabled)
                    Toast.makeText(this, radio.text, Toast.LENGTH_SHORT).show()
                    ns -1
                }
            }else if (row2.checkedRadioButtonId != -1){
                id = row2.checkedRadioButtonId
                var radio: RadioButton = findViewById(id)
                if (radio.isChecked){
                    radio.setBackgroundResource(R.drawable.radio_disabled)
                    Toast.makeText(this, radio.text, Toast.LENGTH_SHORT).show()
                    ns -1
                }
            }else if(row3.checkedRadioButtonId != -1){
                id = row3.checkedRadioButtonId
                var radio: RadioButton = findViewById(id)
                if (radio.isChecked){
                    radio.setBackgroundResource(R.drawable.radio_disabled)
                    Toast.makeText(this, radio.text, Toast.LENGTH_SHORT).show()
                    ns -1
                }
            }else if(row4.checkedRadioButtonId != -1){
                id = row4.checkedRadioButtonId
                var radio: RadioButton = findViewById(id)
                if (radio.isChecked){
                    radio.setBackgroundResource(R.drawable.radio_disabled)
                    Toast.makeText(this, radio.text, Toast.LENGTH_SHORT).show()
                    ns -1
                }
            }

            when(id){
                row1.checkedRadioButtonId ->{}
                row2.checkedRadioButtonId ->{}
                row3.checkedRadioButtonId ->{}
                row4.checkedRadioButtonId ->{}
            }


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