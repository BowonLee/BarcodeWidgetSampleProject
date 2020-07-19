package bowon.lee.barcodewigetapplication.ui.widget

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import bowon.lee.barcodewigetapplication.R
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder
import kotlinx.android.synthetic.main.barcode_activity.*

class BarcodeActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.barcode_activity)


        createBarcode()
    }

    fun createBarcode(){
        val barcodeNumber = "1234 5789 123456";
        val barcodeEncoder = BarcodeEncoder();
        val bitmap = barcodeEncoder.encodeBitmap(barcodeNumber,BarcodeFormat.CODE_128,400,200);
        this.barcode_image.setImageBitmap(bitmap);
        this.barcode_text.text = barcodeNumber;

    }
}