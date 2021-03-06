
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
package com.example.zhaorui.dvdcollector.Model;

import com.example.zhaorui.dvdcollector.Controller.DataManager;

/**
 * <p>
 * The <code>User</code> class manages the current user's information about his trades,friends,inventory and profile.
 * <p>
 *
 * @author  Dingkai Liang
 * @version 01/11/15
 */
public class User{
    static private User instance;
    /**
     * initialize a Friends to store user's friends.
     */
    private Friends friends;
    /**
     * initialize a Inventory to store user's inventory.
     */
    private Inventory inventory;
    /**
     * initialize a Userprofile to store user's profile.
     */
    private UserProfile profile;
    /**
     * initialize a tradelist to store user's trades.
     */
    private TradeList tradeList;
    /**
     * initialize a gallerylist to store all galleries of user's dvds.
     */
    private GalleryList galleryList;

    /**
     * Used to determine whether user wants to automatically download
     * photos of friend's dvds when viewing a friend's dvd
     * Default is true --> automatically download
     */
    private boolean downloadImage;
    /**
     * Initialize user's related variable
     */
    private User() {
        friends = new Friends();
        inventory = new Inventory();
        profile = new UserProfile();
        tradeList = new TradeList();
        galleryList = new GalleryList();
        downloadImage = true;
    }
    /**
     * Initialize static instance of user
     * @param instance user varibale
     */
    public static void setInstance(User instance) {
        User.instance = instance;
    }
    /**
     * Get instance of user
     * @return instance
     */
    public static User instance(){
        if (instance == null){
            instance = new User();
        }
        return instance;
    }
    /**
     * Call <code>TradeList</code> class to get trade list
     * @return the user's friends.
     */
    public TradeList getTradeList(){return tradeList;}
    /**
     * Call <code>Friends</code> class to get the user's friends.
     * @return the user's friends.
     */
    public Friends getFriends() {
        return friends;
    }
    /**
     * Call <code>Inventory</code> class to get the user's inventories.
     * @return the user's inventories.
     */
    public Inventory getInventory() {
        return inventory;
    }
    /**
     * Call <code>UserProfile</code> class to get the user's prifile information.
     * @return the user's profile information.
     */
    public UserProfile getProfile() {
        return profile;
    }

    /**
     * to get download image
     * @return download Image
     */
    public boolean isDownloadImage() {
        return downloadImage;
    }

    /**
     * set the download image
     * @param downloadImage a boolean variable
     */
    public void setDownloadImage(boolean downloadImage) {
        this.downloadImage = downloadImage;
    }

    /**
     * get gallery list
     * @return gallery list
     */
    public GalleryList getGalleryList() {
        return galleryList;
    }

    /**
     * set trade list
     * @param tradeList a variable of the trade list
     */
    public void setTradeList(TradeList tradeList) {
        this.tradeList = tradeList;
    }
}
