package sg.edu.rp.c346.id20019634.l06_mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton ibtnDBS, ibtnOCBC, ibtnUOB;

    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ibtnDBS = findViewById(R.id.imageButtonDBS);
        ibtnOCBC = findViewById(R.id.imageButtonOCBC);
        ibtnUOB = findViewById(R.id.imageButtonUOB);

        registerForContextMenu(ibtnDBS);
        registerForContextMenu(ibtnOCBC);
        registerForContextMenu(ibtnUOB);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the Bank");

        if (v == ibtnDBS) {
            wordClicked = "dbs";

        } else if (v == ibtnOCBC) {
            wordClicked = "ocbc";

        } else {
            wordClicked = "uob";

        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("dbs")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentDBS = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg/index/default.page"));
                startActivity(intentDBS);
                Toast.makeText(MainActivity.this, "Proceeding to Website...", Toast.LENGTH_SHORT).show();

                return true; //menu item successfully handled

            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentDBSCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 18001111111L));
                startActivity(intentDBSCall);
                Toast.makeText(MainActivity.this, "Proceeding to Phone...", Toast.LENGTH_SHORT).show();

                return true;  //menu item successfully handled

            }

        } else if (wordClicked.equalsIgnoreCase("ocbc")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentOCBC = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com/group/gateway"));
                startActivity(intentOCBC);
                Toast.makeText(MainActivity.this, "Proceeding to Website...", Toast.LENGTH_SHORT).show();

                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentOCBCCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 18003633333L));
                startActivity(intentOCBCCall);
                Toast.makeText(MainActivity.this, "Proceeding to Phone...", Toast.LENGTH_SHORT).show();

                return true;  //menu item successfully handled
            }

        } else {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentUOB = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg/"));
                startActivity(intentUOB);
                Toast.makeText(MainActivity.this, "Proceeding to Website...", Toast.LENGTH_SHORT).show();

                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentUOBCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 18002222121L));
                startActivity(intentUOBCall);
                Toast.makeText(MainActivity.this, "Proceeding to Phone...", Toast.LENGTH_SHORT).show();

                return true;  //menu item successfully handled

            }

        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation

    }
}