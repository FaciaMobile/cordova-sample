cordova.define('cordova/plugin_list', function(require, exports, module) {
  module.exports = [
    {
      "id": "com.facia.cordova.faciaMobileSDK",
      "file": "plugins/com.facia.cordova/www/faciaMobileSDK.js",
      "pluginId": "com.facia.cordova",
      "clobbers": [
        "cordova.plugins.faciaMobileSDK"
      ]
    }
  ];
  module.exports.metadata = {
    "com.facia.cordova": "0.0.1"
  };
});