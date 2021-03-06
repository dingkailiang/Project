/*
 *
 *University of Alberta CMPUT 301 Group: CMPUT301F15T11
 *Copyright {2015} {Dingkai Liang, Zhaorui Chen, Jiaxuan Yue, Xi Zhang, Qingdai Du, Wei Song}
 *
 *Licensed under the Apache License, Version 2.0 (the "License");
 *
 *you may not use this file except in compliance with the License.
 *You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *Unless required by applicable law or agreed to in writing,software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
*/
package com.example.zhaorui.dvdcollector.View;

import android.app.Activity;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.zhaorui.dvdcollector.Controller.DataManager;
import com.example.zhaorui.dvdcollector.Controller.TradeListController;
import com.example.zhaorui.dvdcollector.Model.ContextUtil;
import com.example.zhaorui.dvdcollector.Model.Friend;
import com.example.zhaorui.dvdcollector.Model.User;
import com.example.zhaorui.dvdcollector.R;

/**
 * <p>
 * The <code>MainActivity</code> class controls the user interface of the main menu.
 * <p>
 *
 * @author  Zhaorui Chen
 * @version 11/10/15
 */
public class MainActivity extends BaseActivity {
    /**
     * Initialize inventory button
     */
    Button btnInvent;
    /**
     * Initialize trade button
     */
    Button btnTrade;
    /**
     * Initialize friend button
     */
    Button btnFriends;
    /**
     * Initialize config button
     */
    Button btnConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInvent = (Button)findViewById(R.id.btnInventMain);
        btnTrade = (Button)findViewById(R.id.btnTradeMain);
        btnFriends = (Button)findViewById(R.id.btnFriendsMain);
        btnConfig = (Button)findViewById(R.id.btnConfigMain);
        DataManager.instance().loadFromFile(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    /**
     * Start my inventory
     * @param view view variable
     */
    public void startMyInvent(View view){
        Intent i = new Intent(MainActivity.this, MyInventoryActivity.class);
        startActivity(i);
    }
    /**
     * Start my friend list
     * @param view view variable
     */
    public void startFriendList(View view){
        Intent i = new Intent(MainActivity.this, FriendListActivity.class);
        startActivity(i);
    }
    /**
     * Start config
     * @param view view variable
     */
    public void startConfig(View view){
        Intent i = new Intent(MainActivity.this, ConfigActivity.class);
        startActivity(i);
    }
    /**
     * Start trade center
     * @param view view variable
     */
    public void startTradeCenter(View view){
        Intent i = new Intent(MainActivity.this, TradeCenterActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}