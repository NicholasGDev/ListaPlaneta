package br.sp.senac.listaplaneta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String[] nomePlanetas ={"Jupiter","Lua","Marte","Plutão",
            "Saturno","Sol","Terra","Venus"} ;
    int[] imagemdosPlanetas = {R.drawable.jupiter,R.drawable.lua,R.drawable.marte,R.drawable.plutao,R.drawable.saturno,
            R.drawable.sol,R.drawable.terra,R.drawable.venus};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lstPlanetas);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),ListarDadosPlanetasActivity.class);
                intent.putExtra("name",nomePlanetas[position]);
                intent.putExtra("image",imagemdosPlanetas[position]);
                startActivity(intent);
            }
        });

    }
    class CustomAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return imagemdosPlanetas.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView , ViewGroup parent) {
            View view1 = getLayoutInflater().inflate(R.layout.carrega_planetas, null);
            TextView name = (TextView) view1.findViewById(R.id.planetas);
            ImageView imagem = (ImageView) view1.findViewById(R.id.imgPlanetas);
            name.setText(nomePlanetas[position]);
            imagem.setImageResource(imagemdosPlanetas[position]);
            return view1;
        }
    }


}
