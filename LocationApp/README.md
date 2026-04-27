# LocationApp

Exercise 6: Current location app using Apache Cordova and the geolocation plugin.

## Prerequisites

- Node.js installed
- Cordova CLI installed globally

## Start in the Browser

1. Open a terminal in the `LocationApp` folder.
2. Install dependencies if needed:

   ```bash
   npm install -g cordova
   npm install
   ```

3. Add the browser platform if it is not already present:

   ```bash
   cordova platform add browser
   ```

4. Run the app in the browser:

   ```bash
   cordova run browser
   ```

## Notes

- The browser uses the HTML5 Geolocation API.
- On Android, the geolocation plugin also needs location permissions in the manifest.
