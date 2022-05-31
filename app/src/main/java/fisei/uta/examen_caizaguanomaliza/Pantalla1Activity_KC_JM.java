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
    ListView listViewDatosIndice;
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
        listViewDatosIndice = findViewById(R.id.listViewIndice);

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


        int[] lstnumeros = new int[lstDatosRecibidos.length];
        for (int j=0 ; j<lstDatosRecibidos.length;i++){
            lstnumeros[j]= Integer.valueOf(lstDatosRecibidos[i].toString());
        }
        int[] ordenados = mayorMenor()

        ArrayAdapter<String> adapterIndice  = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,lstDatos);
        //asociar los datos
        listViewDatosIndice.setAdapter(adapter);

    }



    int aux;

    public int[]  mayorMenor(int[] lst){

        int[] lstnueva = new int[lst.length];
        int i=0;
        do {
            int j=i+1;
            do{
                if (lst[i] < lst[j]){
                 aux = lst[i];
                   lst[i]=lst[j];
                   lst[j]=aux;
                }
                j++;
            }while (j < lst.length);
            lstnueva[i]= lst[j];
            i++;
        } while (i<lst.length);

        return lstnueva;

    }
}