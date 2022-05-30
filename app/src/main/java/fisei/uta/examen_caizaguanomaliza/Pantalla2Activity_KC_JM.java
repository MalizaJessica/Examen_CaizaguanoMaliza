package fisei.uta.examen_caizaguanomaliza;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Pantalla2Activity_KC_JM extends AppCompatActivity {
    EditText editTextnumero ;
    int contador =0;
    List<String> lstDatos = new ArrayList<String>();
    ListView listViewDatos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2_kc_jm);

        editTextnumero = findViewById(R.id.editTextNumero);
        listViewDatos = findViewById(R.id.listViewDatos);

    }

    public void  ingresar (View view){

        String numero = editTextnumero.getText().toString();
        lstDatos.add(numero);
        contador++;

        ArrayAdapter<String> adapter  = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,lstDatos);
        //asociar los datos
        listViewDatos.setAdapter(adapter);
    }

    public List<String> cargarDatosListView() {

        List<String> list = new ArrayList<String>();

        for (int i =0; i<=22 ; i++) {
            //String item = lstDatos[i];
            ///list.add(item);
        }

        return  list;
    }
}