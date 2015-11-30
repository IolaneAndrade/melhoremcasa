package mds.gpp.saudeemcasa.view;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import mds.gpp.saudeemcasa.R;

/**
 * Created by iolane on 28/11/15.
 */
public class InfoScreenDrugStore extends FragmentActivity {

    public class InfoScreenSaudeEmCasa extends FragmentActivity{
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.drugstore_info);

            TextView nameTextView = (TextView)findViewById(R.id.text_info_saude_em_casa);
            nameTextView.setText("O Programa Farmácia Popular do Brasil vem a ser uma iniciativa do Governo Federal que autoriza a Fundação Oswaldo Cruz (FIOCRUZ) a disponibilizar medicamentos mediante ressarcimento, e pelo Decreto nº 5.090, de 20 de maio de 2004, que regulamenta a Lei 10.858 e institui o Programa Farmácia Popular do Brasil.\n" +
                    "As unidades próprias contam com um elenco de 112 itens, entre medicamentos e o preservativo masculino, os quais são dispensados pelo seu valor de custo, representando uma redução de até 90% do valor de mercado. A condição para a aquisição dos medicamentos disponíveis nas unidades, neste caso, é a apresentação de documento com foto, no qual conste seu CPF, juntamente com uma receita médica ou odontológica. Importante ressaltar que somente a Rede Própria aceita receitas prescritas por dentistas.\n");
        }
    }

}
