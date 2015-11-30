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

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.zhaorui.dvdcollector.Controller.TradeListController;
import com.example.zhaorui.dvdcollector.Model.ContextUtil;
import com.example.zhaorui.dvdcollector.Model.TradeList;
import com.example.zhaorui.dvdcollector.Model.User;
import com.example.zhaorui.dvdcollector.R;
/**
 * <p>
 * The <code>TradeCenterActivity</code> class controls the user interface of trade centre.
 * This class contains functions, onCreate, onCreateOptionsMenu and onOptionsItemSelected
 * <p>
 *
 * @author  Zhaorui Chen
 * @version 11/10/15
 */
public class TradeCenterActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade_center);
    }

    @Override
    protected void onStart(){
        super.onStart();
        TradeListController tradeListController = new TradeListController(User.instance().getTradeList());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_trade_center, menu);
        return true;
    }


    public void startNewTrade(View view){
        Intent i = new Intent(TradeCenterActivity.this, StartTradeActivity.class);
        startActivity(i);
    }

    public void startIncomingTrade(View view){
        Intent i = new Intent(TradeCenterActivity.this, TradeRequestsActivity.class);
        startActivity(i);
    }

    public void startAllTrade(View view){
        Intent i = new Intent(TradeCenterActivity.this, BrowseTradeLogActivity.class);
        TradeList tradeList = User.instance().getTradeList();
        Log.e("DVD number of trades is", String.valueOf(tradeList.size()));
        startActivity(i);
    }

    public void startTopTraders(View view){
        if (!ContextUtil.getInstance().isConnected()){
            Toast.makeText(ContextUtil.getInstance(), "Not Connect to Internet!", Toast.LENGTH_LONG).show();
            return;
        }
        Intent i = new Intent(TradeCenterActivity.this, TopTradeActivity.class);
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
