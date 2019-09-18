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
package org.restlet.contacto;


import org.restlet.Client;
import org.restlet.Component;


import org.restlet.contacto.webapi.server.ContactoApiApplication;
import org.restlet.contacto.website.ContactoSiteApplication;
import org.restlet.Context;

import org.restlet.Server;
import org.restlet.data.Protocol;


import org.restlet.routing.VirtualHost;


/**
 * RESTful component containing the contacto server application.
 */

public class ContactoServerComponent extends Component {

@Deprecated
public static void main (String[] args) throws Exception {

new ContactoServerComponent().start();
}
public  ContactoServerComponent() throws Exception {


//RESTRICTED CLASS IN GAE getServers().add(Protocol.HTTP, 8080);




getClients().add(Protocol.RIAP);
getClients().add(Protocol.HTTP);
getClients().add(Protocol.FILE);

getDefaultHost().attach("/site", new ContactoSiteApplication());


getInternalRouter().attach("/api", new ContactoApiApplication());
}
}