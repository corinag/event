/**
 * Copyright 2005-2014 Restlet
 * 
 * The contents of this file are subject to the terms of one of the following
 * open source licenses: Apache 2.0 or or EPL 1.0 (the "Licenses"). You can
 * select the license that you prefer but you may not use this file except in
 * compliance with one of these Licenses.
 * 
 * You can obtain a copy of the Apache 2.0 license at
 * http://www.opensource.org/licenses/apache-2.0
 * 
 * You can obtain a copy of the EPL 1.0 license at
 * http://www.opensource.org/licenses/eclipse-1.0
 * 
 * See the Licenses for the specific language governing permissions and
 * limitations under the Licenses.
 * 
 * Alternatively, you can obtain a royalty free commercial license with less
 * limitations, transferable or non-transferable, directly at
 * http://restlet.com/products/restlet-framework
 * 
 * Restlet is a registered trademark of Restlet S.A.S.
 */

package org.restlet.contacto.website;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.resource.Directory;
import org.restlet.routing.Extractor;
import org.restlet.routing.Redirector;
import org.restlet.routing.Router;
import org.restlet.security.MapVerifier;
import java.util.HashMap;

import java.util.Map;




import org.restlet.service.CorsService;



/**
 * The reusable mail server application.
 */
public class ContactoSiteApplication extends Application {

    
/**
     * Constructor.
     */
    

public ContactoSiteApplication() {

 
 CorsService corsService = new CorsService();
 corsService.setSkippingResourceForCorsOptions(true);
 getServices().add(corsService);



setName("RESTful Contacto Site application");
        setDescription("Example Site for 'Club de Lectura'");
        setOwner("Restlet S.A.S.");
        setAuthor("The Restlet Team");

        // Configure the status service
        setStatusService(new ContactoStatusService());
    

}

   /**
     * Creates a root Router to dispatch call to server resources.
     */
    
@Override
    public Restlet createInboundRoot() {
        
Router router = new Router(getContext());
        
router.attach("/", RootServerResource.class);
 
router.attach("/contacts/{contactId}", ContactoServerResource.class);     


// Serve static files (images, etc.)
              
String rootUri = "war:///static";
Directory directory = new Directory(getContext(), rootUri);
        
directory.setListingAllowed(true);
        
router.attach("/static", directory);

// Serve website       
//String rootUri = "file:///" + System.getProperty("java.io.tmpdir");
        
String rootUri1 = "war:///club";
Directory directory1 = new Directory(getContext(), rootUri1);
        
directory.setListingAllowed(true);
        
router.attach("/club", directory1);   

return router;
}

}






