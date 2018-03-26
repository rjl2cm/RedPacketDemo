package com.example.franer.redpacketdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.redpacket.RedPacket;
import com.example.redpacket.RedPacketDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_show).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_show://测试红包点击链接
            RedPacket rp = RedPacket.getInstance();
			new RedPacketDialog(rp).show(getFragmentManager().beginTransaction(), null);
                break;

            default:
                break;
        }
    }
}
