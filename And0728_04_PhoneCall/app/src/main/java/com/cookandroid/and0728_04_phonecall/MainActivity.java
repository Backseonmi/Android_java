package com.cookandroid.and0728_04_phonecall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView edtName, edtTel;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("전화 번호 목록[백선미]");
        edtName = findViewById(R.id.txtName);
        edtTel = findViewById(R.id.txtTel);
        btn = findViewById(R.id.btn);
        registerForContextMenu(btn);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater minflater = getMenuInflater();
        minflater.inflate(R.menu.menu_option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option_Num:
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("전화 번호 등록");
                dlg.setIcon(R.mipmap.ic_launcher_round);
                final View dlgView = (View) View.inflate(MainActivity.this, R.layout.dlg, null);
                dlg.setView(dlgView);

                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText dlgName = dlgView.findViewById(R.id.edtName);
                        EditText dlgTel = dlgView.findViewById(R.id.edtTel);
                        String str = edtName.getText().toString() + "\n" + dlgName.getText().toString();
                        String str2 = edtTel.getText().toString() + "\n" + dlgTel.getText().toString();
                        edtName.setText(str);
                        edtTel.setText(str2);
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "취소되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();

                return true;
            case R.id.itemBlue:
                edtName.setTextColor(Color.BLUE);
                edtTel.setTextColor(Color.BLUE);
                return true;

            case R.id.itmeGreen:
                edtName.setTextColor(Color.GREEN);
                edtTel.setTextColor(Color.GREEN);
                return true;

            case R.id.itmeBas:
                edtName.setTextColor(Color.BLACK);
                edtTel.setTextColor(Color.BLACK);
                return true;

            default:
                return false;

        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater minuInflater = getMenuInflater();
        if (v == btn) {
            menu.setHeaderTitle("메뉴 선택");
            minuInflater.inflate(R.menu.menu_context, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.context_cancle:
                Toast.makeText(getApplicationContext(), "초기화 합니다", Toast.LENGTH_SHORT).show();
                edtName.setText("");
                edtTel.setText("");
                ;
                return true;
            case R.id.context_end:
                finish();
                return true;
            default:
                Toast.makeText(getApplicationContext(), "선택안됨", Toast.LENGTH_SHORT).show();
                return false;

        }
    }
}