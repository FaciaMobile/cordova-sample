cordova.define("com.facia.cordova.faciaMobileSDK", function(require, exports, module) {
var exec = require('cordova/exec');

var faciaMobileSDK = {
    createRequest: function (accessToken, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, 'faciaMobileSDK', 'createRequest', [accessToken, config]);
    }
};

module.exports = faciaMobileSDK;

});
