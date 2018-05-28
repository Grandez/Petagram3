package com.android.jgg.petagram3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

// import com.android.jgg.petagram2.mail.MailSrv;


public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
    }

    public void btnMail_onClick(View view) {
        validate();

        Toast.makeText(view.getRootView().getContext(), "Mensaje enviado", Toast.LENGTH_LONG);

        ////////////////////JGG COMENTADO PARANO EVIAR MAILS
        /*
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    MailSrv mail = new MailSrv("cryptoJGG@gmail.com", "Fjgg2185");
                    String message = mountMessage();
                    mail.sendMail("Nuevo contacto", message,
                                  "cryptoJGG@gmail.com",
                                "cryptoJGG@gmail.com");
                } catch (Exception e) {
                    Log.e("MailServer", e.getMessage(), e);
                }
            }

        }).start();
*/
    }

    private boolean validate() {
        return false;
    }

    private String mountMessage() {
        StringBuilder str = new StringBuilder();
        str.append("Nuevo contacto\n");
        str.append(getItem(R.id.txtNombre, "Nombre:"));
        str.append(getItem(R.id.txtApellidos, "Apellidos:"));
        str.append(getItem(R.id.txtMail, "Mail:"));
        str.append(getItem(R.id.txtComment, "Comentario:"));
        return str.toString();
    }

    private String getItem(int id, String label) {
        EditText txt = (EditText) findViewById(R.id.txtNombre);
        return label + " " + txt.getText().toString().trim() + "\n";
    }
}
