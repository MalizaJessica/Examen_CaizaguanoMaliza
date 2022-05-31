package fisei.uta.examen_caizaguanomaliza;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Pantalla1Activity_KC_JM extends AppCompatActivity {

    String[] lstDatosRecibidos;
    ListView listViewDatosOriginal;
    List<String> lstDatos = new ArrayList<String>();





    ActivityResultLauncher<Intent> activityResult =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    //procesasr los datos
                    if (result.getResultCode() == Activity.RESULT_OK)
                    {
                        //obtener los datos regresados
                        Intent data = result.getData();
                        //obtener los datos regresados
                        Bundle datos = result.getData().getExtras();
                        lstDatosRecibidos = datos.getStringArray("lstDatos");

                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1_kc_jm);
        listViewDatosOriginal = findViewById(R.id.listViewOriginal);

    }

    public void segundoActivity (View view) {
        Intent intent = new Intent(this,Pantalla2Activity_KC_JM.class);
        activityResult.launch(intent);
    }

    public void mostrar(View view) {

        for (int i=0; i<lstDatosRecibidos.length;i++){
            //lstDatosSalida[i]=lstDatos.get(i);
            lstDatos.add(lstDatosRecibidos[i]);
        }

        ArrayAdapter<String> adapter  = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,lstDatos);
        //asociar los datos
        listViewDatosOriginal.setAdapter(adapter);
    }
}