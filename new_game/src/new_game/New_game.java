/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package new_game;

/**
 *
 * @author afsah
 */
public class New_game {   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        game obj = new game();
        obj.the_game();
    }
     public static void main(String[] args) {
        game obj = new game();
        obj.the_game();
    }
            @Override
            public void onClick(View arg0) {
                // create class object
                gps = new getLocation(MainActivity.this);

                // check if GPS enabled
                if(gps.canGetLocation()){
                   
                        objclass = new getData();
                        objclass.setUp("",latitude, longitude, 0);
                        objclass.execute().get();
                }else{
                    // can't get location
                    // GPS or Network is not enabled
                    // Ask user to enable GPS/network in settings
                    gps.showSettingsAlert();
                }

            }
        });

}
