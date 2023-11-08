var exec = require('cordova/exec');

var faciaMobileSDK = {
    createRequest: function (accessToken, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, 'faciaMobileSDK', 'createRequest', [accessToken, config]);
    }
};

module.exports = faciaMobileSDK;
