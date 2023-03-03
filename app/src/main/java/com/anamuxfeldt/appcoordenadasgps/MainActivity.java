package com.anamuxfeldt.appcoordenadasgps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
public static final int REQUEST_LOCATION_PERMISSION = 1;

    String[] permissoesRequeridas = {Manifest.permission.ACCESS_FINE_LOCATION,
                                     Manifest.permission.ACCESS_COARSE_LOCATION};

    public static final int APP_PERMISSOES_ID = 2023;
    TextView txtValorLatitude, txtValorLongitude;
    double latitude, longitude;
    ///Implementar a lógica de verificação da ativação da localização (LocationManager)
    LocationManager locationManager;
    boolean gpsAtivo = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtValorLatitude = findViewById(R.id.txtValorLatitude);
        txtValorLongitude = findViewById(R.id.txtValorLongitude);
// Conferir os serviços disponiveis via LocationManager

        locationManager = (LocationManager) getApplication().getSystemService(Context.LOCATION_SERVICE);
///isProviderEnable: checa se há algum provedor disponível, pode ser wifi, pacote de dados, GPS
        gpsAtivo = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);


        if(gpsAtivo){

            obterCoordenadas();

        }else {

            latitude = 0.00;
            longitude = 0.00;

        txtValorLatitude.setText(String.valueOf(latitude));
        txtValorLongitude.setText(String.valueOf(longitude));

            Toast.makeText(this, "Coordenadas não disponiveis", Toast.LENGTH_LONG).show();

        }

    }

    private void obterCoordenadas() {
        boolean permissaoAtiva = solicitarPermissaoParaObterLocalizacao();

        if(permissaoAtiva){
            capturarUltimaLocalizacaoValida();
        }



    }

    private boolean solicitarPermissaoParaObterLocalizacao() {


        Toast.makeText(this, "App sem permissão de acesso ao GPS", Toast.LENGTH_LONG).show();

        List<String> permissoesNegadas = new ArrayList<>();

        int permissaoNegada;

        for (String permissao : this.permissoesRequeridas) {

            permissaoNegada = ContextCompat.checkSelfPermission(MainActivity.this, permissao);

            if(permissaoNegada != PackageManager.PERMISSION_GRANTED){
                permissoesNegadas.add(permissao);

}

        }

        return true;
    }

    private void capturarUltimaLocalizacaoValida() {
        latitude = 1.98;
        longitude = -1.67;

        txtValorLatitude.setText(String.valueOf(latitude));
        txtValorLongitude.setText(String.valueOf(longitude));

        Toast.makeText(this, "Coordenadas obtidas com sucesso", Toast.LENGTH_LONG).show();

    }
}