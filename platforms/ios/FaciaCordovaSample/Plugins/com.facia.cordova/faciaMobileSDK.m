#import "faciaMobileSDK.h"
#import <Facia/Facia.h>
#import <Cordova/CDV.h>

@implementation faciaMobileSDK

- (void)createRequest:(CDVInvokedUrlCommand *)command {
    __block CDVPluginResult *pluginResult = nil;

    // Retrieve the access token and config from the Cordova command arguments
    NSString *accessToken = [command.arguments objectAtIndex:0];
    NSDictionary *config = [command.arguments objectAtIndex:1];

    Facia *facia = [[Facia alloc] init];

    [facia createRequestWithParentViewController:self.viewController
                                    accessToken:accessToken
                                         configs:config
                                      completion:^(NSDictionary *result) {
        if (result) {
            pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsDictionary:result];
        } else {
            pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
        }

        [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
    }];
}

@end
