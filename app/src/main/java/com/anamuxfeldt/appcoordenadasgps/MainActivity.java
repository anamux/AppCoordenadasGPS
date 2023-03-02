package com.anamuxfeldt.appcoordenadasgps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtValorLatitude, txtValorLongitude;
    double latitude, longitude;
    boolean gpsAtivo = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtValorLatitude = findViewById(R.id.txtValorLatitude);
        txtValorLongitude = findViewById(R.id.txtValorLongitude);

        if(gpsAtivo){

            obterCoordenadas();

        }else {

            latitude = 0.00;
            longitude = 0.00;

        txtValorLatitude.setText(String.valueOf(latitude));
        txtValorLongitude.setText(String.valueOf(longitude));

        }

    }

    private void obterCoordenadas() {
        boolean permissaoAtiva = false;

        if(permissaoAtiva){
            capturarUltimaLocalizacaoValida();
        }else{
            solicitarPermissaoParaObterLocalizacao();
        }


    }

    private void solicitarPermissaoParaObterLocalizacao() {
    }

    private void capturarUltimaLocalizacaoValida() {
        latitude = 1.9876;
        longitude = -1.6789;

        txtValorLatitude.setText(String.valueOf(latitude));
        txtValorLongitude.setText(String.valueOf(longitude));

    }
}