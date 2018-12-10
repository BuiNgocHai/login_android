package com.example.vicker.login;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtuser, edtpassword;
    Button btndangky, btndangnhap, btnthoat;
    String ten,mk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        ControlButton();
    }
    private void ControlButton(){
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Bạn có chắc muốn thoát ứng dụng vui vẻ không");
                builder.setMessage("Hãy lựa chọn bên dưới để xác nhận ");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed(); //Thoát app
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }) ; // set ở lại
                builder.show();

            }
        });
        btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setTitle("Hộp thoại xử lý");
                dialog.setCancelable(false); // Không cho click bên ngoài hộp thaoij
                dialog.setContentView(R.layout.customdialog);
                final EditText edttk = (EditText)dialog.findViewById(R.id.edttk);
                final EditText edtmk = (EditText)dialog.findViewById(R.id.edtmk);
                Button btnhuy = (Button) dialog.findViewById(R.id.buttonhuy);
                Button btndongy = (Button) dialog.findViewById(R.id.buttondongy);
                btndongy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ten = edttk.getText().toString().trim();
                        mk = edtmk.getText().toString().trim();

                        edtuser.setText(ten);
                        edtpassword.setText(mk);

                        dialog.cancel();
                    }
                });
                btnhuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();

            }
        });
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtuser.getText().length() != 0  && edtpassword.getText().length() !=0){
                    if(edtuser.getText().toString().equals(ten) && edtpassword.getText().toString().equals(mk)){
                        Toast.makeText(MainActivity.this,"Bạn đã đăng nhập thành công",Toast.LENGTH_SHORT).show();
                        Intent intent =  new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(intent);

                    }
                    else if(edtuser.getText().toString().equals("Hit") && edtpassword.getText().toString().equals("123")){
                        Toast.makeText(MainActivity.this,"Bạn đã đăng nhập thành công",Toast.LENGTH_SHORT).show();
                        Intent intent =  new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(MainActivity.this,"Đăng nhập thất bại",Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this,"Nhập đủ đi má -.- ",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void Anhxa(){
        edtuser = (EditText)findViewById(R.id.edittextuser);
        edtpassword = (EditText)findViewById(R.id.edittextpassword);
        btndangnhap = (Button)findViewById(R.id.buttondangnhap);
        btndangky = (Button)findViewById(R.id.buttondangky);
        btnthoat = (Button)findViewById(R.id.buttonthoat);
    }
}
