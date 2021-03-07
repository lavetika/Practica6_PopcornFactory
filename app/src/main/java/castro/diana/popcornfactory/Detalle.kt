package castro.diana.popcornfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detalle.*

class Detalle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        val bundle = intent.extras

        if (bundle != null){
            iv_header.setImageResource(bundle.getInt("header"))
            tv_nombre.setText(bundle.getString("titulo"))
            tv_desc.setText(bundle.getString("sinopsis"))
        }
    }
}