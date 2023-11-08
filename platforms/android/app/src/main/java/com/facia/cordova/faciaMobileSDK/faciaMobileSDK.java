package com.facia.cordova;

import org.apache.cordova.CordovaActivity;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.facia.faciasdk.Activity.Helpers.RequestListener;
import com.facia.faciasdk.FaciaAi;

import java.util.HashMap;

public class faciaMobileSDK extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("createRequest")) {
            try {
                String accessToken = args.getString(0);
                JSONObject config = args.getJSONObject(1);
                this.createRequest(accessToken, config, callbackContext);
                return true;
            } catch (Exception e) {
                callbackContext.error("Error processing request: " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    private void createRequest(String accessToken, JSONObject config, CallbackContext callbackContext) {
        CordovaActivity cordovaActivity = (CordovaActivity) cordova.getActivity();
        FaciaAi facia = new FaciaAi();
        facia.createRequest(accessToken, cordovaActivity, config, new RequestListener() {
            @Override
            public void requestStatus(HashMap<String, String> hashMap) {
                JSONObject responseJson = new JSONObject(hashMap);

                // creating a success result with the response JSON
                PluginResult result = new PluginResult(PluginResult.Status.OK, responseJson);
                callbackContext.sendPluginResult(result);
            }
        });
    }
}
