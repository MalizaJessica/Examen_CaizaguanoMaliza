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

public class Pantalla1Activity_KC_JM extends AppCompatActivity {


    ActivityResultLauncher<Intent> activityResult =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    //procesasr los datos
                    if (result.getResultCode() == Activity.RESULT_OK)
                    {
                        //obtener los datos regresados
                        Intent data = result.getData();
                        //Toast.makeText(MainActivity.this, "Datos regresados" + data.getDataString(), Toast.LENGTH_LONG).show();

                        //textViewDatos.setText(data.getDataString());

                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1_kc_jm);


    }

    public void segundoActivity (View view) {

        Intent intent = new Intent(this,Pantalla2Activity_KC_JM.class);
        activityResult.launch(intent);


    }
}