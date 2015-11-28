package mds.gpp.saudeemcasa.view;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import mds.gpp.saudeemcasa.R;

/**
 * Created by iolane on 28/11/15.
 */
public class InfoScreenSaudeEmCasa extends FragmentActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saude_em_casa_info);

        TextView nameTextView = (TextView)findViewById(R.id.text_info_saude_em_casa);
        nameTextView.setText("O aplicativo Saude em Casa, visa, facilitar ao usuário do Programa Melhor em Casa, formas de encontrar Hospitais, Clínicas ou estabelecimentos mais próximos ao paciente, atendendo à questao de dificuldade de deslocamento dos mesmos. Além disso, o aplicativo disponibiliza também as localizações de farmácias populares do Brasil, para que os usuários possam localizar e ter acesso ao possíveis medicamentos de seus tratamentos de saude.\n");
    }
}
